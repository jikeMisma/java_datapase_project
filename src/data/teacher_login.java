package data;
//教师登录
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

class teacher_login extends JFrame implements ActionListener  {
	// 定义组件
	String  stu_num="刘";
	String stu_pwd="123";
	JLabel jLuser = null;//用户
	JLabel jLpossword = null;//密码	
	JLabel jLloging=null;
	
	JTextField jTFuser = null;//姓名
	JTextField jTFpossword = null;//性别
	
	JButton logings = null;//登录
	JButton register = null;//登录
	public  void clear()  
  {  
		jTFuser.setText("");  
		jTFpossword.setText("");  
  }
	
	// 构造函数
	public teacher_login() {
		// 创建组件	
		jLloging = new JLabel("教师用户登录");
		jLloging.setForeground(Color.blue);
		jLloging.setFont(new   java.awt.Font("Dialog",   0,   25));
		
		jLuser = new JLabel("用户:");
		jLpossword= new JLabel("密码:");
		jLuser.setFont(new   java.awt.Font("Dialog",   0,   19));
		jLpossword.setFont(new   java.awt.Font("Dialog",   0,   19));
		
		jTFuser = new JTextField(10);//查询字段
		jTFpossword = new JTextField(10);//学号
		jTFuser.setFont(new   java.awt.Font("Dialog",   0,   19));
		jTFpossword.setFont(new   java.awt.Font("Dialog",   0,   19));
		
		logings = new JButton("登录");
		logings.setFont(new   java.awt.Font("Dialog",   1,   16));
		register = new JButton("注册");
		register.setFont(new   java.awt.Font("Dialog",   1,   16));

		JPanel jP1, jP2,jP3,jP4=null;
		JPanel jPTop, jPBottom = null;
		
		// 设置监听
		logings.addActionListener(this);
		jP1 = new JPanel();
		jP2 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		
		jPTop = new JPanel();
		jPBottom = new JPanel();
		
		jP1.add(jLloging);
		
		jP2.add(jLuser);
		jP2.add(jTFuser);
		jP2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP2.setPreferredSize(new Dimension(20,20));
		
		jP3.add(jLpossword);
		jP3.add(jTFpossword);
		jP3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP3.setPreferredSize(new Dimension(20,20));
		
		jP4.add(logings);
		jP4.add(register);
	
		jP4.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		
		jPTop.setLayout(new GridLayout(4, 1));
		jPTop.add(jP1);
		
		jPTop.add(jP2);
		jPTop.add(jP3);
		//jPBottom.add(jP2);
		//jPBottom.add(jP3);
		jPTop.add(jP4);
		
		this.add("North",jP1);
		this.add("Center",jP2);
		this.add("Center",jP3);
		this.add("Center",jP4);
		
		/*
		BufferedImage img=null;
		try {
			img=ImageIO.read(new File("./img/bg.gif"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		JLabel labl=new JLabel(new ImageIcon(img));
		getContentPane().add(labl);
		labl.setBounds(0, 0, img.getWidth(), img.getHeight());
      */
		this.setLayout(new GridLayout(4, 1));
		this.setTitle("教务处登录");
		this.setSize(370,270);
		this.setLocation(555, 225);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//dbProcess = new DbProcess();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(stu_num.equals(jTFuser.getText())&&stu_pwd.equals(jTFpossword.getText()))  
		        {   
					new tea_Manger();
					this.setVisible(false);;
		            
		              //创建新界面  
		        }else if(jTFuser.getText().isEmpty()&&jTFpossword.getText().isEmpty())  
		        {  
		            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
		        }else if(jTFuser.getText().isEmpty())  
		        {  
		            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
		        }else if(jTFuser.getText().isEmpty())  
		        {  
		            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
		        }else  
		        {  
		            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
		            //清空输入框  
		            clear();  
		        } 
				
	}
}



	//@Override
	
	//-----------------------------------------------------------------------------------------
	

	
