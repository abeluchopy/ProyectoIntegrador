package ProyectoIntegrador.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha = LocalDateTime.now();

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido() {}

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
        linea.setPedido(this);
    }

    public double getTotal() {
        return lineas.stream().mapToDouble(LineaPedido::getSubtotal).sum();
    }

    public Long getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public List<LineaPedido> getLineas() { return lineas; }
}

