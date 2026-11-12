package cl.duoc.catalogo.controller;

import cl.duoc.catalogo.model.Producto;
import cl.duoc.catalogo.service.ProductosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Productos", description = "Consultas del catálogo")
public class ProductosController {
    private final ProductosService servicio;

    public ProductosController(ProductosService servicio) {
        this.servicio = servicio;
    }

    // springdoc incorpora estas anotaciones a la documentación que muestra Swagger UI.
    @Operation(
            summary = "Listar los productos",
            description = "Devuelve el catálogo completo. La consulta no requiere parámetros ni autenticación.")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de productos. Si el catálogo está vacío, devuelve [].",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Producto.class))))
    @GetMapping("/api/productos")
    public List<Producto> listar() {
        // Spring convierte la lista a JSON en la respuesta HTTP.
        return servicio.listar();
    }
}
