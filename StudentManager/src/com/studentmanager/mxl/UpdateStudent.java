package com.studentmanager.mxl;

import java.awt.*;		//将java.awt下所有的类或接口导入到该类中
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 类UpdateStudent，学生信息修改界面
 * 有6个标签组件、6个单行文本框组件和2个按钮
 * @author Miracle_Wong
 *
 */
public class UpdateStudent extends Dialog implements ActionListener  {
	
	//声明添加对话框的各个组件
	private Panel panel1, panel2, panel3;
	private Label label1, label2, label3, label4, label5, label6;
	private TextField tField1,tField2,tField3,tField4,tField5,tField6;
	private Button button1, button2;
	
	/**
	 * 创建UpdateStudent的构造函数，生成学生信息修改页面。该构造函数有以下5个参数
	 * @param owner——Frame对象函数
	 * @param title——对话框标题参数
	 * @param modal——是否为模式的参数
	 * @param model——业务处理类的对象参数
	 * @param rowNum——表格中选中行的参数
	 */
	//注意这个构造方法，最后又rowNum这个被表格选定的行，以方便获取数据
	//记得添上这一个参数StudentBiz model
	public UpdateStudent(Frame owner, String title, boolean modal, StudentBiz model, int rowNum) {
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
		
		//第二个面板放置文本框
		panel2 = new Panel();		//创建面板2
		panel2.setLayout(new GridLayout(6,1));
		/*从业务处理类中获取数据*/
		//调用业务类中的getValueAt()方法，获取指定行的第一列的值，即学号
		tField1 = new TextField((String)model.getValueAt(rowNum, 0));
		//设置学号的文本框处于不可编辑状态
		tField1.setEditable(false);
		tField2 = new TextField((String)model.getValueAt(rowNum, 1));
		tField3 = new TextField((String)model.getValueAt(rowNum, 2));
		tField4 = new TextField(model.getValueAt(rowNum, 3).toString());
		tField5 = new TextField((String)model.getValueAt(rowNum, 4));
		tField6 = new TextField((String)model.getValueAt(rowNum, 5));
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
		button1 = new Button("确认修改");
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
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//如果按下的是确认修改按钮
		if (e.getSource() == button1) {
			String sql = "update tb_student set stuName = ?, stuSex = ?, stuAge = ?,"
					+ "stuDept = ?,stuAddress = ? where stuId = ?";
			String[] params = new String[] {tField2.getText().trim(),
					tField3.getText().trim(),tField4.getText().trim(),
					tField5.getText().trim(),tField6.getText().trim(),
					tField1.getText().trim()};
			StudentBiz myModel = new StudentBiz();
			myModel.updateStu(sql, params);		//执行修改操作
			this.dispose();
		}
		//如果按下的是取消按钮
		else if (e.getSource() ==button2) {
			this.dispose();
		}
	}
	
}
