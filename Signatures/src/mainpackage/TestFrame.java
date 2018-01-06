/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import animationspackage.NewAnimation;
import demopackage.DBConnector;
import demopackage.IconHelper;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;


public class TestFrame extends JFrame implements ActionListener
{
    private JPanel panel;
    public TestFrame()
    {
       Connection connection= DBConnector.connect();
        System.out.println(connection);
        IconHelper.placeIcon(this);
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        JMenu mnu=new JMenu("Test");
        JMenuItem item=new JMenuItem("Play");
        mb.add(mnu);
        mnu.add(item);
        item.addActionListener(this);
        add(panel=new JPanel());
        panel.setBackground(Color.black);
        setSize(300,300);
        panel.setLayout(new FlowLayout());
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        TestFrame f=new TestFrame();
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // SlideAnimations.drawAnimation(panel);
        NewAnimation.drawAnimation(panel,TestFrame.this);
    }
}

