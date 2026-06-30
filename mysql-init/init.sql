-- Crear la base de datos auth_db
CREATE DATABASE IF NOT EXISTS auth_db;

-- Dar permisos completos al usuario sobre auth_db
GRANT ALL PRIVILEGES ON auth_db.* TO 'usuario'@'%';

-- Asegurar que también tenga permisos sobre customer_db
GRANT ALL PRIVILEGES ON customer_db.* TO 'usuario'@'%';

-- Aplicar los cambios
FLUSH PRIVILEGES;