package UserBookingSystem;

import LoginSystem.Login;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserBookingSystem implements Login {
    Connection con;
    JFrame loginFrame;
    JFrame menuFrame;
    BookRoom br = new BookRoom();
    RoomCheckout rco = new RoomCheckout();
    UserBookingSystem(){
    }
    @Override
    public boolean login(String username, String password) throws SQLException{
        Statement statement = this.con.createStatement();
        String q = String.format("select password from user where username = '%s';", username);
        ResultSet resultSet = statement.executeQuery(q);
//        gets us password if the username exists
        if (resultSet.next()) {
//            compare password with user input
            if (resultSet.getString(1).equals(password)) {
                return true;
            }
            else {
                JFrame popup = new JFrame("Invalid password");
                JLabel popupMsg = new JLabel("The password you entered is invalid.");
                popupMsg.setBounds(20, 10, 300, 50);
                popupMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                popup.add(popupMsg);

                JButton button = new JButton("OK");
                button.setBounds(120, 60, 70, 20);
                button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                button.addActionListener(actionEvent2 -> {
                    popup.dispose();
                });
                popup.add(button);

                popup.setLayout(null);
                popup.setSize(350, 150);
                popup.setVisible(true);
                return false;
            }
        }
        else {
            JFrame popup = new JFrame("Invalid username");
            JLabel popupMsg = new JLabel("The username you entered does not exist.");
            popupMsg.setBounds(20, 10, 500, 50);
            popupMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            popup.add(popupMsg);

            JButton button = new JButton("OK");
            button.setBounds(170, 60, 70, 20);
            button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            button.addActionListener(actionEvent2 -> {
                popup.dispose();
            });
            popup.add(button);

            popup.setLayout(null);
            popup.setSize(450, 150);
            popup.setVisible(true);
            return false;
        }

    }
    public void mainMenu(){
        menuFrame = new JFrame("Hotel+ | User Booking System");

        JLabel welcomeLabel = new JLabel("Welcome to Room Booking System");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        welcomeLabel.setBounds(330, 50, 800, 50);
        menuFrame.add(welcomeLabel);

        JButton bookRoom = new JButton("Room booking and check in");
        bookRoom.setBounds(400, 240, 300, 40);
        bookRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        bookRoom.setFocusPainted(false);
        bookRoom.addActionListener(actionEvent -> {
            br.setConnection(this.con);
            br.viewRoomDetails(menuFrame);
        });
        menuFrame.add(bookRoom);

        JButton checkoutRoom = new JButton("Check out");
        checkoutRoom.setBounds(400, 310, 300, 40);
        checkoutRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        checkoutRoom.setFocusPainted(false);
        checkoutRoom.addActionListener(actionEvent -> {
            rco.setCon(this.con);
            rco.roomCheckout(menuFrame);
        });
        menuFrame.add(checkoutRoom);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 380, 300, 40);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(actionEvent -> {
            menuFrame.dispose();
        });
        menuFrame.add(exitButton);

        menuFrame.setSize(1100, 750);
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);//using no layout managers
        menuFrame.setVisible(true);

    }
    public Connection getCon(){
        return this.con;
    }
    public void setCon(Connection con){
        this.con = con;
    }
}
