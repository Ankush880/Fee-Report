package FeeReportManage;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddAccountent extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4;
    JPasswordField pf;
    Font f,f1;
    
    AddAccountent()
    {
       super("Accountant Section");
       setLocation(100,100);
       setSize(600,400);
      
       l1=new JLabel("Add Accountant");
       l2=new JLabel("Name");
       l3=new JLabel("Password");
       l4=new JLabel("Email");
       l5=new JLabel("contact");
       l6=new JLabel("Address");
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.RED);
       
       bt1=new JButton("Add Accountant");
       bt2=new JButton("Back");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       
       tf1=new JTextField();
       tf2=new JTextField();
       tf3=new JTextField();
       tf4=new JTextField();
       pf=new JPasswordField();
          
       f=new Font("Arial",Font.BOLD,20);
       f1=new Font("Arial",Font.BOLD,15);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       bt1.setFont(f1);
       bt2.setFont(f1);
       tf1.setFont(f1);
       pf.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(6,2,10,10));
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(pf);
       p2.add(l4);
       p2.add(tf2);
       p2.add(l5);
       p2.add(tf3);
       p2.add(l6);
       p2.add(tf4);
       p2.add(bt1);
       p2.add(bt2);
       
       setLayout(new BorderLayout(0,0));
       
       add(p1,"North");
       add(p2,"Center");
          
    }
    public void actionPerformed(ActionEvent e)
    {
        String nam=tf1.getText();
        String pass=pf.getText();
        String eml=tf2.getText();
        String cont=tf3.getText();
        String addr=tf4.getText();
        
        if(e.getSource()==bt1)
        {
            try
           {
              ConnectionClass obj=new ConnectionClass();
              String q="insert into accountant values(?,?,?,?,?)";
              PreparedStatement pst=obj.con.prepareStatement(q);
              pst.setString(1, nam);
              pst.setString(2, pass);
              pst.setString(3, eml);
              pst.setString(4, cont);
              pst.setString(5, addr);
              int i =pst.executeUpdate();
              if(i>0)
              {  
                 JOptionPane.showMessageDialog(this,"Insert successfully !");
                 this.setVisible(true);
              }
              else
              {
                 JOptionPane.showMessageDialog(null,"wrong input!");
                 this.setVisible(true);
              }
           }
           catch(Exception ee)
           {
              JOptionPane.showMessageDialog(null,"Something went wrong!");
              this.setVisible(true);
              //ee.printStackTrace();
           }
        }
        if(e.getSource()==bt2)
        {
           this.setVisible(false); 
           new AdminSection().setVisible(true);
        }
    }
    public static void main(String[] args)
   {
      new AddAccountent().setVisible(true);  
   }
}
