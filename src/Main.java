import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login");
        frame.setContentPane(new form1().login);
        frame.pack();
        frame.setVisible(true);
    }
}