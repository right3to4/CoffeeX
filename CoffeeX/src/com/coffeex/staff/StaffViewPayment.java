package com.coffeex.staff;

import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.NoticeDto;
import com.coffeex.dto.PayDto;
import com.coffeex.staffdao.ManagerViewOrdersDao;
import com.coffeex.staffdao.StaffViewPaymentDao;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class StaffViewPayment {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffViewPayment window = new StaffViewPayment();
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
	public StaffViewPayment() {
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
				TableInit();
				staffPaySearchAction();
				// 이 윈도우만 종료
				frame.setDefaultCloseOperation(2);
			}
		});
		frame.setTitle("판매내역조회");
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getScrollPane());
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("날짜조회");
			lblNewLabel_1.setBounds(20, 68, 50, 23);
		}
		return lblNewLabel_1;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(68, 67, 121, 27);
		}
		return comboBox;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 108, 550, 328);
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

	private void TableInit() {

		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("급여지급내역");
		Outer_Table.addColumn("인센티브지급내역");
		Outer_Table.addColumn("지급일자");

		Outer_Table.setColumnCount(4);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 150;
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

	// ------------------------------------
	private int staffPaySearchAction() {
		StaffViewPaymentDao dao = new StaffViewPaymentDao();
		ArrayList<PayDto> dtoList = dao.selectStaffPay();
		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			int temp = dtoList.get(i).getPaystaffid();
			String[] qTxt = { Integer.toString(temp), Integer.toString(dtoList.get(i).getPayamount()),
					Integer.toString(dtoList.get(i).getPayincentive()), dtoList.get(i).getPaydate() };
			Outer_Table.addRow(qTxt);
		}

		return listCount;
	}

	private void updateCombo(ArrayList<String> abc) {
		StaffViewPaymentDao dao = new StaffViewPaymentDao();
		for (int i = 0; i < abc.size(); i++) {
			abc.get(0);
		}
	}

}