package HotelManagementSystem;

import Database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class hmsFrame {
    private static String username = "";
    private static String password = "";
    DatabaseConnection db = new DatabaseConnection();
    HotelManagementSystem hms = new HotelManagementSystem(db.getCon());
    JFrame main;
    public hmsFrame(JFrame main) throws SQLException {
        hms.loginFrame = new JFrame("Manager Login");
        this.main = main;
    }
    public void showManagerLoginPage(){
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(200,150,220,50);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        hms.loginFrame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameField.setBounds(450,150,420,50);
        hms.loginFrame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        passwordLabel.setBounds(200,250,220,50);
        hms.loginFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordField.setBounds(450,250,420,50);
        hms.loginFrame.add(passwordField);

        JButton back=new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        back.setBounds(300,400,220, 50);
        back.addActionListener(actionEvent -> {
            hms.loginFrame.dispose();
            main.setVisible(true);
        });
        hms.loginFrame.add(back);

        JButton submitButton=new JButton("Login");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        submitButton.setBounds(570,400,220, 50);
        submitButton.addActionListener(actionEvent -> {
            username = usernameField.getText();
            password = String.valueOf(passwordField.getPassword());

            try {
                boolean auth = hms.login(username, password);
                if(auth){
                    hms.loginFrame.dispose();
                    hms.mainMenu();
                }
                else{
                    System.out.println("wrong");
                }

            } catch (SQLException throwables) {

                throwables.printStackTrace();
            }
        });
        hms.loginFrame.add(submitButton);

        hms.loginFrame.setSize(1100,750);
        hms.loginFrame.setLayout(null);
        hms.loginFrame.setVisible(true);
        hms.loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
