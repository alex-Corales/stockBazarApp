# Bazar API - Gestión de Productos y Ventas

## Descripción

El objetivo de esta API es gestionar las operaciones de un bazar, permitiendo registrar productos, clientes y ventas de manera eficiente. Desarrollada en Java con Spring Boot, esta API está diseñada para ser consumida tanto por una aplicación web como móvil, mediante métodos HTTP que permiten realizar las operaciones CRUD necesarias y consultas adicionales sobre productos, clientes y ventas.

## Tecnologías

- **Backend:** Java 17, Spring Boot
- **Frameworks:** Spring Data JPA, Spring Web
- **Base de Datos:** MySQL
- **Otros:** DTOs para transferencia de datos

## Configuración de Base de Datos (MySQL)

Para conectar la API a una base de datos MySQL, configura el archivo `application.properties`  de la siguiente manera:

### `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/stockbazarapp?useSSl=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

Asegúrate de tener MySQL instalado y ejecutar el siguiente comando para crear la base de datos:

```sql
CREATE DATABASE stockbazarapp;
```

## Endpoints

### Productos

- **Crear Producto**\
  `POST /productos/crear`\
  Crea un nuevo producto.

- **Listar Productos**\
  `GET /productos`\
  Obtiene la lista completa de productos.

- **Obtener Producto por Código**\
  `GET /productos/{codigo_producto}`\
  Obtiene un producto por su código.

- **Eliminar Producto**\
  `DELETE /productos/eliminar/{codigo_producto}`\
  Elimina un producto por su código.

- **Editar Producto**\
  `PUT /productos/editar/{codigo_producto}`\
  Actualiza un producto por su código.

- **Productos con bajo stock**\
  `GET /productos/falta_stock`\
  Obtiene los productos cuyo stock es menor a 5 unidades.

### Clientes

- **Crear Cliente**\
  `POST /clientes/crear`\
  Crea un nuevo cliente.

- **Listar Clientes**\
  `GET /clientes`\
  Obtiene la lista completa de clientes.

- **Obtener Cliente por ID**\
  `GET /clientes/{id_cliente}`\
  Obtiene un cliente por su ID.

- **Eliminar Cliente**\
  `DELETE /clientes/eliminar/{id_cliente}`\
  Elimina un cliente por su ID.

- **Editar Cliente**\
  `PUT /clientes/editar/{id_cliente}`\
  Actualiza un cliente por su ID.

### Ventas

- **Crear Venta**\
  `POST /ventas/crear`\
  Crea una nueva venta, asociada a un cliente y productos.

- **Listar Ventas**\
  `GET /ventas`\
  Obtiene la lista completa de ventas realizadas.

- **Obtener Venta por Código**\
  `GET /ventas/{codigo_venta}`\
  Obtiene una venta por su código.

- **Eliminar Venta**\
  `DELETE /ventas/eliminar/{codigo_venta}`\
  Elimina una venta por su código.

- **Editar Venta**\
  `PUT /ventas/editar/{codigo_venta}`\
  Actualiza una venta por su código.

- **Productos de una Venta**\
  `GET /ventas/productos/{codigo_venta}`\
  Obtiene los productos asociados a una venta específica.

- **Ventas del Día**\
  `GET /ventas/{fecha_venta}`\
  Obtiene la sumatoria del monto y cantidad total de ventas realizadas en un día determinado.

- **Mayor Venta**\
  `GET /ventas/mayor_venta`\
  Obtiene la venta con el monto más alto, junto con detalles como el código de venta, el total, la cantidad de productos, el nombre y apellido del cliente.

## Instalación

1. **Clona este repositorio:**

   ```bash
   git clone https://github.com/alex-Corales/stockBazarApp
   ```

2. **Accede a la carpeta del proyecto:**

   ```bash
   cd stockBazarApp
   ```

3. **Instala las dependencias:**

   ```bash
   mvn clean install
   ```

4. **Ejecuta el proyecto:**

   ```bash
   mvn spring-boot:run
   ```

5. **Accede a la API:**
   Abre tu navegador y visita `http://localhost:8080`.

## Contribuciones

Si deseas contribuir al proyecto:

1. Haz un fork de este repositorio.
2. Crea una nueva rama (`git checkout -b feature-nueva`).
3. Realiza tus cambios y haz un commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Envía un Pull Request.

