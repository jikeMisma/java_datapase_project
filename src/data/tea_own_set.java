package data;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class tea_own_set extends Panel implements ActionListener {
	// 定义组件
	JLabel jLStudentInfoTable = null;//学生信息表
	JLabel jLSelectQueryField = null;//选择查询字段
	JLabel jLEqual = null;//=
	JLabel jLteacher = null;//学号
	JLabel jLScourse = null;//姓名
	JLabel jLjidian = null;//班级
	JLabel jLclassroom = null;//班级
	JLabel jLwe_day = null;//班级
	JLabel jLclasnumer = null;//班级
	JLabel jLjiaoshi = null;//班级

	JTextField jTteacher = null;//查询字段
	JTextField jTScourse = null;//学号
	JTextField jTjidian = null;//姓名
	JTextField jTclassroom = null;//班级
	JTextField jTwe_day = null;//班级
	JTextField jTclasnumer = null;//班级
	JTextField jTFQueryField=null;
	
	//定义界面上的button
	JButton jBQuery = null;//查询
	JButton jBQueryAll = null;//查询所有记录
	JButton jBInsert = null;//插入
	JButton jBUpdate = null;//更新
	JButton jBDeleteCurrentRecord = null;//删除当前记录
	JButton jBDeleteAllRecords = null;//删除所有记录
	
	//JComboBox jCBSelectQueryField = null;
	//下拉框
	JComboBox<String> jCBSelectQueryField = null;//查询字段
	JPanel jP1, jP2,jP3,jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;
	Vector titleVector = null;
	
	private static DbProcess dbProcess;
	String SelectQueryFieldStr = "学号";
	
	// 构造函数
	public tea_own_set() {
		// 创建组件	
		jLStudentInfoTable = new JLabel("教师个人课程设置表");
		jLSelectQueryField = new JLabel("选择查询字段");
		jLEqual = new JLabel(" = ");
		jLteacher = new JLabel("教师：刘	  ");
		jLScourse = new JLabel("课程名");
		jLjidian = new JLabel("学分绩点");
		jLclassroom = new JLabel("上课教室");
		jLwe_day = new JLabel("上课周次");
		jLclasnumer = new JLabel("节次");
		jLjiaoshi = new JLabel("刘");
		
		
		jTteacher = new JTextField(10);//查询字段
		jTScourse = new JTextField(10);//学号
		jTjidian = new JTextField(10);//姓名
		jTclassroom = new JTextField(10);//性别
		jTwe_day = new JTextField(10);//性别
		jTclasnumer = new JTextField(10);//性别
		jTFQueryField=new JTextField(10);
		
		jBQuery = new JButton("查询");
		jBQueryAll = new JButton("查询所有记录");
		jBInsert = new JButton("插入");
		jBUpdate = new JButton("更新");
		jBDeleteCurrentRecord = new JButton("删除当前记录");
		jBDeleteAllRecords = new JButton("删除所有记录");
		// 设置监听
		jBQuery.addActionListener(this);
		jBQueryAll.addActionListener(this);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		jBDeleteAllRecords.addActionListener(this);
		
		jCBSelectQueryField = new JComboBox<String>();//查询字段
		jCBSelectQueryField.addItem("教师");  
		jCBSelectQueryField.addItem("课程名");  
		jCBSelectQueryField.addItem("学分绩点");
		jCBSelectQueryField.addItem("上课教室");
		jCBSelectQueryField.addItem("上课周次");
		jCBSelectQueryField.addItem("节次");
		jCBSelectQueryField.addItemListener(new ItemListener() {//下拉框事件监听  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr = (String) event.getItem();  
                    System.out.println("选中：" + SelectQueryFieldStr);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("取消选中：" + event.getItem());  
                    break;  
                }  
            }  
        });
	
		studentVector = new Vector();
		titleVector = new Vector();
		
		// 定义表头
		titleVector.add("教师");
		titleVector.add("课程名");
		titleVector.add("学分绩点");
		titleVector.add("上课教室");
		titleVector.add("上课周次");
		titleVector.add("节次");
		//studentTableModel = new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(600,200));
		studentJScrollPane = new JScrollPane(studentJTable);
		//分别设置水平和垂直滚动条自动出现
		studentJScrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//为表格添加监听器 
		studentJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);

				jTteacher.setText((String) v.get(0));// 学号
				jTScourse.setText((String) v.get(1));
				jTjidian.setText((String) v.get(2));// 姓名
				jTclassroom.setText((String) v.get(3));// 班级
				jTwe_day.setText((String) v.get(4));
				jTclasnumer.setText((String) v.get(5));
				
			}
		});


		jP1 = new JPanel();
		jP2 = new JPanel();
		jP5 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		jP5 = new JPanel();
		jP6 = new JPanel();
		
		jPTop = new JPanel();
		jPBottom = new JPanel();
		
		jP1.add(jLStudentInfoTable,BorderLayout.SOUTH);
		jP2.add(studentJScrollPane);
		
		
		//jP3.add(jLSelectQueryField);    //选择查询字段
		//jP3.add(jCBSelectQueryField);   //查询字段
		//jP3.add(jLEqual);  //=
		//jP3.add(jTFQueryField);	
		
		jP3.add(jBQueryAll);
		jP3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP3.setPreferredSize(new Dimension(20,20));
		
		
		jP4.add(jLteacher);
		//jP4.add(jTteacher);
		jP4.add(jLScourse);
		jP4.add(jTScourse);
		jP4.add(jLjidian);
		jP4.add(jTjidian);
		jP4.add(jBQuery);
		jP4.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP4.setPreferredSize(new Dimension(30,30));
		jP5.add(jLclassroom);
		jP5.add(jTclassroom);
		jP5.add(jLwe_day);
		jP5.add(jTwe_day);
		jP5.add(jLclasnumer);
		jP5.add(jTclasnumer);
		jP5.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP5.setPreferredSize(new Dimension(20,20));
		
		
		jP6.add(jBInsert);
		jP6.add(jBUpdate);
		jP6.add(jBDeleteCurrentRecord);
		jP6.add(jBDeleteAllRecords);
		jP6.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP6.setPreferredSize(new Dimension(20,20));
		
		jPTop.add(jP1);
		jPTop.add(jP2);
		
		jPBottom.setLayout(new GridLayout(4, 1));
		jPBottom.add(jP3);
		jPBottom.add(jP4);
		jPBottom.add(jP5);
		jPBottom.add(jP6);
		this.add("North", jPTop);
		this.add("South", jPBottom);
		
	
		
		this.setLayout(new GridLayout(2, 1));
		//this.setTitle("教室课程设置表");
		this.setSize(580, 500);
		this.setLocation(150, 150);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setResizable(false);
		
		
		dbProcess = new DbProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("查询")  
				&& !jTFQueryField.getText().isEmpty()){
				System.out.println("actionPerformed().查询");
				String sQueryField = jTFQueryField.getText().trim();
				queryProcess(sQueryField);
				jTFQueryField.setText("");
			}else if(e.getActionCommand().equals("查询所有记录")) {
				System.out.println("actionPerformed(). 查询所有记录");
				queryAllProcess();
			}else if(e.getActionCommand().equals("插入")
					&& !jTteacher.getText().isEmpty()
					&& !jTScourse.getText().isEmpty()
					&& !jTjidian.getText().isEmpty()
					&& !jTclassroom.getText().isEmpty()
					&& !jTwe_day.getText().isEmpty()
					&& !jTclasnumer.getText().isEmpty()){
				System.out.println("actionPerformed(). 插入");
				insertProcess();
			}else if(e.getActionCommand().equals("更新")
					&& !jTteacher.getText().isEmpty()
					&& !jTScourse.getText().isEmpty()
					&& !jTjidian.getText().isEmpty()
					&& !jTclassroom.getText().isEmpty()
					&& !jTwe_day.getText().isEmpty()
					&& !jTclasnumer.getText().isEmpty()){
				System.out.println("actionPerformed(). 更新");
				updateProcess();
			}else if(e.getActionCommand().equals("删除当前记录")){
				System.out.println("actionPerformed(). 删除当前记录");
				deleteCurrentRecordProcess();
			}else if(e.getActionCommand().equals("删除所有记录")){
				System.out.println("actionPerformed(). 删除所有记录");
				deleteAllRecordsProcess();
			}
		}
	
	
	/*
	public static void main(String[] args) {
		tea_own_set getcon = new  tea_own_set();
   }
   */
	
	public void queryProcess(String sQueryField)
	{
		try{
			// 建立查询条件
			String sql = "select * from teacher_set where ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
		
			if(queryFieldStr.equals("学分绩点")){//int sAge.
				sql = sql + queryFieldStr;
				sql = sql + " = " + sQueryField;
			}else{
				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";
			}
			
			System.out.println("queryProcess(). sql = " + sql);
	
			dbProcess.connect();
			ResultSet rs = dbProcess.executeQuery(sql);
	
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("教师"));
				v.add(rs.getString("课程名"));
				v.add(rs.getString("学分绩点"));
				v.add(rs.getString("上课教室"));
				v.add(rs.getString("上课周次"));
				v.add(rs.getString("节次"));
				studentVector.add(v);
			}
			
			studentJTable.updateUI();

			dbProcess.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void queryAllProcess()
	{
		try{
			// 建立查询条件
			String sql = "select * from teacher_set;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			dbProcess.connect();
			ResultSet rs = dbProcess.executeQuery(sql);

			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("教师"));
				v.add(rs.getString("课程名"));
				v.add(rs.getString("学分绩点"));
				v.add(rs.getString("上课教室"));
				v.add(rs.getString("上课周次"));
				v.add(rs.getString("节次"));
				studentVector.add(v);
			}
			
			studentJTable.updateUI();

			dbProcess.disconnect();
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insertProcess()
	{
		String teacher =jLjiaoshi.getText().trim();
		String souse = jTScourse.getText().trim();
		String jisian = jTjidian.getText().trim();
		String room = jTclassroom.getText().trim();
		String we_day = jTwe_day.getText().trim();
		String num = jTclasnumer.getText().trim();
		// 建立插入条件
		String sql = "insert into teacher_set values('";
		sql = sql + teacher + "','";
		sql = sql + souse + "','";
		sql = sql + jisian + "',";
		sql = sql + room + ",'";
		sql = sql + we_day + "','";
		sql = sql + num + "');";
		

		System.out.println("insertProcess(). sql = " + sql);
		try{
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("insertProcess(). insert database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void updateProcess()
	{
		String teacher = jTteacher.getText().trim();
		String souse = jTScourse.getText().trim();
		String jisian = jTjidian.getText().trim();
		String room = jTclassroom.getText().trim();
		String we_day = jTwe_day.getText().trim();
		String num = jTclasnumer.getText().trim();
		// 建立更新条件
	
		String sql = "update teacher_set values set 课程名 = '";
		sql = sql + souse + "', 学分绩点 = '";
		sql = sql + jisian + "', 上课教室= ";
		sql = sql + room + ", 上课周次= '";
		sql = sql + we_day + "', 节次 = '";
		sql = sql + num + "'";
		sql =sql +"WHERE 教师 ='"+teacher+"';";
		System.out.println("updateProcess(). sql = " + sql);
		try{
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("updateProcess(). update database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteCurrentRecordProcess()
	{
		String teacher = jTteacher.getText().trim();
		
		// 建立删除条件
		String sql = "delete from teacher_set where 教师 = '" + teacher + "';";
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		try{
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteAllRecordsProcess()
	{
		// 建立删除条件
		String sql = "delete from teacher_set;";
		System.out.println("deleteAllRecordsProcess(). sql = " + sql);
		try{
			if (dbProcess.executeUpdate(sql) < 1) {
				System.out.println("deleteAllRecordsProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
	
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("教师")){
			outputStr = "教师";
		}else if(InputStr.equals("课程名")){
			outputStr = "课程名";
		}else if(InputStr.equals("学分绩点")){
			outputStr = "学分绩点";
		}
		else if(InputStr.equals("上课教室")){
			outputStr = "上课教室";
		}
		else if(InputStr.equals("上课周次")){
			outputStr = "上课周次";
		}
		else if(InputStr.equals("节次")){
			outputStr = "节次";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}
