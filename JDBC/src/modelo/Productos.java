package modelo;

public class Productos {

    private String numArticulo;
    private String seccion;
    private String precio;
    private String paisDeOrigen;

    public Productos(){
        numArticulo = "";
        seccion = "";
        precio = "";
        paisDeOrigen = "";
    }

    public String getNumArticulo() {
        return numArticulo;
    }

    public void setNumArticulo(String numArticulo) {
        this.numArticulo = numArticulo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPaisDeOrigen() {
        return paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }
}
