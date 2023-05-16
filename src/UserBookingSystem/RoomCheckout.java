package UserBookingSystem;

import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomCheckout {
    JFrame frame;
    Connection con;
    RoomCheckout(){
        frame = new JFrame("Room checkout");
    }
    public void roomCheckout(JFrame menuFrame){
        menuFrame.dispose();

        JLabel label = new JLabel("Enter room number");
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label.setBounds(250,200,200,50);
        frame.add(label);

        JTextField idVal = new JTextField();
        idVal.setFont(new Font("Times New Roman", Font.BOLD, 20));
        idVal.setBounds(500,200,200,50);
        frame.add(idVal);
        idVal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(275, 400, 150,40);
        backButton.setFocusPainted(false);

        backButton.addActionListener(actionListener -> {
            menuFrame.setVisible(true);
            frame.dispose();

        });
        frame.add(backButton);

        JButton submitButton = new JButton("Confirm");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submitButton.setBounds(525, 400, 150,40);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(actionEvent ->{
            int id = Integer.parseInt(idVal.getText());
            try {
                showReceipt(id,frame,menuFrame);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        frame.add(submitButton);

        frame.setLayout(null);
        frame.setSize(new Dimension(1100,750));
        frame.setVisible(true);
    }
    public void showReceipt(int room,JFrame parentFrame,JFrame menuFrame) throws SQLException {
        Statement statement1 = this.con.createStatement();
        String query = null;
        if(room<31){
            query = String.format("select * from doubleroom where (roomNumber = '%d' && bookingStatus = '%d')",room,1);
        }
        else {
            query = String.format("select * from singleroom where (roomNumber = '%d' && bookingStatus = '%d')",room,1);
        }
        ResultSet resultSet = statement1.executeQuery(query);
        resultSet.next();
        JFrame frame = new JFrame("Receipt");
        JPanel panel = new JPanel();

        JLabel roomNumber = new JLabel("Room Number");
        roomNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel roomNumberVal = new JLabel(String.valueOf(room));
        roomNumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel nameLabel = new JLabel("Room used by");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel nameVal = new JLabel(resultSet.getString(2));
        nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel priceLabel = new JLabel("Total price");
        priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel priceVal = null;
        if(room>0 && room<=10){
            priceVal = new JLabel("4000");
            priceVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        }
        if(room>10 && room<=30){
            priceVal = new JLabel("3000");
            priceVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        }
        if(room>30 && room <=40){
            priceVal = new JLabel("2200");
            priceVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        }
        if(room>40 && room<=60){
            priceVal = new JLabel("1200");
            priceVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        }
        JLabel paymentLabel = new JLabel("You can pay via");
        paymentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        //paymentLabel.setBounds(300,500,200,50);

        String methods[] = {"Paypal","Visa Card","Credit Card","Cash"};
        JComboBox<String> cb = new JComboBox<String>(methods);
        //cb.setBounds(600,500,100,   50);
        frame.add(paymentLabel);
        //frame.add(cb);


        panel.add(roomNumber);
        panel.add(roomNumberVal);
        panel.add(nameLabel);
        panel.add(nameVal);
        panel.add(priceLabel);
        panel.add(priceVal);
        panel.add(paymentLabel);
        panel.add(cb);

        panel.setBackground(new Color(166, 209, 230));
        panel.setBorder(new EmptyBorder(20, 50, 20, 50));
        panel.setBounds(300,120,500,400);
        GridLayout cardLayout = new GridLayout(0, 2);
        cardLayout.setHgap(5);
        cardLayout.setVgap(10);
        panel.setLayout(cardLayout);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(300,600, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            frame.dispose();
            parentFrame.setVisible(true);
        });
        frame.add(backButton);

        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        confirmButton.setBounds(600,600, 200,50);
        confirmButton.setFocusPainted(false);
        confirmButton.addActionListener(actionListener -> {
            frame.dispose();
            String name = "null";
            String phoneNo = "null";
            String gender = "null";
            int checkout = 0;
            String query1 = null;

            if(room > 0 && room <= 30){
                query1 = String.format("update doubleroom set name1 = '%s',phoneNo = '%s',gender = '%s',name2='%s'," +
                        "phoneNo2 = '%s',gender2 = '%s',bookingStatus = '%d' where roomNumber = '%d'",name,phoneNo,gender,
                        name,phoneNo,gender,checkout,room);
            }
            else if(room >30 && room <=60){
                query1 = String.format("update singleroom set name1 = '%s',phoneNo = '%s',gender = '%s',bookingStatus = '%d' " +
                        "where roomNumber = '%d'",name,phoneNo,gender,checkout,room);
            }
            int price = 0;
            if(room>0 && room<=10){
                price = 4000;
            }
            if(room>10 && room<=30){
                price = 3000;
            }
            if(room>30 && room <=40){
                price = 2200;
            }
            if(room>40 && room<=60){
                price = 1200;
            }
            Date date = new Date();
            // display time and date
            String type = "Room "+ room +" check out";
            String query2 = String.format("insert into financialdata values ('%s','%s','%s')",type,price,
                    cb.getSelectedItem());
            try {
                Statement statement2 = this.con.createStatement();
                statement2.executeUpdate(query1);
                Statement statement3 = this.con.createStatement();
                statement3.executeUpdate(query2);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            menuFrame.setVisible(true);


        });
        frame.add(confirmButton);

        frame.add(panel);

        frame.setSize(1100,750);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        parentFrame.dispose();
    }

    public void setCon(Connection con){
        this.con = con;
    }
}
