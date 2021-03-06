package com.studentmanager.mxl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
/**
 * 主函数
 * @author MiracleWong
 *
 */
public class MainFrame extends Frame implements ActionListener {
	
	/*整个界面是BorderLayout的布局，
	左边（上方）放置工具栏和搜索的相关控件，
	南边（下方）放置操作按钮*/
	
	//各个面板
	private Panel pNorth,pNorthTop,pNorthBottom,pSouth,pSouthTop,pSouthBottom;
	//菜单栏的相关控件
	private MenuBar menuBar;
	private Menu menu1,menu2;
	private MenuItem mItem1, mItem2, mItem3;
	//工具栏相关控件
	private JToolBar jToolBar;
	private JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6;
	//查询组件
	private Label queryLabel;
	private TextField queryTextField;
	private Button queryButton;
	//显示数据组件
	private JScrollPane jScrollPane;
	private StudentBiz model;
	private JTable jTableInfo;
	//最底部的控件
	private Button addButton, updateButton, deleteButton;
	//构建菜单栏组件方法
	public void buildMenu() {
		menuBar = new MenuBar();
		menu1 = new Menu("管理");
		menu2 = new Menu("帮助");
		
		mItem1 = new MenuItem("添加");
		mItem2 = new MenuItem("修改");
		mItem3 = new MenuItem("删除");
		
		mItem1.addActionListener(this);
		mItem2.addActionListener(this);
		mItem3.addActionListener(this);
		
		menu1.add(mItem1);
		menu1.add(mItem2);
		menu1.add(mItem3);
		
		menuBar.add(menu1);
		menuBar.add(menu2);
		this.setMenuBar(menuBar);
	}
	
	//构建工具栏组件方法
	public void buildToolBar() {
		jToolBar = new JToolBar();
		jToolBar.setLocation(0, 20);
		jButton1 = new JButton("添加", new ImageIcon("images/127.gif"));
		jButton2 = new JButton("修改", new ImageIcon("images/061.gif"));
		jButton3 = new JButton("删除", new ImageIcon("images/153.gif"));
		//下面是用来扩展的工具，只实现页面，没实现功能。
		jButton4 = new JButton("优惠", new ImageIcon("images/267.gif"));
		jButton5 = new JButton("时间", new ImageIcon("images/116.gif"));
		jButton6 = new JButton("信箱", new ImageIcon("images/199.gif"));
		//为六个按钮加入监听器
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jButton3.addActionListener(this);
		jButton4.addActionListener(this);
		jButton5.addActionListener(this);
		jButton6.addActionListener(this);
		//将按钮加入到工具栏jToolBar上
		jToolBar.add(jButton1);
		jToolBar.add(jButton2);
		jToolBar.add(jButton3);
		jToolBar.add(jButton4);
		jToolBar.add(jButton5);
		jToolBar.add(jButton6);
		
		pNorthTop.add(jToolBar);
	}
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("学生信息管理系统");
		this.setSize(900, 600);
		/*setLocationRelativeTo(getOwner());	*/	//使得Frame窗口居中显示
		
		//初始化各个面板
		pNorth = new Panel();
		pNorth.setLayout(new BorderLayout());
		pNorthTop = new Panel();
		pNorthBottom = new Panel();
		pSouth = new Panel();
		//菜单栏(调用函数)
		buildMenu();
		//工具栏(调用函数)
		buildToolBar();
		pNorth.add(pNorthTop,BorderLayout.NORTH);
		
		//上层面板的下部查询组件
		queryLabel = new Label("输入姓名");
		queryTextField = new TextField(20);
		queryButton = new Button("查询");
		
		//为queryButton加入监听器
		queryButton.addActionListener(this);
		
		pNorthBottom.add(queryLabel);
		pNorthBottom.add(queryTextField);
		pNorthBottom.add(queryButton);
		
