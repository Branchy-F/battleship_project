package de.battleship.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BSSocket {
    private ObjectOutputStream out;
    private boolean aktiv = false;

    public BSSocket(String host, int port, int portGegner) throws IOException {
        createSocket(port);
        verbindeMitGegner(host, portGegner);
    }

    private void verbindeMitGegner(String host, int portGegner) {
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
        Thread t = new Thread(r);
        t.start();
    }

    private void createSocket(int port) throws IOException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                lausche(port);
            }
        };
        Thread t = new Thread(r);
        t.start();
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
                Kommando kdo = (Kommando) in.readObject();
                verarbeite(kdo);
            }
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            // TODO Errorhandling
            e.printStackTrace();
        }
    }

    private void verarbeite(Kommando kdo) {
        //dummy
        System.out.println("Kommando: " + kdo.toString());
    }

    public boolean isConnected() {
        return out != null;
    }

    public void sende(Kommando kommando) throws IOException {
        out.writeObject(kommando);
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
}
