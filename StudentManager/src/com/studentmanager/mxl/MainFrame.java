package com.studentmanager.mxl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class MainFrame extends Frame implements ActionListener {
	
	/*整个界面是BorderLayout的布局，
	左边（上方）放置工具栏和搜索的相关控件，
	南边（下方）放置操作按钮*/
	
	//各个面板
	private Panel pNorth,pNorthTop,pNorthBottom,pSouth;
	//菜单栏的相关控件
	private MenuBar menuBar;
	private Menu menu1,menu2;
	private MenuItem mItem1, mItem2, mItem3;
	//工具栏相关控件
	
	//查询组件
	private Label queryLabel;
	private TextField queryTextField;
	private Button queryButton;
	
	//构建菜单组件方法
	//构建工具栏组件方法
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("学生信息管理系统");
		this.setSize(900, 600);
		
		//初始化各个面板
		pNorth = new Panel();
		pNorth.setLayout(new BorderLayout());
		pNorthTop = new Panel();
		pNorthBottom = new Panel();
		pSouth = new Panel();
		//菜单栏(调用函数)
		
		
		//上层面板的下部查询组件
		queryLabel = new Label("摄入姓名");
		queryTextField = new TextField(10);
		queryButton = new Button("查询");
		
		pNorthBottom.add(queryLabel);
		pNorthBottom.add(queryTextField);
		pNorthBottom.add(queryButton);
		
		pNorth.add(pNorthBottom,BorderLayout.SOUTH);
		this.add(pNorth,BorderLayout.NORTH);
		
		
		pNorth.add(pNorthTop,BorderLayout.NORTH);
		
		
		this.add(pSouth,BorderLayout.SOUTH);
		
		
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
	public static void main(String[]args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
