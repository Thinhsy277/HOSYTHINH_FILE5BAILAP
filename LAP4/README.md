# Truyện Cười App

Ứng dụng Android hiển thị danh sách chủ đề và truyện cười, dữ liệu lấy từ API Node.js + MySQL.

## Cấu trúc

- `app/` — mã nguồn Android (Java, Retrofit, ViewBinding).
- `server/` — API Express kết nối MySQL.
- `server/db/schema.sql` + `seed.sql` — script tạo CSDL và dữ liệu mẫu (bao gồm chủ đề "Truyện cười hẹn hò với nha sĩ").

## Cài đặt backend

```bash
cd server
npm install
mysql -u root -p < db/schema.sql
mysql -u root -p < db/seed.sql
cp env.example .env   # điền thông tin MySQL thực tế
npm run dev           # hoặc npm start
```

API mặc định chạy ở `http://localhost:3000`. Nếu dùng Android emulator, app sẽ truy cập `http://10.0.2.2:3000`.

## Chạy ứng dụng Android

1. Mở dự án trong Android Studio.
2. Đồng bộ Gradle.
3. Đảm bảo thiết bị/emulator cùng mạng với máy chạy API.
4. Build & Run. Màn hình chủ sẽ tải danh sách chủ đề từ API.

## Tùy chỉnh

- Muốn đổi URL API: sửa `API_BASE_URL` trong `app/build.gradle` (mỗi buildType đều dùng hằng này).
- Khi thay đổi dữ liệu, cập nhật MySQL và API sẽ trả về nội dung mới mà không cần rebuild app.

