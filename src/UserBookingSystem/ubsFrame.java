package UserBookingSystem;

import Database.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ubsFrame {
    static String username = "";
    static String password = "";
    DatabaseConnection ubsDb = new DatabaseConnection();
    UserBookingSystem ubs = new UserBookingSystem();
    JFrame main;
    public ubsFrame(JFrame main) throws SQLException{
        ubs.loginFrame = new JFrame("User Login");
        this.main = main;
        ubs.setCon(ubsDb.getCon());
    }
    public void showUserLoginPage(){
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(200,150,220,50);
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        ubs.loginFrame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameField.setBounds(450,150,420,50);
        ubs.loginFrame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        passwordLabel.setBounds(200,250,220,50);
        ubs.loginFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordField.setBounds(450,250,420,50);
        ubs.loginFrame.add(passwordField);

        JButton back=new JButton("Back");
        back.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        back.setBounds(300,400,220, 50);
        back.addActionListener(actionEvent -> {
            ubs.loginFrame.dispose();
            main.setVisible(true);
        });
        ubs.loginFrame.add(back);

        JButton submitButton=new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        submitButton.setBounds(570,400,250, 50);

        submitButton.addActionListener(actionEvent ->{
            username = usernameField.getText();
            password = String.valueOf(passwordField.getPassword());

            try{
                boolean auth = ubs.login(username,password);
                if(auth){
                    ubs.loginFrame.dispose();
                    ubs.mainMenu();
                }
                else{
                    System.out.println("wrong");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        ubs.loginFrame.add(submitButton);

        ubs.loginFrame.setSize(1100,750);
        ubs.loginFrame.setLayout(null);
        ubs.loginFrame.setVisible(true);
        ubs.loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
