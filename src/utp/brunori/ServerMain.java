package utp.brunori;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerMain {

    public static void main(String[] args){
        try {
            DatagramSocket serverSocket = new DatagramSocket(6789);
            boolean attivo = true;
            byte[] bufferIN = new byte[1024];
            byte[] bufferOUT = new byte[1024];
            
            System.out.println("SERVER avviato...");
            while(attivo)
            {
                DatagramPacket receivePacket = new DatagramPacket(bufferIN,bufferIN.length);
                try {
                    serverSocket.receive(receivePacket);
                } catch (IOException ex) {
                    Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                String ricevuto = new String(receivePacket.getData());
                int numCaratteri = receivePacket.getLength();
                ricevuto=ricevuto.substring(0,numCaratteri);
                System.out.println("RICEVUTO: "+ricevuto);
                
                InetAddress IPClient = receivePacket.getAddresse();
            }
        } catch (SocketException ex) {
            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
