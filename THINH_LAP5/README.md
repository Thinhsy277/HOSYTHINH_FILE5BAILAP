# Account Login & Register Lab

Ứng dụng Android hoàn chỉnh với giao diện đăng nhập/đăng ký giống yêu cầu trong tài liệu và phần backend Node.js kết nối MySQL để lưu tài khoản thực tế. Phần frontend được viết bằng Kotlin + Fragment, phần backend dùng Express + mysql2.

## 1. Thành phần dự án
- `AccountApp/` – mã nguồn Android (Fragment Login & Register, SharedPreferences ghi nhớ email đăng nhập cuối cùng).
- `backend/` – REST API chạy Node.js (Express) kết nối MySQL, cung cấp các endpoint `POST /api/auth/register` và `POST /api/auth/login`.

## 2. Chuẩn bị CSDL MySQL
1. Tạo database (ví dụ `account_app`):
   ```sql
   CREATE DATABASE IF NOT EXISTS account_app CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
   USE account_app;
   ```
2. Bảng người dùng (được server tự động tạo lại nếu thiếu, nhưng bạn có thể chủ động chạy):
   ```sql
   CREATE TABLE IF NOT EXISTS users (
     id INT AUTO_INCREMENT PRIMARY KEY,
     email VARCHAR(255) NOT NULL UNIQUE,
     password VARCHAR(255) NOT NULL,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   ) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
   ```

## 3. Cấu hình backend
1. Sao chép file cấu hình mẫu:
   ```bash
   cd backend
   cp env.sample .env
   ```
2. Sửa `.env` với thông tin MySQL của bạn (`DB_HOST`, `DB_USER`, `DB_PASSWORD`, `DB_NAME`, ...).
3. Cài đặt và chạy server:
   ```bash
   npm install
   npm run dev
   ```
   Mặc định API sẽ chạy tại `http://localhost:4000/api`. Khi dùng Android Emulator, `BASE_URL` đã được cấu hình là `http://10.0.2.2:4000/api/`.

## 4. Chạy ứng dụng Android
1. Mở thư mục `AccountApp` bằng Android Studio.
2. Sync Gradle, build và chạy trên emulator hoặc thiết bị thật.
3. Luồng hoạt động:
   - Đăng ký: nhập email + mật khẩu + nhập lại → backend lưu vào MySQL (hash bcrypt). Nếu thành công, app hiển thị “Đăng ký thành công” và tự động quay lại màn hình đăng nhập.
   - Đăng nhập: kiểm tra với backend. Khi thành công, app hiển thị thông báo và ghi nhớ email cuối cùng bằng `SharedPreferences`.

## 5. Cấu trúc API
Request/response mẫu:
```http
POST /api/auth/register
Body: { "email": "user@example.com", "password": "secret" }
Response: { "success": true, "message": "Đăng ký thành công!", "data": { "id": 1, "email": "user@example.com" } }

POST /api/auth/login
Body: { "email": "user@example.com", "password": "secret" }
Response: { "success": true, "message": "Đăng nhập thành công!", "data": { "id": 1, "email": "user@example.com" } }
```

## 6. Kiến trúc giao diện (theo yêu cầu bài Lab)
- Không có ActionBar, sử dụng LinearLayout + FrameLayout để dựng header bo góc với các drawable `bg_top`, `bg_login`, `bg_radius`, `bg_rect`.
- Icon sử dụng vector drawable (`ic_back`, `ic_email`, `ic_key`).
- LoginFragment & RegisterFragment xử lý animation, validate dữ liệu, gọi repository → Retrofit → backend.
- `MainActivity` điều hướng hai fragment, quản lý `SharedPreferences`.

## 7. Kiểm thử nhanh
- Đảm bảo backend đang chạy.
- Trên app: chọn Register → nhập thông tin mới → nhận toast “Đăng ký thành công!” và app trở về màn hình Login.
- Nhập đúng tài khoản vừa tạo để login → nhận thông báo thành công. Nhập sai mật khẩu sẽ được backend trả về lỗi tương ứng.

Bạn đã có đủ phần giao diện + logic + lưu trữ dữ liệu MySQL như yêu cầu.

