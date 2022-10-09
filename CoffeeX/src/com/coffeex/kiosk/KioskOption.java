package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class KioskOption extends JPanel {
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JLabel lblICE;
	private JLabel lblHOT;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_2;
	private JLabel lblQuantity;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	public KioskOption() {
		setLayout(null);
		add(getLblNewLabel());
		add(getSeparator());
		add(getSeparator_1());
		add(getLblNewLabel_1());
		add(getLblICE());
		add(getLblHOT());
		add(getLblNewLabel_2());
		add(getLblNewLabel_2_2());
		add(getLblQuantity());
		add(getLblNewLabel_3());

	}

	private JLabel getLblNewLabel() { //메뉴 사진
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel
					.setIcon(new ImageIcon(KioskOption.class.getResource("/com/coffeex/kiosk/image/iceamericano2.png")));
			lblNewLabel.setBounds(12, 49, 144, 144);
		}
		return lblNewLabel;
	}

	private JSeparator getSeparator() { //구분선
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 191, 400, 2);
		}
		return separator;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(12, 263, 400, 2);
		}
		return separator_1;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("HOT/ICE");
			lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 203, 120, 50);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblICE() { //아이스 선택 시
		if (lblICE == null) {
			lblICE = new JLabel("ICE");
			lblICE.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblICE.setText(null);
					lblICE.setIcon(new ImageIcon(KioskMain.class.getResource("/com/coffeex/kiosk/image/ICE.JPG")));
					lblHOT.setIcon(null);
					lblHOT.setText("HOT");
				}
			});
			lblICE.setHorizontalAlignment(SwingConstants.CENTER);
			lblICE.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblICE.setBounds(287, 203, 65, 50);
		}
		return lblICE;
	}

	private JLabel getLblHOT() { //핫 선택 시
		if (lblHOT == null) {
			lblHOT = new JLabel("HOT");
			lblHOT.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblHOT.setText(null);
					lblHOT.setIcon(new ImageIcon(KioskMain.class.getResource("/com/coffeex/kiosk/image/HOT.JPG")));
					lblICE.setIcon(null);
					lblICE.setText("ICE");
				}
			});
			lblHOT.setHorizontalAlignment(SwingConstants.CENTER);
			lblHOT.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblHOT.setBounds(161, 203, 65, 50);
		}
		return lblHOT;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("+");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { //수량 늘리기 버튼
					int quant = Integer.parseInt(lblQuantity.getText());
					quant++;
					lblQuantity.setText(Integer.toString(quant));
				}
			});
			lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 25));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(335, 131, 50, 50);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("-");
			lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { //수량 줄이기 버튼
					int quant = Integer.parseInt(lblQuantity.getText());
					if (quant > 1) {
						quant--;
					}
					lblQuantity.setText(Integer.toString(quant));
				}
			});
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 25));
			lblNewLabel_2_2.setBounds(214, 131, 50, 50);
		}
		return lblNewLabel_2_2;
	}

	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("1");
			lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuantity.setFont(new Font("굴림", Font.PLAIN, 20));
			lblQuantity.setBounds(273, 131, 65, 50);
		}
		return lblQuantity;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("옵션선택");
			lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 20));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(161, 10, 103, 38);
		}
		return lblNewLabel_3;
	}
}
