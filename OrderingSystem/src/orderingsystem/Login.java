/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderingsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Allen
 */
class Login extends Frame {
    Login(){
        setBackground(Color.GRAY);
        setTitle("TEA-NAPA Milk Tea Ordering System");
        setSize(350, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        labels();
        textbox();
        buttons();
    }
    
    static Label lblMsg = new Label();
    static TextField txtUser = new TextField(), txtPass = new TextField();
    
     public void labels(){
        Label lblUser = new Label("Username:");
        Label lblPass = new Label("Password:");
        
        lblMsg.setText("Message: ");
        lblUser.setBounds(50, 70, 100, 40);
        lblPass.setBounds(50, 110, 100, 40);
        lblMsg.setBounds(50, 150, 150, 40);
        
        lblUser.setForeground(Color.WHITE);
        lblPass.setForeground(Color.WHITE);
        lblMsg.setForeground(Color.WHITE);
        
        add(lblUser);
        add(lblPass);
        add(lblMsg);
    }
    
    public void textbox(){
        txtUser.setBounds(170, 80, 150, 25);
        txtPass.setBounds(170, 120, 150, 25);
        
        add(txtUser);
        add(txtPass);
        
        
    }
    // setBounds(x-coordinate, y-coordinate, width, height);
    public void buttons(){
        Button btnOkay = new Button("Okay");
        Button btnClear = new Button("Clear");
        Button btnExit = new Button("Exit");
        
        btnOkay.setBounds(40, 200, 40, 40);
        btnClear.setBounds(100, 200, 40, 40);
        btnExit.setBounds(160, 200, 40, 40);
        
        btnOkay.setBackground(Color.CYAN);
        btnClear.setBackground(Color.CYAN);
        btnExit.setBackground(Color.CYAN);
        
        btnOkay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String userName = txtUser.getText(), passWord = txtPass.getText();
                if(userName.trim().equals("admin") && passWord.trim().equals("123")){
                    JOptionPane.showMessageDialog(null, "Access Granted!");
                    Order order = new Order();
                    setVisible(false);
                    order.setVisible(true);
                } else if (userName.isEmpty() || passWord.isEmpty()) {
                    lblMsg.setText("Message: Empty Textbox");
                    JOptionPane.showMessageDialog(null, "Empty Textbox!");
                } else {
                    lblMsg.setText("Message: Invalid Account!");
                    JOptionPane.showMessageDialog(null, "Invalid Account!");
                }
            }
        });
        
        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(txtUser.getText().isEmpty() || txtPass.getText().isEmpty()) {
                    clear();
                } else {
                    clear();
                }
                JOptionPane.showMessageDialog(null, "Textbox Clear!");
            }
        });
        
        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(null, "Thank You and Come Again!");
                dispose();
            }
        });
        
        add(btnOkay);
        add(btnClear);
        add(btnExit);
        
    }
    
    public static void clear(){
        txtUser.setText("");
        txtPass.setText("");
        lblMsg.setText("Message: ");
    }
    
    public static void getWelcomeMessage() {
        JOptionPane.showMessageDialog(null, "Hello, Welcome to TEA-NAPA\nMilk Tea Ordering System");
    }
}
