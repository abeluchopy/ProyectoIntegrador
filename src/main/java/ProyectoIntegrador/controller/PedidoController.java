package ProyectoIntegrador.controller;

import ProyectoIntegrador.entity.LineaPedido;
import ProyectoIntegrador.entity.Pedido;
import ProyectoIntegrador.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public Pedido crear(@RequestBody List<LineaPedido> lineas) {
        return pedidoService.crearPedido(lineas);
    }
}

