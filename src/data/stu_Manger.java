package data;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;
import java.awt.event.*;

public class stu_Manger extends JFrame implements TreeSelectionListener {
	JPanel jp;
	JSplitPane js;
	JScrollPane jsp;
	JTree tree;
	DefaultMutableTreeNode root, t1, t2, t1_1, t1_2, t1_3, t1_4, t1_5, t2_1,
			t2_2,t2_3;

	stu_CardEmploy ae;

	public static void main(String[] args) {
		stu_Manger stu_M = new stu_Manger();
	}

	public stu_Manger() {
		// 给树的各个结点赋值
		root = new DefaultMutableTreeNode("教务管理系统——学生");

		t1 = new DefaultMutableTreeNode("个人信息管理");
		t1_1 = new DefaultMutableTreeNode("学生信息表");
		t1_2 = new DefaultMutableTreeNode("学生成绩表");
		//t1_3 = new DefaultMutableTreeNode("学生选课表");
		//t1_4 = new DefaultMutableTreeNode("删除员工资料");
		//t1_5 = new DefaultMutableTreeNode("查询全体员工");

		t2 = new DefaultMutableTreeNode("课程信息管理");
		t2_1 = new DefaultMutableTreeNode("查看课程");
		t2_2 = new DefaultMutableTreeNode("学生选课");
		t2_3 = new DefaultMutableTreeNode("查看已选课程");
		

		t1.add(t1_1);
		t1.add(t1_2);
		//t1.add(t1_3);
		//t1.add(t1_4);
		//t1.add(t1_5);

		t2.add(t2_1);
		t2.add(t2_2);

		root.add(t1);
		root.add(t2);

		tree = new JTree(root);
		// 对树进行监听

		tree.addTreeSelectionListener(this);

		// 实例化CardEmploy面板 并加到jsplitpane的边
		ae = new stu_CardEmploy();

		js = new JSplitPane();
		js.setLeftComponent(tree);
		js.setRightComponent(ae);

		this.getContentPane().add(js);
		this.setTitle("教务管理———学生");
		this.setVisible(true);
		this.setSize(850, 580);
		this.setResizable(false);
		this.setLocation(150, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void valueChanged(TreeSelectionEvent e) {

		// 获取点击结点名称
		DefaultMutableTreeNode dpath = (DefaultMutableTreeNode) tree
				.getLastSelectedPathComponent();

		// 通过点击不同结点切换不同界面
		if (dpath.equals(t1_1)) {
			ae.c.show(ae, "1");
		} else if (dpath.equals(t1_2)) {
			ae.c.show(ae, "2");
		} else if (dpath.equals(t2_1)) {
			ae.c.show(ae, "3");
		} else if (dpath.equals(t2_2)) {
			ae.c.show(ae, "4");
		}
	}

}