/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage;

import imagepackage.ImagePanel;
import imagepackage.ImageUtilities;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;


public class ProjectMain extends JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        String ac=evt.getActionCommand();
        //**************************************************
        if(ac.equals("Test"))
        {
          BufferedImage img=  ImageUtilities.insertMessageIntoImage(panel.getIcon(), "This is a message");
          panel.setIcon(img);
            return;

        }

        //*********
      /* if(ac.equals("Extract"))
       {
        String img=  ImageUtilities.ExtractMessageFromImage((panel.getIcon());
          panel.setIcon(img);
            return;

        }*/
        //********************************************************
         if(ac.equals("Extracted"))
        {

       BufferedImage  x = panel.getIcon();

      BufferedImage   y =ImageUtilities. getGrayScale(x);
         panel.setIcon(y);
            return;

        }
        //*************************************************************
        if(ac.equals("Parts"))
        {

BufferedImage img=panel.getIcon();
for(int i=1;i<=4;i++)
{
BufferedImage temp=ImageUtilities.getRandomImage(img.getWidth(),img.getHeight());
BufferedImage xor=ImageUtilities.getXORImage(temp,img);
ImageUtilities.saveImage(temp,new File( "p"+i+".png"),"png");
img=xor;

            }
      ImageUtilities.saveImage(img,new File( "p"+5+".png"),"png");
            return;

        }
        //********************************************************
         if(ac.equals("Combined"))
        {

       BufferedImage  x = ImageUtilities.readBufferedImage(new File("p1.png"));
       for(int i=2;i<=5;i++)
       {
       BufferedImage  y = ImageUtilities.readBufferedImage(new File("p" + i +".png"));
    BufferedImage  newx=ImageUtilities.getXORImage(x, y);
    x=newx;
            }
       panel.setIcon(x);
       ImageUtilities.saveImage(x,new File("output.png"), "png");

        }
        //*************************************************************
         if(ac.equals("Result"))
        {

       BufferedImage  x = panel.getIcon();
        BufferedImage  y = p1.getIcon();

      BufferedImage   z =ImageUtilities. getXORImage(x,y);
         p2.setIcon(z);
            return;

        }

        //*********
        if(ac.equals("Random"))
        {
          BufferedImage  x = panel.getIcon();

      BufferedImage   y =ImageUtilities. getRandomImage(x.getWidth(),x.getHeight());
         panel.setIcon(y);
            return;
        }
        //**************************************************
        if(ac.equals("Load"))
        {
       int result=chooser.showOpenDialog(this);
       if(result!=JFileChooser.APPROVE_OPTION)
           return;
       File f=chooser.getSelectedFile();
BufferedImage img=ImageUtilities.readBufferedImage(f);
panel.setIcon(img);
        }
          if(ac.equals("Load Two"))
        {
       int result=chooser.showOpenDialog(this);
       if(result!=JFileChooser.APPROVE_OPTION)
           return;
       File f=chooser.getSelectedFile();
BufferedImage img=ImageUtilities.readBufferedImage(f);
p1.setIcon(img);
        }
         if(ac.equals("Load Three"))
        {
       int result=chooser.showOpenDialog(this);
       if(result!=JFileChooser.APPROVE_OPTION)
           return;
       File f=chooser.getSelectedFile();
BufferedImage img=ImageUtilities.readBufferedImage(f);
p2.setIcon(img);
        }
        

        if(ac.equals(("Save")))
        {

             BufferedImage img = panel.getIcon();
             BufferedImage img2 = p2.getIcon();
              int result=chooser.showSaveDialog(this);
       if(result!=JFileChooser.APPROVE_OPTION)
           return;
File f=chooser.getSelectedFile();
ImageUtilities.saveImage(img, f,"png");
ImageUtilities.saveImage(img2, f,"png");
        }

    }
public static void main(String args[])
    {
    ProjectMain f=new ProjectMain();
    f.setVisible(true);
}
JFileChooser chooser=new JFileChooser();
ImagePanel panel,p1,p2;


public ProjectMain()
    {
    setLayout(new GridLayout(1,3));
    panel=new ImagePanel();
    add(panel);
    p1=new ImagePanel();
    p2=new ImagePanel();
    add(p1);
    add(p2);
    setTitle("Signature");
    setSize(500,500);
    setLocation(300,200);

    JMenuBar mb=new JMenuBar();
    setJMenuBar(mb);
    JMenu utilitymenu=new JMenu("Utilities");
    utilitymenu.setMnemonic('U');




    mb.add (utilitymenu);
    JMenuItem loadmenu=new JMenuItem("Load");
    JMenuItem savemenu=new JMenuItem("Save");
     utilitymenu.add(loadmenu);
     loadmenu.setMnemonic('L');
     
   loadmenu.addActionListener(this);
    savemenu.addActionListener(this);
   

 utilitymenu.add(savemenu);
     savemenu.setMnemonic('S');
     JMenuItem testmenu=new JMenuItem("Test");
      utilitymenu.add(testmenu);
       testmenu.setMnemonic('T');
       testmenu.addActionListener(this);
        JMenuItem extractmenu=new JMenuItem("Extract");
      utilitymenu.add(extractmenu);
       extractmenu.setMnemonic('E');
       extractmenu.addActionListener(this);
       JMenuItem extractedmenu=new JMenuItem("Extracted");
      utilitymenu.add(extractedmenu);
       extractedmenu.setMnemonic('E');
       extractedmenu.addActionListener(this);
       JMenuItem randommenu=new JMenuItem("Random");
      utilitymenu.add(randommenu);
       randommenu.setMnemonic('R');
       randommenu.addActionListener(this);
       JMenuItem loadtwomenu=new JMenuItem("Load Two");
      utilitymenu.add(loadtwomenu);
       loadtwomenu.setMnemonic('L');
       loadtwomenu.addActionListener(this);
       JMenuItem loadthreemenu=new JMenuItem("Load Three");
      utilitymenu.add(loadthreemenu);
       loadthreemenu.setMnemonic('L');
       loadthreemenu.addActionListener(this);
        JMenuItem resultmenu=new JMenuItem("Result");
      utilitymenu.add(resultmenu);
       resultmenu.setMnemonic('R');
       resultmenu.addActionListener(this);
JMenuItem partsmenu=new JMenuItem("Parts");
      utilitymenu.add(partsmenu);
       partsmenu.setMnemonic('P');
       partsmenu.addActionListener(this);
       JMenuItem combomenu=new JMenuItem("Combined");
      utilitymenu.add(combomenu);
       combomenu.setMnemonic('C');
       combomenu.addActionListener(this);


}
}

