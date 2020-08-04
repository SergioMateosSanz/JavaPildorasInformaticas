package Excepciones;

import javax.swing.*;

public class CompruebaMail {

    public static void main(String[] args) {

        String email = JOptionPane.showInputDialog("Introduce email");
        try {
            examinaMail(email);
        } catch (LongitudMailErronea e) {
            System.out.println("Datos introducidos erroneos");
            e.printStackTrace();
        }
        /*try {
            examinaMail(email);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Datos introducidos erroneos");
        }*/
    }

    static void examinaMail(String mail) throws LongitudMailErronea{
        int arroba = 0;
        boolean punto = false;

        if (mail.length() <= 3){
            //ArrayIndexOutOfBoundsException miExcepcion = new ArrayIndexOutOfBoundsException();
            //throw miExcepcion;
            //throw new ArrayIndexOutOfBoundsException();
            throw new LongitudMailErronea("El mail no puede tener menos de 3 caracteres");
        } else {
            for (int i = 0; i < mail.length(); i++) {
                if (mail.charAt(i) == '@') {
                    arroba++;
                }
                if (mail.charAt(i) == '.') {
                    punto = true;
                }
            }

            if (arroba == 1 && punto == true) {
                System.out.println("Es correcto");
            } else {
                System.out.println("Es incorrecto");
            }
        }
    }
}

class LongitudMailErronea extends Exception{

    public LongitudMailErronea(){}

    public LongitudMailErronea(String msjError){

        super(msjError);
    }
}
