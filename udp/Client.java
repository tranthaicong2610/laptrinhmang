package tcp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        // gui du lieu
        String  name = "tran thai cong";
        DatagramPacket packet = new DatagramPacket(name.getBytes(),name.length(), InetAddress.getByName("localhost"),2207);
        client.send(packet);
        System.out.println("send success ....");



        // nhan du lieu
        byte[] buf= new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(buf ,buf.length);
        client.receive(packet1);
        System.out.println(new String(packet1.getData()).trim());

    }
}
