package menupackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
public class LookAndFeelMenu extends JMenu
{
public LookAndFeelMenu()
{
this.setText("Look And Feel Menu");
UIManager.LookAndFeelInfo[] info =UIManager.getInstalledLookAndFeels();  
for(int i=0;i<=info.length-1;i++)
{
JMenuItem item=new JMenuItem(info[i].getName());
this.add(item);
item.addActionListener(new MenuHandler(info[i].getClassName(),info[i].getName()));
}
}



class MenuHandler implements ActionListener
{
private String classname,name;
public MenuHandler(String classname,String name)
{
this.classname=classname;
this.name=name;
}
        @Override
public void actionPerformed(ActionEvent evt)
{
try
{
UIManager.setLookAndFeel(classname);  
SwingUtilities.updateComponentTreeUI(LookAndFeelMenu.this.getParent());
}
catch(Exception ex)
{
System.out.println(ex);
}
}

}



}