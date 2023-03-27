package com.travel.BusinessView;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.travel.service.impl.IBusinessServiceImpl;
import com.travel.utils.CheckByPattern;

public class UpdatePhone extends JFrame {

	private JTextField newName;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePhone frame = new UpdatePhone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdatePhone() {
		setTitle("用户修改电话号码界面");
		setBounds(100, 100, 493, 388);
		getContentPane().setLayout(null);
		
		newName = new JTextField();
		newName.setFont(new Font("宋体", Font.PLAIN, 22));
		newName.setBounds(220, 114, 188, 26);
		getContentPane().add(newName);
		newName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("新电话号码");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(78, 114, 121, 26);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IBusinessServiceImpl iBusinessService = new IBusinessServiceImpl();
		        try {
					if(CheckByPattern.checkPhoneNum(newName.getText())){
						boolean b = iBusinessService.updateBusiness("business_phonenum", Login.business_table.getBusiness_id(),newName.getText());
						if (b){
							System.out.println("修改用户电话号码成功");
							Login.business_table.setBusiness_pwd(newName.getText());
							JOptionPane.showMessageDialog(null,"修改用户电话号码成功");
							Login view = new Login();
							view.setVisible(true);
							dispose();
						}else {
							System.out.println("修改用户电话号码失败");
							JOptionPane.showMessageDialog(null,"修改用户电话号码失败");
						}
					}else {
						System.out.println("修改用户电话号码失败");
						JOptionPane.showMessageDialog(null,"手机号格式错误");
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(161, 194, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessMainPage view = new BusinessMainPage();
				view.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 10, 97, 23);
		getContentPane().add(btnNewButton_1);
	}

}
