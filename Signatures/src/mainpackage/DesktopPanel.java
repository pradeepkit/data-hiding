/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import imagepackage.ImagePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class DesktopPanel extends JPanel{
    public DesktopPanel()
    {
        ThreadedDrawing th=new ThreadedDrawing();
        th.start();
    }
    class ThreadedDrawing extends Thread
    {
        public void run()
        {
            Color[] colors={Color.RED,Color.YELLOW,Color.GREEN};
            int n=0;
            int width=0,height=0;
            while(true)
            {
                try
                {
                Graphics g=getGraphics();
                Dimension d=getSize();
                width++;
                height++;
                g.setColor(colors[n++ % colors.length]);
                Thread.sleep(2000);
                g.fillOval(0, 0, width, height);
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
                
                
            }
            
        }
    }
   
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
//            Dimension d=getSize();
//            g.setColor(Color.red);
//            g.fillOval(0, 0, d.width,d.height);
    }
    
    
    
    
}
