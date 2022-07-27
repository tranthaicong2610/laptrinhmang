/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Win 10
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server Started..");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected..");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                //read from client...
                Object cMsg = ois.readObject();
                System.out.println("From Client: " + (String) cMsg);

                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase();

                //send to client..
                oos.writeObject(serverMsg);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
