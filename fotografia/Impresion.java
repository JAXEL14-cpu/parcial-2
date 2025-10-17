package fotografia;

 //Subclase de Producto que representa una impresión fotográfica.
 //Contiene una lista de fotos asociadas y el tipo de color.

public class Impresion extends Producto {
    private String color;
    private Foto[] fotos;

    public Impresion(int numero, String color, Foto[] fotos) {
        super(numero);
        this.color = color;
        this.fotos = fotos;
    }

 
    public void mostrarDetalle() {
        System.out.println("Impresión en color: " + color + " | Código: " + numero);
        System.out.println("Fotos incluidas:");
        for (Foto f : fotos) {
            System.out.println(" - " + f.getFichero());
        }
    }
}
