package fotografia;

// Clase abstracta que representa un producto general.
// Las subclases deben implementar el método mostrarDetalle().

public abstract class Producto {
    protected int numero;

    public Producto(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public abstract void mostrarDetalle();
}
