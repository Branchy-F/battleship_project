//package de.battleship.service;
//
//import java.io.IOException;
//
//public class BSSocketTester {
//    public static void main(String[] args) throws IOException {
//        BSSocket bs1 = new BSSocket("192.168.1.10", 22000, 22001);
//        BSSocket bs2 = new BSSocket("192.168.1.11", 22001, 22000);
//        Runnable r = () -> {
//            while (!bs1.isConnected() || !bs2.isConnected()) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                bs1.sende(new Zug("zug", 4, 5));
//                bs2.sende(new Zug("treffer", 4, 5));
//                bs2.beende();
//                bs1.beende();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        };
//        new Thread(r).start();
//    }
//
//}
