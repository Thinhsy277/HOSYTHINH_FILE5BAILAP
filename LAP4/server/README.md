# TruyenCuoi API

API nhỏ cung cấp dữ liệu cho ứng dụng Android. Sử dụng Node.js, Express và MySQL.

## Chuẩn bị

1. Cài Node.js LTS và MySQL.
2. Tạo database và dữ liệu mẫu:

```bash
mysql -u root -p < db/schema.sql
mysql -u root -p < db/seed.sql
```

3. Sao chép file cấu hình:

```bash
cp env.example .env
# hoặc tự tạo file .env dựa trên env.example
```

4. Cài dependencies và chạy server:

```bash
cd server
npm install
npm run dev
```

Mặc định API lắng nghe ở `http://localhost:3000`. Trên Android emulator dùng `http://10.0.2.2:3000`.

## Endpoints

- `GET /topics` — trả về danh sách chủ đề kèm danh sách truyện.
- `GET /topics/:id` — chi tiết 1 chủ đề, bao gồm các truyện.
- `GET /stories/:id` — chi tiết 1 truyện.

Khi triển khai production, hãy bảo vệ API bằng auth/token, SSL và không mở MySQL trực tiếp ra internet.

