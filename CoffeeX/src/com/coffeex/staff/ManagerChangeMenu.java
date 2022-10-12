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

import com.coffeex.dto.MenuViewDto;
import com.coffeex.kiosk.KioskInit;
import com.coffeex.kioskdao.KioskViewMenuDao;
import com.coffeex.staffdao.ManagerChangeMenuDao;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerChangeMenu {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JScrollPane spSearchMenu;
	private JScrollPane spSelectMenu;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1_1;
	private JButton btnAddButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JEditorPane editorPane;
	private JTable tbSearchAllMenu;
	private JTable tbSelectMenu;
	private final DefaultTableModel Outer_SearchMenu = new DefaultTableModel();
	private final DefaultTableModel Outer_SearchShopMenu = new DefaultTableModel();
	private final DefaultTableModel Outer_SelectMenu = new DefaultTableModel();
	private JScrollPane spSearchMenu_1;
	private JTable tbSearchShopMenu;
	
	ArrayList<MenuViewDto> dtoall = new ArrayList<MenuViewDto>();
	ArrayList<MenuViewDto> dtoshop = new ArrayList<MenuViewDto>();

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
				SearchShopTableInit();
				SelectTableInit();
				searchAllMenu();
				searchShopMenu();
				btnAddButton.setVisible(false);
			}
			@Override
			public void windowClosing(WindowEvent e) {
				for(int index=0; index <= 1000; index++) {
					File file = new File("./" + index);
					file.delete();
				}
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
		frame.getContentPane().add(getBtnAddButton());
		frame.getContentPane().add(getBtnNewButton_1());
		frame.getContentPane().add(getBtnNewButton_2());
		frame.getContentPane().add(getEditorPane());
		frame.getContentPane().add(getSpSearchMenu_1());
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
			spSearchMenu.setBounds(6, 80, 272, 126);
			spSearchMenu.setViewportView(getTbSearchAllMenu());
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

	private JButton getBtnAddButton() {
		if (btnAddButton == null) {
			btnAddButton = new JButton("등록하기");
			btnAddButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerChangeMenuDao dao=new ManagerChangeMenuDao();
					dao.addMenu(Integer.parseInt((String) tbSearchAllMenu.getValueAt(tbSearchAllMenu.getSelectedRow(), 0)));
					SearchTableInit();
					SearchShopTableInit();
					SelectTableInit();
					searchAllMenu();
					searchShopMenu();
				}
			});
			btnAddButton.setBounds(266, 478, 96, 29);
		}
		return btnAddButton;
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

	private JTable getTbSearchAllMenu() {
		if (tbSearchAllMenu == null) {
			tbSearchAllMenu = new JTable();
			tbSearchAllMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableAllClick();
					btnAddButton.setVisible(true);
				}
			});
			tbSearchAllMenu.setModel(Outer_SearchMenu);
		}
		return tbSearchAllMenu;
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

	private JScrollPane getSpSearchMenu_1() {
		if (spSearchMenu_1 == null) {
			spSearchMenu_1 = new JScrollPane();
			spSearchMenu_1.setBounds(302, 80, 272, 126);
			spSearchMenu_1.setViewportView(getTbSearchShopMenu());
		}
		return spSearchMenu_1;
	}

	private JTable getTbSearchShopMenu() {
		if (tbSearchShopMenu == null) {
			tbSearchShopMenu = new JTable();
			tbSearchShopMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableShopClick();
				}
			});
			tbSearchShopMenu.setModel(Outer_SearchShopMenu);
		}
		return tbSearchShopMenu;
	}

	private void SearchTableInit() {

		Outer_SearchMenu.addColumn("메뉴번호");
		Outer_SearchMenu.addColumn("카테고리");
		Outer_SearchMenu.addColumn("메뉴명");
		Outer_SearchMenu.addColumn("가격");
		Outer_SearchMenu.addColumn("생성일");
		Outer_SearchMenu.addColumn("수정일");

		Outer_SelectMenu.setColumnCount(6);

		int i = Outer_SearchMenu.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_SearchMenu.removeRow(0);
		}

		tbSearchAllMenu.setAutoResizeMode(tbSelectMenu.AUTO_RESIZE_OFF);
		tbSearchAllMenu.setRowHeight(20);

		int vColIndex = 0;

		TableColumn col = tbSearchAllMenu.getColumnModel().getColumn(vColIndex);
		int width = 60;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbSearchAllMenu.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = tbSearchAllMenu.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = tbSearchAllMenu.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = tbSearchAllMenu.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);

	}

	private void SearchShopTableInit() {

		Outer_SearchShopMenu.addColumn("메뉴번호");
		Outer_SearchShopMenu.addColumn("카테고리");
		Outer_SearchShopMenu.addColumn("메뉴명");
		Outer_SearchShopMenu.addColumn("가격");
		Outer_SearchShopMenu.addColumn("생성일");
		Outer_SearchShopMenu.addColumn("수정일");

		Outer_SelectMenu.setColumnCount(6);

		int i = Outer_SearchShopMenu.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_SearchShopMenu.removeRow(0);
		}

		tbSearchShopMenu.setAutoResizeMode(tbSearchShopMenu.AUTO_RESIZE_OFF);
		tbSearchShopMenu.setRowHeight(20);

		int vColIndex = 0;

		TableColumn col = tbSearchShopMenu.getColumnModel().getColumn(vColIndex);
		int width = 60;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbSearchShopMenu.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = tbSearchShopMenu.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = tbSearchShopMenu.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = tbSearchShopMenu.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);

	}

	private void SelectTableInit() {

		Outer_SelectMenu.addColumn("메뉴번호");
		Outer_SelectMenu.addColumn("카테고리");
		Outer_SelectMenu.addColumn("메뉴명");
		Outer_SelectMenu.addColumn("가격");
		Outer_SelectMenu.addColumn("생성일");
		Outer_SelectMenu.addColumn("수정일");

		Outer_SelectMenu.setColumnCount(6);

		int i = Outer_SelectMenu.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_SelectMenu.removeRow(0);
		}

		tbSelectMenu.setAutoResizeMode(tbSelectMenu.AUTO_RESIZE_OFF);
		tbSelectMenu.setRowHeight(20);

		int vColIndex = 0;

		TableColumn col = tbSelectMenu.getColumnModel().getColumn(vColIndex);
		int width = 60;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbSelectMenu.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);
		
		vColIndex = 2;
		col = tbSelectMenu.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = tbSelectMenu.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = tbSelectMenu.getColumnModel().getColumn(vColIndex);
		width = 70;
		col.setPreferredWidth(width);

	}
	
	private void searchAllMenu() {
		ManagerChangeMenuDao dao = new ManagerChangeMenuDao();
		dtoall = dao.ShowAllMenu();

		int listCount = dtoall.size();

		for (int index = 0; index < listCount; index++) {
			int menuid=dtoall.get(index).getMenuid();
			String category=dtoall.get(index).getCategory();
			String menuname=dtoall.get(index).getMenuname();
			int mprice=dtoall.get(index).getPrice();
			String createdate=dtoall.get(index).getCreatedate();
			String updatedate=dtoall.get(index).getUpdatedate();
			String[] qTxt = { Integer.toString(menuid), category, menuname, Integer.toString(mprice), createdate, updatedate };
			Outer_SearchMenu.addRow(qTxt);
		}
	}
	
	private void searchShopMenu() {
		ManagerChangeMenuDao dao = new ManagerChangeMenuDao();
		dtoshop = dao.ShowShopMenu();

		int listCount = dtoshop.size();

		for (int index = 0; index < listCount; index++) {
			int menuid=dtoshop.get(index).getMenuid();
			String category=dtoshop.get(index).getCategory();
			String menuname=dtoshop.get(index).getMenuname();
			int mprice=dtoshop.get(index).getPrice();
			String createdate=dtoshop.get(index).getCreatedate();
			String updatedate=dtoshop.get(index).getUpdatedate();
			String[] qTxt = { Integer.toString(menuid), category, menuname, Integer.toString(mprice), createdate, updatedate };
			Outer_SearchShopMenu.addRow(qTxt);
		}
	}

	private void tableAllClick() {
		int i = tbSearchAllMenu.getSelectedRow();
		String selectedid = (String) tbSearchAllMenu.getValueAt(i, 0);
		String selectedcategory = (String) tbSearchAllMenu.getValueAt(i, 1);
		String selectedname = (String) tbSearchAllMenu.getValueAt(i, 2);
		String selectedprice = (String) tbSearchAllMenu.getValueAt(i, 3);
		String selectedcreatedate = (String) tbSearchAllMenu.getValueAt(i, 4);
		String selectedupdatedate = (String) tbSearchAllMenu.getValueAt(i, 5);
		
		int k = Outer_SelectMenu.getRowCount();
		for (int j = 0; j < k; j++) {
			Outer_SelectMenu.removeRow(0);
			
		}
		
		String[] qTxt= {selectedid, selectedcategory, selectedname, selectedprice, selectedcreatedate, selectedupdatedate};
		Outer_SelectMenu.addRow(qTxt);
		
		tbSearchShopMenu.clearSelection();
		
		ManagerChangeMenuDao dao=new ManagerChangeMenuDao();
		editorPane.setText(dao.getInfo((String)tbSearchAllMenu.getValueAt(i, 0)));
	}
	
	private void tableShopClick() {
		int i = tbSearchShopMenu.getSelectedRow();
		String selectedid = (String) tbSearchShopMenu.getValueAt(i, 0);
		String selectedcategory = (String) tbSearchShopMenu.getValueAt(i, 1);
		String selectedname = (String) tbSearchShopMenu.getValueAt(i, 2);
		String selectedprice = (String) tbSearchShopMenu.getValueAt(i, 3);
		String selectedcreatedate = (String) tbSearchShopMenu.getValueAt(i, 4);
		String selectedupdatedate = (String) tbSearchShopMenu.getValueAt(i, 5);
		
		int k = Outer_SelectMenu.getRowCount();
		for (int j = 0; j < k; j++) {
			Outer_SelectMenu.removeRow(0);
		}
		
		String[] qTxt= {selectedid, selectedcategory, selectedname, selectedprice, selectedcreatedate, selectedupdatedate};
		Outer_SelectMenu.addRow(qTxt);
		
		tbSearchAllMenu.clearSelection();
		
		ManagerChangeMenuDao dao=new ManagerChangeMenuDao();
		editorPane.setText(dao.getInfo((String)tbSearchShopMenu.getValueAt(i, 0)));
	}
	
	
}
