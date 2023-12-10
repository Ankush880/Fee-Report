package FeeReportManage;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class EditStudent extends JFrame implements ActionListener
{
    static String numb ;
    JLabel l1,l2,l3;
    JButton bt1,bt2,bt3;
    JPanel p1,p2,p3;
    JTextField tf1,tf2;
    Font f,f1;
   
    EditStudent()
    {
       super("Edit Student");
       setLocation(100,100);
       setSize(500,200);
    
       l1=new JLabel("Student Details");
       l2=new JLabel("s.no");
       l3=new JLabel("s.name");
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.RED);
       
       bt1=new JButton("Update Details");
       bt2=new JButton("Delete Student");
       bt3=new JButton("Back");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       bt3.addActionListener(this);
       
       tf1=new JTextField();
       tf2=new JTextField();
       
       f=new Font("Arial",Font.BOLD,20);
       f1=new Font("Arial",Font.BOLD,15);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       bt1.setFont(f1);
       bt2.setFont(f1);
       tf1.setFont(f1);
       tf2.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(3,2,10,10));
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(tf2);
       p2.add(bt1);
       p2.add(bt2);
       
       p3=new JPanel();
       p3.setLayout(new GridLayout(1,1,10,10));
       p3.add(bt3);
       
       setLayout(new BorderLayout(0,0));
       
       add(p1,"North");
       add(p2,"Center");
       add(p3,"East");
    }
    public void actionPerformed(ActionEvent e)
   {
       String sno=tf1.getText();
       String sname=tf2.getText();
       numb=sno;
       
       if(e.getSource()==bt1)
       {
           try
           {
              ConnectionClass obj=new ConnectionClass();
              String q="select * from student where std='"+sno+"'and name='"+sname+"'";
              ResultSet rs=obj.st.executeQuery(q);
              if(rs.next())
              {  
                 new Update().setVisible(true);
                 this.setVisible(false);
              }
              else
              {
                 JOptionPane.showMessageDialog(null,"Record not found!");
                 this.setVisible(true);
              }
           }  
           catch(Exception ee)
           {
              JOptionPane.showMessageDialog(null,"Something went wrong !");
              this.setVisible(true);
              //ee.printStackTrace();
           }
       }
       if(e.getSource()==bt2)
       {
           try
           {
              ConnectionClass obj=new ConnectionClass();
              String q="delete from student where std='"+sno+"'";
              Statement stmt = obj.con.createStatement();
              int row = stmt.executeUpdate(q);
              if(row>0)
             {
                  JOptionPane.showMessageDialog(this,"Delete successfully !");
                  this.setVisible(true);
              }
              else
              {
                 JOptionPane.showMessageDialog(null,"Record not found!");
                 this.setVisible(true);
              }
           }  
           catch(Exception ee)
           {
              JOptionPane.showMessageDialog(null,"Something went wrong !");
              this.setVisible(true);
              //ee.printStackTrace();
           }
       }
       if(e.getSource()==bt3)
       {
           new AccountantSection().setVisible(true);
           this.setVisible(false);  
       }
   }
    public static void main(String[] args)
   {
      new EditStudent().setVisible(true);  
   }
}
