package com.coffeex.staff;

import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.OrdersViewDto;
import com.coffeex.staffdao.ManagerViewOrdersDao;
import com.coffeex.staffdao.ManagerViewSalesDao;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerViewSales {

	private JFrame frame;
	private JLabel lb;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerViewSales window = new ManagerViewSales();
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
	public ManagerViewSales() {
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
				monthTableInit();
				viewSalesByMonth();
				// 이 윈도우만 종료
				frame.setDefaultCloseOperation(2);
			}
		});
		frame.setTitle("판매내역조회");
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLb());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
	}

	private JLabel getLb() {
		if (lb == null) {
			lb = new JLabel("판매내역조회");
			lb.setBounds(20, 68, 74, 16);
		}
		return lb;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox.getSelectedItem() == "월별 판매내역") {
						monthTableInit();
						viewSalesByMonth();
						
					} else if (comboBox.getSelectedItem() == "제품별 판매내역") {
						menuTableInit();
						viewSalesByMenu();
					} else if (comboBox.getSelectedItem() == "직원별 판매내역") {
						staffTableInit();
						viewSalesByStaff();
					} else {
						shopTableInit();
						viewSalesByShop();
					}

				}
			});
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "월별 판매내역", "제품별 판매내역", "직원별 판매내역"}));
			comboBox.setBounds(106, 64, 137, 27);
		}
		return comboBox;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 108, 562, 328);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setShowVerticalLines(false);
			Inner_Table.setShowHorizontalLines(false);
			Inner_Table.setShowGrid(false);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}

	private void monthTableInit() {

		Outer_Table.addColumn("월");
		Outer_Table.addColumn("개수");
		Outer_Table.addColumn("매출");

		Outer_Table.setColumnCount(3);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(50);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

	}
	
	private void menuTableInit() {
		
		Outer_Table.addColumn("메뉴");
		Outer_Table.addColumn("개수");
		Outer_Table.addColumn("매출");

		Outer_Table.setColumnCount(3);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(50);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);

		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

	}
	
	private void shopTableInit() {

		Outer_Table.addColumn("지점명");
		Outer_Table.addColumn("개수");
		Outer_Table.addColumn("매출");

		Outer_Table.setColumnCount(3);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(50);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

	}
	
	private void staffTableInit() {

		
		Outer_Table.addColumn("직원명");
		Outer_Table.addColumn("개수");
		Outer_Table.addColumn("매출");

		Outer_Table.setColumnCount(3);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(50);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 230;
		col.setPreferredWidth(width);

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

	public void viewSalesByMonth() {
		ManagerViewSalesDao dao = new ManagerViewSalesDao();
		ArrayList<OrdersViewDto> dtoList = dao.searchSalesByMonth();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String year = dtoList.get(index).getMenuname();
			int quantity = dtoList.get(index).getQuantity();
			int price = dtoList.get(index).getPrice();
			String[] qTxt = { year, Integer.toString(quantity), Integer.toString(price) };
			Outer_Table.addRow(qTxt);
		}
	}

	public void viewSalesByShop() {
		ManagerViewSalesDao dao = new ManagerViewSalesDao();
		ArrayList<OrdersViewDto> dtoList = dao.searchSalesByShop();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String shop = dtoList.get(index).getMenuname();
			int quantity = dtoList.get(index).getQuantity();
			int price = dtoList.get(index).getPrice();
			String[] qTxt = { shop, Integer.toString(quantity), Integer.toString(price) };
			Outer_Table.addRow(qTxt);
		}
	}

	public void viewSalesByStaff() {
		ManagerViewSalesDao dao = new ManagerViewSalesDao();
		ArrayList<OrdersViewDto> dtoList = dao.searchSalesByStaff();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String staff = dtoList.get(index).getMenuname();
			int quantity = dtoList.get(index).getQuantity();
			int price = dtoList.get(index).getPrice();
			String[] qTxt = { staff, Integer.toString(quantity), Integer.toString(price) };
			Outer_Table.addRow(qTxt);
		}
	}

	public void viewSalesByMenu() {
		ManagerViewSalesDao dao = new ManagerViewSalesDao();
		ArrayList<OrdersViewDto> dtoList = dao.searchSalesByMenu();

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String menu = dtoList.get(index).getMenuname();
			int quantity = dtoList.get(index).getQuantity();
			int price = dtoList.get(index).getPrice();
			String[] qTxt = { menu, Integer.toString(quantity), Integer.toString(price) };
			Outer_Table.addRow(qTxt);
		}
	}
}
