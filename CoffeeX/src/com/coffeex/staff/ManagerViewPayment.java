package com.coffeex.staff;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ManagerViewPayment {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JTable Inner_Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerViewPayment window = new ManagerViewPayment();
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
	public ManagerViewPayment() {
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
				frame.setDefaultCloseOperation(2);
			}
			//이 윈도우만 종료
			
		});
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("사원급여내역");
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getScrollPane());
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(335, 23, 130, 26);
		}
		return textField;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("사원검색");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(283, 28, 53, 16);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.setBounds(477, 23, 117, 29);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 81, 532, 365);
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

		Outer_Table.addColumn("성명");
		Outer_Table.addColumn("지급금액");
		Outer_Table.addColumn("지급일자");

		Outer_Table.setColumnCount(3);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(100);

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
}
