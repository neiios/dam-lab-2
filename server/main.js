import express from "express";
import pg from "pg";
const { Pool } = pg;

const app = express();
const port = 3000;

const pool = new Pool({
  host: "localhost",
  user: "dam",
  password: "password",
  database: "dam",
  port: 5432,
});

app.get("/places", async (req, res) => {
  try {
    const query = "SELECT * FROM place";
    const { rows } = await pool.query(query);
    res.json(rows);
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: "Internal server error" });
  }
});

app.get("/places/:id", async (req, res) => {
  try {
    const query = "SELECT * FROM place WHERE id = $1";
    const { rows } = await pool.query(query, [req.params.id]);
    res.json(rows.length ? rows : []);
  } catch (err) {
    console.error(err);
    res.status(500).json({ error: "Internal server error" });
  }
});

app.listen(port, "0.0.0.0", () => {
  console.log(`Server running at http://localhost:${port}`);
});
