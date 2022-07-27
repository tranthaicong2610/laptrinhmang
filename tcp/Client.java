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
import java.util.Scanner;
/**
 *
 * @author Win 10
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started..");
        Socket socket = new Socket("127.0.0.1", 1234);
        System.out.println("Client Connected..");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        //sent to server...
        oos.writeObject(message);

        try {
            //receive from server..
            Object fromServer = ois.readObject();
            System.out.println("From Server: "+(String)fromServer);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
