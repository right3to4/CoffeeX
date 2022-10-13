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
import com.coffeex.staffdao.ChiefSearchSalesDao;
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
	private final DefaultTableModel Outer_Shop = new DefaultTableModel();
	private final DefaultTableModel Outer_Menu = new DefaultTableModel();
	private final DefaultTableModel Outer_Staff = new DefaultTableModel();
	private JLabel lbNotice;
	private JLabel lbShopInsert;
	private JScrollPane scrollPane;
	private JTable Inner_Shop;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_1_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_2;
	private JTable Inner_Menu;
	private JTable Inner_Staff;

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
				lbName.setText(CustomerInfo.staffname);
				shopTableInit();
				menuTableInit();
				staffTableInit();
				showSalesByShop("price", "asc");
				showSalesByMenu("price", "asc");
				showSalesByStaff("price", "asc");
			}

			@Override
			public void windowOpened(WindowEvent e) {
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {

					@Override
					public void run() {
						// TODO Auto-generated method stub

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
		frmCoffeex.getContentPane().add(getScrollPane());
		frmCoffeex.getContentPane().add(getScrollPane_1());
		frmCoffeex.getContentPane().add(getScrollPane_1_1());
		frmCoffeex.getContentPane().add(getLblNewLabel_1());
		frmCoffeex.getContentPane().add(getLblNewLabel_1_1());
		frmCoffeex.getContentPane().add(getLblNewLabel_1_1_1());
		frmCoffeex.getContentPane().add(getLblNewLabel_1_1_2());

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

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(16, 168, 250, 366);
			scrollPane.setViewportView(getInner_Shop());
		}
		return scrollPane;
	}

	private JTable getInner_Shop() {
		if (Inner_Shop == null) {
			Inner_Shop = new JTable();
			Inner_Shop.setModel(Outer_Shop);
		}
		return Inner_Shop;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(317, 168, 250, 366);
			scrollPane_1.setViewportView(getInner_Menu());
		}
		return scrollPane_1;
	}

	private JScrollPane getScrollPane_1_1() {
		if (scrollPane_1_1 == null) {
			scrollPane_1_1 = new JScrollPane();
			scrollPane_1_1.setBounds(626, 168, 250, 366);
			scrollPane_1_1.setViewportView(getInner_Staff());
		}
		return scrollPane_1_1;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("매출현황");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(341, 59, 152, 34);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("지점");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblNewLabel_1_1.setBounds(16, 124, 96, 34);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("메뉴");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblNewLabel_1_1_1.setBounds(317, 124, 96, 34);
		}
		return lblNewLabel_1_1_1;
	}

	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("직원");
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_1_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblNewLabel_1_1_2.setBounds(626, 124, 96, 34);
		}
		return lblNewLabel_1_1_2;
	}

	private JTable getInner_Menu() {
		if (Inner_Menu == null) {
			Inner_Menu = new JTable();
			Inner_Menu.setModel(Outer_Menu);
		}
		return Inner_Menu;
	}

	private JTable getInner_Staff() {
		if (Inner_Staff == null) {
			Inner_Staff = new JTable();
			Inner_Staff.setModel(Outer_Staff);
		}
		return Inner_Staff;
	}

	// ----------------------------function---------------------------------

	private void shopTableInit() {

		Outer_Shop.addColumn("지점명");
		Outer_Shop.addColumn("수량");
		Outer_Shop.addColumn("매출");

		Outer_Shop.setColumnCount(3);

		int i = Outer_Shop.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Shop.removeRow(0);
		}

		Inner_Shop.setAutoResizeMode(Inner_Shop.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = Inner_Shop.getColumnModel().getColumn(vColIndex);
		int width = 110;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Shop.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Shop.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
	}

	private void menuTableInit() {

		Outer_Menu.addColumn("메뉴");
		Outer_Menu.addColumn("수량");
		Outer_Menu.addColumn("매출");

		Outer_Menu.setColumnCount(3);

		int i = Outer_Menu.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Menu.removeRow(0);
		}

		Inner_Menu.setAutoResizeMode(Inner_Menu.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = Inner_Menu.getColumnModel().getColumn(vColIndex);
		int width = 110;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Menu.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Menu.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
		
	}

	private void staffTableInit() {

		Outer_Staff.addColumn("직원명");
		Outer_Staff.addColumn("수량");
		Outer_Staff.addColumn("매출");

		Outer_Staff.setColumnCount(3);

		int i = Outer_Staff.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Staff.removeRow(0);
		}

		Inner_Staff.setAutoResizeMode(Inner_Staff.AUTO_RESIZE_OFF);

		int vColIndex = 0;

		TableColumn col = Inner_Staff.getColumnModel().getColumn(vColIndex);
		int width = 110;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Staff.getColumnModel().getColumn(vColIndex);
		width = 60;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Staff.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

	}
	
	private void showSalesByShop(String group, String ad) {
		ChiefSearchSalesDao dao=new ChiefSearchSalesDao();
		ArrayList<OrdersViewDto> dtoList=dao.ShowSalesByShops(group, ad);
		
		for (int i=0;i<dtoList.size();i++) {
			String shop=dtoList.get(i).getMenuname();
			String quantity=Integer.toString(dtoList.get(i).getQuantity());
			String price=Integer.toString(dtoList.get(i).getPrice());
			
			String[] qTxt= {shop, quantity, price};
			Outer_Shop.addRow(qTxt);
		}
	}
	
	private void showSalesByMenu(String group, String ad) {
		ChiefSearchSalesDao dao=new ChiefSearchSalesDao();
		ArrayList<OrdersViewDto> dtoList=dao.ShowSalesByMenu(group, ad);
		
		for (int i=0;i<dtoList.size();i++) {
			String menu=dtoList.get(i).getMenuname();
			String quantity=Integer.toString(dtoList.get(i).getQuantity());
			String price=Integer.toString(dtoList.get(i).getPrice());
			
			String[] qTxt= {menu, quantity, price};
			Outer_Menu.addRow(qTxt);
		}
	}
	
	private void showSalesByStaff(String group, String ad) {
		ChiefSearchSalesDao dao=new ChiefSearchSalesDao();
		ArrayList<OrdersViewDto> dtoList=dao.ShowSalesByStaff(group, ad);
		
		for (int i=0;i<dtoList.size();i++) {
			String staff=dtoList.get(i).getMenuname();
			String quantity=Integer.toString(dtoList.get(i).getQuantity());
			String price=Integer.toString(dtoList.get(i).getPrice());
			
			String[] qTxt= {staff, quantity, price};
			Outer_Staff.addRow(qTxt);
		}
	}

}
