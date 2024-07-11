import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Busqueda {
    public JPanel mainPanel;
    private JTextField BuscarTF;
    private JButton regresar;
    private JLabel NombreTxt;
    private JLabel CedulaTxt;
    private JLabel b1Txt;
    private JLabel b2Txt;
    private JButton Buscar;

    public Busqueda() {
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

        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/Poo";
                String user = "root";
                String password = "";

                String cedula = BuscarTF.getText();

                String sql = "SELECT * FROM estudiantes WHERE cedula = ?";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, cedula);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        NombreTxt.setText(resultSet.getString("nombre"));
                        CedulaTxt.setText(resultSet.getString("cedula"));
                        b1Txt.setText(resultSet.getString("b1"));
                        b2Txt.setText(resultSet.getString("b2"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al buscar datos");
                }
            }
        });
    }


}
