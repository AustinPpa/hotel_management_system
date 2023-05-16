package UserBookingSystem;

import com.mysql.cj.protocol.Resultset;

import javax.print.event.PrintJobAttributeListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookRoom {
    JFrame viewRoomAvailability;
    ViewRoomType vrt = new ViewRoomType();
    Connection connection;
    public void setConnection(Connection con){
        this.connection = con;
    }
    BookRoom(){
        viewRoomAvailability = new JFrame("Rooms available in Hotel");
    }

    public void viewRoomDetails(JFrame menuFrame){
        menuFrame.dispose();
        JPanel panel = new JPanel();

        JLabel view = new JLabel("Rooms available in the hotel");
        view.setFont(new Font("Times New Roman", Font.BOLD, 32));
        view.setBounds(380, 50, 800, 50);
        viewRoomAvailability.add(view);

        JButton doubleRoom = new JButton("Double rooms");
        doubleRoom.setBounds(400, 200, 300, 40);
        doubleRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        doubleRoom.setFocusPainted(false);
        doubleRoom.addActionListener(actionEvent ->{
            try {
                viewDoubleRoom();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        viewRoomAvailability.add(doubleRoom);

        JButton singleRoom = new JButton("Single rooms");
        singleRoom.setBounds(400, 270, 300, 40);
        singleRoom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        singleRoom.setFocusPainted(false);
        singleRoom.addActionListener(actionEvent ->{
            try{
                viewSingleRoom();
            }catch(SQLException e){
                throw new RuntimeException();
            }
        });
        viewRoomAvailability.add(singleRoom);

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
    public void viewDoubleRoom() throws SQLException{
        boolean status = false;
        viewRoomAvailability.setVisible(false);
        int id = 0;

        JFrame drFrame = new JFrame("Double rooms in the hotel");
        JPanel drPanel = new JPanel();

        Statement statement = this.connection.createStatement();
        String q = String.format("select roomNumber,roomType from doubleroom where bookingStatus = '%b'",status);
        ResultSet resultSet = statement.executeQuery(q);

        while(resultSet.next()){
            JPanel doubleCard = new JPanel();

            JLabel roomNumberLabel = new JLabel("Room Number");
            roomNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomNumberVal = new JLabel(String.valueOf(resultSet.getInt(1)));
            roomNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeLabel = new JLabel("Room Type");
            roomTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeVal = new JLabel(resultSet.getString(2));
            roomTypeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            id = resultSet.getInt(1);
            JButton bookButton = new JButton("Book room");
            bookButton.setFont(new Font("Times New roman", Font.PLAIN, 20));
            bookButton.setFocusPainted(false);
            int finalId = id;
            bookButton.addActionListener(actionListener ->{
                try {
                    confirmBooking(finalId,drFrame);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            JButton viewButton = new JButton("View Room Detail");
            viewButton.setFont(new Font("Times New roman", Font.PLAIN, 20));
            viewButton.setFocusPainted(false);
            viewButton.addActionListener(actionEvent ->{
                vrt.viewRoomType(finalId,drFrame);
            });

            doubleCard.add(roomNumberLabel);
            doubleCard.add(roomNumberVal);
            doubleCard.add(roomTypeLabel);
            doubleCard.add(roomTypeVal);
            doubleCard.add(bookButton);
            doubleCard.add(viewButton);

            doubleCard.setSize(1000, 400);
            doubleCard.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            doubleCard.setLayout(cardLayout);
            drPanel.add(doubleCard);


        }
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            drFrame.dispose();
            viewRoomAvailability.setVisible(true);
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(254, 251, 246));
        drPanel.add(buttonPanel);

        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        drPanel.setLayout(layout);
        drPanel.setBackground(new Color(254, 251, 246));
        drPanel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(drPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(30);
        drFrame.add(scrollBar);
        drFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drFrame.setPreferredSize(new Dimension(1100,750));
        drFrame.pack();
        drFrame.setVisible(true);

    }
    public void viewSingleRoom() throws SQLException{
        boolean status = false;
        viewRoomAvailability.setVisible(false);
        int id = 0;

        JFrame drFrame = new JFrame("Double rooms in the hotel");
        JPanel drPanel = new JPanel();

        Statement statement = this.connection.createStatement();
        String q = String.format("select roomNumber,roomType from singleroom where bookingStatus = '%b'",status);
        ResultSet resultSet = statement.executeQuery(q);

        while(resultSet.next()){
            JPanel doubleCard = new JPanel();
            JPanel bookCard = new JPanel();

            JLabel roomNumberLabel = new JLabel("Room Number");
            roomNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomNumberVal = new JLabel(String.valueOf(resultSet.getInt(1)));
            roomNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeLabel = new JLabel("Room Type");
            roomTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel roomTypeVal = new JLabel(resultSet.getString(2));
            roomTypeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            id = resultSet.getInt(1);
            JButton bookButton = new JButton("Book room");
            bookButton.setFont(new Font("Times New roman", Font.PLAIN, 20));
            bookButton.setFocusPainted(false);
            int finalId = id;
            bookButton.addActionListener(actionListener ->{
                try {
                    confirmBooking(finalId,drFrame);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            JButton viewButton = new JButton("View Room Detail");
            viewButton.setFont(new Font("Times New roman", Font.PLAIN, 20));
            viewButton.setFocusPainted(false);
            viewButton.addActionListener(actionEvent ->{
                vrt.viewRoomType(finalId,drFrame);
            });


            doubleCard.add(roomNumberLabel);
            doubleCard.add(roomNumberVal);
            doubleCard.add(roomTypeLabel);
            doubleCard.add(roomTypeVal);
            doubleCard.add(bookButton);
            doubleCard.add(viewButton);

            doubleCard.setSize(1000, 400);
            doubleCard.setBorder(new EmptyBorder(20, 50, 20, 50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            doubleCard.setLayout(cardLayout);
            drPanel.add(doubleCard);


        }
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            drFrame.dispose();
            viewRoomAvailability.setVisible(true);
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(254, 251, 246));
        drPanel.add(buttonPanel);

        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        drPanel.setLayout(layout);
        drPanel.setBackground(new Color(254, 251, 246));
        drPanel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(drPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(30);
        drFrame.add(scrollBar);
        drFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drFrame.setPreferredSize(new Dimension(1100,750));
        drFrame.pack();
        drFrame.setVisible(true);

    }
    public void confirmBooking(int roomNumber,JFrame drFrame) throws SQLException {
        drFrame.dispose();
        String q = null;
        JTextField nameVal = null;
        JTextField nameVal2 = null;
        JTextField phNumberVal = null;
        JTextField phNumberVal2 = null;
        JTextField genderVal = null;
        JTextField genderVal2 = null;

        JFrame frame = new JFrame("Confirm Booking");
        JPanel panel = new JPanel();

        if(roomNumber > 0 && roomNumber <=30){
            JLabel nameLabel = new JLabel("Enter first person name");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            nameVal = new JTextField("");
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phNumberLabel = new JLabel("Enter first person phone number");
            phNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            phNumberVal = new JTextField("");
            phNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel = new JLabel("Enter first person gender");
            genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            genderVal = new JTextField("");
            genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel nameLabel2 = new JLabel("Enter second person name");
            nameLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            nameVal2 = new JTextField("");
            nameVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phNumberLabel2 = new JLabel("Enter second person phone number");
            phNumberLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            phNumberVal2 = new JTextField("");
            phNumberVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel2 = new JLabel("Enter second person gender");
            genderLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            genderVal2 = new JTextField("");
            genderVal2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            panel.add(nameLabel);
            panel.add(nameVal);
            panel.add(phNumberLabel);
            panel.add(phNumberVal);
            panel.add(genderLabel);
            panel.add(genderVal);
            panel.add(nameLabel2);
            panel.add(nameVal2);
            panel.add(phNumberLabel2);
            panel.add(phNumberVal2);
            panel.add(genderLabel2);
            panel.add(genderVal2);

        }
        else {
            JLabel nameLabel = new JLabel("Enter your name");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            nameVal = new JTextField("");
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel phNumberLabel = new JLabel("Enter your phone number");
            phNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            phNumberVal = new JTextField("");
            phNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel genderLabel = new JLabel("Enter your gender");
            genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            genderVal = new JTextField("");
            genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            panel.add(nameLabel);
            panel.add(nameVal);
            panel.add(phNumberLabel);
            panel.add(phNumberVal);
            panel.add(genderLabel);
            panel.add(genderVal);
        }
        GridLayout cardLayout = new GridLayout(0, 2);
        cardLayout.setHgap(60);
        cardLayout.setVgap(40);
        panel.setLayout(cardLayout);

        panel.setSize(1000, 400);
        panel.setBackground(new Color(166, 209, 230));
        panel.setBorder(new EmptyBorder(20, 50, 20, 50));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,30);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            frame.dispose();
            drFrame.setVisible(true);
        });
        panel.add(backButton);
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submitButton.setBounds(450, 30, 200,30);
        submitButton.setFocusPainted(false);

        JTextField finalNameVal = nameVal;
        JTextField finalPhNumberVal = phNumberVal;
        JTextField finalGenderVal = genderVal;
        JTextField finalNameVal2 = nameVal2;
        JTextField finalPhNumberVal2 = phNumberVal2;
        JTextField finalGenderVal2 = genderVal2;
        submitButton.addActionListener(actionListener ->{
            Statement statement1;
            try{
                statement1 = this.connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String query;

            int bookingTrue = 1;
            if(roomNumber>0 && roomNumber<=30) {
                String name = finalNameVal.getText();
                String phNumber = finalPhNumberVal.getText();
                String gender = finalGenderVal.getText();
                String name2 = finalNameVal2.getText();
                String phNumber2 = finalPhNumberVal2.getText();
                String gender2 = finalGenderVal2.getText();
                query = String.format("update doubleroom set name1 = '%s', phoneNo = '%s',gender = '%s',name2 = '%s'," +
                        "phoneNo2 = '%s', gender2 = '%s',bookingStatus = '%d' where roomNumber = '%d';",name,phNumber,gender,name2,phNumber2,
                        gender2,bookingTrue,roomNumber) ;
            } else{
                String name = finalNameVal.getText();
                String phNumber = finalPhNumberVal.getText();
                String gender = finalGenderVal.getText();
                query = String.format("update singleroom set name1 = '%s', phoneNo = '%s', gender = '%s',bookingStatus = '%d' where " +
                        "roomNumber = '%d';",name,phNumber,gender,bookingTrue,roomNumber);
            }
            try{
                assert statement1 != null;
                statement1.executeUpdate(query);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            frame.dispose();
            drFrame.setVisible(true);
        });
        panel.add(submitButton);

        panel.setBackground(new Color(254, 251, 246));
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1100,750));
        frame.pack();
        frame.setVisible(true);

    }

}
