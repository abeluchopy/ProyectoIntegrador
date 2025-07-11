package ProyectoIntegrador.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private LocalDateTime fecha;
    private List<LineaPedidoDTO> lineas;
    private double total;

    public PedidoDTO() {}

    public PedidoDTO(Long id, LocalDateTime fecha, List<LineaPedidoDTO> lineas, double total) {
        this.id = id;
        this.fecha = fecha;
        this.lineas = lineas;
        this.total = total;
    }
    // Getters y setters
    public Long getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public List<LineaPedidoDTO> getLineas() { return lineas; }
    public double getTotal() { return total; }

    public void setId(Long id) { this.id = id; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setLineas(List<LineaPedidoDTO> lineas) { this.lineas = lineas; }
    public void setTotal(double total) { this.total = total; }

}
