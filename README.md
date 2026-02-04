# Star Wars API (Reto Tecnico)

Proyecto Spring Boot para integrar SWAPI y persistir planetas favoritos en MySQL local.

## Requisitos
- Java 17+
- Maven Wrapper (incluido)
- MySQL local

## Configuracion MySQL
1) Crear base de datos y tabla:
- Ver `DB_SCRIPTS.md`

2) Crear usuario local (ejemplo):
```sql
CREATE USER 'starwars'@'localhost' IDENTIFIED BY 'Arian1902';
GRANT ALL PRIVILEGES ON starwars.* TO 'starwars'@'localhost';
FLUSH PRIVILEGES;
```

3) Configurar conexion en `src/main/resources/application.yaml`:
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/starwars?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: starwars
    password: Arian1902
```

## Ejecutar el proyecto
```bash
./mvnw spring-boot:run
```

## Swagger / OpenAPI
- UI: ` `
- OpenAPI: `http://localhost:8080/v3/api-docs`

## Endpoints

### GET /api/personajes/{id}
Obtiene un personaje desde SWAPI y devuelve el DTO en espanol.

Ejemplo:
```
GET http://localhost:8080/api/personajes/22
```

Respuesta:
```json
{
  "altura": "183",
  "anioNacimiento": "31.5BBY",
  "colorCabello": "black",
  "colorOjos": "brown",
  "colorPiel": "fair",
  "genero": "male",
  "nombre": "Boba Fett",
  "peso": "78.2"
}
```

### POST /api/planetas
Guarda un planeta favorito en MySQL.

```
POST http://localhost:8080/api/planetas
```

Body:
```json
{
  "nombre": "Tatooine",
  "clima": "arido",
  "terreno": "desierto",
  "poblacion": 200000
}
```

Respuesta:
```json
{
  "id": 1,
  "nombre": "Tatooine",
  "clima": "arido",
  "terreno": "desierto",
  "poblacion": 200000,
  "fechaCreacion": "2026-02-04T02:59:16"
}
```

### GET /api/planetas
Lista planetas favoritos almacenados.

```
GET http://localhost:8080/api/planetas
```

Respuesta:
```json
[
  {
    "id": 1,
    "nombre": "Tatooine",
    "clima": "arido",
    "terreno": "desierto",
    "poblacion": 200000,
    "fechaCreacion": "2026-02-04T02:59:16"
  }
]
```

## Tests
```bash
./mvnw test
```
