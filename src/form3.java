import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form3 {
    private JTextField codigoprod;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton BUSCARButton;
    public JPanel buscar;
    private JButton IRAREGISTRARPRODUCTOSButton;
    private JButton IRALLOGINButton;

    public form3() {
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/PRODUCTO";
                String user = "root";
                String pass = "12345";
                String sql = " SELECT * FROM PRODUCTO";

                try(Connection connection = DriverManager.getConnection(url,user,pass)){
                    System.out.println("Conexion a la base correcta");
                    String query = "SELECT * FROM PRODUCTO where codigo_producto= '"+codigoprod.getText()+"'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        textField1.setText(resultSet.getString("nombre"));
                        textField2.setText(resultSet.getString("descripcion"));
                        textField3.setText(resultSet.getString("precio"));
                        textField3.setText(resultSet.getString("cantidad"));
                        textField3.setText(resultSet.getString("categoria"));
                    }
                }catch (SQLException a){
                    System.out.println(a.getMessage());

                }
            }
        });
        IRALLOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("REGISTRO DE PRODUCTOS");
                frame.setContentPane(new form1().login);
                frame.pack();
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();
            }
        });
        IRAREGISTRARPRODUCTOSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("REGISTRO DE PRODUCTOS");
                frame.setContentPane(new form2().productos);
                frame.pack();
                frame.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(buscar)).dispose();

            }
        });
    }
}
