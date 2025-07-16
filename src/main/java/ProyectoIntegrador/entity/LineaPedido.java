package ProyectoIntegrador.entity;

import jakarta.persistence.*;

@Entity
public class LineaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cantidad;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Pedido pedido;

    public LineaPedido() {}

    public LineaPedido(Producto producto, Pedido pedido, int cantidad) {
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return cantidad * producto.getPrecio();
    }

    public Long getId() { return id; }
    public int getCantidad() { return cantidad; }
    public Producto getProducto() { return producto; }
    public Pedido getPedido() { return pedido; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setProducto(Producto producto) { this.producto = producto; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
}
