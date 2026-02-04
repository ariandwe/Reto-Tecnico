# Arquitectura del Proyecto (Resumen)

Paquete base: `com.example.starwars`

## Capas y responsabilidades
- `controller`: expone la API REST y delega en `service`. No contiene lógica de negocio.
- `service`: encapsula la lógica de negocio y orquesta repositorios, mappers y clientes.
- `repository`: acceso a datos vía Spring Data JPA. No contiene lógica de negocio.
- `entity`: modelos de persistencia. No se exponen en la API.
- `dto.request`: modelos de entrada (payloads HTTP).
- `dto.response`: modelos de salida (responses HTTP).
- `mapper`: conversión manual entre `entity` y `dto`.
- `client`: integración con servicios externos (si aplica).
- `exception`: excepciones de dominio y manejo global de errores.
- `config`: configuraciones transversales (ej. OpenAPI/Swagger).

## Reglas de diseño
- Controllers solo delegan.
- Services contienen la lógica.
- Repositories solo acceden a DB.
- Entities NO se exponen.
- DTOs obligatorios.
- Mappers manuales (sin MapStruct).
