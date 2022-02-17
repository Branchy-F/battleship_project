package de.battleship.service;

import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BSSocket {
    private final String host;
    private final int portGegner;
    private ObjectOutputStream out;
    private boolean aktiv = false;
    private SpielFeldService spielFeldService;

    public BSSocket(SpielFeldService spielFeldService, String host, int port, int portGegner) throws IOException {
        this.spielFeldService = spielFeldService;
        this.host = host;
        this.portGegner = portGegner;
        createSocket(port);

    }

    public boolean isConnected() {
        return out != null;
    }
    public void beende() {
        aktiv = false;
        try {
            out.close();
        } catch (IOException e) {
            // TODO Errorhandling
            e.printStackTrace();
        }
    }

    public void verbindeMitGegner() {
        Runnable r = () -> {
            try {
                System.out.printf("Kontaktiere Gegner auf %s:%d...%n",host, portGegner);
                InetSocketAddress address = new InetSocketAddress(host, portGegner);
                System.out.println(address.isUnresolved());
                while (address.isUnresolved()) {
                    System.out.println("Warte auf Server");
                    Thread.sleep(500);

                }
                Socket socket = new Socket(host, portGegner);
                out = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("...verbunden!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(r).start();
    }

    private void createSocket(int port) throws IOException {
        new Thread(() -> lausche(port)).start();
    }

    private void lausche(int port) {
        try {
            System.out.printf("Erzeuge ServerSocket auf Port %d...%n", port);
            ServerSocket server = new ServerSocket(port);
            System.out.println("Warte auf Gegner...");
            Socket socket = server.accept();
            System.out.println("..habe den Gegner!");
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            aktiv = true;
            while (aktiv) {
                Object nachricht = in.readObject();
                Platform.runLater(() -> {
                    if (nachricht instanceof Zug) { verarbeite(this, (Zug) nachricht); }
                    else if (nachricht instanceof Antwort) { verarbeite((Antwort) nachricht); }
                });
            }
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void verarbeite(BSSocket bsSocket, Zug zug) {
        System.out.println("Verarbeite Zug "+zug);
        try {
            bsSocket.out.writeObject(spielFeldService.aufZugReagieren(zug));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void verarbeite(Antwort antwort) {
        System.out.println("Verarbeite Antwort "+antwort);
        spielFeldService.aufAntwortReagieren(antwort);
    }

    public void sendeZug(Zug zug) throws IOException {
        if (isConnected()) { out.writeObject(zug); }
        else { System.out.println("Keine Verbindung!"); }
    }
}
