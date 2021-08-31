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
class Payment extends Frame {
    
    public TextField txtCashier;
    public TextArea txtOrder;
    private Checkbox gcash, paypal, cash, creditcard, debitcard;
    public String kit = "";
    public Order order = new Order();
    
    Payment(){
        setBackground(Color.GRAY);
        setTitle("TEA-NAPA Milk Tea Ordering System");
        setSize(550, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        labels();
        mode();
        textfields();
        
        buttons();
    }
    
    public void labels(){
        Label cashier = new Label("Cashier:");
        Label order = new Label("Order:");
        cashier.setForeground(Color.WHITE);
        order.setForeground(Color.WHITE);
        cashier.setBounds(50, 50, 100, 40);
        order.setBounds(50, 100, 100, 40);
        
        add(cashier); add(order);
        
    }
    public void textfields(){
        txtCashier = new TextField();
        txtOrder = new TextArea();
        txtOrder.setEnabled(false);
        txtCashier.setBounds(150, 50, 200, 30);
        
        txtOrder.setBounds(150, 90, 200, 100);
        txtOrder.setText(order.getDescription());
        
        add(txtCashier); add(txtOrder);
    }
    public void mode(){
        Panel panel = new Panel();
        Label label = new Label("Mode of Payment:");
        CheckboxGroup groups = new CheckboxGroup();
        gcash = new Checkbox("GCash", groups, false);
        paypal = new Checkbox("PayPal", groups, false);
        cash = new Checkbox("Cash", groups, false);
        creditcard = new Checkbox("Credit", groups, false);
        debitcard = new Checkbox("Debit", groups, false);
        panel.setBackground(Color.darkGray);
        panel.setForeground(Color.white);
        panel.setBounds(50, 200, 450, 30);
        panel.add(label);
        panel.add(gcash);
        panel.add(paypal);
        panel.add(cash);
        panel.add(creditcard);
        panel.add(debitcard);
        
        add(panel);
    }
    public void buttons(){
        Button b1 = new Button("Proceed");
        Button b2 = new Button("Back");
        
        b1.setBounds(200, 250, 100, 30);
        b2.setBounds(330, 250, 100, 30);
        
        events(b1, b2);
        add(b1); add(b2);
    }
    public void events(Button b1, Button b2){
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               if(!txtCashier.getText().equals("")){
                    String cashierr = "\nCashier: " + txtCashier.getText();
                    if(gcash.getState() == true){
                        kit = "\nMode of Payment: GCash";
                    }
                    if(paypal.getState() == true){
                        kit = "\nMode of Payment: PayPal";
                    }
                    if(cash.getState() == true){
                        kit = "\nMode of Payment: Cash";
                    }
                    if(creditcard.getState() == true){
                        kit = "\nMode of Payment: Credit Card";
                    }
                    if(debitcard.getState() == true){
                        kit = "\nMode of Payment: Debit Card";
                    }
                    
                    txtOrder.setText(txtOrder.getText().concat(cashierr + kit));
                    order.orderr = txtOrder.getText();
                    Receipt receipt = new Receipt();
                    receipt.setVisible(true);
                    setVisible(false);
                    float value = order.getAddonPrice() + order.getFlavorPrice() + order.getCupPrice();
                    String lahat = "Addon: P" + order.getAddonPrice() + "\nFlavor: P" + order.getFlavorPrice() + "\nCup: P" + order.getCupPrice();
                    JOptionPane.showMessageDialog(null, "[ ORDER ]\n" + lahat + "\n\nTOTAL: P" + value);
               }
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                order.setVisible(true);
                setVisible(false);
            }
        });
    }
}
