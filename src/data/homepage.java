package data;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class homepage extends JFrame implements ActionListener{
	Panel cardPanle=new Panel();
	Panel controlpaPanlel=new Panel();
	Button button1,button2;
	CardLayout cardLayout=new CardLayout();
	public homepage() {
		setSize(800,600);
		setVisible(true);
		this.setLocation(280, 80);
		//添加关闭时事件监听器
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				homepage.this.dispose();
			}
		});
		cardPanle.setLayout(cardLayout);
		//cardPanle.add(new Label("第一个界面"));
		//cardPanle.add(new Label("第一个界面"));
		//cardPanle.add();
		
		//按钮对象
		button1=new Button("学生信息");
		button1.setBounds(20, 20, 30, 30);
		button2=new Button("成绩");
		
		//按钮注册监听
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		//将按钮添加到controlpaPanlel容器中
		controlpaPanlel.add(button1);
		controlpaPanlel.add(button2);
		
		//将cardpanle放置在窗口布局中间，默认边界布局
		this.add(cardPanle,BorderLayout.CENTER);
		this.add(controlpaPanlel,BorderLayout.WEST);
	}
	//按钮的监听并触发
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)
		{
			cardLayout.show(new DatabaseCourseDesign(), "学生信息");
		}
		
		if(e.getSource()==button2)
		{
			cardLayout.last(cardPanle);
		}
	}
	public static void main(String args[]) {
		homepage s1=new homepage();
	}
	
}
