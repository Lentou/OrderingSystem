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
class Order extends Frame {
    
    public TextArea txtReceipt = new TextArea();
    private Checkbox blackPearl, crystal, pudding, whitePearl, ch0, ch25, ch75, ch100;
    private Choice sizes, flavorsList;
    private Button done, select;
    private static float add = 10, fl, c;
    public String level = "", addons = "";
    public static String orderr = "";
    public String order = "Order System\nFlavor: N/A\nCup Size: N/A\nSugar Level: 0%\nAddons: N/A";
    
    Order(){
        setBackground(Color.GRAY);
        setTitle("TEA-NAPA Milk Tea Ordering System");
        setSize(600, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        
        sizes();
        flavors();
        sugarlevels();
        addons();
        buttons();
        panel();
        events();
    }
    
    static float getAddonPrice() {
        return add;
    }
    
    static float getFlavorPrice() {
        return fl;
    }
    
    static float getCupPrice() {
        return c;
    }
    
    static String getDescription() {
        return orderr;
    }
    
    public void sizes(){
        Panel theCups = new Panel();
        sizes = new Choice();
        
        String[] cups = {"Small", "Medium", "Large"};
        for (String c : cups) {
            sizes.add(c);
        }
        Label label = new Label("Sizes:");
        label.setForeground(Color.WHITE);
        theCups.setBackground(Color.PINK);
        theCups.setBounds(40, 120, 120, 60);
        theCups.add(label);
        theCups.add(sizes);
        add(theCups);
    }
    public void flavors(){
        Panel flavors = new Panel();
        flavorsList = new Choice();
        
        String[] milkteas = {"Strawberry", "Vanilla", "Cocoa", "Ube", "Durian"};
        for (String m : milkteas){
            flavorsList.add(m);
        }
        Label label = new Label("Flavors:");
        label.setForeground(Color.WHITE);
        flavors.setBackground(Color.ORANGE);
        flavors.setBounds(40, 50, 120, 60);
        flavors.add(label);
        flavors.add(flavorsList);
        add(flavors);
    }
    public void sugarlevels(){
        Panel sugars = new Panel();
        CheckboxGroup groups = new CheckboxGroup();
        ch0 = new Checkbox("0% Sugar", groups, false);
        ch25 = new Checkbox("25% Sugar", groups, false);
        ch75 = new Checkbox("75% Sugar", groups, false);
        ch100 = new Checkbox("100% Sugar", groups, false);
        sugars.setBackground(Color.DARK_GRAY);
        
        Label label = new Label("Sugar Lvls:");
        sugars.setBounds(50, 250, 420, 30);
        sugars.setForeground(Color.WHITE);
        sugars.add(label);
        sugars.add(ch0);
        sugars.add(ch25);
        sugars.add(ch75);
        sugars.add(ch100);
        add(sugars);
    }
    public void addons(){
        Panel addons = new Panel();
        CheckboxGroup groups = new CheckboxGroup();
        blackPearl = new Checkbox("Black Pearl", groups, false);
        crystal = new Checkbox("Crystal", groups, false);
        pudding = new Checkbox("Pudding", groups, false);
        whitePearl = new Checkbox("White Pearl", groups, false);
       
        
        Label label = new Label("Addons:");
        addons.setBackground(Color.BLACK);
        addons.setBounds(50, 200, 500, 30);
        addons.setForeground(Color.WHITE);
        addons.add(label);
        addons.add(blackPearl);
        addons.add(crystal);
        addons.add(pudding);
        addons.add(whitePearl);
        
        add(addons);
    }
    
    public void buttons(){
        done = new Button("Proceed");
        select = new Button("Update");
        
        done.setBounds(410, 300, 100, 30);
        select.setBounds(300, 300, 100, 30);
        add(done);
        add(select);
    }
    //.setAlignment(Pos.TOP_LEFT);
    public void panel(){
        
        txtReceipt.setBounds(160, 50, 390, 130);
        
        txtReceipt.setEnabled(false);
        txtReceipt.setText(order);
        
        add(txtReceipt);
    }
    
    public void events(){
        done.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int options = JOptionPane.YES_NO_OPTION;
                int input = JOptionPane.showConfirmDialog(null, "Confirmation of Order? YES/NO?", "TEA-NAPA Milk Tea", options, JOptionPane.INFORMATION_MESSAGE);
                if (input == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    new Payment().setVisible(true);
                }
            }
        });
        select.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    String order = "Order System\nFlavor: " + flavorsList.getItem(flavorsList.getSelectedIndex()) + "\nCup Size: " + sizes.getItem(sizes.getSelectedIndex()) + "\n";
                    txtReceipt.setText(order);
                    switch(flavorsList.getItem(flavorsList.getSelectedIndex())){
                        case "Ube":
                            fl = 25;
                        break;
                        case "Vanilla":
                            fl = 30;
                        break;
                        default:
                            fl = 20;
                    }
                    switch(sizes.getItem(sizes.getSelectedIndex())){
                        case "Small":
                            c = 30;
                        break;
                        case "Medium":
                            c = 50;
                        break;
                        case "Large":
                            c = 70;
                        break;
                    }
                    if(ch0.getState() == true){
                        level = "Sugar Level: 0%\n";
                    }
                    if(ch25.getState() == true){
                        level = "Sugar Level: 25%\n";
                    }
                    if(ch75.getState() == true){
                        level = "Sugar Level: 75%\n";
                    }
                    if(ch100.getState() == true){
                        level = "Sugar Level: 100%\n";
                    }
                    if(blackPearl.getState() == true){
                        addons = level + "Addons: Black Pearl";
                    }
                    if(crystal.getState() == true){
                        addons = level + "Addons: Crystal";
                    }
                    if(pudding.getState() == true){
                        addons = level + "Addons: Pudding";
                    } 
                    if(whitePearl.getState() == true){
                        addons = level + "Addons: White Pearl";
                    }
                    orderr = txtReceipt.getText().concat(addons);
                    txtReceipt.setText(txtReceipt.getText().concat(addons));
            }
        });
    }
    
    
    
}
