package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.Icon;
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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class KioskViewMenu extends JPanel {
	private JLabel lblTodaysMenu;
	private JLabel lblCoffee;
	private JLabel lblAide;
	private JLabel lblTea;
	private JLabel lblSmoothie;
	private JLabel lblSide;
	private JScrollPane scrollPane;
	public JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	public static String selectedname;
	public ArrayList<MenuViewDto> dto = new ArrayList<MenuViewDto>();

	/**
	 * Create the panel.
	 */
	public KioskViewMenu() {
		setBackground(new Color(148, 128, 96));
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
			lblTodaysMenu = new JLabel("오늘의 메뉴");
			lblTodaysMenu.setForeground(new Color(0, 0, 0));
			lblTodaysMenu.setOpaque(true);
			lblTodaysMenu.setBackground(new Color(118, 98, 66));
			lblTodaysMenu.setHorizontalAlignment(SwingConstants.CENTER);
			lblTodaysMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblTodaysMenu.setBackground(new Color(118, 98, 66));
					lblCoffee.setBackground(new Color(148, 128, 96));
					lblAide.setBackground(new Color(148, 128, 96));
					lblTea.setBackground(new Color(148, 128, 96));
					lblSmoothie.setBackground(new Color(148, 128, 96));
					lblSide.setBackground(new Color(148, 128, 96));
					tableInit();
					searchTodaysMenu();
//					for (int index = 0; index < dto.size(); index++) {
//						File file = new File("./" + dto.get(index).getPhoto());
//						System.out.println("./" + dto.get(index).getPhoto());
//						file.delete();
//					}
				}
			});
			lblTodaysMenu.setBounds(0, 0, 71, 31);

		}
		return lblTodaysMenu;
	}

	private JLabel getLblCoffee() {
		if (lblCoffee == null) {
			lblCoffee = new JLabel("커피");
			lblCoffee.setForeground(new Color(0, 0, 0));
			lblCoffee.setOpaque(true);
			lblCoffee.setHorizontalAlignment(SwingConstants.CENTER);
			lblCoffee.setBackground(new Color(148, 128, 96));
			lblCoffee.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblTodaysMenu.setBackground(new Color(148, 128, 96));
					lblCoffee.setBackground(new Color(118, 98, 66));
					lblAide.setBackground(new Color(148, 128, 96));
					lblTea.setBackground(new Color(148, 128, 96));
					lblSmoothie.setBackground(new Color(148, 128, 96));
					lblSide.setBackground(new Color(148, 128, 96));
					tableInit();
					searchMenuByCategory("커피");
					for (int index = 0; index < dto.size(); index++) {
						File file = new File("./" + dto.get(index).getPhoto());
						file.delete();
					}
				}
			});
			lblCoffee.setBounds(71, 0, 71, 31);
		}
		return lblCoffee;
	}

	private JLabel getLblAide() {
		if (lblAide == null) {
			lblAide = new JLabel("에이드");
			lblAide.setForeground(new Color(0, 0, 0));
			lblAide.setOpaque(true);
			lblAide.setBackground(new Color(148, 128, 96));
			lblAide.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblTodaysMenu.setBackground(new Color(148, 128, 96));
					lblCoffee.setBackground(new Color(148, 128, 96));
					lblAide.setBackground(new Color(118, 98, 66));
					lblTea.setBackground(new Color(148, 128, 96));
					lblSmoothie.setBackground(new Color(148, 128, 96));
					lblSide.setBackground(new Color(148, 128, 96));
					tableInit();
					searchMenuByCategory("에이드");
					for (int index = 0; index < dto.size(); index++) {
						File file = new File("./" + dto.get(index).getPhoto());
						file.delete();
					}
				}
			});
			lblAide.setHorizontalAlignment(SwingConstants.CENTER);
			lblAide.setBounds(142, 0, 71, 31);
		}
		return lblAide;
	}

	private JLabel getLblTea() {
		if (lblTea == null) {
			lblTea = new JLabel("티");
			lblTea.setForeground(new Color(0, 0, 0));
			lblTea.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblTodaysMenu.setBackground(new Color(148, 128, 96));
					lblCoffee.setBackground(new Color(148, 128, 96));
					lblAide.setBackground(new Color(148, 128, 96));
					lblTea.setBackground(new Color(118, 98, 66));
					lblSmoothie.setBackground(new Color(148, 128, 96));
					lblSide.setBackground(new Color(148, 128, 96));
					searchMenuByCategory("티");
					tableInit();
					for (int index = 0; index < dto.size(); index++) {
						File file = new File("./" + dto.get(index).getPhoto());
						file.delete();
					}
				}
			});
			lblTea.setOpaque(true);
			lblTea.setBackground(new Color(148, 128, 96));
			lblTea.setHorizontalAlignment(SwingConstants.CENTER);
			lblTea.setBounds(213, 0, 71, 31);
		}
		return lblTea;
	}

	private JLabel getLblSmoothie() {
		if (lblSmoothie == null) {
			lblSmoothie = new JLabel("스무디");
			lblSmoothie.setForeground(new Color(0, 0, 0));
			lblSmoothie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblTodaysMenu.setBackground(new Color(148, 128, 96));
					lblCoffee.setBackground(new Color(148, 128, 96));
					lblAide.setBackground(new Color(148, 128, 96));
					lblTea.setBackground(new Color(148, 128, 96));
					lblSmoothie.setBackground(new Color(118, 98, 66));
					lblSide.setBackground(new Color(148, 128, 96));
					searchMenuByCategory("스무디");
					tableInit();
					for (int index = 0; index < dto.size(); index++) {
						File file = new File("./" + dto.get(index).getPhoto());
						file.delete();
					}
				}
			});
			lblSmoothie.setOpaque(true);
			lblSmoothie.setBackground(new Color(148, 128, 96));
			lblSmoothie.setHorizontalAlignment(SwingConstants.CENTER);
			lblSmoothie.setBounds(284, 0, 71, 31);
		}
		return lblSmoothie;
	}

	private JLabel getLblSide() {
		if (lblSide == null) {
			lblSide = new JLabel("사이드");
			lblSide.setForeground(new Color(0, 0, 0));
			lblSide.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblTodaysMenu.setBackground(new Color(148, 128, 96));
					lblCoffee.setBackground(new Color(148, 128, 96));
					lblAide.setBackground(new Color(148, 128, 96));
					lblTea.setBackground(new Color(148, 128, 96));
					lblSmoothie.setBackground(new Color(148, 128, 96));
					lblSide.setBackground(new Color(118, 98, 66));
					searchMenuByCategory("사이드");
					tableInit();
					for (int index = 0; index < dto.size(); index++) {
						File file = new File("./" + dto.get(index).getPhoto());
						file.delete();
					}
				}
			});
			lblSide.setOpaque(true);
			lblSide.setBackground(new Color(148, 128, 96));
			lblSide.setHorizontalAlignment(SwingConstants.CENTER);
			lblSide.setBounds(355, 0, 71, 31);
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
			Inner_Table = new JTable() {
				public Class getColumnClass(int column) {
					return (column == 0) ? Icon.class : Object.class;
				}
			};
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

		Outer_Table.addColumn("사진");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("가격");

		Outer_Table.setColumnCount(3);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(100);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 150;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
	}

	private void searchTodaysMenu() {

//		if (dto.size() != 0) {
//			for (int index2 = 0; index2 < dto.size(); index2++) {
//				File file2 = new File("./" + dto.get(index2).getPhoto());
////			System.out.println("./" + dto.get(index2).getPhoto());
//				file2.delete();
//
//			}
			dto = new ArrayList<MenuViewDto>();
			KioskViewMenuDao dao = new KioskViewMenuDao();
			dto = dao.ShowTodaysMenuList();

			int listCount = dto.size();

			for (int index = 0; index < listCount; index++) {
				ImageIcon image = new ImageIcon(dto.get(index).getPhoto());
				File file = new File("./" + dto.get(index).getPhoto());
				String temp = dto.get(index).getMenuname();
				Object[] qTxt = { image, temp, Integer.toString(dto.get(index).getPrice()) };
				Outer_Table.addRow(qTxt);
			}

		}
	

	private void searchMenuByCategory(String category) {

//		if (dto.size() != 0) {
//			for (int index2 = 0; index2 < dto.size(); index2++) {
//				File file2 = new File("./" + dto.get(index2).getPhoto());
////			System.out.println("./" + dto.get(index2).getPhoto());
//				file2.delete();
//
//			}
			dto = new ArrayList<MenuViewDto>();
			KioskViewMenuDao dao = new KioskViewMenuDao();
			dto = dao.ShowMenuListByCondition(category);

			int listCount = dto.size();

			for (int index = 0; index < listCount; index++) {
				String temp = dto.get(index).getMenuname();
				File file = new File(dto.get(index).getPhoto());
				ImageIcon image = new ImageIcon("./" + dto.get(index).getPhoto());
				Object[] qTxt = { image, temp, Integer.toString(dto.get(index).getPrice()) };
				Outer_Table.addRow(qTxt);
				file.delete();
			}
		}
	

	private void tableClick() {
		int i = Inner_Table.getSelectedRow();
		selectedname = (String) Inner_Table.getValueAt(i, 2);
		KioskInit.lblAddbutton.setVisible(true);
	}

}
