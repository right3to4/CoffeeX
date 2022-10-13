package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.NoticeDto;
import com.coffeex.dto.OrdersViewDto;
import com.coffeex.kioskdao.KioskViewMenuDao;
import com.coffeex.staffdao.ManagerViewOrdersDao;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTable;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffViewOrders {
	int click = 0;
	private JFrame frmCoffeex;
	private JLabel lblNewLabel;
	private JLabel lbUpdateInfo;
	private JLabel lbChangeMenu;
	private JLabel lbPayment;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JScrollPane spOrderMade;
	private JScrollPane spOrderWait;
	private JLabel lblNewLabel_3_1_1;
	private JScrollPane spOrderComplete;
	private JLabel lblNewLabel_2_1;
	private JLabel lbPromote;
	private JLabel lbStaffPayManege;
	private JLabel lbStaffInsertDel;
	private final DefaultTableModel Outer_OrderWait = new DefaultTableModel();
	private final DefaultTableModel Outer_OrderMade = new DefaultTableModel();
	private final DefaultTableModel Outer_OrderComplete = new DefaultTableModel();
	private JTable tbOrderComplete;
	private JTable tbOrderWait;
	private JTable tbOrderMade;
	private JLabel lbNotice;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblOrdersWaiting;
	private JLabel lblOrdersMaking;
	private JLabel lblOrdersComplete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffViewOrders window = new StaffViewOrders();
					window.frmCoffeex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StaffViewOrders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCoffeex = new JFrame();
		frmCoffeex.getContentPane().setBackground(new Color(238, 238, 238));
		frmCoffeex.setTitle("CoffeeX");
		frmCoffeex.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				OrderWaitTableInit();
				OrderMadeTableInit();
				OrderCompleteTableInit();
//				OrderCompleteTableInit();
//				OrderNoticeTableInit();
			}

			@Override
			public void windowOpened(WindowEvent e) {
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub

						// Outer_Notice.fireTableRowsUpdated(0, NoticeSearchAction());
//						OrderNoticeTableInit();
//						NoticeSearchAction();

						refresh();

					}
				};

				timer.schedule(task, 0, 3000);
			}

		});

		frmCoffeex.setBounds(100, 100, 900, 600);
		frmCoffeex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoffeex.getContentPane().setLayout(null);
		frmCoffeex.getContentPane().add(getLbPayment());
//		frmCoffeex.getContentPane().add(getLbChangeMenu());
		frmCoffeex.getContentPane().add(getLbUpdateInfo());
		frmCoffeex.getContentPane().add(getLblNewLabel_3());
		frmCoffeex.getContentPane().add(getLblNewLabel_3_1());
		frmCoffeex.getContentPane().add(getSpOrderMade());
		frmCoffeex.getContentPane().add(getSpOrderWait());
		frmCoffeex.getContentPane().add(getLblNewLabel_3_1_1());
		frmCoffeex.getContentPane().add(getSpOrderComplete());
		frmCoffeex.getContentPane().add(getLblNewLabel_2_1());
		frmCoffeex.getContentPane().add(getLbPromote());
//		frmCoffeex.getContentPane().add(getLbStaffPayManege());
//		frmCoffeex.getContentPane().add(getLbStaffInsertDel());
//		frmCoffeex.getContentPane().add(getLbNotice());
		frmCoffeex.getContentPane().add(getLblNewLabel());
		frmCoffeex.getContentPane().add(getBtnNewButton());
		frmCoffeex.getContentPane().add(getBtnNewButton_1());
		frmCoffeex.getContentPane().add(getLblOrdersWaiting());
		frmCoffeex.getContentPane().add(getLblOrdersMaking());
		frmCoffeex.getContentPane().add(getLblOrdersComplete());
		lblNewLabel_2_1.setText(CustomerInfo.position + "\t" + CustomerInfo.staffname + "님");

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("  CoffeeX");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lblNewLabel.setBackground(new Color(148, 128, 96));
			lblNewLabel.setBounds(0, 0, 900, 50);
		}
		return lblNewLabel;
	}

	private JLabel getLbUpdateInfo() {
		if (lbUpdateInfo == null) {
			lbUpdateInfo = new JLabel("마이페이지");
			lbUpdateInfo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StaffUpdateInfo.main(null);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lbUpdateInfo.setForeground(Color.black);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lbUpdateInfo.setForeground(Color.white);
				}

			});
			lbUpdateInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lbUpdateInfo.setForeground(Color.WHITE);
			lbUpdateInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lbUpdateInfo.setBounds(760, 0, 140, 50);
		}
		return lbUpdateInfo;
	}

