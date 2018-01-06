/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demopackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.OracleDriver;


public class DBConnector {
    public static boolean checkpassword(String pwd)
    {
        try{
            Connection conn=connect();
            //System.out.println("Password is " + pwd.trim());
            PreparedStatement ps=conn.prepareStatement("select * from login where password=?");
            ps.setString(1, pwd.trim());
            ResultSet rs=ps.executeQuery();
            boolean b=rs.next();
            System.out.println(b);
            return b;
        }
       catch(Exception ex) 
       {
           System.out.println(ex);
           return false;
        }
        
    }
    public static Connection connect()
    {
         try
        {
        DriverManager.registerDriver(new OracleDriver());
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String username="system";
        String password="oracle";
            Connection con=DriverManager.getConnection(url, username, password);
            return con;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return null;
        }
        
    }
}
