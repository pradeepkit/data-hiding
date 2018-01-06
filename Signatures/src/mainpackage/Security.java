/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import imagepackage.ImagePanel;
import imagepackage.ImageUtilities;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Security extends JFrame implements ActionListener{
     JLabel l1,l2,l3,l4,l5,l6,l7;
     JTextField textpassword,textpassword2;
     JButton browse,pt1,s1,b;
     ImagePanel[] panels; 
     JFrame parentform;
     
     
 public void actionPerformed(ActionEvent evt)
    {
String ac=evt.getActionCommand();
       
        //**************************************************
         if(ac.equals("Back"))
         {
             
             Security.this.setVisible(false);
             Security.this.dispose();
             parentform.setVisible(true);
          
         }
//********************************************
if(ac.equals("Browse"))
        {
       int result=chooser.showOpenDialog(this);
       if(result!=JFileChooser.APPROVE_OPTION)
           return;
       File f=chooser.getSelectedFile();
BufferedImage img=ImageUtilities.readBufferedImage(f);
panel.setIcon(img);
        }
//***********************************************
 if(ac.equals("Parts"))
        { int n = 0;
           BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
     BufferedImage img=panel.getIcon();
    try {
        n=Integer.parseInt(textpassword.getText());
        System.out.println(n);int s=(int)Math.sqrt(n);
    int x=s,y=s;
    while(x*y<=n)
    {
        y++;
       
    }
    y--;
    
    if(x*y<n)
        y=y+1;
        System.out.println(y + "," + x);
        try
        {
            p1.removeAll();
        }
        catch(Exception ex)
        {
            
        }
    p1.setLayout(new GridLayout(y,x));
        
        //p1.setLayout(new GridLayout(1,n));
    } 
    catch (Exception ex) {
        Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
    }
    panels=new ImagePanel[n];
    Color[] colors={Color.RED,Color.YELLOW,Color.GREEN,Color.BLUE};
for(int i=0;i<=n-1;i++)
{
    panels[i]=new ImagePanel();
    panels[i].setBackground(colors[i % colors.length]);
    p1.add(panels[i]);
}
    
    p1.revalidate();
    boolean b=false;
    if(b)
        return;
    int picno=0;
   BufferedImage newimg=panel.getIcon();
for(int i=0;i<=n-2;i++)
{
BufferedImage temp=ImageUtilities.getRandomImage(newimg.getWidth(),newimg.getHeight());
BufferedImage xor=ImageUtilities.getXORImage(temp,newimg);
panels[picno].setIcon(xor);
picno++;
System.out.println(picno);

newimg=temp;

            }
      panels[picno].setIcon(newimg);
//panel.setIcon(img);
            


      //ImageUtilities.saveImage(img,new File( "p"+5+".png"),"png");
            return;
}
 //********************************
 if(ac.equals("Save"))
        {
try{
        // System.out.println("m clicked");   
         int n=panels.length;
         String filename=textpassword2.getText();
         String extension=Validation.getExtension(filename);
         filename=filename.replace("." + extension, "");
          for(int i=0;i<=n-1;i++)
          {
          String currentfilename=filename+i+"." +extension;
          System.out.println(currentfilename);
          File f=new File(currentfilename);
       boolean b=   ImageUtilities.saveImage(panels[i].getIcon(),f, extension);
              System.out.println(b + f.getAbsolutePath());
              Validation.setSuccess(l7,"");
          }
}
catch(Exception e){
    
    
Validation.setError(l7,e);
}       // System.out.println(n); 
         //BufferedImage img = panel.getIcon();
             
          //ImageUtilities.saveImage(img, ,"png");
         
        
 //************************************
        }
          }
 public Security(JFrame parentform)
     {

this.parentform=parentform;
     //ImagePanel panel;
     //JFileChooser chooser=new JFileChooser();

  setLayout(new GridBagLayout());

     setTitle("Digital Signature");
    setSize(500,500);
    setLocation(300,200);
     l1=new JLabel("No. of Division");
     l1.setOpaque(true);
    // l1.setBackground(Color.white);
      textpassword=new JTextField();
      textpassword2=new JTextField();
     l2=new JLabel(" ");
     l2.setOpaque(true);
     l3=new JLabel("Choose  Your Image");
     l3.setOpaque(true);
     l5=new JLabel("File Name");
     l5.setOpaque(true);
     l6=new JLabel("       ");
     l6.setOpaque(true);
     l7=new JLabel("Use PNG file extension ");
     l7.setOpaque(true);
     
     //l2.setBackground(Color.white);
     GridBagConstraints gbc=new GridBagConstraints();
     //*********************************labael 1
     gbc.gridx=1;
     gbc.gridy=1;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.fill=GridBagConstraints.NONE;
     add(l1,gbc);
     //********************************text field
    gbc.gridx=2;
     gbc.gridy=1;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.HORIZONTAL;
     add(textpassword,gbc);
     
     
     
     //********************************label of image name
      gbc.gridx=3;
     gbc.gridy=1;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.fill=GridBagConstraints.NONE;
     add(l5,gbc);
      //********************************text field2
    gbc.gridx=4;
     gbc.gridy=1;
     gbc.gridwidth=3;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.HORIZONTAL;
     add(textpassword2,gbc);
     //***********************label 2
     gbc.gridx=5;
     gbc.gridy=2;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l7,gbc);
      //*********************************label 7
     gbc.gridx=1;
     gbc.gridy=3;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.fill=GridBagConstraints.NONE;
     add(l2,gbc);
      
      //*******************************label3
      gbc.gridx=1;
     gbc.gridy=4;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l3,gbc);
      //************************************Browse button

     browse=new JButton("Browse");
     browse.addActionListener(this);
     gbc.gridx=2;
     gbc.gridy=4;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(browse,gbc);
      //************************************Parts button

     pt1=new JButton("Parts");
     pt1.addActionListener(this);
     gbc.gridx=3;
     gbc.gridy=4;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(pt1,gbc);
       //***********************label 6 for spacing
     gbc.gridx=4;
     gbc.gridy=4;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l6,gbc);
      //*********************************save button
       s1=new JButton("Save");
     s1.addActionListener(this);
     gbc.gridx=5;
     gbc.gridy=4;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(s1,gbc);
      
      //*********************************back button
      b=new JButton("Back");
     b.addActionListener(this);
     gbc.gridx=6;
     gbc.gridy=4;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(b,gbc);
//**********************************label4

      l4=new JLabel(" ");
     l4.setOpaque(true);
      gbc.gridx=1;
     gbc.gridy=5;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l4,gbc);

      //******************************panel
      panel=new ImagePanel();
     panel.setBackground(Color.white);
     gbc.gridx=1;
     gbc.gridy=6;
     gbc.gridwidth=3;
     gbc.gridheight=1;
     gbc.weightx=1;
     gbc.weighty=1;
     gbc.fill=GridBagConstraints.BOTH;
     add(panel,gbc);
     //************************************p1 panel
     p1=new ImagePanel();
     p1.setBackground(Color.gray);
     gbc.gridx=4;
     gbc.gridy=6;
     gbc.gridwidth=3;
     gbc.gridheight=1;
     gbc.weightx=2;
     gbc.weighty=2;
     gbc.fill=GridBagConstraints.BOTH;
     add(p1,gbc);
//**********************************
 }
 public static void  main(String[] args)
    {

     Security f=new Security(null);
     f.setVisible(true);

 }
 JFileChooser chooser=new JFileChooser();
 ImagePanel panel,p1;
}
