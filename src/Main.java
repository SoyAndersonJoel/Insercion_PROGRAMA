import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Mi aplicación ");
        frame.setContentPane(new Bienvenida().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1900, 900);
        frame.pack();
        frame.setVisible(true);

    }
}