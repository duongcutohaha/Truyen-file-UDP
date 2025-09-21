<h2 align="center">
    <a href="https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin">
    🎓 Faculty of Information Technology (DaiNam University)
    </a>
</h2>
<h2 align="center">
   TRUYỀN FILE QUA UDP
</h2>
<div align="center">
    <p align="center">
        <img src="docs/aiotlab_logo.png" alt="AIoTLab Logo" width="170"/>
        <img src="docs/fitdnu_logo.png" alt="AIoTLab Logo" width="180"/>
        <img src="docs/dnu_logo.png" alt="DaiNam University Logo" width="200"/>
    </p>

[![AIoTLab](https://img.shields.io/badge/AIoTLab-green?style=for-the-badge)](https://www.facebook.com/DNUAIoTLab)
[![Faculty of Information Technology](https://img.shields.io/badge/Faculty%20of%20Information%20Technology-blue?style=for-the-badge)](https://dainam.edu.vn/vi/khoa-cong-nghe-thong-tin)
[![DaiNam University](https://img.shields.io/badge/DaiNam%20University-orange?style=for-the-badge)](https://dainam.edu.vn)

</div>

## 📖 1. Giới thiệu
Giới thiệu về UDP (User Datagram Protocol)
Trong lĩnh vực mạng máy tính, UDP (User Datagram Protocol) là một trong những giao thức quan trọng thuộc tầng Transport trong mô hình TCP/IP. UDP được sử dụng để truyền dữ liệu giữa các thiết bị trong mạng một cách nhanh chóng, gọn nhẹ mà không cần quá nhiều cơ chế kiểm soát phức tạp.

🔹 Đặc điểm chính của UDP

Không kết nối (Connectionless):
Trước khi gửi dữ liệu, UDP không cần thiết lập kết nối giữa client và server như TCP. Vì vậy, việc truyền tải diễn ra nhanh hơn.

Không đảm bảo (Unreliable):
UDP không đảm bảo dữ liệu sẽ đến nơi, không kiểm tra lỗi toàn vẹn dữ liệu, không có cơ chế xác nhận gói tin đã được nhận.

Đơn giản và hiệu quả:
UDP có header chỉ 8 byte, nhỏ hơn rất nhiều so với TCP (20 byte), giúp tiết kiệm băng thông.

Truyền broadcast/multicast:
UDP hỗ trợ gửi dữ liệu tới nhiều thiết bị cùng lúc, rất hữu ích trong các ứng dụng cần phân phối dữ liệu đồng thời.

🔹 Cấu trúc gói tin UDP

Một gói tin UDP bao gồm 4 phần chính:

Source Port (16 bit): Cổng nguồn.

Destination Port (16 bit): Cổng đích.

Length (16 bit): Độ dài toàn bộ gói UDP.

Checksum (16 bit): Kiểm tra lỗi cơ bản.

🔹 Ứng dụng của UDP

UDP thường được dùng trong các ứng dụng cần tốc độ hơn độ tin cậy tuyệt đối:

Truyền phát video/audio trực tuyến (YouTube, Zoom, VoIP).

Game online (yêu cầu phản hồi nhanh, chấp nhận mất gói).

DNS (Domain Name System).

Streaming đa phương tiện, IPTV.

## 🔧 2. Ngôn ngữ lập trình sử dụng: [![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)

## 🚀 3. Công nghệ sử dụng

<p align="center">
  <img src="z7035786410500_d8b5418e1c6ede72bd25a9309533b2e5.jpg" alt="Ảnh 1" width="1000"/>
</p>

<p align="center">
  <em>Hình 1: Ảnh giao diện   </em>
</p>

<p align="center">
  <img src="z7035788886451_d385743a247ab62b886e8ddda792cd6b.jpg" alt="Ảnh 2" width="1000"/>
</p>
<p align="center">
  <em> Hình 2: Chọn file để truyền </em>
</p>

<p align="center">
  <img src="z7035790708936_49c2d8164028215be815e21c98b8a6dd.jpg" alt="Ảnh 3" width="1000"/>
</p>
<p align="center">
  <em> Hình 3: File được chọn và gửi </em>
</p>

<p align="center">
  <img src="z7035793657540_7515c0a165ea2c334acd91bdd1f06372.jpg" alt="Ảnh 4" width="700"/>
</p>
<p align="center">
  <em> Hình 4: Gửi thành công </em>
</p>

<p align="center">
  <img src="z7035800768760_9469e084f7f7a7c680c9d06284296684.jpg" alt="Ảnh 5" width="400"/>
</p>
<p align="center">
  <em> Hình 5:Kết quả </em>
</p>
## 📝 4. Hướng dẫn cài đặt và sử dụng
### 🔧 Yêu cầu hệ thống

- **Java Development Kit (JDK)**: Phiên bản 8 trở lên
- **Hệ điều hành**: Windows, macOS, hoặc Linux
- **Môi trường phát triển**: IDE (IntelliJ IDEA, Eclipse, VS Code) hoặc terminal/command prompt
- **Bộ nhớ**: Tối thiểu 512MB RAM
- **Dung lượng**: Khoảng 10MB cho mã nguồn và file thực thi
- ### 📦 Cài đặt và triển khai
### 1️⃣ Chạy Server
run as với sever để lắng nghe cổng 9999
### 2️⃣ Chạy Client
run as với client là hoàn thiện

## Nguồn
DaiNam University. 
Lê Xuân Dương - 1671020074
Gmail: lexuanduong129@gmail.com

---
