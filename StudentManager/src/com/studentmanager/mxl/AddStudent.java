package com.studentmanager.mxl;

import java.awt.*;		//将java.awt下所有的类或接口导入到该类中
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 类AddStudent，学生信息添加界面
 * @author MiracleWong
 *
 */
public class AddStudent extends Dialog implements ActionListener  {
	
	//定义添加对话框的各个组件
	private Panel panel1, panel2, panel3;
	private Label label1, label2, label3, label4, label5, label6;
	private TextField tField1,tField2,tField3,tField4,tField5,tField6;
	private Button button1, button2;
	
	//Frame为父窗口，也就是对话框所处的父窗口，title为标题
	//modal是否为模式的，如果是模式的，则必须关闭相应的对话框，否则无法操作父窗口	
	public AddStudent(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		
		this.setSize(300, 400);
		//第一个面板为GridLayout，添加各个标签
		panel1 = new Panel();			//创建面板1
		panel1.setLayout(new GridLayout(6,1));
		label1 = new Label("学号");
		label2 = new Label("姓名");
		label3 = new Label("性别");
		label4 = new Label("年龄");
		label5 = new Label("部门");
		label6 = new Label("地址");
		//将6个标签组件放置于面板1的容器中
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		//将面板1容器组件放置于窗口的左边
		this.add(panel1, BorderLayout.WEST);
		
		//第二个面板为GridLayout，添加各个标签
		panel2 = new Panel();		//创建面板2
		panel2.setLayout(new GridLayout(6,1));
		tField1 = new TextField();
		tField2 = new TextField();
		tField3 = new TextField();
		tField4 = new TextField();
		tField5 = new TextField();
		tField6 = new TextField();
		//将6个文本框组件放置于面板2的容器中
		panel2.add(tField1);
		panel2.add(tField2);
		panel2.add(tField3);
		panel2.add(tField4);
		panel2.add(tField5);
		panel2.add(tField6);
		//将面板2容器组件放置于窗口的中间
		this.add(panel2, BorderLayout.CENTER);
		
		//第三个面板，添加两个按钮
		panel3 = new Panel();
		button1 = new Button("确定");
		button2 = new Button("取消");
		button1.addActionListener(this);
		button2.addActionListener(this);
		panel3.add(button1);
		panel3.add(button2);
		//将面板3容器组件放置于窗口的底部
		this.add(panel3, BorderLayout.SOUTH);
		
		//整个学生信息添加对话框的属性设置
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		//设置对话框的弹出位置，在屏幕居中显示
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		//添加监听器
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
			public void windowClosing(WindowEvent frame) {
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
		//显示对话框
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//如果按下的是确定按钮，执行插入SQL的语句
		if (e.getSource() == button1) {
			StudentBiz model = new StudentBiz();		//实例化业务处理类
			String sql = "insert into tb_student values(?,?,?,?,?,?)";
			String[] params = new String[] {tField1.getText().trim(),
					tField2.getText().trim(),tField3.getText().trim(),
					tField4.getText().trim(),tField5.getText().trim(),
					tField6.getText().trim()};
			model.updateStu(sql, params);
			this.dispose();
		} else if (e.getSource() ==button2) {
			this.dispose();
		}
	}
	
}
