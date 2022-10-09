package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.kioskdao.KioskViewMenuDao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class KioskViewMenu extends JPanel {
	private JLabel lblTodaysMenu;
	private JLabel lblCoffee;
	private JLabel lblAide;
	private JLabel lblTea;
	private JLabel lblSmoothie;
	private JLabel lblSide;
	private JScrollPane scrollPane;
	public static JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	public static String selectedname;

	/**
	 * Create the panel.
	 */
	public KioskViewMenu() {
		setLayout(null);
		add(getLblTodaysMenu());
		add(getLblCoffee());
		add(getLblAide());
		add(getLblTea());
		add(getLblSmoothie());
		add(getLblSide());
		add(getScrollPane());
		tableInit();
		searchTodaysMenu();
	}

	private JLabel getLblTodaysMenu() {
		if (lblTodaysMenu == null) {
			lblTodaysMenu = new JLabel("");
			lblTodaysMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchTodaysMenu();
				}
			});
			lblTodaysMenu.setBounds(0, 0, 71, 33);
			lblTodaysMenu
					.setIcon(new ImageIcon(KioskViewMenu.class.getResource("/com/coffeex/kiosk/image/todaysmenu.JPG")));

		}
		return lblTodaysMenu;
	}

	private JLabel getLblCoffee() {
		if (lblCoffee == null) {
			lblCoffee = new JLabel("");
			lblCoffee.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchMenuByCategory("커피");
				}
			});
			lblCoffee
					.setIcon(new ImageIcon(KioskViewMenu.class.getResource("/com/coffeex/kiosk/image/coffeetext.JPG")));
			lblCoffee.setBounds(71, 0, 71, 33);
		}
		return lblCoffee;
	}

	private JLabel getLblAide() {
		if (lblAide == null) {
			lblAide = new JLabel("에이드");
			lblAide.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableInit();
					searchMenuByCategory("에이드");
				}
			});
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
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			Inner_Table.setShowVerticalLines(false);
			Inner_Table.setShowHorizontalLines(false);
			Inner_Table.setShowGrid(false);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private void tableInit() {

		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("가격");

		Outer_Table.setColumnCount(2);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(100);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 211;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 211;
		col.setPreferredWidth(width);
	}

	private void searchTodaysMenu() {

		KioskViewMenuDao dao = new KioskViewMenuDao();
		ArrayList<MenuViewDto> dtoList = dao.ShowTodaysMenuList();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = dtoList.get(index).getMenuname();
			String[] qTxt = { temp, Integer.toString(dtoList.get(index).getPrice()) };
			Outer_Table.addRow(qTxt);
		}
	}

	private void searchMenuByCategory(String category) {

		KioskViewMenuDao dao = new KioskViewMenuDao();
		ArrayList<MenuViewDto> dtoList = dao.ShowMenuListByCondition(category);

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = dtoList.get(index).getMenuname();
			String[] qTxt = { temp, Integer.toString(dtoList.get(index).getPrice()) };
			Outer_Table.addRow(qTxt);
		}
	}
	
	private void tableClick() {
		int i = Inner_Table.getSelectedRow();
		selectedname = (String) Inner_Table.getValueAt(i, 1);
	}
}
