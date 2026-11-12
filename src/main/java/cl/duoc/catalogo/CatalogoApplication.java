package cl.duoc.catalogo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "API del catálogo de productos",
        description = "API educativa de Duoc UC para consultar un catálogo de ejemplo.",
        version = "1.0"))
public class CatalogoApplication {
    public static void main(String[] args) {
        // Spring inicia el servidor HTTP y detecta los componentes del paquete.
        SpringApplication.run(CatalogoApplication.class, args);
    }
}
