package baitaplon;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class UDPClientGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField filePathField;
    private JButton browseButton, sendButton;
    private JTextArea logArea;

    final String SERVER_IP = "127.0.0.1";
    final int SERVER_PORT = 9999;
    final int CHUNK_SIZE = 1024;

    public UDPClientGUI() {
        setTitle("UDP Client - Gửi File");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel chọn file
        JPanel topPanel = new JPanel(new BorderLayout());
        filePathField = new JTextField();
        browseButton = new JButton("Chọn file...");
        topPanel.add(filePathField, BorderLayout.CENTER);
        topPanel.add(browseButton, BorderLayout.EAST);

        // Nút gửi
        sendButton = new JButton("Gửi file");
        topPanel.add(sendButton, BorderLayout.SOUTH);

        // Log hiển thị
        logArea = new JTextArea();
        logArea.setEditable(false);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(logArea), BorderLayout.CENTER);

        // Chọn file
        browseButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                filePathField.setText(file.getAbsolutePath());
            }
        });

        // Gửi file
        sendButton.addActionListener(e -> sendFile());
    }

    private void sendFile() {
        String filePath = filePathField.getText();
        if (filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy chọn file trước!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "File không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (DatagramSocket socket = new DatagramSocket();
             FileInputStream fis = new FileInputStream(file)) {

            InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

            byte[] buffer = new byte[CHUNK_SIZE];
            int bytesRead;
            int seq = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String header = String.format("%010d", seq);
                byte[] headerBytes = header.getBytes();

                byte[] packetData = new byte[headerBytes.length + bytesRead];
                System.arraycopy(headerBytes, 0, packetData, 0, headerBytes.length);
                System.arraycopy(buffer, 0, packetData, headerBytes.length, bytesRead);

                DatagramPacket packet = new DatagramPacket(packetData, packetData.length, serverAddr, SERVER_PORT);
                socket.send(packet);

                logArea.append("📤 Gửi gói " + seq + " (" + bytesRead + " bytes)\n");
                seq++;
            }

            // Gửi gói kết thúc
            byte[] end = "END".getBytes();
            DatagramPacket endPacket = new DatagramPacket(end, end.length, serverAddr, SERVER_PORT);
            socket.send(endPacket);

            logArea.append("✅ Đã gửi xong file!\n");

        } catch (IOException e) {
            logArea.append("❌ Lỗi: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UDPClientGUI().setVisible(true));
    }
}