		pNorth.add(pNorthBottom,BorderLayout.SOUTH);
		this.add(pNorth,BorderLayout.NORTH);
		//中部的表格组件
		model = new StudentBiz();
		String sql = "select * from tb_student where 0=?";
		String[] params = new String[] {"0"};
		model.queryStudent(sql, params);	//将查询到的数据放入表格模型
		jTableInfo = new JTable(model);		//将表格模型放入到表格中
		jTableInfo.setRowHeight(25);
		jScrollPane = new JScrollPane(jTableInfo);
		this.add(jScrollPane, BorderLayout.CENTER);
		
		
		

/*		SinPanel sinPanel = new SinPanel();
		this.add(sinPanel, BorderLayout.CENTER);*/
		
		
		//底部的增加、修改、删除控件，并添加到面板
		addButton = new Button("添加");
		updateButton = new Button("修改");
		deleteButton = new Button("删除");
		//添加监听器
		addButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		pSouth.add(addButton);
		pSouth.add(updateButton);
		pSouth.add(deleteButton);
				
		this.add(pSouth,BorderLayout.SOUTH);
		
		//整个页面的属性设置
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();		//获取主显示器的大小，如1280*1024
		//使得Frame窗口在屏幕居中显示
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			//
			public void windowClosing(WindowEvent frame) {	//给窗口注册监听器
				// TODO Auto-generated method stub
				frame.getWindow().setVisible(false);	//设置为隐藏
				((Frame)frame.getComponent()).dispose();//释放资源
				System.exit(0);							//退出程序
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//处理按钮事件
		if (e.getSource() == queryButton) {
			String jtfValue = queryTextField.getText().trim();
			//假如查询的时候输入的是空字符串，查询所有数据
			if (jtfValue.equals("")) {
				String sql = "select * from tb_student where 1=?";
				String[] params = new String[] {"1"};
				model = new StudentBiz();
				model.queryStudent(sql, params);
				jTableInfo.setModel(model);
			} else {
				//如果查询的时候输入了字符串
				String sql = "select * from tb_student where stuName=?";
				String[] params = new String[] {jtfValue};
				model = new StudentBiz();
				model.queryStudent(sql, params);
				jTableInfo.setModel(model);
			}
		}
		//处理添加按钮事件
		//单击的是菜单栏中的添加按钮或工具栏中的底部中的添加按钮
		else if (e.getSource() == addButton || e.getSource() == mItem1 || e.getSource() == jButton1 ) {
			AddStudent addStudent = new AddStudent(this, "添加学生", true);		//弹出对话框
			String sql = "select * from tb_student where 1=?";
			String[] params = new String[] {"1"};
			model = new StudentBiz();
			model.queryStudent(sql, params);
			jTableInfo.setModel(model);
		}
		//处理修改按钮事件
		else if (e.getSource() == updateButton || e.getSource() == mItem2 || e.getSource() == jButton2 ) {
			//获取选中的数据行
			int rowNum = this.jTableInfo.getSelectedRow();
			System.out.println(rowNum);
			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "请选择一行修改");
				return;
			} else {
				UpdateStudent updateStudent = new UpdateStudent(this, "修改学生信息", true, model,rowNum);
				model = new StudentBiz();
				String sql = "select * from tb_student where 1=?";
				String[] params = new String[] {"1"};
				model.queryStudent(sql, params);
				jTableInfo.setModel(model);
			}
		}
		//处理删除按钮事件
		else if (e.getSource() == deleteButton || e.getSource() == mItem3 || e.getSource() == jButton3 ) {
			//获取选中的数据行
			int rowNum = this.jTableInfo.getSelectedRow();
			System.out.println(rowNum);
			if (rowNum == -1) {
				JOptionPane.showMessageDialog(this, "请选择一行修改");
				return;
			} else {
				String sql = "delete from tb_student where stuId=?";
				String stuId =(String)this.jTableInfo.getValueAt(rowNum, 0);
				String[] params = new String[] {stuId};
				StudentBiz myModel = new StudentBiz();
				myModel.updateStu(sql, params);				//执行删除语句
				
				//重新获得新的数据模型
				model = new StudentBiz();
				String sql2 = "select * from tb_student where 1=?";
				String[] params2 = new String[] {"1"};
				model.queryStudent(sql2, params2);
				jTableInfo.setModel(model);
			}
		}
	}	
	
	public static void main(String[]args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
