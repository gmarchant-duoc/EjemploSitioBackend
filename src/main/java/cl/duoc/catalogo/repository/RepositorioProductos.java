package cl.duoc.catalogo.repository;

import cl.duoc.catalogo.model.Producto;
import java.io.IOException;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

@Repository
public class RepositorioProductos {
    private final List<Producto> productos;

    public RepositorioProductos(JsonMapper jsonMapper) throws IOException {
        // El classpath permite leer el recurso tanto en desarrollo como dentro del JAR.
        // Cargamos una sola vez y conservamos una lista de solo lectura en memoria.
        var recurso = new ClassPathResource("data/productos.json");
        try (var entrada = recurso.getInputStream()) {
            productos = List.copyOf(jsonMapper.readValue(entrada, new TypeReference<List<Producto>>() {}));
        }
    }

    public List<Producto> listar() {
        return productos;
    }
}
