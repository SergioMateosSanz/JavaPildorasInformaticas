package poo;

public class Coche {
    
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int peso_plataforma;
    private String color;
    private int peso_total;
    private boolean asientos_cuero,climatizador;
    
    public Coche(){
        ruedas=4;
        largo=2000;
        ancho=300;
        motor=1600;
        peso_plataforma=500;
    }
    
    public void set_color(String color_coche){
        color=color_coche;
    }
    public void set_asientos_cuero(String asientos_cuero){
        if (asientos_cuero.equalsIgnoreCase("si")){
            this.asientos_cuero=true;
        }else{
            this.asientos_cuero=false;
        }
    }
    public void set_climatizador(String climatizador){
        if (climatizador.equalsIgnoreCase("si")){
            this.climatizador=true;
        }else{
            this.climatizador=false;
        }
    }
    public String get_color(){
        return color;
    }
    public String dime_asientos(){
        if (asientos_cuero==true){
            return "El coche tiene asientos de cuero";
        }else{
            return "El coche no tiene asientos de cuero";
        }
    }
    public String dime_climatizador(){
        if (climatizador==true){
            return "El coche incorpora climatizador";
        }else{
            return "El coche no incorpora climatizador";
        }
    }
    public int get_ruedas(){
        return ruedas;
    }
    public String dime_ruedas(){
        return "Su coche tiene " + ruedas + " ruedas";
    }
    public int get_largo(){
        return largo;
    }
    public int get_ancho(){
        return ancho;
    }
    public int get_motor(){
        return motor;
    }
    public int get_peso_plataforma(){
        return peso_plataforma;
    }
    public int precio_coche(){
        int precio_final=10000;
        if (asientos_cuero=true){
            precio_final=precio_final+2000;
        }
        if (climatizador=true){
            precio_final+=1500;
        }
        return precio_final;
    }
}
