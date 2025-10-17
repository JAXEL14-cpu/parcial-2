package fotografia;

//Subclase de Producto que representa una cámara con marca y modelo.

public class Camara extends Producto {
    private String marca;
    private String modelo;

    public Camara(int numero, String marca, String modelo) {
        super(numero);
        this.marca = marca;
        this.modelo = modelo;
    }


    public void mostrarDetalle() {
        System.out.println("Cámara " + marca + " - Modelo " + modelo + " | Código: " + numero);
    }
}
