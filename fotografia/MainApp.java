package fotografia;

import java.util.*;

// Programa principal con menús y submenús para crear pedidos fotográficos.
// Implementa el patrón Builder para construir los pedidos.

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("====================================");
        System.out.println("  SISTEMA DE PEDIDOS FOTOGRÁFICOS");
        System.out.println("====================================");

        // Crear cliente con datos aleatorios
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        String cedula = String.valueOf(rand.nextInt(90000000) + 10000000);
        Cliente cliente = new Cliente(cedula, nombre);

        // Crear el builder
        Pedido.Builder builder = new Pedido.Builder()
                .setCliente(cliente)
                .setNumeroTarjeta(rand.nextInt(90000000) + 10000000);

        int opcion;
        do {
            System.out.println("\n---------- MENÚ PRINCIPAL ----------");
            System.out.println("1. Agregar cámara");
            System.out.println("2. Capturar foto");
            System.out.println("3. Agregar impresión");
            System.out.println("4. Ver pedido actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> { // Submenú de cámaras
                    int opCam;
                    do {
                        System.out.println("\n--- Submenú de Cámaras ---");
                        System.out.println("1. Canon EOS 2000D");
                        System.out.println("2. Nikon D7500");
                        System.out.println("3. Sony Alpha ZV-E10");
                        System.out.println("0. Volver");
                        System.out.print("Seleccione: ");
                        opCam = sc.nextInt();
                        sc.nextLine();

                        if (opCam == 1)
                            builder.addProducto(new Camara(1, "Canon", "EOS 2000D"));
                        else if (opCam == 2)
                            builder.addProducto(new Camara(2, "Nikon", "D7500"));
                        else if (opCam == 3)
                            builder.addProducto(new Camara(3, "Sony", "Alpha ZV-E10"));
                        else if (opCam != 0)
                            System.out.println("Opción no válida.");

                        if (opCam != 0)
                            System.out.println("Cámara agregada correctamente.");
                    } while (opCam != 0);
                }

                case 2 -> { // Capturar foto (con precio manual)
                    System.out.print("Nombre del archivo de la foto: ");
                    String archivo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precioFoto = sc.nextDouble();
                    sc.nextLine();

                    Foto foto = new Foto(archivo);
                    foto.print();

                    builder.addProducto(new ProductoConPrecio(4, "Foto '" + archivo + "'", precioFoto));
                    System.out.println("Foto agregada correctamente.");
                }

                case 3 -> { // Submenú de impresiones
                    int opImp;
                    do {
                        System.out.println("\n--- Submenú de Impresiones ---");
                        System.out.println("1. Blanco y negro");
                        System.out.println("2. A color");
                        System.out.println("3. Alta resolución");
                        System.out.println("0. Volver");
                        System.out.print("Seleccione: ");
                        opImp = sc.nextInt();
                        sc.nextLine();

                        if (opImp == 0) break;

                        Foto[] fotos = { new Foto("foto1.jpg"), new Foto("foto2.jpg") };

                        if (opImp == 1)
                            builder.addProducto(new Impresion(5, "Blanco y negro", fotos));
                        else if (opImp == 2)
                            builder.addProducto(new Impresion(6, "Color", fotos));
                        else if (opImp == 3)
                            builder.addProducto(new Impresion(7, "Alta resolución", fotos));
                        else
                            System.out.println("Opción no válida.");

                        System.out.println("Impresión agregada correctamente.");
                    } while (opImp != 0);
                }

                case 4 -> { // Mostrar pedido con builder
                    Pedido pedido = builder.build();
                    pedido.mostrarPedido();
                }

                case 0 -> System.out.println("Gracias por usar el sistema.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
