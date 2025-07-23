package com.techlab.pedidos;

import java.util.*;

public class Pedido {
    private static int contador = 1;
    private int id;
    private List<LineaPedido> lineas;

    public Pedido() {
        this.id = contador++;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea(LineaPedido linea) {
        this.lineas.add(linea);
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaPedido l : lineas) {
            total += l.calcularSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido ID: " + id + "\n");
        for (LineaPedido l : lineas) {
            sb.append("Producto: " + l.getProducto().getNombre() + ", Cantidad: " + l.getCantidad() + ", Subtotal: $" + l.calcularSubtotal() + "\n");
        }
        sb.append("TOTAL: $" + calcularTotal());
        return sb.toString();
    }
}

