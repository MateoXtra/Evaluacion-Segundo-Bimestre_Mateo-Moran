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

                Productos producto = new Productos();
                String codigo = codp.getText();
                String nombre = nomp.getText();
                String descripcion = decp.getText();
                double precio=Double.parseDouble(preciop.getText());
                int cantidad=Integer.parseInt(cantp.getText());
                String categoia=catep.getText();

                producto.setCodigoProducto(codigo);
                producto.setNombreProducto(nombre);
                producto.setDescripcionProducto(descripcion);
                producto.setPrecioProducto(precio);
                producto.setCantidadProducto(cantidad);
                producto.setCategoriaProducto(categoia);


                String sql = "INSERT INTO PRODUCTO (codigo_producto, nombre, descripcion, precio, cantidad, categoria) VALUES ('CP001', 'Crema facial anti-edad', 'Crema facial hidratante y antiarrugas, 50ml', 29.99, 50, 'Cuidado Facial')" +
                        "('CP002', 'Shampoo reparador', 'Shampoo fortificante para cabello dañado, 300ml', 12.50, 80, 'Cuidado Capilar')"+ ("'CP003', 'Jabón líquido de manos', 'Jabón antibacterial con aloe vera, 250ml', 8.99, 100, 'Higiene Personal'");
                try (Connection connection = DriverManager.getConnection(url,user,pass)){
                    System.out.println("BASE DE DATOS PRODUCTO CONETACADA CORRECTAMENTE");
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,codigo);
                    preparedStatement.setString(2,nombre);
                    preparedStatement.setString(3,descripcion);
                    preparedStatement.setDouble(4,precio);
                    preparedStatement.setInt(5,cantidad);
                    preparedStatement.setString(6,categoia);
                    preparedStatement.execute();
                }catch (SQLException z){
                    System.out.println(z.getMessage());
                }
            }
        });
        BUSCARPRODUCTOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("BUSCAR PRODUCTO");
                frame.setContentPane(new form3().buscar);
                frame.pack();
                frame.setVisible(true);

                ((JFrame) SwingUtilities.getWindowAncestor(productos)).dispose();
            }
        });
    }
}
