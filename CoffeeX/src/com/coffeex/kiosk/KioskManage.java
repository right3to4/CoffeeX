package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.coffeex.kioskdao.KioskManagerDao;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

import javax.swing.JTextField;

public class KioskManage extends JPanel {
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel;
	private JButton btnNewButton_3;
	private JButton btnNewButton_3_1;
	private JButton btnNewButton_3_2;
	private JButton btnNewButton_3_3;
	private JButton btnNewButton_3_4;
	private JButton btnNewButton_3_5;
	private JButton btnNewButton_3_6;
	private JButton btnNewButton_3_7;
	private JButton btnNewButton_3_8;
	private JButton btnNewButton_3_9;
	private JButton btnNewButton_3_10;
	private JButton btnNewButton_3_11;
	public JPasswordField passwordField;
	private JLabel lblNewLabel;

	public static ArrayList<String> pw = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public KioskManage() {
		setLayout(null);
		add(getPanel());
		add(getBtnNewButton_1());
		add(getBtnNewButton_2());
		btnNewButton_1.setVisible(false);
		btnNewButton_2.setVisible(false);
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("로그아웃");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KioskInit.lblCancelbutton.setVisible(false);
					KioskInit.lblNewLabel.setVisible(true);
					panel.setVisible(true);
					setVisible(false);
					passwordField.setText(null);

					pw.removeAll(pw);
					
					
					
				}
			});
			btnNewButton_1.setBounds(130, 114, 114, 50);
		}
		return btnNewButton_1;
	}

	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("키오스크 종료");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnNewButton_2.setBounds(130, 174, 114, 50);
		}
		return btnNewButton_2;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(69, 68, 261, 306);
			panel.setLayout(null);
			panel.add(getBtnNewButton_3());
			panel.add(getBtnNewButton_3_1());
			panel.add(getBtnNewButton_3_2());
			panel.add(getBtnNewButton_3_3());
			panel.add(getBtnNewButton_3_4());
			panel.add(getBtnNewButton_3_5());
			panel.add(getBtnNewButton_3_6());
			panel.add(getBtnNewButton_3_7());
			panel.add(getBtnNewButton_3_8());
			panel.add(getBtnNewButton_3_9());
			panel.add(getBtnNewButton_3_10());
			panel.add(getBtnNewButton_3_11());
			panel.add(getPasswordField());
			panel.add(getLblNewLabel());
		}
		return panel;
	}

	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("1");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("1");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3.setBounds(44, 79, 46, 46);
		}
		return btnNewButton_3;
	}

	private JButton getBtnNewButton_3_1() {
		if (btnNewButton_3_1 == null) {
			btnNewButton_3_1 = new JButton("2");
			btnNewButton_3_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("2");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_1.setBounds(102, 79, 46, 46);
		}
		return btnNewButton_3_1;
	}

	private JButton getBtnNewButton_3_2() {
		if (btnNewButton_3_2 == null) {
			btnNewButton_3_2 = new JButton("3");
			btnNewButton_3_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("3");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_2.setBounds(160, 79, 46, 46);
		}
		return btnNewButton_3_2;
	}

	private JButton getBtnNewButton_3_3() {
		if (btnNewButton_3_3 == null) {
			btnNewButton_3_3 = new JButton("4");
			btnNewButton_3_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("4");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_3.setBounds(44, 135, 46, 46);
		}
		return btnNewButton_3_3;
	}

	private JButton getBtnNewButton_3_4() {
		if (btnNewButton_3_4 == null) {
			btnNewButton_3_4 = new JButton("5");
			btnNewButton_3_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("5");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_4.setBounds(102, 135, 46, 46);
		}
		return btnNewButton_3_4;
	}

	private JButton getBtnNewButton_3_5() {
		if (btnNewButton_3_5 == null) {
			btnNewButton_3_5 = new JButton("6");
			btnNewButton_3_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("6");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_5.setBounds(160, 135, 46, 46);
		}
		return btnNewButton_3_5;
	}

	private JButton getBtnNewButton_3_6() {
		if (btnNewButton_3_6 == null) {
			btnNewButton_3_6 = new JButton("7");
			btnNewButton_3_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("7");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_6.setBounds(44, 191, 46, 46);
		}
		return btnNewButton_3_6;
	}

	private JButton getBtnNewButton_3_7() {
		if (btnNewButton_3_7 == null) {
			btnNewButton_3_7 = new JButton("8");
			btnNewButton_3_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("8");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_7.setBounds(102, 191, 46, 46);
		}
		return btnNewButton_3_7;
	}

	private JButton getBtnNewButton_3_8() {
		if (btnNewButton_3_8 == null) {
			btnNewButton_3_8 = new JButton("9");
			btnNewButton_3_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("9");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_8.setBounds(160, 191, 46, 46);
		}
		return btnNewButton_3_8;
	}

	private JButton getBtnNewButton_3_9() {
		if (btnNewButton_3_9 == null) {
			btnNewButton_3_9 = new JButton("<-");
			btnNewButton_3_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (passwordField.getPassword().length > 0) {
						pw.remove(pw.size() - 1);
						passwordField.setText(ArrtoString(pw));
					}
				}
			});
			btnNewButton_3_9.setBounds(44, 247, 46, 46);
		}
		return btnNewButton_3_9;
	}

	private JButton getBtnNewButton_3_10() {
		if (btnNewButton_3_10 == null) {
			btnNewButton_3_10 = new JButton("0");
			btnNewButton_3_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pw.add("0");
					passwordField.setText(ArrtoString(pw));
				}
			});
			btnNewButton_3_10.setBounds(102, 247, 46, 46);
		}
		return btnNewButton_3_10;
	}

	private JButton getBtnNewButton_3_11() {
		if (btnNewButton_3_11 == null) {
			btnNewButton_3_11 = new JButton(">");
			btnNewButton_3_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KioskManagerDao dao = new KioskManagerDao();
					boolean check = dao.loginCheck(ArrtoString(passwordField.getPassword()));
					String staffid="";

					if (check == true) {
						panel.setVisible(false);
						btnNewButton_1.setVisible(true);
						btnNewButton_2.setVisible(true);
						for (int i=0;i<passwordField.getPassword().length;i++) {
							staffid=staffid+passwordField.getPassword()[i];
						}
						CustomerInfo.shopname=dao.checkShopName(Integer.parseInt(staffid));
						
						passwordField.setText(null);
					} else {
						passwordField.setText(null);
						pw.removeAll(pw);
					}
				}
			});
			btnNewButton_3_11.setBounds(160, 247, 46, 46);
		}
		return btnNewButton_3_11;
	}

	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setEchoChar('*');
			passwordField.setEditable(false);
			passwordField.setBounds(44, 37, 162, 32);
		}
		return passwordField;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 로그인");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(44, 10, 162, 26);
		}
		return lblNewLabel;
	}

	private String ArrtoString(ArrayList<String> arr) {
		String str = "";
		for (int i = 0; i < arr.size(); i++) {
			str = str + arr.get(i);
		}
		return str;
	}

	private String ArrtoString(char[] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str = str + arr[i];
		}
		return str;
	}
}
