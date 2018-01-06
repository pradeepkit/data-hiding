package mainpackage;
import imagepackage.ImagePanel;
import imagepackage.ImageUtilities;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExtractFrame extends JFrame implements ActionListener{
     JLabel l1,l2,l3,l4,l5;
     JTextField textpassword;
     JButton browse,e1,b;
     JFrame parentform;
    @Override
 public void actionPerformed(ActionEvent evt)
    {
String ac=evt.getActionCommand();
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
 if(ac.equals("Extract"))
        {
     String message=  ImageUtilities.ExtractMessageFromImage(panel.getIcon());
     textpassword.setText(message);


            // BufferedImage img = panel.getIcon();

       
          return;
        }
//**************************************************
          if(ac.equals("Back"))
         {
             ExtractFrame.this.setVisible(false);
             ExtractFrame.this.dispose();
             parentform.setVisible(true);
//             SimpleFrame obj=new SimpleFrame();
//             obj.setVisible(true);
//             this.setVisible(false);
              
         }  
          
 //**************************************************         
        
}
 public ExtractFrame(JFrame parentform)
     {
this.parentform=parentform;

     //ImagePanel panel;
     //JFileChooser chooser=new JFileChooser();

  setLayout(new GridBagLayout());

     setTitle("Digital Signature");
    setSize(500,500);
    setLocation(300,200);
     l1=new JLabel(" Your Password");
     l1.setOpaque(true);
    // l1.setBackground(Color.white);
      textpassword=new JTextField();
     l2=new JLabel(" ");
     l2.setOpaque(true);
     l3=new JLabel("Choose  Your Image");
     l3.setOpaque(true);
     l5=new JLabel("                ");
     l5.setOpaque(true);
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
     gbc.gridwidth=4;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.fill=GridBagConstraints.HORIZONTAL;
     add(textpassword,gbc);
     //***********************label 2
     gbc.gridx=1;
     gbc.gridy=2;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l2,gbc);
      //*******************************label3
      gbc.gridx=1;
     gbc.gridy=3;
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
     gbc.gridy=3;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(browse,gbc);
   //*******************************label5
      gbc.gridx=3;
     gbc.gridy=3;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l5,gbc);   
      //************************************extract button

     e1=new JButton("Extract");
     e1.addActionListener(this);
     gbc.gridx=4;
     gbc.gridy=3;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(e1,gbc);
      //*********************************back button
       b=new JButton("Back");
     b.addActionListener(this);
     gbc.gridx=5;
     gbc.gridy=3;
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
     gbc.gridy=4;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l4,gbc);

      //******************************panel
      panel=new ImagePanel();
      panel.setBackground(Color.white);

     gbc.gridx=1;
     gbc.gridy=5;
     gbc.gridwidth=5;
     gbc.gridheight=1;
     gbc.weightx=1;
     gbc.weighty=1;
     gbc.fill=GridBagConstraints.BOTH;
     add(panel,gbc);
     //************************************



 }
 public static void  main(String[] args)
    {
     
     ExtractFrame f=new ExtractFrame(null);
     f.setVisible(true);
        
 }
 JFileChooser chooser=new JFileChooser();
 ImagePanel panel;
}
