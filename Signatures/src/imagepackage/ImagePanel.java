/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagepackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
public class ImagePanel extends JPanel
{
private Image img;
private BufferedImage bimage=null;
public void setIcon(BufferedImage img)
{
this.img=img;
bimage=img;
paintComponent(super.getGraphics());
}
public void setIcon(Image img)
{
this.img=img;
paintComponent(super.getGraphics());
}
public BufferedImage getIcon()
    {
    return bimage;
}
public void paintComponent(Graphics g)
{
super.paintComponent(g);
if(img==null)
return;
Dimension d=getSize();
g.drawImage(img,0,0,d.width,d.height,null);
}
}