//	private JLabel getLbChangeMenu() {
//		if (lbChangeMenu == null) {
//			lbChangeMenu = new JLabel("메뉴등록");
//			lbChangeMenu.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					ManagerChangeMenu.main(null);
//				}
//
//				@Override
//				public void mousePressed(MouseEvent e) {
//					lbChangeMenu.setForeground(Color.black);
//				}
//
//				@Override
//				public void mouseReleased(MouseEvent e) {
//					lbChangeMenu.setForeground(Color.white);
//				}
//
//			});
//			lbChangeMenu.setHorizontalAlignment(SwingConstants.CENTER);
//			lbChangeMenu.setForeground(Color.WHITE);
//			lbChangeMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
//			lbChangeMenu.setBounds(608, 0, 140, 50);
//		}
//		return lbChangeMenu;
//	}

	private JLabel getLbPayment() {
		if (lbPayment == null) {
			lbPayment = new JLabel("급여 및 판매내역");
			lbPayment.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StaffViewPayment.main(null);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lbPayment.setForeground(Color.black);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lbPayment.setForeground(Color.white);
				}
			});
			lbPayment.setHorizontalAlignment(SwingConstants.CENTER);
			lbPayment.setForeground(Color.WHITE);
			lbPayment.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lbPayment.setBounds(566, 0, 182, 50);
		}
		return lbPayment;
	}

//	private JLabel getLbNotice() {
//		if (lbNotice == null) {
//			lbNotice = new JLabel("공지사항");
//			lbNotice.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					StaffViewNotice.main(null);
//				}
//
//				@Override
//				public void mousePressed(MouseEvent e) {
//					lbNotice.setForeground(Color.black);
//				}
//
//				@Override
//				public void mouseReleased(MouseEvent e) {
//					lbNotice.setForeground(Color.white);
//				}
//			});
//			lbNotice.setHorizontalAlignment(SwingConstants.CENTER);
//			lbNotice.setForeground(Color.WHITE);
//			lbNotice.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
//			lbNotice.setBounds(405, 0, 117, 50);
//		}
//		return lbNotice;
//	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("주문 대기");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(145, 60, 117, 25);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("제조 중");
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3_1.setBounds(145, 216, 117, 25);
		}
		return lblNewLabel_3_1;
	}

	private JScrollPane getSpOrderMade() {
		if (spOrderMade == null) {
			spOrderMade = new JScrollPane();
			spOrderMade.setBounds(145, 253, 550, 110);
			spOrderMade.setViewportView(getTbOrderMade());

		}
		return spOrderMade;
	}

	private JScrollPane getSpOrderWait() {
		if (spOrderWait == null) {
			spOrderWait = new JScrollPane();
			spOrderWait.setBounds(145, 97, 550, 110);
			spOrderWait.setViewportView(getTbOrderWait());

		}
		return spOrderWait;
	}

	private JScrollPane getSpOrderComplete() {
		if (spOrderComplete == null) {
			spOrderComplete = new JScrollPane();
			spOrderComplete.setBounds(145, 417, 550, 110);
			spOrderComplete.setViewportView(getTbOrderComplete());
		}
		return spOrderComplete;
	}

	private JTable getTbOrderWait() {
		if (tbOrderWait == null) {
			tbOrderWait = new JTable();
			tbOrderWait.setShowVerticalLines(false);
			tbOrderWait.setShowHorizontalLines(false);
			tbOrderWait.setShowGrid(false);
			tbOrderWait.setModel(Outer_OrderWait);
		}
		return tbOrderWait;
	}

	private JTable getTbOrderMade() {
		if (tbOrderMade == null) {
			tbOrderMade = new JTable();
			tbOrderMade.setShowVerticalLines(false);
			tbOrderMade.setShowHorizontalLines(false);
			tbOrderMade.setShowGrid(false);
			tbOrderMade.setModel(Outer_OrderMade);
		}
		return tbOrderMade;
	}

	private JTable getTbOrderComplete() {
		if (tbOrderComplete == null) {
			tbOrderComplete = new JTable();
			tbOrderComplete.setShowVerticalLines(false);
			tbOrderComplete.setShowHorizontalLines(false);
			tbOrderComplete.setShowGrid(false);
			tbOrderComplete.setModel(Outer_OrderComplete);
		}
		return tbOrderComplete;
	}

	private JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("제조 완료");
			lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3_1_1.setBounds(145, 380, 145, 25);
		}
		return lblNewLabel_3_1_1;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("이름");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			lblNewLabel_2_1.setBounds(10, 58, 140, 28);
		}
		return lblNewLabel_2_1;
	}

	private JLabel getLbPromote() {
		if (lbPromote == null) {
			lbPromote = new JLabel("직원");
			lbPromote.setForeground(Color.WHITE);
			lbPromote.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lbPromote.setBounds(130, 8, 97, 30);
		}
		return lbPromote;
	}

