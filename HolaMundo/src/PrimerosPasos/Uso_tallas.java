package PrimerosPasos;

import java.util.Scanner;
public class Uso_tallas {
    
    enum Talla {MINI, MEDIANO, GRANDE, MUY_GRANDE};
    enum Talla2 {
        MINI("S"),MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");
        
        private String abreviatura;
        
        private Talla2(String abreviatura){
            this.abreviatura=abreviatura;
        }
        public String dameAbreviatura(){
            return abreviatura;
        }
    }
    
    public static void main(String[] args) {
        Talla s=Talla.MINI;
        Talla m=Talla.MEDIANO;
        Talla l=Talla.GRANDE;
        Talla xl=Talla.MUY_GRANDE;
        
        Scanner entrada=new Scanner(System.in);
        System.out.println("Introduce la talla, por favor: MINI, MEDIANO, GRANDE, MUY_GRANDE");
        String entrada_datos=entrada.next().toUpperCase();
        
        Talla2 la_talla=Enum.valueOf(Talla2.class,entrada_datos);
        System.out.println("Talla="+la_talla);
        System.out.println("Abreviatura="+la_talla.dameAbreviatura());
        
    }
}
