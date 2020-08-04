package PrimerosPasos;

public class arrays {
    public static void main(String args []) {
        double acumulado;
        double interes=0.10;
        
        double [][] saldo=new double[6][5];
        
        for (int i=0;i<6;i++){
            saldo[i][0]=10000;
            acumulado=10000.00;
            for (int j=1;j<5;j++){
                acumulado=acumulado+(acumulado*interes);
                saldo[i][j]=acumulado;
            }
            interes=interes+0.01;
        }
        for (double []fila:saldo){
            for (double z:fila){
                System.out.printf("%1.2f",z);
                System.out.print(" ");
            }
            System.out.println();
        }
        /*
        int [][] matrix={
            {10,15,18,19,21},
            {5,25,37,41,15},
            {7,19,32,14,90},
            {85,2,7,40,27}
        };
          
        for (int []fila:matrix){
            for (int z:fila){
                System.out.print(z+ " ");
            }
            System.out.println();
        }
        
        for (int i=0;i<4;i++){
            for (int j=0;j<5;j++){
                System.out.print(" Pos "+i+ " "+j+ " es "+matrix[i][j]);
            }
            System.out.println();
        }
        
        int [] matriz_aleatoria=new int[40];
        
        for (int i=0;i<matriz_aleatoria.length;i++){
            matriz_aleatoria[i]=(int)Math.round(Math.random()*100);
        }
        for (int numeros:matriz_aleatoria){
           System.out.print(numeros+ " ");
        }
        
        
        String [] matriz_paises={"España", "Mexico", "Colombia", "Peru", "Chile", 
            "Argentina", "Ecuador", "Venezuela"};
        
        for (String elemento:matriz_paises){
            System.out.println(elemento);
        }
        
        int [] mi_matriz={5, 38, 43, -4, 71};
             
        for (int i=0;i<mi_matriz.length;i++){
            System.out.print(mi_matriz[i]+" ");
        }
        */
    }
}
