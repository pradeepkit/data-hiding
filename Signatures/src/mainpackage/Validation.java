/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import java.awt.Color;
import java.io.File;
import javax.swing.JLabel;

public class Validation {
    public static void setError(JLabel lb,String message){
        lb.setText(message);
        lb.setBackground(Color.RED);
        
    }
    public static  String getExtension(String filename) throws Exception{
        filename=filename.trim();
        int n=filename.indexOf(".");
        if(n<0)
            return "png";
        if(n==0)
            throw new Exception("Not a proper filename");
        String[] extensions={"jpg","jpeg","png","bmp","gif","wbmp"};
        String extension=filename.substring(n+1).trim().toLowerCase();
        for(int i=0;i<=extensions.length-1;i++)
            if(extension.equals(extensions[i]))
                    return extension;
                    
                
        throw new Exception("Invalid extension");
        
    }
    public static void isFileExisting(File f)throws Exception 
    {
        if(!f.exists())
        {
            throw new Exception("File does not exist");
        }
    }
     public static void setError(JLabel lb,Exception ex){
         Color newcolor=new Color(238,238,238);
         
        lb.setText(ex.getMessage());
        lb.setBackground(newcolor);
        
    }
    public static void setSuccess(JLabel lb,String message){
       Color newcolor=new Color(238,238,238);
        
        lb.setText(message);
        lb.setBackground(newcolor);
        
    }
    
  public static void  main(String[] args)
    {

     Validation f=new Validation();
    
 }   
}
