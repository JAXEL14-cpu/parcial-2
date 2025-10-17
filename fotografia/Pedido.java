package fotografia;

import java.util.*;


//Representa un pedido que realiza un cliente.
//Aplica el patrón de diseño Builder para su construcción.
 
public class Pedido {
    private Cliente cliente;
    private List<Producto> productos;
    private Date fecha;
    private int numeroTarjetaCredito;

     // Constructor privado, solo accesible desde el Builder 
    private Pedido(Builder builder) {
        this.cliente = builder.cliente;
        this.productos = builder.productos;
        this.fecha = builder.fecha;
        this.numeroTarjetaCredito = builder.numeroTarjetaCredito;
    }

    // Muestra los datos completos del pedido 
    public void mostrarPedido() {
        System.out.println("\n===== DETALLE DEL PEDIDO =====");
        System.out.println(cliente);
        System.out.println("Fecha: " + fecha);
        System.out.println("N° Tarjeta: ****" + (numeroTarjetaCredito % 10000));
        System.out.println("--------------------------------");

        double total = 0;
        for (Producto p : productos) {
            p.mostrarDetalle();
            if (p instanceof ProductoConPrecio precioProd) {
                total += precioProd.getPrecio();
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Total de productos: " + productos.size());
        System.out.println("Total a pagar: $" + total);
        System.out.println("Pedido registrado correctamente.");
    }

      //Builder interno para crear pedidos paso a paso 

    public static class Builder {
        private Cliente cliente;
        private List<Producto> productos = new ArrayList<>();
        private Date fecha = new Date();
        private int numeroTarjetaCredito;

        public Builder setCliente(Cliente cliente) {
            this.cliente = cliente;
            return this;
        }

        public Builder addProducto(Producto producto) {
            productos.add(producto);
            return this;
        }

        public Builder setNumeroTarjeta(int numeroTarjetaCredito) {
            this.numeroTarjetaCredito = numeroTarjetaCredito;
            return this;
        }

        public Pedido build() {
            return new Pedido(this);
        }
    }
}
