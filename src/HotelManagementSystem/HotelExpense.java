package HotelManagementSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelExpense {
    JFrame frame;
    Connection con;
    public void setCon(Connection con){
        this.con = con;
    }
    HotelExpense(){
        frame = new JFrame("Hotel expenses");
    }
    public void addExpense(JFrame menuFrame){
        menuFrame.dispose();

        JPanel panel = new JPanel();

        JLabel type = new JLabel("Type of expense");
        type.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField typeVal = new JTextField("");
        typeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JLabel amount = new JLabel("Amount");
        amount.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JTextField amountVal = new JTextField("");
        amountVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        panel.add(type);
        panel.add(typeVal);
        panel.add(amount);
        panel.add(amountVal);

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
        backButton.addActionListener(actionEvent ->{
            frame.dispose();
            menuFrame.setVisible(true);
        });
        panel.add(backButton);

        JButton submitButton = new JButton("Add");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submitButton.setBounds(450, 30, 200,30);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(actionEvent ->{
            Statement statement = null;
            frame.dispose();
            String typeText = typeVal.getText();
            int amountText = Integer.parseInt(amountVal.getText());
            String typeOfExpense = "null";

            try {
                statement = this.con.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            String query = String.format("insert into financialdata values ('%s','%d','%s');", typeText,amountText,typeOfExpense);
            try {
                assert statement != null;
                statement.executeUpdate(query);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            menuFrame.setVisible(true);
        });
        panel.add(submitButton);

        panel.setBackground(new Color(254, 251, 246));
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1100,750));
        frame.setLayout(null);
        frame.setVisible(true);


    }

}
