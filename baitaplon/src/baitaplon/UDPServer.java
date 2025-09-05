package baitaplon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        final int PORT = 9999;
        final int BUFFER_SIZE = 2048;
        String outputFile = "received.txt";

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("Server đang lắng nghe trên cổng " + PORT + "...");

            byte[] buffer = new byte[BUFFER_SIZE];
            FileOutputStream fos = new FileOutputStream(outputFile);

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String check = new String(packet.getData(), 0, packet.getLength());
                if (check.equals("END")) {
                    System.out.println("Đã nhận xong file!");
                    break;
                }

                // Lấy dữ liệu và ghi vào file
                fos.write(packet.getData(), 10, packet.getLength() - 10);
            }

            fos.close();
            socket.close();
            System.out.println("File đã lưu thành công: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
