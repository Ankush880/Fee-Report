package FeeReportManage;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
    Font f,f1;
    
    Update()
    {
       super("Updating Section");
       setLocation(100,100);
       setSize(600,500);
       
    
       l1=new JLabel("Update Details");
       l2=new JLabel("Name");
       l3=new JLabel("Email");
       l4=new JLabel("Course");
       l5=new JLabel("Fee");
       l6=new JLabel("Paid");
       l7=new JLabel("Due");
       l8=new JLabel("Address");
       l9=new JLabel("Contact");
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.RED);
       
       bt1=new JButton("Update Data");
       bt2=new JButton("Back");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       
       
       tf1=new JTextField();
       tf2=new JTextField();
       tf3=new JTextField();
       tf4=new JTextField();
       tf5=new JTextField();
       tf6=new JTextField();
       tf7=new JTextField();
       tf8=new JTextField();
       
       f=new Font("Arial",Font.BOLD,20);
       f1=new Font("Arial",Font.BOLD,15);
       
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       l7.setFont(f1);
       l8.setFont(f1);
       l9.setFont(f1);
       bt1.setFont(f1);
       bt2.setFont(f1);
     
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(9,2,10,10));
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(tf2);
       p2.add(l4);
       p2.add(tf3);
       p2.add(l5);
       p2.add(tf4);
       p2.add(l6);
       p2.add(tf5);
       p2.add(l7);
       p2.add(tf6);
       p2.add(l8);
       p2.add(tf7);
       p2.add(l9);
       p2.add(tf8); 
       p2.add(bt1);
       p2.add(bt2);
       
       setLayout(new BorderLayout(0,0));
       
       add(p1,"North");
       add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
     {
        
        String nam=tf1.getText();
        String eml=tf2.getText();
        String cours=tf3.getText();
        String fe=tf4.getText();
        String pai=tf5.getText();
        String du=tf6.getText();
        String addr=tf7.getText();
        String cont=tf8.getText();
        
        if(e.getSource()==bt1)
        {
            try
           {
              ConnectionClass obj=new ConnectionClass();
              String q="update student set name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,contact=? where std='"+EditStudent.numb+"'";
              PreparedStatement pst=obj.con.prepareStatement(q);
              
              pst.setString(1, nam);
              pst.setString(2, eml);
              pst.setString(3, cours);
              pst.setString(4, fe);
              pst.setString(5, pai);
              pst.setString(6, du);
              pst.setString(7, addr);
              pst.setString(8, cont);
              int i =pst.executeUpdate();
              if(i>0)
              {  
                 JOptionPane.showMessageDialog(this,"Update successfully !");
                 this.setVisible(true);
              }
              else
              {
                 JOptionPane.showMessageDialog(null,"Invalid S.No,please check and try again!");
                 this.setVisible(true);
              }
           }
            catch(Exception ee)
           {  
               JOptionPane.showMessageDialog(null,"Something went wrong, Not saved !");
               this.setVisible(true);
               //ee.printStackTrace();
           }
             }
        if(e.getSource()==bt2)
        {
            new EditStudent().setVisible(true);
            this.setVisible(false);
        }
     }
     public static void main(String[] args)
     {
         new Update().setVisible(true);  
     }
}
