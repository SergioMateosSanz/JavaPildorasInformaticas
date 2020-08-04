package poo;
//import javax.swing.JOptionPane;
public class Uso_Vehiculo {
    public static void main(String args []) {
        
        Coche micoche1=new Coche();
        micoche1.set_color("Rojo");
        
        Furgoneta mifurgoneta1=new Furgoneta(7,580);
        mifurgoneta1.set_color("Blanco");
        mifurgoneta1.set_asientos_cuero("si");
        mifurgoneta1.set_climatizador("si");
        
        System.out.println("Su coche es de color "+micoche1.get_color());
        System.out.println(micoche1.dime_asientos());
        System.out.println(micoche1.dime_climatizador());
        System.out.println("Su furgoneta es de color "+mifurgoneta1.get_color());
        System.out.println(mifurgoneta1.dime_asientos());
        System.out.println(mifurgoneta1.dime_climatizador());
        System.out.println(mifurgoneta1.get_datos_furgoneta());
        
        /*
        Coche micoche=new Coche(); //Instanciar una clase. Ejemplar de clase
        
        System.out.println("Este coche tiene "+micoche.get_ruedas()+" ruedas");
        micoche.set_color(JOptionPane.showInputDialog("Introduce el color del coche, por favor"));
        micoche.set_asientos_cuero(JOptionPane.showInputDialog("¿El coche tiene asientos de cuero?"));
        micoche.set_climatizador(JOptionPane.showInputDialog("¿El coche tiene climatizador?"));
        System.out.println("Su coche es de color "+micoche.get_color());
        System.out.println(micoche.dime_asientos());
        System.out.println(micoche.dime_climatizador());
        System.out.println("Su coche cuesta "+micoche.precio_coche()+" euros");
        */
    }
}
