# SIGIP-Inventory-Service
Microservicio de inventario e insumos para SIGIP.
- Java 25, Spring Boot 3.5.6, Spring Cloud 2025.0.0
- Puerto 8098; base de datos sigip_inventory
- Variables opcionales: DB_USERNAME, DB_PASSWORD, EUREKA_URL
Endpoints:
- GET/POST /api/inventario/insumos
- GET/PUT/DELETE /api/inventario/insumos/{id}
- GET /api/inventario/movimientos
- GET /api/inventario/movimientos/insumo/{id}
- POST /api/inventario/movimientos (ENTRADA o SALIDA; actualiza stock)
- GET /api/inventory/health
La salida no permite stock negativo. La aplicación crea/actualiza tablas con JPA en desarrollo.