package HotelManagementSystem;

import LoginSystem.Login;

import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class HotelManagementSystem implements Login {
    Connection con;
    JFrame loginFrame;
    JFrame menuFrame;
    HotelRoomAvailability hotelRV = new HotelRoomAvailability();
    RoomMaintenance roomM = new RoomMaintenance();
    HotelExpense hotelE = new HotelExpense();
    CheckFinancialData checkData = new CheckFinancialData();
    HotelManagementSystem(Connection con) {
        this.con = con;
    }
    @Override
    public boolean login(String username, String password) throws SQLException {
        Statement statement = this.con.createStatement();
        String q = String.format("select password from admin where username = '%s';", username);
        ResultSet resultSet = statement.executeQuery(q);
//        gets us password if the username exists
        if (resultSet.next()) {
//            compare password with user input
            if (resultSet.getString(1).equals(password)) {
                return true;
            } else {
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
        } else {
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
    public void mainMenu() {
        menuFrame = new JFrame("Hotel+ | Hotel Management System");

        JLabel welcomeLabel = new JLabel("Welcome to Hotel Management System");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        welcomeLabel.setBounds(300, 50, 800, 50);
        menuFrame.add(welcomeLabel);

        JButton roomAvailButton = new JButton("Check room details");
        roomAvailButton.setBounds(400, 200, 300, 40);
        roomAvailButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        roomAvailButton.setFocusPainted(false);
        roomAvailButton.addActionListener(actionEvent -> {
            hotelRV.viewRoomDetails(menuFrame);
            hotelRV.setConnection(con);
        });
        menuFrame.add(roomAvailButton);

        JButton checkFinancialData = new JButton("Check financial data");
        checkFinancialData.setBounds(400, 270, 300, 40);
        checkFinancialData.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        checkFinancialData.setFocusPainted(false);
        checkFinancialData.addActionListener(actionEvent -> {
            checkData.setCon(con);
            try {
                checkData.viewFinancialData(menuFrame);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        menuFrame.add(checkFinancialData);

        JButton roomMainteButton = new JButton("Room maintenance");
        roomMainteButton.setBounds(400, 340, 300, 40);
        roomMainteButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        roomMainteButton.setFocusPainted(false);
        roomMainteButton.addActionListener(deleteEvent -> {
            roomM.setConnection(con);
            roomM.roomMaintenance(menuFrame);
        });
        menuFrame.add(roomMainteButton);

        JButton hotelExpense = new JButton("Hotel Expenses");
        hotelExpense.setBounds(400, 410, 300, 40);
        hotelExpense.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        hotelExpense.setFocusPainted(false);
        hotelExpense.addActionListener(actionEvent -> {
            hotelE.setCon(con);
            hotelE.addExpense(menuFrame);

        });
        menuFrame.add(hotelExpense);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 480, 300, 40);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        exitButton.setFocusPainted(false);

        exitButton.addActionListener(actionEvent -> {
            menuFrame.dispose();

        });
        menuFrame.add(exitButton);


        menuFrame.setSize(1100, 750);
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setLayout(null);//using no layout managers
        menuFrame.setVisible(true);//maki
    }
}
