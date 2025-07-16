package ProyectoIntegrador.service;



import ProyectoIntegrador.entity.LineaPedido;
import ProyectoIntegrador.entity.Pedido;
import ProyectoIntegrador.entity.Producto;
import ProyectoIntegrador.repository.PedidoRepository;
import ProyectoIntegrador.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Pedido crearPedido(List<LineaPedido> lineas) {
        Pedido pedido = new Pedido();

        for (LineaPedido linea : lineas) {
            Producto p = productoRepository.findById(linea.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (p.getStock() < linea.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para " + p.getNombre());
            }

            p.setStock(p.getStock() - linea.getCantidad());

            LineaPedido nueva = new LineaPedido(p, pedido, linea.getCantidad());
            pedido.agregarLinea(nueva);
        }

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}

