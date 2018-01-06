package mainpackage;
import demopackage.IconHelper;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class SimpleFrame extends JFrame implements ActionListener{
     JMenuBar bm;
    @Override
     public void actionPerformed(ActionEvent evt)
    {
        
          String ac=evt.getActionCommand();
//**************************************************
         if(ac.equals("Insert Password"))
         {
             PasswordFrame obj=new PasswordFrame(SimpleFrame.this);
             obj.setVisible(true);
             this.setVisible(false);
              
         }
 if(ac.equals("Retrieve Password"))
         {
          ExtractFrame obj=new ExtractFrame(SimpleFrame.this);
             obj.setVisible(true);
             this.setVisible(false);   
         }
         
//**********************************************************
 if(ac.equals("Fragment"))
         {
             Security obj=new Security(SimpleFrame.this);
             obj.setVisible(true);
             this.setVisible(false);
              
         }
 if(ac.equals("Combine"))
         {
          Combo obj=new Combo(SimpleFrame.this);
             obj.setVisible(true);
             this.setVisible(false);   
         }
//*********************************************************
     }
     //***********************************k*******************
//JButton internal,external;
 public SimpleFrame()
 {
     IconHelper.placeIcon(this);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     //setLayout(new GridBagLayout());
     setTitle("Digital Signature");
    setSize(500,500);
    setLocation(300,200);
 //GridBagConstraints gbc=new GridBagConstraints();
  //******************************panel
      panel=new DesktopPanel();
     panel.setBackground(Color.white);
    
     add(panel);
     //*********************************
    bm=new JMenuBar();
    bm.setVisible(true);
    setJMenuBar(bm);
    JMenu internalmenu=new JMenu("Internal Access");
    internalmenu.setMnemonic('I');
    bm.add (internalmenu);
    
    
    
   JMenu externalmenu=new JMenu("External Access");
    externalmenu.setMnemonic('E');
    bm.add (externalmenu);
    
   JMenuItem insertmenu=new JMenuItem("Insert Password");
      externalmenu.add(insertmenu);
       insertmenu.setMnemonic('I');
      insertmenu.addActionListener(this);
       JMenuItem retrievemenu=new JMenuItem("Retrieve Password");
      externalmenu.add(retrievemenu);
       retrievemenu.setMnemonic('R');
       retrievemenu.addActionListener(this); 
       JMenuItem fragmenu=new JMenuItem("Fragment");
      internalmenu.add(fragmenu);
       fragmenu.setMnemonic('F');
      fragmenu.addActionListener(this);
       JMenuItem segmenu=new JMenuItem("Combine");
      internalmenu.add(segmenu);
       segmenu.setMnemonic('C');
     segmenu.addActionListener(this);
       
   
 }
 //***********************************************************
public static void main(String args[])
    {

     SimpleFrame obj=new SimpleFrame();
 obj.setVisible(true);
    }
DesktopPanel panel;
}


 
 
 
  

