package HotelManagementSystem;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RoomMaintenance {
    JFrame frame;
    Connection con;
    public void setConnection(Connection con){
        this.con = con;
    }
    RoomMaintenance(){
        frame = new JFrame("Room maintenance");
    }
    public void roomMaintenance(JFrame menuFrame){
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

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submitButton.setBounds(525, 400, 150,40);
        submitButton.setFocusPainted(false);

        submitButton.addActionListener(actionEvent -> {
            String q = null;
            int id = Integer.parseInt(idVal.getText());
            if(id>0 && id<=30) {
                q = String.format("select * from doubleroom where roomNumber = %d;", id);
            } else{
                q = String.format("select * from singleroom where roomNumber = %d;", id);
            }
            Statement statement = null;
            try {
                statement = this.con.createStatement();
                ResultSet resultSet = statement.executeQuery(q);
                if (resultSet.next()) {
                    //                    return true;
                    roomForMaintenance(id, frame,menuFrame);
                }
                else{
                    JFrame popup = new JFrame("Invalid ID");
                    JLabel popupMsg = new JLabel("The ID you entered is invalid.");
                    popupMsg.setBounds(20,10,300,50);
                    popupMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    popup.add(popupMsg);

                    JButton button = new JButton("OK");
                    button.setBounds(120,60,70,20);
                    button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    button.addActionListener(actionEvent2 -> {
                        popup.dispose();
                    });
                    popup.add(button);

                    popup.setLayout(null);
                    popup.setSize(350, 150);
                    popup.setVisible(true);

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        frame.add(submitButton);

        frame.setLayout(null);
        frame.setSize(new Dimension(1100,750));
        frame.setVisible(true);
    }
    public void roomForMaintenance(int id, JFrame parentFrame,JFrame menuFrame) throws SQLException {
        String q;
        JTextField nameVal;
        JTextField statusVal;
        JFrame frame = new JFrame("Room for maintenance");
        JPanel panel=new JPanel();

        Statement statement = null;
        try {
            statement = this.con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(id>0 && id<=30) {
            q = String.format("select * from doubleroom where roomNumber = %d;", id);
            assert statement != null;
            ResultSet resultSet = statement.executeQuery(q);
            resultSet.next();

            JLabel nameLabel = new JLabel("Name");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            nameVal = new JTextField(resultSet.getString(2));
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel statusLabel = new JLabel("Status");
            statusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            statusVal = new JTextField(String.valueOf(resultSet.getInt(8)));
            statusVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            panel.add(nameLabel);
            panel.add(nameVal);
            panel.add(statusLabel);
            panel.add(statusVal);
        }
        else{
            q = String.format("select * from singleroom where roomNumber = %d;", id);
            assert statement != null;
            ResultSet resultSet = statement.executeQuery(q);
            resultSet.next();

            JLabel nameLabel = new JLabel("Name");
            nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            nameVal = new JTextField(resultSet.getString(2));
            nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel statusLabel = new JLabel("Status");
            statusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            statusVal = new JTextField(String.valueOf(resultSet.getInt(5)));
            statusVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            panel.add(nameLabel);
            panel.add(nameVal);
            panel.add(statusLabel);
            panel.add(statusVal);
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
            menuFrame.setVisible(true);
        });
        panel.add(backButton);

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submitButton.setBounds(450, 30, 200,30);
        submitButton.setFocusPainted(false);

        JTextField finalNameVal = nameVal;
        JTextField finalStatusVal = statusVal;
        submitButton.addActionListener(actionListener -> {
            Statement statemnt = null;
            try {
                statemnt = this.con.createStatement();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            String query;
            String name = finalNameVal.getText();
            int status = Integer.parseInt(finalStatusVal.getText());
            if(id>0 && id<=30) {
                query = String.format("update doubleroom set name1 = '%s', bookingStatus = '%d' where roomNumber = '%d';", name,status,id);
            } else{
                query = String.format("update singleroom set name1 = '%s', bookingStatus = '%d' where roomNumber = '%d';", name,status,id);
            }
            try {
                assert statemnt != null;
                statemnt.executeUpdate(query);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            menuFrame.setVisible(true);
            frame.dispose();

        });
        panel.add(submitButton);

        panel.setBackground(new Color(254, 251, 246));
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1100,750));
        frame.pack();
        frame.setVisible(true);
        parentFrame.dispose();
    }
}

