package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.NoticeDto;
import com.coffeex.staffdao.ManagerViewOrdersDao;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTable;
import java.awt.Window.Type;
import javax.swing.ListSelectionModel;

public class ManagerViewOrders {
	int click = 0;
	private JFrame frmCoffeex;
	private JLabel lblNewLabel;
	private JLabel lbUpdateInfo;
	private JLabel lbChangeMenu;
	private JLabel lbPayment;
	private JLabel lbStaffManage;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JScrollPane spOrderMade;
	private JScrollPane spOrderWait;
	private JLabel lblNewLabel_3_1_1;
	private JLabel lblNewLabel_3_1_1_1;
	private JScrollPane spNotice;
	private JScrollPane spOrderComplete;
	private JLabel lblNewLabel_2_1;
	private JLabel lbPromote;
	private JLabel lbStaffPayManege;
	private JLabel lbStaffInsertDel;
	private final DefaultTableModel Outer_OrderWait = new DefaultTableModel();
	private final DefaultTableModel Outer_OrderMade = new DefaultTableModel();
	private final DefaultTableModel Outer_OrderComplete = new DefaultTableModel();
	private JTable tbOrderComplete;
	private JTable tbNotice;
	private final DefaultTableModel Outer_Notice = new DefaultTableModel();
	private JTable tbOrderWait;
	private JTable tbOrderMade;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerViewOrders window = new ManagerViewOrders();
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
	public ManagerViewOrders() {
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
				//OrderNoticeTableInit();
			}
			@Override
			public void windowOpened(WindowEvent e) {
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
	
						//Outer_Notice.fireTableRowsUpdated(0, NoticeSearchAction());
						OrderNoticeTableInit();
						NoticeSearchAction();
						
					}
				};
				
				
				timer.schedule(task, 0, 1000);
			}
		});
		
		frmCoffeex.setBounds(100, 100, 900, 600);
		frmCoffeex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoffeex.getContentPane().setLayout(null);
		frmCoffeex.getContentPane().add(getLbStaffManage());
		frmCoffeex.getContentPane().add(getLbPayment());
		frmCoffeex.getContentPane().add(getLbChangeMenu());
		frmCoffeex.getContentPane().add(getLbUpdateInfo());
		frmCoffeex.getContentPane().add(getLblNewLabel_3());
		frmCoffeex.getContentPane().add(getLblNewLabel_3_1());
		frmCoffeex.getContentPane().add(getSpOrderMade());
		frmCoffeex.getContentPane().add(getSpOrderWait());
		frmCoffeex.getContentPane().add(getLblNewLabel_3_1_1());
		frmCoffeex.getContentPane().add(getLblNewLabel_3_1_1_1());
		frmCoffeex.getContentPane().add(getSpNotice());
		frmCoffeex.getContentPane().add(getSpOrderComplete());
		frmCoffeex.getContentPane().add(getLblNewLabel_2_1());
		frmCoffeex.getContentPane().add(getLbPromote());
		frmCoffeex.getContentPane().add(getLbStaffPayManege());
		frmCoffeex.getContentPane().add(getLbStaffInsertDel());
		frmCoffeex.getContentPane().add(getLblNewLabel());
		
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
					if(click%2 == 0) {
						lbStaffManage.setForeground(Color.black);
						lbStaffPayManege.setVisible(true);
						lbStaffInsertDel.setVisible(true);	
					}else {
						lbStaffManage.setForeground(Color.white);
						lbStaffPayManege.setVisible(false);
						lbStaffInsertDel.setVisible(false);
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
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("주문 대기");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(81, 118, 117, 25);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("제조 중");
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3_1.setBounds(491, 118, 117, 25);
		}
		return lblNewLabel_3_1;
	}
	private JScrollPane getSpOrderMade() {
		if (spOrderMade == null) {
			spOrderMade = new JScrollPane();
			spOrderMade.setBounds(491, 155, 350, 170);
			spOrderMade.setViewportView(getTbOrderMade());
		
		}
		return spOrderMade;
	}
	private JScrollPane getSpOrderWait() {
		if (spOrderWait == null) {
			spOrderWait = new JScrollPane();
			spOrderWait.setBounds(81, 155, 350, 170);
			spOrderWait.setViewportView(getTbOrderWait());

		}
		return spOrderWait;
	}
	private JScrollPane getSpNotice() {
		if (spNotice == null) {
			spNotice = new JScrollPane();
			spNotice.setBounds(395, 382, 446, 170);
			spNotice.setViewportView(getTbNotice());
		}
		return spNotice;
	}
	private JScrollPane getSpOrderComplete() {
		if (spOrderComplete == null) {
			spOrderComplete = new JScrollPane();
			spOrderComplete.setBounds(81, 382, 250, 170);
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
	private JTable getTbNotice() {
		if (tbNotice == null) {
			tbNotice = new JTable();
			tbNotice.setShowGrid(false);
			tbNotice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbNotice.setShowVerticalLines(false);
			tbNotice.setShowHorizontalLines(false);
			tbNotice.setModel(Outer_Notice);
		}
		return tbNotice;
	}
	private JLabel getLblNewLabel_3_1_1() {
		if (lblNewLabel_3_1_1 == null) {
			lblNewLabel_3_1_1 = new JLabel("제조 완료 현황");
			lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3_1_1.setBounds(81, 345, 117, 25);
		}
		return lblNewLabel_3_1_1;
	}
	private JLabel getLblNewLabel_3_1_1_1() {
		if (lblNewLabel_3_1_1_1 == null) {
			lblNewLabel_3_1_1_1 = new JLabel("공지사항");
			lblNewLabel_3_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			lblNewLabel_3_1_1_1.setBounds(395, 345, 117, 25);
		}
		return lblNewLabel_3_1_1_1;
	}
	
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("이름");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_2_1.setBounds(47, 62, 125, 28);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLbPromote() {
		if (lbPromote == null) {
			lbPromote = new JLabel("점장");
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
					ManagerAddStaff.main(null);
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
	
	private void OrderCompleteTableInit() {

		Outer_OrderComplete.addColumn("주문번호");
		Outer_OrderComplete.addColumn("메뉴");
		Outer_OrderComplete.addColumn("옵션");

		Outer_OrderComplete.setColumnCount(3);

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
		width = 100;
		col.setPreferredWidth(width);

	}
	
	private void OrderMadeTableInit() {

		Outer_OrderMade.addColumn("주문번호");
		Outer_OrderMade.addColumn("메뉴");
		Outer_OrderMade.addColumn("옵션");
		Outer_OrderMade.addColumn("주문시간");

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
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = tbOrderMade.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}
	
	private void OrderWaitTableInit() {

		Outer_OrderWait.addColumn("주문번호");
		Outer_OrderWait.addColumn("메뉴");
		Outer_OrderWait.addColumn("옵션");
		Outer_OrderWait.addColumn("주문시간");

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
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = tbOrderWait.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}
	
	private void OrderNoticeTableInit() {
		
		Outer_Notice.addColumn("No.");
		Outer_Notice.addColumn("제목");
		Outer_Notice.addColumn("작성일");
		Outer_Notice.addColumn("수정일자");

		Outer_Notice.setColumnCount(4);

		int i = Outer_Notice.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Notice.removeRow(0);
		}

		tbNotice.setAutoResizeMode(tbNotice.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = tbNotice.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = tbNotice.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tbNotice.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = tbNotice.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

	}
	
	private int NoticeSearchAction() {
		ManagerViewOrdersDao dao = new ManagerViewOrdersDao();
		ArrayList<NoticeDto> dtoList = dao.SelecNoticetList();
		int listCount = dtoList.size();
		
		for (int index = 0; index < listCount; index++) {
			int temp = dtoList.get(index).getNoticeid();
			String[] qTxt = { Integer.toString(temp), dtoList.get(index).getNoticetitle(), dtoList.get(index).getNoticeinsertdate(), dtoList.get(index).getNoticeupdatedate()};
			Outer_Notice.addRow(qTxt);
		}
		return listCount;
	}
	
//	private void NoticeSearchAction() {
//		ManagerViewOrdersDao dao = new ManagerViewOrdersDao();
//		ArrayList<NoticeDto> dtoList = dao.SelecNoticetList();
//		int listCount = dtoList.size();
//		
//		for (int index = 0; index < listCount; index++) {
//			int temp = dtoList.get(index).getNoticeid();
//			String[] qTxt = { Integer.toString(temp), dtoList.get(index).getNoticetitle(), dtoList.get(index).getNoticeinsertdate(), dtoList.get(index).getNoticeupdatedate()};
//			Outer_Notice.addRow(qTxt);
//		}
//	}

}
