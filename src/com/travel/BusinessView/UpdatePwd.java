package com.travel.BusinessView;

import com.travel.domain.Business_table;
import com.travel.service.impl.IBusinessServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePwd extends JFrame {
	

	private JTextField newPwd;

	private JPanel contentPane;
	private JTextField oldPwd;
	private JTextField reNewPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePwd frame = new UpdatePwd(Login.getBusiness());
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
	public UpdatePwd(Business_table user) {
		setTitle("用户修改密码界面");
		setBounds(100, 100, 493, 388);
		getContentPane().setLayout(null);
		
		newPwd = new JTextField();
		newPwd.setFont(new Font("宋体", Font.PLAIN, 22));
		newPwd.setBounds(202, 114, 188, 26);
		getContentPane().add(newPwd);
		newPwd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("新密码");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(96, 114, 101, 26);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 22));
		btnNewButton.setBounds(166, 244, 97, 23);
		getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusinessMainPage businessMainPage = new BusinessMainPage();
				businessMainPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 10, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("旧密码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(96, 71, 101, 26);
		getContentPane().add(lblNewLabel_1);
		
		oldPwd = new JTextField();
		oldPwd.setToolTipText("");
		oldPwd.setFont(new Font("宋体", Font.PLAIN, 22));
		oldPwd.setColumns(10);
		oldPwd.setBounds(202, 71, 188, 26);
		getContentPane().add(oldPwd);
		
		JLabel lblNewLabel_2 = new JLabel("确认密码");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(96, 158, 101, 26);
		getContentPane().add(lblNewLabel_2);
		
		reNewPwd = new JTextField();
		reNewPwd.setFont(new Font("宋体", Font.PLAIN, 22));
		reNewPwd.setColumns(10);
		reNewPwd.setBounds(202, 158, 188, 26);
		getContentPane().add(reNewPwd);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IBusinessServiceImpl businessService = new IBusinessServiceImpl();
				try {
					boolean t;
					if ((t=businessService.getPwd(oldPwd.getText()).equals(user.getBusiness_pwd())) && newPwd.getText().equals(reNewPwd.getText())){
						boolean b = businessService.updateBusiness("business_pwd", Login.getBusiness().getBusiness_id(), newPwd.getText());
						if (b){
							user.setBusiness_pwd(newPwd.getText());
							JOptionPane.showMessageDialog(null,"修改密码成功");
							Login login = new Login();
							login.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"修改密码失败");
						}
					}else {
						JOptionPane.showMessageDialog(null,t?"两次密码输入不一致":"旧密码错误！");
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
	}
}
