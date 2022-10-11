package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.coffeex.staffdao.StaffUpdateInfoDao;
import com.coffeex.util.CustomerInfo;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffUpdateInfo {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfStaffId;
	private JLabel lblNewLabel_2;
	private JPasswordField pfPw;
	private JLabel lblNewLabel_3;
	private JPasswordField pfPwC;
	private JLabel lblNewLabel_4;
	private JTextField tfStaffName;
	private JLabel lblNewLabel_5;
	private JTextField tfStaffPhone;
	private JButton btnUpdate;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffUpdateInfo window = new StaffUpdateInfo();
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
	public StaffUpdateInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("개인 정보 수정");
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfStaffId());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getPfPw());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getPfPwC());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfStaffName());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTfStaffPhone());
		frame.getContentPane().add(getBtnUpdate());
		frame.getContentPane().add(getLblNewLabel_6());
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

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("사번");
			lblNewLabel_1.setBounds(26, 96, 61, 16);
		}
		return lblNewLabel_1;
	}

	private JTextField getTfStaffId() {
		if (tfStaffId == null) {
			tfStaffId = new JTextField();
			tfStaffId.setBounds(26, 124, 130, 26);
			tfStaffId.setColumns(10);
		}
		return tfStaffId;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("비밀번호");
			lblNewLabel_2.setBounds(26, 162, 61, 16);
		}
		return lblNewLabel_2;
	}

	private JPasswordField getPfPw() {
		if (pfPw == null) {
			pfPw = new JPasswordField();
			pfPw.setBounds(26, 190, 130, 26);
		}
		return pfPw;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호 확인");
			lblNewLabel_3.setBounds(26, 228, 70, 16);
		}
		return lblNewLabel_3;
	}

	private JPasswordField getPfPwC() {
		if (pfPwC == null) {
			pfPwC = new JPasswordField();
			pfPwC.setBounds(26, 256, 130, 26);
		}
		return pfPwC;
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("이름");
			lblNewLabel_4.setBounds(26, 294, 61, 16);
		}
		return lblNewLabel_4;
	}

	private JTextField getTfStaffName() {
		if (tfStaffName == null) {
			tfStaffName = new JTextField();
			tfStaffName.setBounds(26, 322, 130, 26);
			tfStaffName.setColumns(10);
		}
		return tfStaffName;
	}

	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("휴대폰번호");
			lblNewLabel_5.setBounds(26, 360, 61, 16);
		}
		return lblNewLabel_5;
	}

	private JTextField getTfStaffPhone() {
		if (tfStaffPhone == null) {
			tfStaffPhone = new JTextField();
			tfStaffPhone.setBounds(26, 388, 130, 26);
			tfStaffPhone.setColumns(10);
		}
		return tfStaffPhone;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("수정하기");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UpdateInfo();
				}
			});
			btnUpdate.setBounds(33, 426, 117, 29);
		}
		return btnUpdate;
	}

	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("1232");
			lblNewLabel_6.setBounds(168, 261, 166, 16);
		}
		return lblNewLabel_6;
	}
	// -----------------------------------------

	private void UpdateInfo() {
		String password = "";
		for (int i = 0; i < pfPw.getPassword().length; i++) {
			password = password + pfPw.getPassword()[i];
		}
		StaffUpdateInfoDao dao = new StaffUpdateInfoDao(tfStaffName.getText(), password, tfStaffPhone.getText());
		boolean ok = dao.UpdateAction(CustomerInfo.userid);

		if (ok == true) {
			JOptionPane.showMessageDialog(null, "변경에 성공하였습니다");
		} else {
			JOptionPane.showMessageDialog(null, "변경에 실패하였습니다");
		}
	}

	public boolean pwCheck() {
		String pw = null;
		String pwC = null;
		for (int i = 0; i < pfPw.getPassword().length; i++) {
			pw += pfPw.getPassword()[i];
		}
		for (int i = 0; i < pfPwC.getPassword().length; i++) {
			pwC += pfPwC.getPassword()[i];
		}
		if (pw.equals(pwC)) {
			return true;
		} else {
			return false;
		}
	}

}
