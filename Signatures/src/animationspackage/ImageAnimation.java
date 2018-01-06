/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animationspackage;
import imagepackage.ImageUtilities;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JPanel;

public class ImageAnimation extends Thread{
    private JPanel panel;
    public static void drawAnimation(JPanel panel)
    {
        ImageAnimation animations=new ImageAnimation(panel);
        animations.start();
    }
    public ImageAnimation(JPanel panel)
    {
        this.panel=panel;
    }
    public void run()
    {
        Dimension d=panel.getSize();
        int width=d.width;
        int height=d.height;
        int x=d.width;
        BufferedImage img= ImageUtilities.readBufferedImage(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg"));
        
        Graphics g=panel.getGraphics();
       // g.drawImage(null, 0, 0, );
        while(true)
        try
        {
            
            g.drawImage(img, 0, 0, x, height, panel);
            x--;
            if(x<0)
                return;;
                Thread.sleep(30);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
