package FeeReportManage;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AccountantSection extends JFrame implements ActionListener
{
    JLabel l1;
    JButton bt1,bt2,bt3,bt4,bt5,bt6;
    JPanel p1;
    Font f,f1; 
    
    AccountantSection()
    {
       super("Accountant Section");
       setLocation(100,100);
       setSize(500,400);
       
       l1=new JLabel("Accountant Section");
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.RED);
       
       bt1=new JButton("Add Student");
       bt2=new JButton("View Student");
       bt3=new JButton("Edit Student");
       bt4=new JButton("Due Fee");
       bt5=new JButton("Logout");
       bt6=new JButton("Back");
       
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       bt3.addActionListener(this);
       bt4.addActionListener(this);
       bt5.addActionListener(this);
       bt6.addActionListener(this);
       
       f=new Font("Arial",Font.BOLD,20);
       f1=new Font("Arial",Font.BOLD,15);
       
       l1.setFont(f);
       bt1.setFont(f1);
       bt2.setFont(f1);
       bt3.setFont(f1);
       bt4.setFont(f1);
       bt5.setFont(f1);
       bt6.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(7,1,10,10));
       p1.add(l1);
       p1.add(bt1);
       p1.add(bt2);
       p1.add(bt3);
       p1.add(bt4);
       p1.add(bt5);
       p1.add(bt6);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource()==bt1)
       {
           new AddStudent().setVisible(true);
           this.setVisible(false);
       }
       if(e.getSource()==bt2)
       {
           new ViewStudent().setVisible(true);
           this.setVisible(false);
       }
       if(e.getSource()==bt3)
       {
           new EditStudent().setVisible(true);
           this.setVisible(false);
       }
       if(e.getSource()==bt4)
       {
           new DueFee().setVisible(true);
           this.setVisible(false);
       }
       if(e.getSource()==bt5)
       {
           this.setVisible(false);
           new Index().setVisible(true);
       }
       if(e.getSource()==bt6)
       {
           new Accountant().setVisible(true);
           this.setVisible(false);
       }
    }
     public static void main(String[] args)
    {
       new AccountantSection().setVisible(true);  
    }
}
