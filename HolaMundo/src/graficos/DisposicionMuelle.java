package graficos;

        import javax.swing.*;

public class DisposicionMuelle {

    public static void main(String[] args) {

        MarcoMuelle miMarco=new MarcoMuelle();
        miMarco.setTitle("Ejemplo Disposicion en Muelle");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoMuelle extends JFrame {

    public MarcoMuelle(){

        setBounds(300,400,1000,350);
        LaminaMuelle miLaminaMuelle = new LaminaMuelle();
        add(miLaminaMuelle);
        setVisible(true);
    }
}

class LaminaMuelle extends JPanel{

    public LaminaMuelle(){

        JButton botonA = new JButton("Boton A");
        JButton botonB = new JButton("Boton B");
        JButton botonC = new JButton("Boton C");

        SpringLayout miDisposicion = new SpringLayout();
        setLayout(miDisposicion);

        add(botonA);
        add(botonB);
        add(botonC);

        Spring miMuelle = Spring.constant(0,10,100);
        Spring miMuelleRigido = Spring.constant(10);
        miDisposicion.putConstraint(SpringLayout.WEST, botonA, miMuelle, SpringLayout.WEST, this);
        miDisposicion.putConstraint(SpringLayout.WEST, botonB, miMuelleRigido, SpringLayout.EAST, botonA);
        miDisposicion.putConstraint(SpringLayout.WEST, botonC, miMuelleRigido, SpringLayout.EAST, botonB);
        miDisposicion.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, botonC);
    }
}