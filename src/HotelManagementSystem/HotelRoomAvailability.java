package HotelManagementSystem;

import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class HotelRoomAvailability {
    JFrame viewRoomAvailability;
    Connection connection;
    HotelRoomAvailability(){
        viewRoomAvailability = new JFrame("Rooms available in Hotel");
    }
    public void setConnection(Connection con){
        this.connection = con;
    }
    public void viewRoomDetails(JFrame menuFrame){
        menuFrame.setVisible(false);

        JPanel panel = new JPanel();

        JLabel view = new JLabel("Check rooms availability");
        view.setFont(new Font("Times New Roman", Font.BOLD, 32));
        view.setBounds(380, 50, 800, 50);
        viewRoomAvailability.add(view);

        JButton luxuryDoubleRoom = new JButton("Luxury double room");
        luxuryDoubleRoom.setBounds(400, 200, 300, 40);
        luxuryDoubleRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        luxuryDoubleRoom.setFocusPainted(false);
        luxuryDoubleRoom.addActionListener(actionEvent ->{
            try {
                viewLuxuryDoubleRoom();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        viewRoomAvailability.add(luxuryDoubleRoom);

        JButton deluxeDoubleRoom = new JButton("Deluxe double room");
        deluxeDoubleRoom.setBounds(400, 270, 300, 40);
        deluxeDoubleRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deluxeDoubleRoom.setFocusPainted(false);
        deluxeDoubleRoom.addActionListener(actionEvent ->{
            try{
                viewDeluxeDoubleRoom();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        viewRoomAvailability.add(deluxeDoubleRoom);

        JButton luxurySingleRoom = new JButton("Luxury single room");
        luxurySingleRoom.setBounds(400, 340, 300, 40);
        luxurySingleRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        luxurySingleRoom.setFocusPainted(false);
        luxurySingleRoom.addActionListener(actionEvent ->{
            try {
                viewLuxurySingleRoom();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        viewRoomAvailability.add(luxurySingleRoom);

        JButton deluxeSingleRoom = new JButton("Deluxe single room");
        deluxeSingleRoom.setBounds(400, 410, 300, 40);
        deluxeSingleRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deluxeSingleRoom.setFocusPainted(false);
        deluxeSingleRoom.addActionListener(actionEvent ->{
            try{
                viewDeluxeSingleRoom();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        viewRoomAvailability.add(deluxeSingleRoom);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(400, 480, 300, 40);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            viewRoomAvailability.dispose();
            menuFrame.setVisible(true);
        });
        viewRoomAvailability.add(backButton);

        viewRoomAvailability.setSize(1100,750);
        viewRoomAvailability.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        viewRoomAvailability.setLayout(null);
        viewRoomAvailability.add(panel);
        viewRoomAvailability.setVisible(true);
    }
    public void viewLuxuryDoubleRoom() throws SQLException {
        viewRoomAvailability.setVisible(false);

        JFrame doubleRoom = new JFrame("All room types available in Hotel");
        JPanel doublePanel = new JPanel();

        Statement statement = this.connection.createStatement();
        String q = "select * from doubleroom where (roomNumber < 11)";
        ResultSet resultSet = statement.executeQuery(q);
        while (resultSet.next()){
            JPanel hotelCard = new JPanel();
            JLabel roomNumberLabel = new JLabel("Room Number");
            roomNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomNumberVal = new JLabel(String.valueOf(resultSet.getInt(1)));
            roomNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeLabel = new JLabel("Room Type");
            roomTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeVal = new JLabel(resultSet.getString(9));
            roomTypeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameLabel = new JLabel("Name of Customer 1");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameVal = new JLabel(resultSet.getString(2));
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberLabel = new JLabel("Phone number of Customer 1");
            phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberVal = new JLabel(resultSet.getString(3));
            phoneNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel = new JLabel("Gender of Customer 1");
            genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderVal = new JLabel(resultSet.getString(4));
            genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameLabel2 = new JLabel("Name of Customer 2");
            nameLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameVal2 = new JLabel(resultSet.getString(5));
            nameVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberLabel2 = new JLabel("Phone number of Customer 2");
            phoneNumberLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberVal2 = new JLabel(resultSet.getString(6));
            phoneNumberVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel2 = new JLabel("Gender of Customer 2");
            genderLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderVal2 = new JLabel(resultSet.getString(7));
            genderVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel bookingStatusLabel = new JLabel("Booking Status");
            bookingStatusLabel.setFont(new Font("Times New Roman",Font.PLAIN,20));

            JLabel bookingStatusVal = new JLabel(String.valueOf(resultSet.getBoolean(8)));
            bookingStatusVal.setFont(new Font("Times New Roman",Font.PLAIN,20));

            hotelCard.add(roomNumberLabel);
            hotelCard.add(roomNumberVal);
            hotelCard.add(roomTypeLabel);
            hotelCard.add(roomTypeVal);
            hotelCard.add(nameLabel);
            hotelCard.add(nameVal);
            hotelCard.add(phoneNumberLabel);
            hotelCard.add(phoneNumberVal);
            hotelCard.add(genderLabel);
            hotelCard.add(genderVal);
            hotelCard.add(nameLabel2);
            hotelCard.add(nameVal2);
            hotelCard.add(phoneNumberLabel2);
            hotelCard.add(phoneNumberVal2);
            hotelCard.add(genderLabel2);
            hotelCard.add(genderVal2);
            hotelCard.add(bookingStatusLabel);
            hotelCard.add(bookingStatusVal);

            hotelCard.setSize(1000, 400);
            if(resultSet.getBoolean(8)){
                hotelCard.setBackground(new Color(232, 84, 84));
            }
            else {
                hotelCard.setBackground(new Color(166, 209, 230));
            }
            hotelCard.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            hotelCard.setLayout(cardLayout);
            doublePanel.add(hotelCard);

        }
        // panel for j button
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            doubleRoom.dispose();
            viewRoomAvailability.setVisible(true);
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(254, 251, 246));
        doublePanel.add(buttonPanel);

//        panel.setPreferredSize(new Dimension(500,500));
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        doublePanel.setLayout(layout);
        doublePanel.setBackground(new Color(254, 251, 246));
        doublePanel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(doublePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(25);
        doubleRoom.add(scrollBar);
        doubleRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doubleRoom.setPreferredSize(new Dimension(1100,750));
        doubleRoom.pack();
        doubleRoom.setVisible(true);
    }
    public void viewDeluxeDoubleRoom() throws SQLException {
        viewRoomAvailability.setVisible(false);

        JFrame doubleRoom = new JFrame("All room types available in Hotel");
        JPanel doublePanel = new JPanel();

        Statement statement = this.connection.createStatement();
        String q = "select * from doubleroom where (roomNumber > 10 && roomNumber <31)";
        ResultSet resultSet = statement.executeQuery(q);
        while (resultSet.next()){
            JPanel hotelCard = new JPanel();
            JLabel roomNumberLabel = new JLabel("Room Number");
            roomNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomNumberVal = new JLabel(String.valueOf(resultSet.getInt(1)));
            roomNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeLabel = new JLabel("Room Type");
            roomTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeVal = new JLabel(resultSet.getString(9));
            roomTypeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameLabel = new JLabel("Name of Customer 1");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameVal = new JLabel(resultSet.getString(2));
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberLabel = new JLabel("Phone number of Customer 1");
            phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberVal = new JLabel(resultSet.getString(3));
            phoneNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel = new JLabel("Gender of Customer 1");
            genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderVal = new JLabel(resultSet.getString(4));
            genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameLabel2 = new JLabel("Name of Customer 2");
            nameLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameVal2 = new JLabel(resultSet.getString(5));
            nameVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberLabel2 = new JLabel("Phone number of Customer 2");
            phoneNumberLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberVal2 = new JLabel(resultSet.getString(6));
            phoneNumberVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel2 = new JLabel("Gender of Customer 2");
            genderLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderVal2 = new JLabel(resultSet.getString(7));
            genderVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel bookingStatusLabel = new JLabel("Booking Status");
            bookingStatusLabel.setFont(new Font("Times New Roman",Font.PLAIN,20));

            JLabel bookingStatusVal = new JLabel(String.valueOf(resultSet.getBoolean(8)));
            bookingStatusVal.setFont(new Font("Times New Roman",Font.PLAIN,20));

            hotelCard.add(roomNumberLabel);
            hotelCard.add(roomNumberVal);
            hotelCard.add(roomTypeLabel);
            hotelCard.add(roomTypeVal);
            hotelCard.add(nameLabel);
            hotelCard.add(nameVal);
            hotelCard.add(phoneNumberLabel);
            hotelCard.add(phoneNumberVal);
            hotelCard.add(genderLabel);
            hotelCard.add(genderVal);
            hotelCard.add(nameLabel2);
            hotelCard.add(nameVal2);
            hotelCard.add(phoneNumberLabel2);
            hotelCard.add(phoneNumberVal2);
            hotelCard.add(genderLabel2);
            hotelCard.add(genderVal2);
            hotelCard.add(bookingStatusLabel);
            hotelCard.add(bookingStatusVal);

            hotelCard.setSize(1000, 400);
            if(resultSet.getBoolean(8)){
                hotelCard.setBackground(new Color(232, 84, 84));
            }
            else {
                hotelCard.setBackground(new Color(166, 209, 230));
            }
            hotelCard.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            hotelCard.setLayout(cardLayout);
            doublePanel.add(hotelCard);

        }
        // panel for back button
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            doubleRoom.dispose();
            viewRoomAvailability.setVisible(true);
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(254, 251, 246));
        doublePanel.add(buttonPanel);

//        panel.setPreferredSize(new Dimension(500,500));
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        doublePanel.setLayout(layout);
        doublePanel.setBackground(new Color(254, 251, 246));
        doublePanel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(doublePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(30);
        doubleRoom.add(scrollBar);
        doubleRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        doubleRoom.setPreferredSize(new Dimension(1100,750));
        doubleRoom.pack();
        doubleRoom.setVisible(true);
    }
    public void viewLuxurySingleRoom() throws SQLException {
        viewRoomAvailability.setVisible(false);

        JFrame singleRoom = new JFrame("All room types available in Hotel");
        JPanel singlePanel = new JPanel();

        Statement statement = this.connection.createStatement();
        String q = "select * from singleroom where (roomNumber >30 && roomNumber <41)";
        ResultSet resultSet = statement.executeQuery(q);
        while (resultSet.next()){
            JPanel hotelCard = new JPanel();
            JLabel roomNumberLabel = new JLabel("Room Number");
            roomNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomNumberVal = new JLabel(String.valueOf(resultSet.getInt(1)));
            roomNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeLabel = new JLabel("Room Type");
            roomTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeVal = new JLabel(resultSet.getString(6));
            roomTypeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameLabel = new JLabel("Name of Customer 1");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameVal = new JLabel(resultSet.getString(2));
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberLabel = new JLabel("Phone number of Customer 1");
            phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberVal = new JLabel(resultSet.getString(3));
            phoneNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel = new JLabel("Gender of Customer 1");
            genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderVal = new JLabel(resultSet.getString(4));
            genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));


            JLabel bookingStatusLabel = new JLabel("Booking Status");
            bookingStatusLabel.setFont(new Font("Times New Roman",Font.PLAIN,20));

            JLabel bookingStatusVal = new JLabel(String.valueOf(resultSet.getBoolean(5)));
            bookingStatusVal.setFont(new Font("Times New Roman",Font.PLAIN,20));

            hotelCard.add(roomNumberLabel);
            hotelCard.add(roomNumberVal);
            hotelCard.add(roomTypeLabel);
            hotelCard.add(roomTypeVal);
            hotelCard.add(nameLabel);
            hotelCard.add(nameVal);
            hotelCard.add(phoneNumberLabel);
            hotelCard.add(phoneNumberVal);
            hotelCard.add(genderLabel);
            hotelCard.add(genderVal);
            hotelCard.add(bookingStatusLabel);
            hotelCard.add(bookingStatusVal);

            hotelCard.setSize(1000, 400);
            if(resultSet.getBoolean(5)){
                hotelCard.setBackground(new Color(232, 84, 84));
            }
            else {
                hotelCard.setBackground(new Color(166, 209, 230));
            }
            hotelCard.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            hotelCard.setLayout(cardLayout);
            singlePanel.add(hotelCard);

        }
        // panel for j button
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            singleRoom.dispose();
            viewRoomAvailability.setVisible(true);
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(254, 251, 246));
        singlePanel.add(buttonPanel);

//        panel.setPreferredSize(new Dimension(500,500));
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        singlePanel.setLayout(layout);
        singlePanel.setBackground(new Color(254, 251, 246));
        singlePanel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(singlePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(25);
        singleRoom.add(scrollBar);
        singleRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        singleRoom.setPreferredSize(new Dimension(1100,750));
        singleRoom.pack();
        singleRoom.setVisible(true);
    }
    public void viewDeluxeSingleRoom() throws SQLException {
        viewRoomAvailability.setVisible(false);

        JFrame singleRoom = new JFrame("All room types available in Hotel");
        JPanel singlePanel = new JPanel();

        Statement statement = this.connection.createStatement();
        String q = "select * from singleroom where (roomNumber > 40 && roomNumber <= 60)";
        ResultSet resultSet = statement.executeQuery(q);
        while (resultSet.next()){
            JPanel hotelCard = new JPanel();
            JLabel roomNumberLabel = new JLabel("Room Number");
            roomNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomNumberVal = new JLabel(String.valueOf(resultSet.getInt(1)));
            roomNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeLabel = new JLabel("Room Type");
            roomTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeVal = new JLabel(resultSet.getString(6));
            roomTypeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameLabel = new JLabel("Name of Customer 1");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameVal = new JLabel(resultSet.getString(2));
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberLabel = new JLabel("Phone number of Customer 1");
            phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phoneNumberVal = new JLabel(resultSet.getString(3));
            phoneNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel = new JLabel("Gender of Customer 1");
            genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderVal = new JLabel(resultSet.getString(4));
            genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));


            JLabel bookingStatusLabel = new JLabel("Booking Status");
            bookingStatusLabel.setFont(new Font("Times New Roman",Font.PLAIN,20));

            JLabel bookingStatusVal = new JLabel(String.valueOf(resultSet.getBoolean(5)));
            bookingStatusVal.setFont(new Font("Times New Roman",Font.PLAIN,20));

            hotelCard.add(roomNumberLabel);
            hotelCard.add(roomNumberVal);
            hotelCard.add(roomTypeLabel);
            hotelCard.add(roomTypeVal);
            hotelCard.add(nameLabel);
            hotelCard.add(nameVal);
            hotelCard.add(phoneNumberLabel);
            hotelCard.add(phoneNumberVal);
            hotelCard.add(genderLabel);
            hotelCard.add(genderVal);
            hotelCard.add(bookingStatusLabel);
            hotelCard.add(bookingStatusVal);

            hotelCard.setSize(1000, 400);
            if(resultSet.getBoolean(5)){
                hotelCard.setBackground(new Color(232, 84, 84));
            }
            else {
                hotelCard.setBackground(new Color(166, 209, 230));
            }
            hotelCard.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            hotelCard.setLayout(cardLayout);
            singlePanel.add(hotelCard);

        }
        // panel for j button
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            singleRoom.dispose();
            viewRoomAvailability.setVisible(true);
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(254, 251, 246));
        singlePanel.add(buttonPanel);

//        panel.setPreferredSize(new Dimension(500,500));
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        singlePanel.setLayout(layout);
        singlePanel.setBackground(new Color(254, 251, 246));
        singlePanel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(singlePanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(30);
        singleRoom.add(scrollBar);
        singleRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        singleRoom.setPreferredSize(new Dimension(1100,750));
        singleRoom.pack();
        singleRoom.setVisible(true);
    }
}
