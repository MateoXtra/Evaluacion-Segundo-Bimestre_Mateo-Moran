import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.CompactNumberFormat;

public class form2 {
    private JTextField codp;
    private JTextField nomp;
    private JTextField decp;
    private JTextField preciop;
    private JTextField cantp;
    private JTextField catep;
    public JPanel productos;
    private JButton AGREGARPRODUCTOButton;
    private JButton BUSCARPRODUCTOButton;

    public form2() {
        AGREGARPRODUCTOButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String url = "jdbc:mysql://localhost:3306/PRODUCTO";
                String user = "root";
                String pass = "12345";

                String sql = " INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, categoria)";
                try(Connection connection = DriverManager.getConnection(url,user,pass)){
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCTO");

                }catch (SQLException z){
                    System.out.println(z.getMessage());
                }
            }
        });
        BUSCARPRODUCTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
