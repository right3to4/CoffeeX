package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KioskOrder extends JPanel {
	private JLabel lblTodaysMenu;
	private JLabel lblCoffee;
	private JLabel lblAide;
	private JLabel lblTea;
	private JLabel lblSmoothie;
	private JLabel lblSide;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();


	/**
	 * Create the panel.
	 */
	public KioskOrder() {
		setLayout(null);
		add(getLblTodaysMenu());
		add(getLblCoffee());
		add(getLblAide());
		add(getLblTea());
		add(getLblSmoothie());
		add(getLblSide());
		add(getScrollPane());

	}

	private JLabel getLblTodaysMenu() {
		if (lblTodaysMenu == null) {
			lblTodaysMenu = new JLabel("");
			lblTodaysMenu.setBounds(0, 0, 71, 33);
			lblTodaysMenu.setIcon(new ImageIcon(KioskOrder.class.getResource("/com/coffeex/kiosk/image/todaysmenu.JPG")));

		}
		return lblTodaysMenu;
	}
	private JLabel getLblCoffee() {
		if (lblCoffee == null) {
			lblCoffee = new JLabel("");
			lblCoffee.setIcon(new ImageIcon(KioskOrder.class.getResource("/com/coffeex/kiosk/image/coffeetext.JPG")));
			lblCoffee.setBounds(71, 0, 71, 33);
		}
		return lblCoffee;
	}
	private JLabel getLblAide() {
		if (lblAide == null) {
			lblAide = new JLabel("에이드");
			lblAide.setHorizontalAlignment(SwingConstants.CENTER);
			lblAide.setBounds(142, 0, 71, 33);
		}
		return lblAide;
	}
	private JLabel getLblTea() {
		if (lblTea == null) {
			lblTea = new JLabel("티");
			lblTea.setHorizontalAlignment(SwingConstants.CENTER);
			lblTea.setBounds(213, 0, 71, 33);
		}
		return lblTea;
	}
	private JLabel getLblSmoothie() {
		if (lblSmoothie == null) {
			lblSmoothie = new JLabel("스무디");
			lblSmoothie.setHorizontalAlignment(SwingConstants.CENTER);
			lblSmoothie.setBounds(284, 0, 71, 33);
		}
		return lblSmoothie;
	}
	private JLabel getLblSide() {
		if (lblSide == null) {
			lblSide = new JLabel("사이드");
			lblSide.setHorizontalAlignment(SwingConstants.CENTER);
			lblSide.setBounds(355, 0, 71, 33);
		}
		return lblSide;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 31, 426, 413);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
}
