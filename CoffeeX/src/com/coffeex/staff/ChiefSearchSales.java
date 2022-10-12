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

public class ChiefSearchSales {
	int click = 0;
	private JFrame frmCoffeex;
	private JLabel lblNewLabel;
	private JLabel lbUpdateInfo;
	private JLabel lbChangeMenu;
	private JLabel lbPayment;
	private JLabel lbStaffManage;
	private JLabel lbName;
	private JLabel lbPromote;
	private JLabel lbStaffPayManege;
	private JLabel lbStaffInsertDel;
	private final DefaultTableModel Outer_OrderWait = new DefaultTableModel();
	private final DefaultTableModel Outer_OrderMade = new DefaultTableModel();
	private final DefaultTableModel Outer_OrderComplete = new DefaultTableModel();
	private JLabel lbNotice;
	private JLabel lbShopInsert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiefSearchSales window = new ChiefSearchSales();
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
	public ChiefSearchSales() {
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
//				OrderWaitTableInit();
//				OrderMadeTableInit();
//				OrderCompleteTableInit();
				lbName.setText(CustomerInfo.staffname);
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
						
//						refresh();

					}
				};

				timer.schedule(task, 0, 3000);
			}

		});

		frmCoffeex.setBounds(100, 100, 900, 600);
		frmCoffeex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoffeex.getContentPane().setLayout(null);
		frmCoffeex.getContentPane().add(getLbStaffManage());
		frmCoffeex.getContentPane().add(getLbPayment());
		frmCoffeex.getContentPane().add(getLbChangeMenu());
		frmCoffeex.getContentPane().add(getLbUpdateInfo());
		frmCoffeex.getContentPane().add(getLbName());
		frmCoffeex.getContentPane().add(getLbPromote());
		frmCoffeex.getContentPane().add(getLbStaffPayManege());
		frmCoffeex.getContentPane().add(getLbStaffInsertDel());
		frmCoffeex.getContentPane().add(getLbNotice());
		frmCoffeex.getContentPane().add(getLblNewLabel());
		frmCoffeex.getContentPane().add(getLbShopInsert());

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
					ManagerUpdateInfo.main(null);
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

	private JLabel getLbChangeMenu() {
		if (lbChangeMenu == null) {
			lbChangeMenu = new JLabel("메뉴등록");
			lbChangeMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ManagerChangeMenu.main(null);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lbChangeMenu.setForeground(Color.black);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lbChangeMenu.setForeground(Color.white);
				}

			});
			lbChangeMenu.setHorizontalAlignment(SwingConstants.CENTER);
			lbChangeMenu.setForeground(Color.WHITE);
			lbChangeMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lbChangeMenu.setBounds(608, 0, 140, 50);
		}
		return lbChangeMenu;
	}

	private JLabel getLbPayment() {
		if (lbPayment == null) {
			lbPayment = new JLabel("판매내역조회");
			lbPayment.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ManagerViewSales.main(null);
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
			lbPayment.setBounds(456, 0, 140, 50);
		}
		return lbPayment;
	}

	private JLabel getLbStaffManage() {
		if (lbStaffManage == null) {
			lbStaffManage = new JLabel("사원관리");
			lbStaffManage.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (click % 2 == 0) {
						lbStaffManage.setForeground(Color.black);
						lbStaffPayManege.setVisible(true);
						lbStaffInsertDel.setVisible(true);
						lbShopInsert.setVisible(true);
					} else {
						lbStaffManage.setForeground(Color.white);
						lbStaffPayManege.setVisible(false);
						lbStaffInsertDel.setVisible(false);
						lbShopInsert.setVisible(false);
					}
					click++;
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lbStaffManage.setForeground(Color.black);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lbStaffManage.setForeground(Color.white);
				}
			});
			lbStaffManage.setHorizontalAlignment(SwingConstants.CENTER);
			lbStaffManage.setForeground(Color.WHITE);
			lbStaffManage.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lbStaffManage.setBounds(304, 0, 140, 50);
		}
		return lbStaffManage;
	}

	private JLabel getLbNotice() {
		if (lbNotice == null) {
			lbNotice = new JLabel("공지사항");
			lbNotice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					StaffViewNotice.main(null);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					lbNotice.setForeground(Color.black);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					lbNotice.setForeground(Color.white);
				}
			});
			lbNotice.setHorizontalAlignment(SwingConstants.CENTER);
			lbNotice.setForeground(Color.WHITE);
			lbNotice.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lbNotice.setBounds(191, 0, 140, 50);
		}
		return lbNotice;
	}

	private JLabel getLbName() {
		if (lbName == null) {
			lbName = new JLabel("이름");
			lbName.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lbName.setBounds(47, 62, 125, 28);
		}
		return lbName;
	}

	private JLabel getLbPromote() {
		if (lbPromote == null) {
			lbPromote = new JLabel("관리자");
			lbPromote.setForeground(Color.WHITE);
			lbPromote.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
			lbPromote.setBounds(130, 8, 97, 30);
		}
		return lbPromote;
	}

	private JLabel getLbStaffPayManege() {
		if (lbStaffPayManege == null) {
			lbStaffPayManege = new JLabel("사원급여관리");
			lbStaffPayManege.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ManagerViewPayment.main(null);
					lbShopInsert.setVisible(false);
					lbStaffInsertDel.setVisible(false);
					lbStaffPayManege.setVisible(false);
					lbStaffManage.setForeground(Color.white);
				}
			});

			lbStaffPayManege.setHorizontalAlignment(SwingConstants.CENTER);
			lbStaffPayManege.setForeground(Color.BLACK);
			lbStaffPayManege.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lbStaffPayManege.setBounds(304, 50, 140, 25);
		}
		lbStaffPayManege.setVisible(false);
		return lbStaffPayManege;
	}

	private JLabel getLbStaffInsertDel() {
		if (lbStaffInsertDel == null) {
			lbStaffInsertDel = new JLabel("사원등록/삭제");
			lbStaffInsertDel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ChefUpdateStaff.main(null);
					lbShopInsert.setVisible(false);
					lbStaffInsertDel.setVisible(false);
					lbStaffPayManege.setVisible(false);
					lbStaffManage.setForeground(Color.white);

				}
			});
			lbStaffInsertDel.setHorizontalAlignment(SwingConstants.CENTER);
			lbStaffInsertDel.setForeground(Color.BLACK);
			lbStaffInsertDel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lbStaffInsertDel.setBounds(304, 75, 140, 25);
		}
		lbStaffInsertDel.setVisible(false);
		return lbStaffInsertDel;
	}
	private JLabel getLbShopInsert() {
		if (lbShopInsert == null) {
			lbShopInsert = new JLabel("지점등록");
			lbShopInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ChefManageShop.main(null);
					lbShopInsert.setVisible(false);
					lbStaffInsertDel.setVisible(false);
					lbStaffPayManege.setVisible(false);
					lbStaffManage.setForeground(Color.white);

				}
			});
			lbShopInsert.setHorizontalAlignment(SwingConstants.CENTER);
			lbShopInsert.setForeground(Color.BLACK);
			lbShopInsert.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lbShopInsert.setBounds(304, 100, 140, 25);
		}
		lbShopInsert.setVisible(false);
		return lbShopInsert;
	}
	

	// ----------------------------function---------------------------------
	private void OrderCompleteTableInit() {

		Outer_OrderComplete.addColumn("주문번호");
		Outer_OrderComplete.addColumn("메뉴");
		Outer_OrderComplete.addColumn("옵션");
		Outer_OrderComplete.addColumn("수량");

		Outer_OrderComplete.setColumnCount(4);

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
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbOrderComplete.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbOrderComplete.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

	}

	private void OrderMadeTableInit() {

		Outer_OrderMade.addColumn("주문번호");
		Outer_OrderMade.addColumn("메뉴");
		Outer_OrderMade.addColumn("옵션");
		Outer_OrderMade.addColumn("수량");

		Outer_OrderMade.setColumnCount(4);

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
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

	}

	private void OrderWaitTableInit() {

		Outer_OrderWait.addColumn("주문번호");
		Outer_OrderWait.addColumn("메뉴");
		Outer_OrderWait.addColumn("옵션");
		Outer_OrderWait.addColumn("수량");

		Outer_OrderWait.setColumnCount(4);

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
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		width = 150;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		width = 50;
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
			String[] qTxt = { Integer.toString(orderid), menu, option, Integer.toString(quantity) };
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
			String[] qTxt = { Integer.toString(orderid), menu, option, Integer.toString(quantity) };
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
			String[] qTxt = { Integer.toString(orderid), menu, option, Integer.toString(quantity) };
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
	}
	
}