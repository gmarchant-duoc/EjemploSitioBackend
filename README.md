# EjemploSitioBackend

API de catálogo para el ejemplo educativo de Duoc UC. Requiere un JDK 17 y usa Maven Wrapper.

## Ejecutar en Windows

Clona el repositorio, inicia la API y espera el mensaje `Started CatalogoApplication`.

```powershell
git clone https://github.com/gmarchant-duoc/EjemploSitioBackend.git
cd EjemploSitioBackend
.\mvnw.cmd spring-boot:run
```

## Explorar la API con Swagger

1. Abre [Swagger UI](http://localhost:8080/swagger-ui.html) con el backend iniciado.
2. En **Productos**, despliega **GET /api/productos**. Revisa la respuesta **200** y el esquema de `Producto`.
3. Pulsa **Try it out** y luego **Execute**. Swagger UI hará la petición y mostrará el código HTTP y el JSON devuelto por el backend.

[OpenAPI en JSON](http://localhost:8080/v3/api-docs) y [OpenAPI en YAML](http://localhost:8080/v3/api-docs.yaml) exponen el contrato que genera springdoc a partir del controlador y del modelo.

## Contrato del catálogo

`GET /api/productos` devuelve HTTP 200 y una lista JSON con el catálogo completo. La consulta no requiere parámetros ni autenticación.

| Campo | Tipo | Descripción |
| --- | --- | --- |
| `id` | Entero | Identificador del producto |
| `nombre` | Texto | Nombre que se muestra en el catálogo |
| `imagen` | Texto | URL de la imagen |
| `precio` | Entero | Precio en pesos chilenos (CLP) |

También puedes consultar la API desde PowerShell.

```powershell
Invoke-RestMethod http://localhost:8080/api/productos
```

Edita `src/main/resources/data/productos.json` y reinicia la API para actualizar los datos.

## Organización e integración

- `ProductosController` expone la ruta HTTP y documenta la operación para Swagger.
- `ProductosService` entrega el catálogo al controlador.
- `RepositorioProductos` lee el JSON incluido en los recursos al arrancar.
- `Producto` define los campos que se serializan en la respuesta.

El proyecto [EjemploSitioFullFront](https://github.com/gmarchant-duoc/EjemploSitioFullFront)
consulta esta API a través del proxy de Vite. Si cambias el puerto en
`src/main/resources/application.properties`, actualiza también el proxy del frontend.

Para generar el JAR en `target/`, ejecuta `.\mvnw.cmd clean package`.
