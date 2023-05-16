package LoginSystem;
import HotelManagementSystem.hmsFrame;
import UserBookingSystem.ubsFrame;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        JFrame main = new JFrame("Main");

        JLabel welcome = new JLabel("Welcome to Hotel Plus | Hotel Booking & Management System");
        welcome.setFont(new Font("Times New Roman", Font.BOLD,20));
        welcome.setBounds(300,50,800,50);
        main.add(welcome);

        JButton userLogin = new JButton("Login as User");
        userLogin.setBounds(400, 200, 300, 40);
        userLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        userLogin.setFocusPainted(false);
        userLogin.addActionListener(actionEvent -> {
            main.dispose();
            ubsFrame uF = null;
            try {
                uF = new ubsFrame(main);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            uF.showUserLoginPage();
        });
        main.add(userLogin);

        JButton managerLogin = new JButton("Login as Manger");
        managerLogin.setBounds(400, 270, 300, 40);
        managerLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        managerLogin.setFocusPainted(false);
        managerLogin.addActionListener(actionEvent -> {
            main.dispose();
            hmsFrame hF = null;
            try {
                hF = new hmsFrame(main);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            hF.showManagerLoginPage();
        });
        main.add(managerLogin);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 340, 300, 40);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(actionEvent -> {
            main.dispose();
        });
        main.add(exitButton);

        main.setSize(1100, 750);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(null);//using no layout managers
        main.setVisible(true);

    }
}

