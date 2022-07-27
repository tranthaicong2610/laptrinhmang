package tcp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(2207);
        System.out.println("server is running ...");
        while (true) {
            // tiep nhan du lieu
            byte[] buf= new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf ,buf.length);
            server.receive(packet);
//            System.out.println(new String(packet.getData()).trim());
            String name = new String(packet.getData()).trim();
            // xu ly du lieu
            String res = Server.reverse(name);
            DatagramPacket packet1 = new DatagramPacket(res.getBytes(),res.length(),
                    packet.getAddress(),packet.getPort());
            server.send(packet1);


            //dap tra


        }

    }
}
