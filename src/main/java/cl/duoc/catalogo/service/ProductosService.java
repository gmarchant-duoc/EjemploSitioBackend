package cl.duoc.catalogo.service;

import cl.duoc.catalogo.model.Producto;
import cl.duoc.catalogo.repository.RepositorioProductos;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductosService {
    private final RepositorioProductos repositorio;

    public ProductosService(RepositorioProductos repositorio) {
        this.repositorio = repositorio;
    }

    public List<Producto> listar() {
        // Aquí se aplicarían las reglas del catálogo. El repositorio obtiene los datos.
        return repositorio.listar();
    }
}
