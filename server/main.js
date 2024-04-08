const express = require("express");
const mysql = require("mysql");

const app = express();
const port = 3000;

const db = mysql.createConnection({
  host: "localhost",
  user: "dam",
  password: "password",
  database: "dam",
});

db.connect((err) => {
  if (err) throw err;
  console.log("Connected to the MySQL server.");
});

app.get("/places", (req, res) => {
  const query = "SELECT * FROM place";
  db.query(query, (err, results) => {
    if (err) throw err;
    res.json(results);
  });
});

app.get("/places/:id", (req, res) => {
  const query = "SELECT * FROM place WHERE id = ?";
  db.query(query, [req.params.id], (err, results) => {
    if (err) throw err;
    res.json(results.length ? results[0] : {});
  });
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});
