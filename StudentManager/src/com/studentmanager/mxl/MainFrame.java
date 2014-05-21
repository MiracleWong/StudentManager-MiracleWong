package com.studentmanager.mxl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
	
	//��ѯ���
	private Label queryLabel;
	private TextField queryTextField;
	private Button queryButton;
	
	//�����˵��������
	//�����������������
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("ѧ����Ϣ����ϵͳ");
		this.setSize(900, 600);
		
		//��ʼ���������
		pNorth = new Panel();
		pNorth.setLayout(new BorderLayout());
		pNorthTop = new Panel();
		pNorthBottom = new Panel();
		pSouth = new Panel();
		//�˵���(���ú���)
		
		
		//�ϲ������²���ѯ���
		queryLabel = new Label("��������");
		queryTextField = new TextField(10);
		queryButton = new Button("��ѯ");
		
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
		new MainFrame();
	}

}
