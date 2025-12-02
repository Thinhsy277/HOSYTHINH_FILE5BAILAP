import express from "express";
import cors from "cors";
import morgan from "morgan";
import dotenv from "dotenv";
import authRoutes from "./routes/authRoutes.js";
import { ensureSchema } from "./config/db.js";

dotenv.config();

const app = express();
const PORT = process.env.PORT || 4000;
const API_PREFIX = process.env.API_PREFIX || "/api";

app.use(cors());
app.use(express.json());
app.use(morgan("dev"));

app.get("/", (_req, res) => {
  res.json({ message: "Account backend is running." });
});

app.use(`${API_PREFIX}/auth`, authRoutes);

app.use((err, _req, res, _next) => {
  console.error(err);
  res
    .status(500)
    .json({ success: false, message: "Lỗi máy chủ, vui lòng thử lại sau." });
});

ensureSchema()
  .then(() => {
    app.listen(PORT, () =>
      console.log(`Server listening on http://localhost:${PORT}${API_PREFIX}`)
    );
  })
  .catch((error) => {
    console.error("Failed to initialize database schema", error);
    process.exit(1);
  });

