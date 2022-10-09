package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.kioskdao.KioskViewMenuDao;
import com.coffeex.util.DBConnect;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTextField;

public class KioskOrder extends JPanel {
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	public static String selectedname;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblStep;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblStep_1;
	private JPanel panel;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	private JLabel lblNewLabel_2_4;
	private JLabel lblNewLabel_2_5;
	private JLabel lblNewLabel_2_6;
	private JLabel lblNewLabel_2_7;
	private JLabel lblNewLabel_2_8;
	private JLabel lblNewLabel_2_6_1;
	private JLabel lblNewLabel_2_6_2;
	private JLabel lblNewLabel_2_6_3;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	public KioskOrder() {
		setLayout(null);
		add(getScrollPane_1());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_1_1());
		add(getLblNewLabel_1_1_1());
		add(getLblNewLabel_1_2());
		add(getLblStep());
		add(getLblNewLabel_1_1_2());
		add(getLblNewLabel_1_3());
		add(getLblStep_1());
		add(getPanel());
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 44, 250, 261);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
		}
		Inner_Table.setModel(Outer_Table);
		return Inner_Table;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Step1: 포장 선택");
			lblNewLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
			lblNewLabel.setBounds(250, 44, 176, 27);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("포장");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(250, 72, 88, 58);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("매장 식사");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(338, 72, 88, 58);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("적립안함");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_1_1.setBounds(338, 159, 88, 58);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1_2 == null) {
			lblNewLabel_1_2 = new JLabel("적립");
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_2.setBounds(250, 159, 88, 58);
		}
		return lblNewLabel_1_2;
	}
	private JLabel getLblStep() {
		if (lblStep == null) {
			lblStep = new JLabel("Step2: 포인트 적립 선택");
			lblStep.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
			lblStep.setBounds(250, 131, 176, 27);
		}
		return lblStep;
	}
	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("카드");
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_1_2.setBounds(338, 247, 88, 58);
		}
		return lblNewLabel_1_1_2;
	}
	private JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("포인트");
			lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_3.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_3.setBounds(250, 247, 88, 58);
		}
		return lblNewLabel_1_3;
	}
	private JLabel getLblStep_1() {
		if (lblStep_1 == null) {
			lblStep_1 = new JLabel("Step3: 결제 방식 선택");
			lblStep_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
			lblStep_1.setBounds(250, 219, 176, 27);
		}
		return lblStep_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 315, 250, 120);
			panel.setLayout(null);
			panel.add(getTextField());
			panel.add(getLblNewLabel_2());
			panel.add(getLblNewLabel_2_1());
			panel.add(getLblNewLabel_2_2());
			panel.add(getLblNewLabel_2_3());
			panel.add(getLblNewLabel_2_4());
			panel.add(getLblNewLabel_2_5());
			panel.add(getLblNewLabel_2_6());
			panel.add(getLblNewLabel_2_7());
			panel.add(getLblNewLabel_2_8());
			panel.add(getLblNewLabel_2_6_1());
			panel.add(getLblNewLabel_2_6_2());
			panel.add(getLblNewLabel_2_6_3());
			panel.add(getLblNewLabel_3());
		}
		return panel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(12, 35, 97, 21);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("1");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(108, 0, 47, 30);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("2");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setBounds(156, 0, 47, 30);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("3");
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setBounds(203, 0, 47, 30);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_3() {
		if (lblNewLabel_2_3 == null) {
			lblNewLabel_2_3 = new JLabel("6");
			lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_3.setBounds(203, 30, 47, 30);
		}
		return lblNewLabel_2_3;
	}
	private JLabel getLblNewLabel_2_4() {
		if (lblNewLabel_2_4 == null) {
			lblNewLabel_2_4 = new JLabel("5");
			lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_4.setBounds(156, 30, 47, 30);
		}
		return lblNewLabel_2_4;
	}
	private JLabel getLblNewLabel_2_5() {
		if (lblNewLabel_2_5 == null) {
			lblNewLabel_2_5 = new JLabel("4");
			lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_5.setBounds(108, 30, 47, 30);
		}
		return lblNewLabel_2_5;
	}
	private JLabel getLblNewLabel_2_6() {
		if (lblNewLabel_2_6 == null) {
			lblNewLabel_2_6 = new JLabel("7");
			lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_6.setBounds(108, 60, 47, 30);
		}
		return lblNewLabel_2_6;
	}
	private JLabel getLblNewLabel_2_7() {
		if (lblNewLabel_2_7 == null) {
			lblNewLabel_2_7 = new JLabel("8");
			lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_7.setBounds(156, 60, 47, 30);
		}
		return lblNewLabel_2_7;
	}
	private JLabel getLblNewLabel_2_8() {
		if (lblNewLabel_2_8 == null) {
			lblNewLabel_2_8 = new JLabel("9");
			lblNewLabel_2_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_8.setBounds(203, 60, 47, 30);
		}
		return lblNewLabel_2_8;
	}
	private JLabel getLblNewLabel_2_6_1() {
		if (lblNewLabel_2_6_1 == null) {
			lblNewLabel_2_6_1 = new JLabel("지움");
			lblNewLabel_2_6_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_6_1.setBounds(108, 90, 47, 30);
		}
		return lblNewLabel_2_6_1;
	}
	private JLabel getLblNewLabel_2_6_2() {
		if (lblNewLabel_2_6_2 == null) {
			lblNewLabel_2_6_2 = new JLabel("0");
			lblNewLabel_2_6_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_6_2.setBounds(156, 90, 47, 30);
		}
		return lblNewLabel_2_6_2;
	}
	private JLabel getLblNewLabel_2_6_3() {
		if (lblNewLabel_2_6_3 == null) {
			lblNewLabel_2_6_3 = new JLabel("입력");
			lblNewLabel_2_6_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_6_3.setBounds(203, 90, 47, 30);
		}
		return lblNewLabel_2_6_3;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전화번호");
			lblNewLabel_3.setBounds(12, 8, 50, 15);
		}
		return lblNewLabel_3;
	}
}
