/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demopackage;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class ProgressBarDemo extends JFrame{
    private JProgressBar pg;
    class ProgressThread extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                while(true)
                {
                    int value=pg.getValue();
                    value++;
                    pg.setValue(value);
                    Thread.sleep(1000);
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
    }
    public void f1()
    {
        ProgressThread th=new ProgressThread();
        th.start();
    }
    public ProgressBarDemo()
    {
        pg=new JProgressBar(0,100);
        add(pg);
        setSize(200,100);
        
    }
    public static void main(String[] args)
    {
        ProgressBarDemo d=new ProgressBarDemo();
        d.setVisible(true);
        d.f1();
    }
}
