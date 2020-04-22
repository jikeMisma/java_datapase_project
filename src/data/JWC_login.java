package data;
import javax.imageio.ImageIO;
import java.awt.Container;
import java.awt.FlowLayout; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

 class JWC_login extends JFrame  {
	// 定义组件
	
	JButton jwc = null;//登录
	JButton tea= null;//登录
	JButton stu=null;
	JLabel jLloging=null;
	JLabel jLloging1=null; 
	
	// 构造函数
	public JWC_login() {
		
		// 创建组件	
		jLloging = new JLabel("欢迎使用教务管理系统");
		jLloging.setForeground(Color.blue);
		jLloging.setFont(new   java.awt.Font("Dialog",   0,   25));
		jwc = new JButton("教务处登录");
		jwc.setFont(new   java.awt.Font("Dialog",   1,   16));
		jwc.setSize(80, 20);
		tea = new JButton("教师登录");
		tea.setFont(new   java.awt.Font("Dialog",   1,   16));
		stu = new JButton("学生登录");
		stu.setFont(new   java.awt.Font("Dialog",   1,   16));

		JPanel jP1, jP2,jP3,jP4=null;
		JPanel jPTop, jPBottom = null;
		
		// 设置监听
		
		//logings.addActionListener();teacher_login
		jwc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				getcon.setVisible(false);
		    
			}
		});
		
		tea.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					new teacher_login();
					getcon.setVisible(false);
					
		    
			}
		});
		stu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					new stu_login();
					getcon.setVisible(false);
			}
		});
		
		jP1 = new JPanel();
		jP2 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		
		jPTop = new JPanel();
		jPBottom = new JPanel();
		
		jP1.add(jLloging);
		jP2.add(jwc);
		jP2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP2.setPreferredSize(new Dimension(20,20));
	
		jP3.add(tea);
		jP3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP3.setPreferredSize(new Dimension(20,20));
		jP4.add(stu);
		jP4.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		jPTop.setLayout(new GridLayout(4, 1));
		jPTop.add(jP1);
		//jPTop.setOpaque(false);

		jPBottom.add(jP2);
		jPBottom.add(jP3);
		jPBottom.add(jP4);
		//jPBottom.setOpaque(false);
		jPTop.setLayout(new GridLayout(4, 1));
		//jPTop.add(jP4);
		
		this.add("North",jP1);
		this.add("Center",jP2);
		this.add("Center",jP3);
		this.add("Center",jP4);
		
		this.setLayout(new GridLayout(4, 2));
		this.setTitle("教务管理系统");
		this.setSize(370,270);
		this.setLocation(555, 225);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		//this.setComponentZOrder(jPBottom, 1);
		
		 /*
		ImageIcon img = new ImageIcon("E:\\eclipse_project\\databasedvp\\img\\cb.jpg");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	    Container contain = this.getContentPane();
		((JPanel) contain).setOpaque(false); 
		this.setComponentZOrder(contain, 0);
		*/
	}
	
	private void setBackground(ImageIcon background) {
		// TODO Auto-generated method stub
		
	}

	public static JWC_login getcon = null;
		public static void main(String[] args) {
		getcon = new  JWC_login();
		//JWC_login.setVisible(true);
		
	}

 }
	//@Override
	
	//-----------------------------------------------------------------------------------------
	

	