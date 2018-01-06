/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animationspackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;


public class SlideAnimations extends Thread{
    private JPanel panel;
    public static void drawAnimation(JPanel panel)
    {
        SlideAnimations animations=new SlideAnimations(panel);
        animations.start();
    }
    public SlideAnimations(JPanel panel)
    {
        this.panel=panel;
    }
    public void run()
    {
        Dimension d=panel.getSize();
        int width=d.width;
        int height=d.height;
        int x=0;
        Graphics g=panel.getGraphics();
        g.setColor(Color.BLUE);
        while(true)
        try
        {
            
            g.fillRect(0,0, x, height);
            x++;
            if(x>=width)
                return;;
                Thread.sleep(30);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
