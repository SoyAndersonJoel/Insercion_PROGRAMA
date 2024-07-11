import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insercion {
    public JPanel mainPanel;
    private JTextField NombreTF;
    private JTextField CedulaTF;
    private JTextField B1TF;
    private JTextField B2TF;
    private JButton regresar;
    private JButton insertar;
    private JButton cancelar;

    public Insercion() {
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Mi aplicación ");
                frame.setContentPane(new Bienvenida().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.pack();
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(mainPanel)).dispose();
            }
        });

        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/Poo";
                String user = "root";
                String password = "";

                String nombre = NombreTF.getText();
                String cedula = CedulaTF.getText();
                Double b1 = Double.parseDouble(B1TF.getText());
                Double b2 = Double.parseDouble(B2TF.getText());

                String sql = "INSERT INTO estudiantes (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, cedula);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setDouble(3, b1);
                    preparedStatement.setDouble(4, b2);

                    preparedStatement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Datos insertados");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al insertar datos");
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NombreTF.setText("");
                CedulaTF.setText("");
                B1TF.setText("");
                B2TF.setText("");
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
