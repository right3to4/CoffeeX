package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ManagerAddStaff {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JButton btnSearchStaff;
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JLabel lblNewLabel_3_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_3_2;
	private JPasswordField passwordField_1;
	private JLabel lbConfirm;
	private JLabel lblNewLabel_3_3;
	private JTextField textField_2;
	private JButton btnTfReset;
	private JButton btnDelete;
	private JButton btnInsert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerAddStaff window = new ManagerAddStaff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagerAddStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("사원등록/삭제");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnSearchStaff());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getLblNewLabel_3_1());
		frame.getContentPane().add(getPasswordField());
		frame.getContentPane().add(getLblNewLabel_3_2());
		frame.getContentPane().add(getPasswordField_1());
		frame.getContentPane().add(getLbConfirm());
		frame.getContentPane().add(getLblNewLabel_3_3());
		frame.getContentPane().add(getTextField_2());
		frame.getContentPane().add(getBtnTfReset());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnInsert());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("  CoffeeX");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lblNewLabel.setBackground(new Color(148, 128, 96));
			lblNewLabel.setBounds(0, 0, 600, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("사원검색");
			lblNewLabel_2.setBounds(56, 84, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnSearchStaff() {
		if (btnSearchStaff == null) {
			btnSearchStaff = new JButton("검색");
			btnSearchStaff.setBounds(198, 101, 117, 29);
		}
		return btnSearchStaff;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(56, 101, 130, 26);
		}
		return textField;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("사번");
			lblNewLabel_3.setBounds(56, 152, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(56, 167, 130, 26);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("비밀번호");
			lblNewLabel_3_1.setBounds(56, 205, 61, 16);
		}
		return lblNewLabel_3_1;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(56, 220, 130, 26);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_3_2() {
		if (lblNewLabel_3_2 == null) {
			lblNewLabel_3_2 = new JLabel("비밀번호 확인");
			lblNewLabel_3_2.setBounds(56, 258, 81, 16);
		}
		return lblNewLabel_3_2;
	}
	private JPasswordField getPasswordField_1() {
		if (passwordField_1 == null) {
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(56, 273, 130, 26);
		}
		return passwordField_1;
	}
	private JLabel getLbConfirm() {
		if (lbConfirm == null) {
			lbConfirm = new JLabel("비밀번호 틀림");
			lbConfirm.setForeground(Color.RED);
			lbConfirm.setBounds(198, 278, 158, 16);
		}
		return lbConfirm;
	}
	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("이름");
			lblNewLabel_3_3.setBounds(56, 311, 61, 16);
		}
		return lblNewLabel_3_3;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(56, 326, 130, 26);
		}
		return textField_2;
	}
	private JButton getBtnTfReset() {
		if (btnTfReset == null) {
			btnTfReset = new JButton("초기화");
			btnTfReset.setBounds(56, 364, 117, 29);
		}
		return btnTfReset;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.setBounds(305, 399, 117, 29);
		}
		return btnDelete;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("등록하기");
			btnInsert.setBounds(176, 399, 117, 29);
		}
		return btnInsert;
	}
}
