package ProyectoIntegrador.dto;

import javax.sound.sampled.Line;

public class LineaPedidoDTO {
    private Long productoId;
    private int cantidad;

    public LineaPedidoDTO() {}

    public LineaPedidoDTO(Long productoID, int cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
    }
    // Getters y setters
    public Long getProductoId() { return productoId; }
    public int getCantidad() { return cantidad; }

    public void setProductoId(Long productoId) { this.productoId = productoId; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
