package tcp.test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",2207);
        System.out.println(client);
        // gui du lieu yeu cau
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeInt(100);
        dos.writeInt(200);
        //  nhan du lieu dap tra
        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println("tong 2 so la :"+dis.readInt());

    }

}
