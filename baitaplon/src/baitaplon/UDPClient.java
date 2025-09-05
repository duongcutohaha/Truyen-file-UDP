package baitaplon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int SERVER_PORT = 9999;
        final int CHUNK_SIZE = 1024;
        String filePath = "test.txt";

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            byte[] buffer = new byte[CHUNK_SIZE];
            int bytesRead;
            int seq = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String header = String.format("%010d", seq); // số thứ tự 10 byte
                byte[] headerBytes = header.getBytes();

                byte[] packetData = new byte[headerBytes.length + bytesRead];
                System.arraycopy(headerBytes, 0, packetData, 0, headerBytes.length);
                System.arraycopy(buffer, 0, packetData, headerBytes.length, bytesRead);

                DatagramPacket packet = new DatagramPacket(packetData, packetData.length, serverAddr, SERVER_PORT);
                socket.send(packet);

                seq++;
            }

            // Gửi gói kết thúc
            byte[] end = "END".getBytes();
            DatagramPacket endPacket = new DatagramPacket(end, end.length, serverAddr, SERVER_PORT);
            socket.send(endPacket);

            fis.close();
            socket.close();
            System.out.println("Đã gửi xong file!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
