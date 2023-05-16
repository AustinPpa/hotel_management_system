package UserBookingSystem;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ViewRoomType {
    JFrame feature;
    ViewRoomType(){
    }
    public void viewRoomType(int id,JFrame menuFrame){
        if(id>= 0 && id<=10){
            feature = new JFrame("Luxury Double Room Features");

            JPanel detail = new JPanel();

            JLabel noBed = new JLabel("Number of double beds");
            noBed.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel noBedVal = new JLabel("1");
            noBedVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel ac = new JLabel("AC");
            ac.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel acVal = new JLabel("Yes");
            acVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfast = new JLabel("Free breakfast");
            breakfast.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfastVal = new JLabel("Yes");
            breakfastVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel fee = new JLabel("Charges");
            fee.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel feeVal = new JLabel("4000");
            feeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            detail.add(noBed);
            detail.add(noBedVal);
            detail.add(ac);
            detail.add(acVal);
            detail.add(breakfast);
            detail.add(breakfastVal);
            detail.add(fee);
            detail.add(feeVal);


            detail.setBackground(new Color(166, 209, 230));
            detail.setBorder(new EmptyBorder(20, 50, 20, 50));
            detail.setBounds(300,120,500,400);
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            detail.setLayout(cardLayout);

            JButton backButton = new JButton("Back");
            backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            backButton.setBounds(450,600, 200,50);
            backButton.setFocusPainted(false);
            backButton.addActionListener(actionListener -> {
                feature.dispose();
                menuFrame.setVisible(true);
            });
            feature.add(backButton);

            feature.add(detail);

            feature.setSize(1100,750);
            feature.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            feature.setLayout(null);
            feature.setVisible(true);
        }
        if(id>10 && id<=30){
            JFrame feature = new JFrame("Deluxe Double Room Features");

            JPanel detail = new JPanel();

            JLabel noBed = new JLabel("Number of double beds");
            noBed.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel noBedVal = new JLabel("1");
            noBedVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel ac = new JLabel("AC");
            ac.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel acVal = new JLabel("No");
            acVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfast = new JLabel("Free breakfast");
            breakfast.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfastVal = new JLabel("Yes");
            breakfastVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel fee = new JLabel("Charges");
            fee.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel feeVal = new JLabel("3000");
            feeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            detail.add(noBed);
            detail.add(noBedVal);
            detail.add(ac);
            detail.add(acVal);
            detail.add(breakfast);
            detail.add(breakfastVal);
            detail.add(fee);
            detail.add(feeVal);


            detail.setBackground(new Color(166, 209, 230));
            detail.setBorder(new EmptyBorder(20, 50, 20, 50));
            detail.setBounds(300,120,500,400);
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            detail.setLayout(cardLayout);

            JButton backButton = new JButton("Back");
            backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            backButton.setBounds(450,600, 200,50);
            backButton.setFocusPainted(false);
            backButton.addActionListener(actionListener -> {
                feature.dispose();
                menuFrame.setVisible(true);
            });
            feature.add(backButton);

            feature.add(detail);

            feature.setSize(1100,750);
            feature.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            feature.setLayout(null);
            feature.setVisible(true);
        }
        if(id>=30 && id<=40){
            JFrame feature = new JFrame("Luxury Single Room Features");

            JPanel detail = new JPanel();

            JLabel noBed = new JLabel("Number of single beds");
            noBed.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel noBedVal = new JLabel("1");
            noBedVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel ac = new JLabel("AC");
            ac.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel acVal = new JLabel("Yes");
            acVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfast = new JLabel("Free breakfast");
            breakfast.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfastVal = new JLabel("1");
            breakfastVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel fee = new JLabel("Charges");
            fee.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel feeVal = new JLabel("2200");
            feeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            detail.add(noBed);
            detail.add(noBedVal);
            detail.add(ac);
            detail.add(acVal);
            detail.add(breakfast);
            detail.add(breakfastVal);
            detail.add(fee);
            detail.add(feeVal);


            detail.setBackground(new Color(166, 209, 230));
            detail.setBorder(new EmptyBorder(20, 50, 20, 50));
            detail.setBounds(300,120,500,400);
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            detail.setLayout(cardLayout);

            JButton backButton = new JButton("Back");
            backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            backButton.setBounds(450,600, 200,50);
            backButton.setFocusPainted(false);
            backButton.addActionListener(actionListener -> {
                feature.dispose();
                menuFrame.setVisible(true);
            });
            feature.add(backButton);

            feature.add(detail);

            feature.setSize(1100,750);
            feature.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            feature.setLayout(null);
            feature.setVisible(true);
        }
        if(id>40 && id<=60){
            JFrame feature = new JFrame("Deluxe Single Room Features");

            JPanel detail = new JPanel();

            JLabel noBed = new JLabel("Number of single beds");
            noBed.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel noBedVal = new JLabel("1");
            noBedVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel ac = new JLabel("AC");
            ac.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel acVal = new JLabel("No");
            acVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfast = new JLabel("Free breakfast");
            breakfast.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel breakfastVal = new JLabel("Yes");
            breakfastVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel fee = new JLabel("Charges");
            fee.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            JLabel feeVal = new JLabel("1200");
            feeVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            detail.add(noBed);
            detail.add(noBedVal);
            detail.add(ac);
            detail.add(acVal);
            detail.add(breakfast);
            detail.add(breakfastVal);
            detail.add(fee);
            detail.add(feeVal);


            detail.setBackground(new Color(166, 209, 230));
            detail.setBorder(new EmptyBorder(20, 50, 20, 50));
            detail.setBounds(300,120,500,400);
            GridLayout cardLayout = new GridLayout(0, 2);
            cardLayout.setHgap(5);
            cardLayout.setVgap(10);
            detail.setLayout(cardLayout);

            JButton backButton = new JButton("Back");
            backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            backButton.setBounds(450,600, 200,50);
            backButton.setFocusPainted(false);
            backButton.addActionListener(actionListener -> {
                feature.dispose();
                menuFrame.setVisible(true);
            });
            feature.add(backButton);

            feature.add(detail);

            feature.setSize(1100,750);
            feature.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            feature.setLayout(null);
            feature.setVisible(true);
        }
    }

}
