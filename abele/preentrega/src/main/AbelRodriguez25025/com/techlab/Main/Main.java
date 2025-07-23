package com.techlab;

import com.techlab.productos.Producto;
import com.techlab.pedidos.*;
import com.techlab.excepciones.StockInsuficienteException;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Producto> productos = new ArrayList<>();
    static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elija una opción: ");

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarActualizarProducto();
                case 4 -> eliminarProducto();
                case 5 -> crearPedido();
                case 6 -> listarPedidos();
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 7);
    }

    static void mostrarMenu() {
        System.out.println("\n==== SISTEMA DE GESTIÓN - TECHLAB ====");
        System.out.println("1) Agregar producto");
        System.out.println("2) Listar productos");
        System.out.println("3) Buscar/Actualizar producto");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Crear un pedido");
        System.out.println("6) Listar pedidos");
        System.out.println("7) Salir");
    }

    static void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        double precio = leerDouble("Precio: ");
        int stock = leerEntero("Cantidad en stock: ");
        productos.add(new Producto(nombre, precio, stock));
        System.out.println("Producto agregado.");
    }

    static void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }
        productos.forEach(System.out::println);
    }

    static void buscarActualizarProducto() {
        int id = leerEntero("Ingrese el ID del producto a buscar: ");
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            System.out.println("Encontrado: " + p);
            System.out.println("Desea actualizar el precio o stock? (s/n)");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                p.setPrecio(leerDouble("Nuevo precio: "));
                p.setStock(leerEntero("Nuevo stock: "));
                System.out.println("Producto actualizado.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    static void eliminarProducto() {
        int id = leerEntero("ID del producto a eliminar: ");
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            System.out.println("¿Seguro que desea eliminarlo? (s/n)");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                productos.remove(p);
                System.out.println("Producto eliminado.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    static void crearPedido() {
        Pedido pedido = new Pedido();
        while (true) {
            listarProductos();
            int id = leerEntero("ID del producto a agregar (0 para finalizar): ");
            if (id == 0) break;
            Producto p = buscarProductoPorId(id);
            if (p == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }
            int cantidad = leerEntero("Cantidad deseada: ");
            try {
                if (cantidad > p.getStock()) {
                    throw new StockInsuficienteException("Stock insuficiente.");
                }
                pedido.agregarLinea(new LineaPedido(p, cantidad));
                p.setStock(p.getStock() - cantidad);
                System.out.println("Producto agregado al pedido.");
            } catch (StockInsuficienteException e) {
                System.out.println(e.getMessage());
            }
        }
        pedidos.add(pedido);
        System.out.println("Pedido creado. Total: $" + pedido.calcularTotal());
    }

    static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos.");
            return;
        }
        for (Pedido p : pedidos) {
            System.out.println(p);
            System.out.println("-------------------");
        }
    }

    static Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número decimal válido.");
            }
        }
    }
}
