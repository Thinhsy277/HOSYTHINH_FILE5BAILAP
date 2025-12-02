# Lab 1 - Android Studio Project

## Mô tả dự án
Dự án Android Studio hoàn chỉnh bao gồm tất cả các bài tập trong Lab 1:
- ✅ Máy tính (Calculator) với 5 phép toán: +, -, *, /, %
- ✅ Tích hợp Camera để chụp ảnh
- ✅ Random Number Generator (tạo số ngẫu nhiên)
- ✅ Dice Roller (xúc xắc)
- ✅ Call/SMS (gọi điện và gửi tin nhắn)

## Cấu trúc dự án

```
c:\Lap1\
├── app\
│   ├── src\
│   │   └── main\
│   │       ├── java\com\example\lab1\
│   │       │   ├── MainActivity.java
│   │       │   ├── CalculatorActivity.java
│   │       │   ├── CameraActivity.java
│   │       │   ├── RandomNumberActivity.java
│   │       │   ├── DiceRollerActivity.java
│   │       │   └── CallSmsActivity.java
│   │       ├── res\
│   │       │   ├── layout\
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── activity_calculator.xml
│   │       │   │   ├── activity_camera.xml
│   │       │   │   ├── activity_random_number.xml
│   │       │   │   ├── activity_dice_roller.xml
│   │       │   │   └── activity_call_sms.xml
│   │       │   ├── values\
│   │       │   │   ├── strings.xml
│   │       │   │   ├── colors.xml
│   │       │   │   └── themes.xml
│   │       │   └── drawable\
│   │       │       └── (cần thêm ảnh xúc xắc)
│   │       └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
├── gradle.properties
└── HUONG_DAN_THEM_ANH.md
```

## Hướng dẫn sử dụng

### 1. Mở project trong Android Studio
- Mở Android Studio
- Chọn **File > Open**
- Chọn thư mục `c:\Lap1`
- Đợi Android Studio sync Gradle

### 2. Thêm ảnh xúc xắc (QUAN TRỌNG)
⚠️ **Bạn cần thêm 6 file ảnh xúc xắc vào thư mục:**
`c:\Lap1\app\src\main\res\drawable\`

**Tên file cần tạo:**
- dice_1.png
- dice_2.png
- dice_3.png
- dice_4.png
- dice_5.png
- dice_6.png

Xem file `HUONG_DAN_THEM_ANH.md` để biết chi tiết.

### 3. Cấp quyền cho ứng dụng
Khi chạy app trên thiết bị/emulator, bạn cần cấp các quyền sau:
- **Camera**: Để chụp ảnh
- **Phone**: Để gọi điện thoại
- **SMS**: Để gửi tin nhắn

### 4. Build và chạy
- Kết nối thiết bị Android hoặc khởi động emulator
- Click nút **Run** (hoặc Shift+F10)
- Chọn thiết bị và chờ app cài đặt

## Tính năng chi tiết

### 1. Máy tính (Calculator)
- Nhập 2 số vào EditText
- Chọn phép toán: +, -, *, /, %
- Kết quả hiển thị ngay lập tức
- Có xử lý lỗi chia cho 0

### 2. Camera
- Nhấn nút "Chụp ảnh" để mở camera
- Chụp ảnh và xem preview
- Ảnh hiển thị trong ImageView

### 3. Random Number
- Nhấn nút "RANDOM NUMBER" để tạo số ngẫu nhiên (0-99)
- Số hiển thị màu đỏ, kích thước lớn

### 4. Dice Roller
- Tap vào xúc xắc để roll
- Hiển thị ngẫu nhiên 1 trong 6 mặt xúc xắc
- Giao diện màu xanh dương

### 5. Call/SMS
- Nhập số điện thoại
- Nhấn "Call" để gọi điện
- Nhấn "Send SMS" để gửi tin nhắn
- Cần cấp quyền khi sử dụng lần đầu

## Yêu cầu hệ thống
- Android Studio Arctic Fox trở lên
- Android SDK 33
- Minimum SDK: 21 (Android 5.0)
- Java 8

## Lưu ý
- Code được viết theo đúng cấu trúc trong tài liệu Lab 1
- Sử dụng findViewById() theo cách truyền thống
- Tất cả các activity đều có trong AndroidManifest.xml
- Permissions đã được khai báo đầy đủ

## Tác giả
Lab 1 - Lập trình trên thiết bị di động (Android)
