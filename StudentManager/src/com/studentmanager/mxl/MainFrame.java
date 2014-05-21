package com.studentmanager.mxl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
public class MainFrame extends Frame implements ActionListener {
	
	/*����������BorderLayout�Ĳ��֣�
	��ߣ��Ϸ������ù���������������ؿؼ���
	�ϱߣ��·������ò�����ť*/
	
	//�������
	private Panel pNorth,pNorthTop,pNorthBottom,pSouth;
	//�˵�������ؿؼ�
	private MenuBar menuBar;
	private Menu menu1,menu2;
	private MenuItem mItem1, mItem2, mItem3;
	//��������ؿؼ�
	private JToolBar jToolBar;
	private JButton jButton1,jButton2,jButton3,jButton4,jButton5,jButton6;
	//��ѯ���
	private Label queryLabel;
	private TextField queryTextField;
	private Button queryButton;
	//��ʾ�������
	private JScrollPane jScrollPane;
	
	private JTable jTableInfo;
	//��ײ��Ŀؼ�
	private Button addButton, updateButton, deleteButton;
	//�����˵����������
	public void buildMenu() {
		menuBar = new MenuBar();
		menu1 = new Menu("����");
		menu2 = new Menu("����");
		
		mItem1 = new MenuItem("���");
		mItem2 = new MenuItem("�޸�");
		mItem3 = new MenuItem("ɾ��");
		
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
	
	//�����������������
	public void buildToolBar() {
		jToolBar = new JToolBar();
		jToolBar.setLocation(0, 20);
		jButton1 = new JButton("���", new ImageIcon("images/127.gif"));
		jButton2 = new JButton("�޸�", new ImageIcon("images/061.gif"));
		jButton3 = new JButton("ɾ��", new ImageIcon("images/153.gif"));
		jButton4 = new JButton("�Ż�", new ImageIcon("images/267.gif"));
		jButton5 = new JButton("ʱ��", new ImageIcon("images/116.gif"));
		jButton6 = new JButton("����", new ImageIcon("images/199.gif"));
		//Ϊ������ť���������
		jButton1.addActionListener(this);
		jButton2.addActionListener(this);
		jButton3.addActionListener(this);
		jButton4.addActionListener(this);
		jButton5.addActionListener(this);
		jButton6.addActionListener(this);
		//����ť���뵽������jToolBar��
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
		this.setTitle("ѧ����Ϣ����ϵͳ");
		this.setSize(900, 600);
		/*setLocationRelativeTo(getOwner());	*/	//ʹ��Frame���ھ�����ʾ
		
		//��ʼ���������
		pNorth = new Panel();
		pNorth.setLayout(new BorderLayout());
		pNorthTop = new Panel();
		pNorthBottom = new Panel();
		pSouth = new Panel();
		//�˵���(���ú���)
		buildMenu();
		//������(���ú���)
		buildToolBar();
		pNorth.add(pNorthTop,BorderLayout.NORTH);
		
		//�ϲ������²���ѯ���
		queryLabel = new Label("��������");
		queryTextField = new TextField(20);
		queryButton = new Button("��ѯ");
		
		pNorthBottom.add(queryLabel);
		pNorthBottom.add(queryTextField);
		pNorthBottom.add(queryButton);
		
		pNorth.add(pNorthBottom,BorderLayout.SOUTH);
		this.add(pNorth,BorderLayout.NORTH);
		//�в��ı�����
		
		//�ײ������ӡ��޸ġ�ɾ���ؼ�������ӵ����
		addButton = new Button("���");
		updateButton = new Button("�޸�");
		deleteButton = new Button("ɾ��");
		addButton.addActionListener(this);
		updateButton.addActionListener(this);
		deleteButton.addActionListener(this);
		
		pSouth.add(addButton);
		pSouth.add(updateButton);
		pSouth.add(deleteButton);
				
		this.add(pSouth,BorderLayout.SOUTH);
		
		//����ҳ�����������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();		//��ȡ����ʾ���Ĵ�С����1280*1024
		//ʹ��Frame��������Ļ������ʾ
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
			public void windowClosing(WindowEvent frame) {	//������ע�������
				// TODO Auto-generated method stub
				frame.getWindow().setVisible(false);	//����Ϊ����
				((Frame)frame.getComponent()).dispose();//�ͷ���Դ
				System.exit(0);							//�˳�����
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
//		new MainFrame();
//		MainFrame mainFrame=null;
//		AddStudent addStudent = new AddStudent(mainFrame, "���ѧ��", true);
		
		MainFrame mainFrame=null;
		int row = 1;
		UpdateStudent updateStudent = new UpdateStudent(mainFrame, "�޸���Ϣ", true,row);
	}

}
