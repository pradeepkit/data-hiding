/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import imagepackage.ImagePanel;
import imagepackage.ImageUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Confirm extends JFrame implements ActionListener{
    JLabel l1,l2;
     JTextField textpassword1;
     JButton s;
     ImagePanel panel;
     
    @Override
  public void actionPerformed(ActionEvent evt)
    {
     String ac=evt.getActionCommand();
     if(ac.equals("Submit"))
         {
              
             
              
         }  
    
    }
  public Confirm()
     {  
        setLayout(new GridBagLayout());
    setSize(500,500);
    setLocation(300,200); 
       Dimension d=panel.getSize();
        int width=d.width;
        int height=d.height;
        int x=d.width;
    BufferedImage img= ImageUtilities.readBufferedImage(new File("C:\\Users\\Tripti\\Documents\\NetBeansProjects\\Signature\\dist\\images\\i9"));     
    Graphics g=panel.getGraphics();
    
    GridBagConstraints gbc=new GridBagConstraints();
      g.drawImage(img, 0, 0, x, height, panel); 
      l1=new JLabel("SECURITY");
     l1.setOpaque(true);
    
     l2=new JLabel("PASSWORD");
     l2.setOpaque(true);
     textpassword1=new JTextField();
     //***********************label 1
     gbc.gridx=1;
     gbc.gridy=1;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l1,gbc);
       
         //*********************************labael 2
     gbc.gridx=1;
     gbc.gridy=2;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.fill=GridBagConstraints.NONE;
     add(l2,gbc);
     //********************************text field
    gbc.gridx=2;
     gbc.gridy=2;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.HORIZONTAL;
     add(textpassword1,gbc);
    //************************************ button

     s=new JButton("Submit");
     s.addActionListener(this);
     gbc.gridx=1;
     gbc.gridy=3;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(s,gbc);  
         
         
         //******************************panel
      panel=new ImagePanel();
     panel.setBackground(Color.white);
//    gbc.gridx=1;
//     gbc.gridy=4;
//     gbc.gridwidth=1;
//     gbc.gridheight=1;
//     gbc.weightx=1;
//     gbc.weighty=1;
//     gbc.fill=GridBagConstraints.BOTH;
     add(panel);
//
//         
         
     }
 public static void  main(String[] args)
    {
        
     Confirm f=new Confirm();
     f.setVisible(true);

 }
 
}