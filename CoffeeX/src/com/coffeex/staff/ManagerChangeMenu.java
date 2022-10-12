package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManagerChangeMenu {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JScrollPane spSearchMenu;
	private JScrollPane spSelectMenu;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JEditorPane editorPane;
	private JTable tbSearchMenu;
	private JTable tbSelectMenu;
	private final DefaultTableModel Outer_SearchMenu = new DefaultTableModel();
	private final DefaultTableModel Outer_SelectMenu = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerChangeMenu window = new ManagerChangeMenu();
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
	public ManagerChangeMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				SearchTableInit();
				SelectTableInit();
			}
		});
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setTitle("메뉴 등록/삭제");
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getSpSearchMenu());
		frame.getContentPane().add(getSpSelectMenu());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getBtnNewButton_2());
		frame.getContentPane().add(getEditorPane());
		frame.setDefaultCloseOperation(2);
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
	private JScrollPane getSpSearchMenu() {
		if (spSearchMenu == null) {
			spSearchMenu = new JScrollPane();
			spSearchMenu.setBounds(6, 80, 568, 126);
			spSearchMenu.setViewportView(getTbSearchMenu());
		}
		return spSearchMenu;
	}
	private JScrollPane getSpSelectMenu() {
		if (spSelectMenu == null) {
			spSelectMenu = new JScrollPane();
			spSelectMenu.setBounds(6, 229, 568, 55);
			spSelectMenu.setViewportView(getTbSelectMenu());
		}
		return spSelectMenu;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("선택된 메뉴");
			lblNewLabel_1.setBounds(6, 209, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("메뉴 사진");
			lblNewLabel_1_1.setBounds(6, 295, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("메뉴사진");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(6, 323, 248, 193);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("메뉴 소개글");
			lblNewLabel_1_1_1.setBounds(262, 296, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("등록하기");
			btnNewButton.setBounds(266, 478, 96, 29);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("수정하기");
			btnNewButton_1.setBounds(374, 478, 96, 29);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("삭제하기");
			btnNewButton_2.setBounds(482, 478, 96, 29);
		}
		return btnNewButton_2;
	}
	private JEditorPane getEditorPane() {
		if (editorPane == null) {
			editorPane = new JEditorPane();
			editorPane.setText("소개글을 작성해 주세요.");
			editorPane.setBounds(266, 323, 308, 143);
			
		}
		return editorPane;
	}
	private JTable getTbSearchMenu() {
		if (tbSearchMenu == null) {
			tbSearchMenu = new JTable();
			tbSearchMenu.setShowVerticalLines(false);
			tbSearchMenu.setShowGrid(false);
			tbSearchMenu.setShowHorizontalLines(false);
			tbSearchMenu.setModel(Outer_SearchMenu);
		}
		return tbSearchMenu;
	}
	private JTable getTbSelectMenu() {
		if (tbSelectMenu == null) {
			tbSelectMenu = new JTable();
			tbSelectMenu.setShowHorizontalLines(false);
			tbSelectMenu.setShowVerticalLines(false);
			tbSelectMenu.setShowGrid(false);
			tbSelectMenu.setModel(Outer_SelectMenu);
			
		}
		return tbSelectMenu;
	}
	
	private void SearchTableInit() {

		Outer_SearchMenu.addColumn("주문번호");
		Outer_SearchMenu.addColumn("메뉴");

		Outer_SearchMenu.setColumnCount(2);

		int i = Outer_SearchMenu.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_SearchMenu.removeRow(0);
		}

		tbSearchMenu.setAutoResizeMode(tbSearchMenu.AUTO_RESIZE_OFF);
		tbSearchMenu.setRowHeight(100);

		int vColIndex = 0;

		TableColumn col = tbSearchMenu.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbSearchMenu.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

	}
	
	private void SelectTableInit() {

		Outer_SelectMenu.addColumn("주문번호");
		Outer_SelectMenu.addColumn("메뉴");

		Outer_SelectMenu.setColumnCount(2);

		int i = Outer_SelectMenu.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_SelectMenu.removeRow(0);
		}

		tbSelectMenu.setAutoResizeMode(tbSelectMenu.AUTO_RESIZE_OFF);
		tbSelectMenu.setRowHeight(100);

		int vColIndex = 0;

		TableColumn col = tbSelectMenu.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbSelectMenu.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

	}
}
