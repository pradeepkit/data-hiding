/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demopackage;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class IconHelper {
    public static void placeIcon(JFrame f)
    {
         Toolkit tk=Toolkit.getDefaultToolkit();
     Image img=tk.getImage("e:\\1.png");
     f.setIconImage(img);
    
    }
}
