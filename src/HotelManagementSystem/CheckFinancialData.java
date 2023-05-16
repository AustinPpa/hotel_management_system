package HotelManagementSystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckFinancialData {
    Connection con;
    JFrame data;

    public void setCon(Connection con){
        this.con = con;
    }
    CheckFinancialData(){
        data = new JFrame("All financial data in the hotel");
    }
    public void viewFinancialData(JFrame menuFrame) throws SQLException {
        menuFrame.dispose();

        JPanel panel = new JPanel();

        Statement statement = this.con.createStatement();
        String q = "select * from financialdata";
        ResultSet resultSet = statement.executeQuery(q);
        while(resultSet.next()){
            JPanel card = new JPanel();

            JLabel typeLabel = new JLabel("Type of expense");
            typeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel typeVal = new JLabel(resultSet.getString(1));
            typeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel amountLabel = new JLabel("Amount");
            amountLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel amountVal = new JLabel(String.valueOf(resultSet.getInt(2)));
            amountVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel methodLabel = new JLabel("Payment method");
            methodLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel methodVal = new JLabel(resultSet.getString(3));
            methodVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            card.add(typeLabel);
            card.add(typeVal);
            card.add(amountLabel);
            card.add(amountVal);
            card.add(methodLabel);
            card.add(methodVal);

            card.setSize(1000,400);
            card.setBackground(new Color(166,209,230));
            card.setBorder(new EmptyBorder(20,50,20,50));
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            card.setLayout(cardLayout);
            panel.add(card);
        }
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        backButton.setBounds(450, 30, 200,50);
        backButton.setFocusPainted(false);
        backButton.addActionListener(actionListener -> {
            data.dispose();
            menuFrame.setVisible(true);
        });
        buttonPanel.add(backButton);
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(new Color(254, 251, 246));
        panel.add(buttonPanel);

        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(30);
        panel.setLayout(layout);
        panel.setBackground(new Color(254, 251, 246));
        panel.setBorder(new EmptyBorder(50, 0, 50, 0));

        JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.getVerticalScrollBar().setUnitIncrement(25);
        data.add(scrollBar);
        data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data.setPreferredSize(new Dimension(1100,750));
        data.pack();
        data.setVisible(true);
    }
}
