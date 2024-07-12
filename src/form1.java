import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class form1 {
    public JPanel login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton INGRESAR;

    public form1() {
        INGRESAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/USUARIO";
                String user = "root";
                String pass = "12345";

                String sql = "INSERT INTO USUARIO (username, password) VALUES ('Freddy', 'Freddy123')";

                try(Connection connection = DriverManager.getConnection(url,user,pass)){
                    System.out.println("Conexion exitosa con la base");

                    String query = "SELECT * FROM USUARIO where username= '"+textField1.getText()+"'";
                    String queryy = "SELECT * FROM USUARIO where password= '"+passwordField1.getText()+"'";

                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setTitle("REGISTRO DE PRODUCTOS");
                    frame.setContentPane(new form2().productos);
                    frame.pack();
                    frame.setVisible(true);


                }catch (SQLException i){
                    System.out.println(i.getMessage());
                }
                ((JFrame) SwingUtilities.getWindowAncestor(login)).dispose();

            }
        });
    }
}
