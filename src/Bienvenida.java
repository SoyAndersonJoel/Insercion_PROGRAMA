import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenida {
    public JPanel mainPanel;
    private JButton insertar;
    private JButton buscarB;

    public Bienvenida() {
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Mi aplicación ");
                frame.setContentPane(new Insercion().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.pack();
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();
            }
        });

        buscarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fram = new JFrame("Mi aplicación ");
                fram.setContentPane(new Busqueda().mainPanel);
                fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fram.setSize(800, 600);
                fram.pack();
                fram.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();
            }
        });
    }


    public static void main(String[] args) {
        JFrame framer = new JFrame("Bienvenida");
        framer.setContentPane(new Bienvenida().mainPanel);
        framer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framer.pack();
        framer.setVisible(true);
    }
}
