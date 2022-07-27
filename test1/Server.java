package tcp.test1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2207);
        System.out.println("server running ...");
        while(true){
            Socket conn = server.accept();
            System.out.println(conn);
            // nhan du lieu
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            int a  = dis.readInt();
            int b = dis.readInt();
            System.out.println(a+" "+b);
            // gui du lieu
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeInt(a+b);
            dis.close();
            dos.close();

            conn.close();
        }
    }
}
