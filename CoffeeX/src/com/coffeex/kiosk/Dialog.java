package com.coffeex.kiosk;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dialog extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public Dialog() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());

	}
	
	public Dialog(String message) {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		lblNewLabel.setText(message);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("잘못된 전화번호입니다.");
			lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 33, 244, 36);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("확인");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
				}
			});
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(new Color(148, 128, 96));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(103, 110, 50, 24);
		}
		return lblNewLabel_1;
	}
	
	public void ShowDialog(String message) {
		setVisible(true);
		lblNewLabel.setText(message);
	}
}
