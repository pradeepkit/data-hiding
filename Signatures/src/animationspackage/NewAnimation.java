
package animationspackage;
import demopackage.DBConnector;
import imagepackage.ImageUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
import mainpackage.SimpleFrame;
import mainpackage.TestFrame;


public class NewAnimation extends Thread implements ActionListener{
    private JPanel panel;
    JLabel l1,l2;
     JPasswordField textpassword1;
     JButton s;
     TestFrame f;
    private BufferedImage[] images;
    public static void drawAnimation(JPanel panel,TestFrame f)
    {
        NewAnimation animations=new NewAnimation(panel,f);
        animations.start();
    }
    public NewAnimation(JPanel panel,TestFrame f)
    {
        this.f=f;
        images=new BufferedImage[9];
        String basepath="C:\\Users\\Tripti\\Documents\\NetBeansProjects\\Signature\\dist\\images\\i";
        for(int i=0;i<=images.length-1;i++)
        {
           images[i]=ImageUtilities.readBufferedImage(new File(basepath + (i+1) + ".png"));
            //System.out.println(basepath + (i+1) + ".png");
        }
        this.panel=panel;
    }
    public void run()
    {
       int imageno=0;
            
        Dimension d=panel.getSize();
         Graphics g=panel.getGraphics();
        
      
        while(true)
        try
        {
            
            g.drawImage(images[imageno], 0, 0, d.width,d.height, null);
            imageno=(imageno+1)%images.length;
                Thread.sleep(250);
                if(imageno==0)
                {
                  l1=new JLabel("SECURITY");
                  l1.setOpaque(true);
    
                  l2=new JLabel("PASSWORD");
                  l2.setOpaque(true);
                  textpassword1=new JPasswordField(10);
                   panel.add(l1);
                   panel.add(l2);
                    panel.add(textpassword1);
                    panel.add(s=new JButton("Submit"));
                 s.addActionListener(this);
                    panel.revalidate();
                    panel.setBackground(Color.WHITE);
                    return;
                }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String pwd=new String(textpassword1.getPassword());
       // System.out.println(pwd);
        boolean b=DBConnector.checkpassword(pwd);
        if(!b)
        {
            JOptionPane.showMessageDialog(null, "Invalid password");
            return;
        }
        f.setVisible(false);
        SimpleFrame ff=new SimpleFrame();
        ff.setVisible(true);
    }
}
