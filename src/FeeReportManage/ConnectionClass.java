package FeeReportManage;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import oracle.jdbc.driver.OracleDriver;

public class ConnectionClass
{
    Connection con;
    Statement st;
    PreparedStatement pst;
    OracleDriver d;
    Properties p;
     
    ConnectionClass()
    {
      try
      {
        d = new OracleDriver();
        p = new Properties();
	p.setProperty("user", "scott");
	p.setProperty("password", "tiger");
	con = d.connect("jdbc:oracle:thin:@localhost:1521:orcl", p);
        st = con.createStatement();
        if(con.isClosed())
        {
            JOptionPane.showMessageDialog(null,"Connection fail,Something went wrong !");
            //System.out.println("Database connection fail !");
        }
      }
      catch(Exception e)
      {
           JOptionPane.showMessageDialog(null,"Connection fail,Something went wrong !");
           //e.printStackTrace();
      }
    }
    public static void main(String[] args)
    {  
       new ConnectionClass();
    }

    
}