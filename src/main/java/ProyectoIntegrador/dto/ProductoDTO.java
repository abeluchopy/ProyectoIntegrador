package ProyectoIntegrador.dto;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;

    public ProductoDTO() {}

    public ProductoDTO(Long id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters y Setters
    public Long getId() {return id;}
    public String getNombre() { return nombre;}
    public double getPrecio() { return precio;}
    public int getStock() { return stock;}

    public void setId(Long Id) { this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPrecio(double precio) { this.precio = precio;}
    public void setStock(int stock) {this.stock = stock;}
}
