package fotografia;

//Clase auxiliar para representar productos con precio (fotos, extras, etc.)

public class ProductoConPrecio extends Producto {
    private String descripcion;
    private double precio;

    public ProductoConPrecio(int numero, String descripcion, double precio) {
        super(numero);
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println(descripcion + " | Precio: $" + precio);
    }
}
