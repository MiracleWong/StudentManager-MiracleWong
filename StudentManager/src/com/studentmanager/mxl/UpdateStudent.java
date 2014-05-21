package com.studentmanager.mxl;

import java.awt.*;		//��java.awt�����е����ӿڵ��뵽������
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * ��UpdateStudent��ѧ����Ϣ�޸Ľ���
 * ��6����ǩ�����6�������ı��������2����ť
 * @author Miracle_Wong
 *
 */
public class UpdateStudent extends Dialog implements ActionListener  {
	
	//�������ӶԻ���ĸ������
	private Panel panel1, panel2, panel3;
	private Label label1, label2, label3, label4, label5, label6;
	private TextField tField1,tField2,tField3,tField4,tField5,tField6;
	private Button button1, button2;
	
	/**
	 * ����UpdateStudent�Ĺ��캯��������ѧ����Ϣ�޸�ҳ�档�ù��캯��������5������
	 * @param owner����Frame������
	 * @param title�����Ի���������
	 * @param modal�����Ƿ�Ϊģʽ�Ĳ���
	 * @param model����ҵ������Ķ������
	 * @param rowNum����������ѡ���еĲ���
	 */
	//ע��������췽���������rowNum���������ѡ�����У��Է����ȡ����
	//�ǵ�������һ������StudentBiz model
	public UpdateStudent(Frame owner, String title, boolean modal, int rowNum) {
		super(owner, title, modal);
		// TODO Auto-generated constructor stub
		
		this.setSize(300, 400);
		//��һ�����ΪGridLayout�����Ӹ�����ǩ
		panel1 = new Panel();			//�������1
		panel1.setLayout(new GridLayout(6,1));
		label1 = new Label("ѧ��");
		label2 = new Label("����");
		label3 = new Label("�Ա�");
		label4 = new Label("����");
		label5 = new Label("����");
		label6 = new Label("��ַ");
		//��6����ǩ������������1��������
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(label3);
		panel1.add(label4);
		panel1.add(label5);
		panel1.add(label6);
		//�����1������������ڴ��ڵ����
		this.add(panel1, BorderLayout.WEST);
		
		//�ڶ������ΪGridLayout�����Ӹ�����ǩ
		panel2 = new Panel();		//�������2
		panel2.setLayout(new GridLayout(6,1));
		//���µ�������Ҫ����ҵ�������л�ȡ����
		tField1 = new TextField();
		tField2 = new TextField();
		tField3 = new TextField();
		tField4 = new TextField();
		tField5 = new TextField();
		tField6 = new TextField();
		//��6���ı���������������2��������
		panel2.add(tField1);
		panel2.add(tField2);
		panel2.add(tField3);
		panel2.add(tField4);
		panel2.add(tField5);
		panel2.add(tField6);
		//�����2������������ڴ��ڵ��м�
		this.add(panel2, BorderLayout.CENTER);
		
		//��������壬����������ť
		panel3 = new Panel();
		button1 = new Button("ȷ���޸�");
		button2 = new Button("ȡ��");
		button1.addActionListener(this);
		button2.addActionListener(this);
		panel3.add(button1);
		panel3.add(button2);
		//�����3������������ڴ��ڵĵײ�
		this.add(panel3, BorderLayout.SOUTH);
		
		//����ѧ����Ϣ���ӶԻ������������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		//���öԻ���ĵ���λ�ã�����Ļ������ʾ
		this.setLocation((screenSize.width - this.getWidth()) / 2,
				(screenSize.height - this.getHeight()) / 2);
		
		//���Ӽ�����
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			this.dispose();
		} else if (e.getSource() ==button2) {
			this.dispose();
		}
	}
	
}