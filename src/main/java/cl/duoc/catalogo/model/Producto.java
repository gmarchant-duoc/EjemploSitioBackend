package cl.duoc.catalogo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

// Lombok genera los métodos de acceso durante la compilación.
@Getter
@Setter
public class Producto {
    @Schema(description = "Identificador del producto", example = "1")
    private int id;
    @Schema(description = "Nombre que se muestra en el catálogo", example = "Zapatillas")
    private String nombre;
    @Schema(description = "URL de la imagen del producto", example = "https://example.com/zapatillas.webp")
    private String imagen;
    @Schema(description = "Precio entero en pesos chilenos (CLP)", example = "48000")
    private int precio;

    // Jackson usa este constructor para crear un producto a partir del JSON local.
    @JsonCreator
    public Producto(
            @JsonProperty("id") int id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("imagen") String imagen,
            @JsonProperty("precio") int precio) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }

}