//	private JLabel getLbStaffPayManege() {
//		if (lbStaffPayManege == null) {
//			lbStaffPayManege = new JLabel("사원급여관리");
//			lbStaffPayManege.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					ManagerViewPayment.main(null);
//					lbStaffInsertDel.setVisible(false);
//					lbStaffPayManege.setVisible(false);
//					lbStaffManage.setForeground(Color.white);
//				}
//			});
//
//			lbStaffPayManege.setHorizontalAlignment(SwingConstants.CENTER);
//			lbStaffPayManege.setForeground(Color.BLACK);
//			lbStaffPayManege.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//			lbStaffPayManege.setBounds(304, 50, 140, 25);
//		}
//		lbStaffPayManege.setVisible(false);
//		return lbStaffPayManege;
//	}

//	private JLabel getLbStaffInsertDel() {
//		if (lbStaffInsertDel == null) {
//			lbStaffInsertDel = new JLabel("사원등록/삭제");
//			lbStaffInsertDel.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					ManagerAddStaff.main(null);
//					lbStaffInsertDel.setVisible(false);
//					lbStaffPayManege.setVisible(false);
//					lbStaffManage.setForeground(Color.white);
//
//				}
//			});
//			lbStaffInsertDel.setHorizontalAlignment(SwingConstants.CENTER);
//			lbStaffInsertDel.setForeground(Color.BLACK);
//			lbStaffInsertDel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//			lbStaffInsertDel.setBounds(304, 75, 140, 25);
//		}
//		lbStaffInsertDel.setVisible(false);
//		return lbStaffInsertDel;
//	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("제조");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerViewOrdersDao dao = new ManagerViewOrdersDao();
					int orderid = orderWaitTableClick();
					dao.AlterStatus(orderid, "제조중");
					refresh();
				}
			});
			btnNewButton.setBounds(604, 60, 91, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("완료");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ManagerViewOrdersDao dao = new ManagerViewOrdersDao();
					int orderid = orderMadeTableClick();
					dao.AlterStatus(orderid, "제조완료");
					refresh();
				}
			});
			btnNewButton_1.setBounds(604, 220, 91, 23);
		}
		return btnNewButton_1;
	}

	// ----------------------------function---------------------------------
	private void OrderCompleteTableInit() {

		Outer_OrderComplete.addColumn("주문번호");
		Outer_OrderComplete.addColumn("메뉴");
		Outer_OrderComplete.addColumn("옵션");
		Outer_OrderComplete.addColumn("수량");
		Outer_OrderComplete.addColumn("포장");

		Outer_OrderComplete.setColumnCount(5);

		int i = Outer_OrderComplete.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_OrderComplete.removeRow(0);
		}

		tbOrderComplete.setAutoResizeMode(tbOrderComplete.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = tbOrderComplete.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbOrderComplete.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbOrderComplete.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbOrderComplete.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = tbOrderComplete.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}

	private void OrderMadeTableInit() {

		Outer_OrderMade.addColumn("주문번호");
		Outer_OrderMade.addColumn("메뉴");
		Outer_OrderMade.addColumn("옵션");
		Outer_OrderMade.addColumn("수량");
		Outer_OrderMade.addColumn("포장");

		Outer_OrderMade.setColumnCount(5);

		int i = Outer_OrderMade.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_OrderMade.removeRow(0);
		}

		tbOrderMade.setAutoResizeMode(tbOrderMade.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 4;
		col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}

	private void OrderWaitTableInit() {

		Outer_OrderWait.addColumn("주문번호");
		Outer_OrderWait.addColumn("메뉴");
		Outer_OrderWait.addColumn("옵션");
		Outer_OrderWait.addColumn("수량");
		Outer_OrderWait.addColumn("포장");

		Outer_OrderWait.setColumnCount(5);

		int i = Outer_OrderWait.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_OrderWait.removeRow(0);
		}

		tbOrderWait.setAutoResizeMode(tbOrderWait.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}

	private int orderWaitTableClick() {
		int i = tbOrderWait.getSelectedRow();
		int orderid = Integer.parseInt((String) tbOrderWait.getValueAt(i, 0));
		return orderid;
	}

	private int orderMadeTableClick() {
		int i = tbOrderMade.getSelectedRow();
		int orderid = Integer.parseInt((String) tbOrderMade.getValueAt(i, 0));
		return orderid;
	}

	private void searchMenuWait() {
		ManagerViewOrdersDao dao = new ManagerViewOrdersDao();
		ArrayList<OrdersViewDto> dtoList = dao.ShowOrdersListByStatus("주문접수");

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			int orderid = dtoList.get(index).getOrderid();
			String menu = dtoList.get(index).getMenuname();
			String option = dtoList.get(index).getOrdersoptions();
			int quantity = dtoList.get(index).getQuantity();
			String place = dtoList.get(index).getOrderplace();
			String[] qTxt = { Integer.toString(orderid), menu, option, Integer.toString(quantity), place };
			Outer_OrderWait.addRow(qTxt);
		}
	}

	private void searchMenuMade() {
		ManagerViewOrdersDao dao = new ManagerViewOrdersDao();
		ArrayList<OrdersViewDto> dtoList = dao.ShowOrdersListByStatus("제조중");

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			int orderid = dtoList.get(index).getOrderid();
			String menu = dtoList.get(index).getMenuname();
			String option = dtoList.get(index).getOrdersoptions();
			int quantity = dtoList.get(index).getQuantity();
			String place = dtoList.get(index).getOrderplace();
			String[] qTxt = { Integer.toString(orderid), menu, option, Integer.toString(quantity), place };
			Outer_OrderMade.addRow(qTxt);
		}
	}

	private void searchMenuComplete() {
		ManagerViewOrdersDao dao = new ManagerViewOrdersDao();
		ArrayList<OrdersViewDto> dtoList = dao.ShowOrdersListByStatus("제조완료");

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			int orderid = dtoList.get(index).getOrderid();
			String menu = dtoList.get(index).getMenuname();
			String option = dtoList.get(index).getOrdersoptions();
			int quantity = dtoList.get(index).getQuantity();
			String place = dtoList.get(index).getOrderplace();
			String[] qTxt = { Integer.toString(orderid), menu, option, Integer.toString(quantity), place };
			Outer_OrderComplete.addRow(qTxt);
		}
	}

	public void refresh() {
		int i = Outer_OrderWait.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_OrderWait.removeRow(0);
		}

		i = Outer_OrderMade.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_OrderMade.removeRow(0);
		}

		i = Outer_OrderComplete.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_OrderComplete.removeRow(0);
		}
		searchMenuMade();
		searchMenuWait();
		searchMenuComplete();
		lblOrdersWaiting.setText("총 " + Outer_OrderWait.getRowCount() + "건");
		lblOrdersMaking.setText("총 " + Outer_OrderMade.getRowCount() + "건");
		lblOrdersComplete.setText("총 " + Outer_OrderComplete.getRowCount() + "건");
	}

	private JLabel getLblOrdersWaiting() {
		if (lblOrdersWaiting == null) {
			lblOrdersWaiting = new JLabel("New label");
			lblOrdersWaiting.setFont(new Font("굴림", Font.PLAIN, 15));
			lblOrdersWaiting.setBounds(707, 184, 63, 23);
		}
		return lblOrdersWaiting;
	}

	private JLabel getLblOrdersMaking() {
		if (lblOrdersMaking == null) {
			lblOrdersMaking = new JLabel("New label");
			lblOrdersMaking.setFont(new Font("굴림", Font.PLAIN, 15));
			lblOrdersMaking.setBounds(707, 340, 63, 23);
		}
		return lblOrdersMaking;
	}

	private JLabel getLblOrdersComplete() {
		if (lblOrdersComplete == null) {
			lblOrdersComplete = new JLabel("New label");
			lblOrdersComplete.setFont(new Font("굴림", Font.PLAIN, 15));
			lblOrdersComplete.setBounds(707, 504, 63, 23);
		}
		return lblOrdersComplete;
	}
}
