# Scripts MySQL (Entregable)

Estos scripts crean la base de datos y la tabla necesaria para probar el reto.

## Crear base de datos
```sql
CREATE DATABASE IF NOT EXISTS starwars;
```

## Usar base de datos
```sql
USE starwars;
```

## Crear tabla `planeta_favorito`
```sql
CREATE TABLE IF NOT EXISTS planeta_favorito (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  clima VARCHAR(255),
  terreno VARCHAR(255),
  poblacion BIGINT,
  fecha_creacion DATETIME NOT NULL,
  PRIMARY KEY (id)
);
```

## Datos de ejemplo (opcional)
```sql
INSERT INTO planeta_favorito (nombre, clima, terreno, poblacion, fecha_creacion)
VALUES
  ('Tatooine', 'arido', 'desierto', 200000, NOW()),
  ('Hoth', 'frio', 'tundra', NULL, NOW());
```
