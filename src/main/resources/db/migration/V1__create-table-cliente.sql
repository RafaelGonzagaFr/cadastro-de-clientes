CREATE TABLE cliente (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    nome TEXT NOT NULL,
    email TEXT NOT NULL,
    telefone TEXT NOT NULL,
    cidade TEXT NOT NULL
);