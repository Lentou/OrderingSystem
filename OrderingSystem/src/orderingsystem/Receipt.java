/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderingsystem;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Allen
 */
class Receipt extends Frame {
    
    Order order = new Order();
    Payment pay = new Payment();
    Receipt(){
        setBackground(Color.GRAY);
        setTitle("TEA-NAPA Milk Tea Ordering System");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        type();
        button();
    }
    
    public void type(){
        TextArea area = new TextArea();
        area.setBounds(50, 50, 200, 240);
        area.setEnabled(false);
        float value = order.getAddonPrice() + order.getFlavorPrice() + order.getCupPrice();
        String lahat = "Addon: P" + order.getAddonPrice() + "\nFlavor: P" + order.getFlavorPrice() + "\nCup: P" + order.getCupPrice();
        area.setText(
                " -- [ TEA-NAPA MILK TEA ] --\n" + order.getDescription() + "\n -- [ RECEIPT ] -- \n" + lahat + "\nTOTAL: P" + value);
        add(area);
    }
    public void button(){
        Button done = new Button("Done");
        done.setBounds(270, 50, 90, 30);
        done.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               setVisible(false);
               order.setVisible(true);
            }
        });
        add(done);
    }
}
