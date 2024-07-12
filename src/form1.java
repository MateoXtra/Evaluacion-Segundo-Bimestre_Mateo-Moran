import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    public JPanel login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton INGRESARButton;

    public form1() {
        INGRESARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/USUARIO";
                String user = "root";
                String pass = "12345";

                String sql = "INSERT INTO USUARIO (username, password) VALUES ('Freddy', 'Freddy123')";

                try(Connection connection = DriverManager.getConnection(url,user,pass)){
                    System.out.println("Conexion a la base de datos de usuarios");
                    PreparedStatement preparedStatement = connection.prepareStatement("select * from productos_cp.usuario");
                    ResultSet resultSet = preparedStatement.executeQuery();

                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle("REGISTRO DE PRODUCTOS");
                    frame.setContentPane(new form2().productos);
                    frame.pack();
                    frame.setVisible(true);
                }catch (SQLException q){
                    System.out.println(q);
                }
                ((JFrame)) SwingUtilities.getWindowAncestor(login);
            }
        });
    }
}
