import bcrypt from "bcryptjs";
import { pool } from "../config/db.js";

const sanitize = (value = "") => value.trim().toLowerCase();

export async function register(req, res, next) {
  try {
    const email = sanitize(req.body.email || "");
    const password = (req.body.password || "").trim();

    if (!email || !password) {
      return res.status(400).json({
        success: false,
        message: "Vui lòng nhập đầy đủ email và mật khẩu.",
      });
    }

    const [existing] = await pool.query("SELECT id FROM users WHERE email = ?", [
      email,
    ]);
    if (existing.length) {
      return res.status(409).json({
        success: false,
        message: "Email đã tồn tại.",
      });
    }

    const hashedPassword = await bcrypt.hash(password, 10);
    const [result] = await pool.query(
      "INSERT INTO users (email, password) VALUES (?, ?)",
      [email, hashedPassword]
    );

    return res.status(201).json({
      success: true,
      message: "Đăng ký thành công!",
      data: { id: result.insertId, email },
    });
  } catch (error) {
    next(error);
  }
}

export async function login(req, res, next) {
  try {
    const email = sanitize(req.body.email || "");
    const password = (req.body.password || "").trim();

    if (!email || !password) {
      return res.status(400).json({
        success: false,
        message: "Vui lòng nhập đầy đủ email và mật khẩu.",
      });
    }

    const [rows] = await pool.query(
      "SELECT id, email, password FROM users WHERE email = ?",
      [email]
    );

    if (!rows.length) {
      return res.status(404).json({
        success: false,
        message: "Email chưa được đăng ký.",
      });
    }

    const user = rows[0];
    const isMatch = await bcrypt.compare(password, user.password);

    if (!isMatch) {
      return res.status(401).json({
        success: false,
        message: "Mật khẩu không chính xác.",
      });
    }

    return res.json({
      success: true,
      message: "Đăng nhập thành công!",
      data: { id: user.id, email: user.email },
    });
  } catch (error) {
    next(error);
  }
}

