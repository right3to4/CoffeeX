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
import com.coffeex.dto.OrdersDto;
import com.coffeex.dto.PayDto;
import com.coffeex.dto.StaffDto;
import com.coffeex.staffdao.ManagerAddStaffDao;
import com.coffeex.staffdao.ManagerViewOrdersDao;
import com.coffeex.staffdao.StaffViewPaymentDao;
import com.coffeex.staffdao.StaffViewSalesDao;
import com.coffeex.util.CustomerInfo;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class StaffViewPayment {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JComboBox cbPayMonth;
	private JScrollPane SPPay;
	private JTable tbPay;
	private final DefaultTableModel Outer_tbPay = new DefaultTableModel();
	private final DefaultTableModel Outer_tbSales = new DefaultTableModel();
	private JLabel lblNewLabel;
	private JLabel lblSumPayAmount;
	private JLabel lblSumPayIncentive;
	private JScrollPane SPSales;
	private JTable tbSales;
	private JLabel lblSumSalesquantity;
	private JLabel lblSumSalesprice;
	private JLabel lblNewLabel_1_1;
	private JComboBox cbSalesMonth;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_3;
	private JButton btnSearchPay;
	private JButton btnSearchSales;

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
				TableInitPay();
				TableInitSales();
				staffPaySearch();
				staffSalesSearch();
				// ??? ???????????? ??????
				frame.setDefaultCloseOperation(2);
			}
		});
		frame.setTitle("?????? ??? ??????????????????");
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getCbPayMonth());
		frame.getContentPane().add(getSPPay());
		frame.getContentPane().add(getSPSales());
		frame.getContentPane().add(getLblSumPayAmount());
		frame.getContentPane().add(getLblSumPayIncentive());
		frame.getContentPane().add(getLblSumSalesquantity());
		frame.getContentPane().add(getLblSumSalesprice());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getCbSalesMonth());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getBtnSearchPay());
		frame.getContentPane().add(getBtnSearchSales());
		updatePayCombo();
		updateSalesCombo();
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("????????????");
			lblNewLabel_1.setBounds(20, 120, 50, 23);
		}
		return lblNewLabel_1;
	}

	private JComboBox getCbPayMonth() {
		if (cbPayMonth == null) {
			cbPayMonth = new JComboBox();
			cbPayMonth.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					TableInitPay();
					cbPayDateSearch();
				}
			});
			cbPayMonth.setBounds(75, 119, 107, 27);
		}
		return cbPayMonth;
	}

	private JComboBox getCbSalesMonth() {
		if (cbSalesMonth == null) {
			cbSalesMonth = new JComboBox();
			cbSalesMonth.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					TableInitSales();
					cbSalesDateSearch();
				}
			});
			cbSalesMonth.setBounds(75, 334, 107, 27);
		}
		return cbSalesMonth;
	}

	private JScrollPane getSPPay() {
		if (SPPay == null) {
			SPPay = new JScrollPane();
			SPPay.setBounds(20, 155, 550, 140);
			SPPay.setViewportView(getTbPay());
		}
		return SPPay;
	}

	private JScrollPane getSPSales() {
		if (SPSales == null) {
			SPSales = new JScrollPane();
			SPSales.setBounds(20, 370, 550, 140);
			SPSales.setViewportView(getTbSales());
		}
		return SPSales;
	}

	private JTable getTbPay() {
		if (tbPay == null) {
			tbPay = new JTable();
			tbPay.setEnabled(false);
			tbPay.setShowVerticalLines(false);
			tbPay.setShowHorizontalLines(false);
			tbPay.setShowGrid(false);
			tbPay.setModel(Outer_tbPay);
		}
		return tbPay;
	}

	private JTable getTbSales() {
		if (tbSales == null) {
			tbSales = new JTable();
			tbSales.setShowVerticalLines(false);
			tbSales.setShowHorizontalLines(false);
			tbSales.setShowGrid(false);
			tbSales.setFillsViewportHeight(true);
			tbSales.setEnabled(false);
			tbSales.setModel(Outer_tbSales);
		}
		return tbSales;
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

	private JLabel getLblSumPayAmount() {
		if (lblSumPayAmount == null) {
			lblSumPayAmount = new JLabel("????????????");
			lblSumPayAmount.setBounds(194, 123, 156, 16);
		}
		return lblSumPayAmount;
	}

	private JLabel getLblSumPayIncentive() {
		if (lblSumPayIncentive == null) {
			lblSumPayIncentive = new JLabel("??????????????????");
			lblSumPayIncentive.setBounds(362, 123, 163, 16);
		}
		return lblSumPayIncentive;
	}

	private JLabel getLblSumSalesquantity() {
		if (lblSumSalesquantity == null) {
			lblSumSalesquantity = new JLabel("??? ????????????");
			lblSumSalesquantity.setBounds(194, 338, 156, 16);
		}
		return lblSumSalesquantity;
	}

	private JLabel getLblSumSalesprice() {
		if (lblSumSalesprice == null) {
			lblSumSalesprice = new JLabel("??? ????????????");
			lblSumSalesprice.setBounds(362, 338, 163, 16);
		}
		return lblSumSalesprice;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("????????????");
			lblNewLabel_1_1.setBounds(20, 335, 50, 23);
		}
		return lblNewLabel_1_1;
	}

	private JButton getBtnSearchPay() {
		if (btnSearchPay == null) {
			btnSearchPay = new JButton("????????????");
			btnSearchPay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableInitPay();
					staffPaySearch();
				}
			});
			btnSearchPay.setBounds(89, 87, 81, 29);
		}
		return btnSearchPay;
	}

	private JButton getBtnSearchSales() {
		if (btnSearchSales == null) {
			btnSearchSales = new JButton("????????????");
			btnSearchSales.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableInitSales();
					staffSalesSearch();
				}
			});
			btnSearchSales.setBounds(89, 302, 81, 29);
		}
		return btnSearchSales;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("??????????????????");
			lblNewLabel_2.setBounds(20, 307, 74, 16);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("??????????????????");
			lblNewLabel_2_1.setBounds(20, 92, 74, 16);
		}
		return lblNewLabel_2_1;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel(CustomerInfo.position + "\t" + CustomerInfo.staffname + "???");
			lblNewLabel_3.setBounds(21, 65, 132, 16);
		}
		return lblNewLabel_3;
	}

	// ------------------------------------

	private void TableInitPay() {

		Outer_tbPay.addColumn("??????");
		Outer_tbPay.addColumn("??????????????????");
		Outer_tbPay.addColumn("????????????????????????");
		Outer_tbPay.addColumn("????????????");

		Outer_tbPay.setColumnCount(4);

		int i = Outer_tbPay.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_tbPay.removeRow(0);
		}

		tbPay.setAutoResizeMode(tbPay.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = tbPay.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbPay.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbPay.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbPay.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);

	}

	private void TableInitSales() {

		Outer_tbSales.addColumn("??????");
		Outer_tbSales.addColumn("??????");
		Outer_tbSales.addColumn("??????");
		Outer_tbSales.addColumn("??????");
		Outer_tbSales.addColumn("????????????");

		Outer_tbSales.setColumnCount(5);

		int i = Outer_tbSales.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_tbSales.removeRow(0);
		}

		tbSales.setAutoResizeMode(tbSales.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = tbSales.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbSales.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbSales.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbSales.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = tbSales.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);

	}

	private int staffPaySearch() {
		StaffViewPaymentDao dao = new StaffViewPaymentDao();
		ArrayList<PayDto> dtoList = dao.selectStaffPay();
		int listCount = dtoList.size();

		int wkPayAmount = 0;
		int wkPayIncentive = 0;

		for (int i = 0; i < listCount; i++) {
			int temp = dtoList.get(i).getPaystaffid();
			String[] qTxt = { Integer.toString(i + 1), Integer.toString(dtoList.get(i).getPayamount()) + "???",
					Integer.toString(dtoList.get(i).getPayincentive()) + "???", dtoList.get(i).getPaydate() };
			Outer_tbPay.addRow(qTxt);

			wkPayAmount += dtoList.get(i).getPayamount();
			wkPayIncentive += dtoList.get(i).getPayincentive();
		}
		lblSumPayAmount.setText("???????????? = " + Integer.toString(wkPayAmount) + "???");
		lblSumPayIncentive.setText("?????????????????? = " + Integer.toString(wkPayIncentive) + "???");

		return listCount;
	}

	private int cbPayDateSearch() {

		StaffViewPaymentDao dao = new StaffViewPaymentDao();
		// dao.cbDate ??? ??????
		dao.cbDate = cbPayMonth.getItemAt(cbPayMonth.getSelectedIndex()).toString();
		// dao.selectCbDate ???????????? dtoList??? ??????
		ArrayList<PayDto> dtoList = dao.selectPayYM();
		// ??????
		int listCount = dtoList.size();
		int wkPayAmount = 0;
		int wkPayIncentive = 0;
		for (int i = 0; i < listCount; i++) {
			int temp = dtoList.get(i).getPaystaffid();
			String[] qTxt = { Integer.toString(i + 1), Integer.toString(dtoList.get(i).getPayamount()) + "???",
					Integer.toString(dtoList.get(i).getPayincentive()) + "???", dtoList.get(i).getPaydate() };
			Outer_tbPay.addRow(qTxt);

			wkPayAmount += dtoList.get(i).getPayamount();
			wkPayIncentive += dtoList.get(i).getPayincentive();
		}
		lblSumPayAmount.setText("???????????? = " + Integer.toString(wkPayAmount) + "???");
		lblSumPayIncentive.setText("?????????????????? = " + Integer.toString(wkPayIncentive) + "???");

		return listCount;
	}

	private void updatePayCombo() {
		StaffViewPaymentDao dao = new StaffViewPaymentDao();
		ArrayList<String> cbPayDate = dao.loadPayYM();
		int i = 0;
		while (dao.loadPayYM().size() > i) {
			cbPayMonth.addItem(cbPayDate.get(i));
			i++;
		}
	}

	private int staffSalesSearch() {
		StaffViewSalesDao dao = new StaffViewSalesDao();
		ArrayList<OrdersDto> dtoList = dao.selectStaffSales();

		int listCount = dtoList.size();

		int wkOrdersQuantity = 0;
		int wkOrdersSaleprice = 0;

		for (int i = 0; i < listCount; i++) {
			int temp = dtoList.get(i).getOrdersstaffid();
			String[] qTxt = { Integer.toString(i + 1), dtoList.get(i).getOrdersmmanageid(),
					Integer.toString(dtoList.get(i).getOrdersquantity()),
					Integer.toString(dtoList.get(i).getOrderssaleprice()), dtoList.get(i).getOrdersdate() };
			Outer_tbSales.addRow(qTxt);

			wkOrdersQuantity += dtoList.get(i).getOrdersquantity();
			wkOrdersSaleprice += dtoList.get(i).getOrderssaleprice();
		}

		lblSumSalesquantity.setText("??? ???????????? = " + Integer.toString(wkOrdersQuantity) + "???");
		lblSumSalesprice.setText("??? ???????????? = " + Integer.toString(wkOrdersSaleprice) + "???");

		return listCount;
	}

	private int cbSalesDateSearch() {

		StaffViewSalesDao dao = new StaffViewSalesDao();
		// dao.cbDate ??? ??????
		dao.cbDate = cbSalesMonth.getItemAt(cbSalesMonth.getSelectedIndex()).toString();
		// dao.selectCbDate ???????????? dtoList??? ??????
		ArrayList<OrdersDto> dtoList = dao.selectSalesYM();
		// ??????
		int listCount = dtoList.size();

		int wkOrdersQuantity = 0;
		int wkOrdersSaleprice = 0;

		for (int i = 0; i < listCount; i++) {
			int temp = dtoList.get(i).getOrdersstaffid();
			String[] qTxt = { Integer.toString(i + 1), dtoList.get(i).getOrdersmmanageid(),
					Integer.toString(dtoList.get(i).getOrdersquantity()),
					Integer.toString(dtoList.get(i).getOrderssaleprice()), dtoList.get(i).getOrdersdate() };
			Outer_tbSales.addRow(qTxt);

			wkOrdersQuantity += dtoList.get(i).getOrdersquantity();
			wkOrdersSaleprice += dtoList.get(i).getOrderssaleprice();
		}
		lblSumSalesquantity.setText("??? ???????????? = " + Integer.toString(wkOrdersQuantity) + "???");
		lblSumSalesprice.setText("??? ???????????? = " + Integer.toString(wkOrdersSaleprice) + "???");

		return listCount;
	}

	private void updateSalesCombo() {
		StaffViewSalesDao dao = new StaffViewSalesDao();
		ArrayList<String> cbSalesDate = dao.loadSalesYM();
		int i = 0;
		while (dao.loadSalesYM().size() > i) {
			cbSalesMonth.addItem(cbSalesDate.get(i));
			i++;
		}
	}

}
