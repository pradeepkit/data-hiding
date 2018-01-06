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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import menupackage.LookAndFeelMenu;

public class Combo extends JFrame implements ActionListener{
     JLabel l1,l2,l3,l4,l5,l6;
     JTextField textpassword2;
     JButton c1,s1,b;
     ImagePanel[] panels;
     JProgressBar progressBar;
     JFrame parentform;
   /*  task = new Task();
    task.addPropertyChangeListener(this);
    task.execute();*/
 public void actionPerformed(ActionEvent evt)
    {
String ac=evt.getActionCommand();
BufferedImage  img1;
Color newcolor=new Color(238,238,238);




//********************************************
/*java.io.File f;
f.listFiles();*/
//***********************************************
 if(ac.equals("Combined"))
        {  
            try
            {
            
            //String a=textpassword2.getText();
            int result=chooser.showOpenDialog(this);
       if(result!=JFileChooser.APPROVE_OPTION)
           return;
                System.out.println(progressBar.getBackground());
       File f=chooser.getSelectedFile();
       Validation.isFileExisting(f);
   String name=    f.getName();
   int pos=name.lastIndexOf(".");
   String extension=name.substring(pos+1).trim();
   String filename=name.substring(0,pos);
   String folder=    f.getParent();
            
            pos=0;
            char[] chars=filename.toCharArray();
            while(!Character.isDigit(chars[pos]))
                pos++;
            name=filename.substring(0,pos);
            String number=filename.substring(pos).trim();
            System.out.printf("\nName = %s, directory=%s, extension=%s number=%s\n",name,folder,extension,number);
            List<File> lst=new ArrayList<File>();
            File directory=new File(folder);
            File[] files=directory.listFiles();
            for(File file:files)
            {
                String x=file.getName();
                if(x.startsWith(name) && x.endsWith(extension))
                {
                    lst.add(file);
                    System.out.println(x);
                }
            }
            int nooffiles=lst.size();
            System.out.printf("\nFiles found=%s",nooffiles);
            int n=nooffiles;
//********************************************************
  
  
  img1 = ImageUtilities.readBufferedImage(lst.get(0));
          //  System.out.println("done");
  progressBar.setMinimum(0);
  progressBar.setMaximum(lst.size()-1);
  for(int i=1;i<=lst.size()-1;i++)
{
BufferedImage  img2 = ImageUtilities.readBufferedImage(lst.get(i));
BufferedImage  img3=ImageUtilities.getXORImage(img1, img2);
    img1=img3;
    progressBar.setValue(i);
    progressBar.repaint();
              
}
      panel.setIcon(img1);
Validation.setSuccess(l3, "Image Combined successfully");

                //System.out.println(progressBar.getBackground(Color.OPAQUE);
      return;
 
 
        }
 
            
 catch(Exception ex)
 {
     Validation.setError(l3, ex);
 }
            
        }        
 //********************************************** 
 if(ac.equals(("Save")))
        {
            try
            {

             img1 = panel.getIcon();
             
              int result1=chooser.showSaveDialog(this);
       if(result1!=JFileChooser.APPROVE_OPTION)
           return;
File g=chooser.getSelectedFile();
ImageUtilities.saveImage(img1, g,"png");
Validation.setSuccess(l3, "File saved successfully");
            }
            catch(Exception ex)
            {
                Validation.setError(l3, ex);
            }
        }
 if(ac.equals("Back"))
         {
              Combo.this.setVisible(false);
              Combo.this.dispose();
             parentform.setVisible(true);
              
         }  
 
 //********************************************

}
 public Combo(JFrame parentform)
     {

this.parentform=parentform; 
     //ImagePanel panel;
     //JFileChooser chooser=new JFileChooser();
         JMenuBar mb=new JMenuBar();
         mb.add(new LookAndFeelMenu());
         setJMenuBar(mb);
  setLayout(new GridBagLayout());

     setTitle("Digital Signature");
    setSize(500,500);
    setLocation(300,200);
     l1=new JLabel(" ");
     l1.setOpaque(true);
    
     l2=new JLabel(" ");
     l2.setOpaque(true);
     progressBar = new JProgressBar();
     progressBar.setStringPainted(true);
     l3=new JLabel("Status");
     l3.setOpaque(true); 
     l4=new JLabel(" ");
     l4.setOpaque(true);
      l5=new JLabel("                          ");
     l5.setOpaque(true);
      l6=new JLabel(" ");
     l6.setOpaque(true);
     
     //l2.setBackground(Color.white);
     GridBagConstraints gbc=new GridBagConstraints();
     //***********************label 1
     gbc.gridx=1;
     gbc.gridy=1;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l1,gbc);
       //************************************combo button

     c1=new JButton("Combined");
     c1.addActionListener(this);
     gbc.gridx=1;
     gbc.gridy=2;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(c1,gbc);
       //***********************label 5 for space
     gbc.gridx=2;
     gbc.gridy=2;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l5,gbc);
      //*********************************save
       s1=new JButton("Save");
     s1.addActionListener(this);
     gbc.gridx=3;
     gbc.gridy=2;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(s1,gbc);
       //***********************label 6 for space
     gbc.gridx=4;
     gbc.gridy=2;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(l6,gbc);
      //*********************************back
       b=new JButton("Back");
     b.addActionListener(this);
     gbc.gridx=5;
     gbc.gridy=2;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(b,gbc);
     //*********************************label 2
     gbc.gridx=1;
     gbc.gridy=3;
     gbc.gridwidth=1;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
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
     // Color newcolor=new Color(238,238,238);
      
      
      //*******************************progress bar
     gbc.gridx=4;
     gbc.gridy=4;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=0;
     gbc.weighty=0;
     gbc.fill=GridBagConstraints.NONE;
      add(progressBar,gbc);
    
     
//**********************************label4

     
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
     gbc.gridwidth=5;
     gbc.gridheight=1;
     gbc.weightx=1;
     gbc.weighty=1;
     gbc.fill=GridBagConstraints.BOTH;
     add(panel,gbc);
     //************************************p1 panel
   /*  p1=new ImagePanel();
     p1.setBackground(Color.gray);
     gbc.gridx=3;
     gbc.gridy=5;
     gbc.gridwidth=2;
     gbc.gridheight=1;
     gbc.weightx=2;
     gbc.weighty=2;
     gbc.fill=GridBagConstraints.BOTH;
     add(p1,gbc);*/
//**********************************
 }
 public static void  main(String[] args)
    {

     Combo f=new Combo(null);
     f.setVisible(true);

 }
 JFileChooser chooser=new JFileChooser();
 ImagePanel panel;
 
}

