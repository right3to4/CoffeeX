package com.coffeex.kiosk;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.SwingConstants;

import com.coffeex.kioskdao.KioskOrderDao;
import com.coffeex.kioskdao.KioskSetOptionDao;
import com.coffeex.kioskdao.KioskViewMenuDao;

import java.awt.Font;

public class KioskInit {

	// 구성: 아래쪽은 공통 부분, 위쪽을 패널로 구현하여 변경하여 화면 전환

	private JFrame frame;
	private JLabel lblorderbutton;
	private KioskViewMenu panel; // 주문하기 패널
	private KioskSetOption kioskoption; // 옵션선택 패널
	private KioskOrder kioskorder;
	public static JLabel lblAddbutton;
	private JLabel lblCancelbutton;
	private JLabel lblAd;
	private JLabel lblConfirm;
	private JLabel lblFianalOrder;
	private JLabel lblReButton;
	public static String menuname;
	private JLabel lblPayButton;
	private KioskManage kioskmanage;

	KioskOrderDao dao0 = new KioskOrderDao();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskInit window = new KioskInit();
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
	public KioskInit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) { // 화면, 버튼 다 끄기
				lblAddbutton.setVisible(false);
				lblCancelbutton.setVisible(false);
				panel.setVisible(false);
				kioskoption.setVisible(false);
				lblConfirm.setVisible(false);
				kioskorder.setVisible(false);
				lblReButton.setVisible(false);
				lblPayButton.setVisible(false);
				kioskmanage.setVisible(false);
			}
		});
		frame.setBounds(100, 100, 466, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getKioskmanage());
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getKioskorder());
		frame.getContentPane().add(getKioskoption());
		frame.getContentPane().add(getLblorderbutton());
		frame.getContentPane().add(getLblAddbutton());
		frame.getContentPane().add(getLblCancelbutton());
		frame.getContentPane().add(getLblAd());
		frame.getContentPane().add(getLblConfirm());
		frame.getContentPane().add(getLblReButton());
		frame.getContentPane().add(getLblPayButton());
		frame.getContentPane().add(getLblNewLabel());

	}

	private JLabel getLblorderbutton() {
		if (lblorderbutton == null) {
			lblorderbutton = new JLabel("");
			lblorderbutton.setBounds(167, 464, 117, 40);
			lblorderbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // 주문하기 버튼 클릭 시
					panel.setVisible(true);
					lblCancelbutton.setVisible(true);
					lblorderbutton.setVisible(false);
				}
			});
			lblorderbutton
					.setIcon(new ImageIcon(KioskInit.class.getResource("/com/coffeex/kiosk/image/orderbutton.JPG")));

		}
		return lblorderbutton;
	}

	private JLabel getLblAd() {
		if (lblAd == null) {
			lblAd = new JLabel("");
			lblAd.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblAd.setHorizontalAlignment(SwingConstants.CENTER);
			lblAd.setIcon(new ImageIcon(KioskInit.class.getResource("/com/coffeex/kiosk/image/ad3.png")));
			lblAd.setBounds(12, 10, 426, 426);
		}
		return lblAd;
	}

	private KioskViewMenu getPanel() {
		if (panel == null) {
			panel = new KioskViewMenu();
			panel.setBounds(12, 10, 426, 444);
			panel.setLayout(null);
		}
		return panel;
	}

	private KioskManage getKioskmanage() {
		if (kioskmanage == null) {
			kioskmanage = new KioskManage();
			kioskmanage.setBounds(12, 10, 426, 444);
			kioskmanage.setLayout(null);
		}
		return kioskmanage;
	}

	private KioskOrder getKioskorder() {
		if (kioskorder == null) {
			kioskorder = new KioskOrder();
			kioskorder.setBounds(12, 10, 426, 444);
			kioskorder.setLayout(null);
		}
		return kioskorder;
	}

	private KioskSetOption getKioskoption() {
		if (kioskoption == null) {
			kioskoption = new KioskSetOption();
			kioskoption.setBounds(12, 10, 426, 444);
			kioskoption.setLayout(null);
		}
		return kioskoption;
	}

	private JLabel getLblAddbutton() {
		if (lblAddbutton == null) {
			lblAddbutton = new JLabel("추가");
			lblAddbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // 추가하기 버튼 눌렀을 때
					lblAddbutton.setVisible(false);
					panel.setVisible(false);
					kioskoption.setVisible(true);
					int i = panel.Inner_Table.getSelectedRow();
					menuname = (String) panel.Inner_Table.getValueAt(i, 1);
					lblConfirm.setVisible(true);
					kioskoption.lblMenuName.setText(menuname);
				}
			});
			lblAddbutton.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblAddbutton.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddbutton.setBounds(379, 464, 59, 40);
		}
		return lblAddbutton;
	}

	private JLabel getLblCancelbutton() {
		if (lblCancelbutton == null) {
			lblCancelbutton = new JLabel("취소");
			lblCancelbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // 초기화면으로 돌아가기
					reset();

					KioskOrderDao dao = new KioskOrderDao();
					dao.emptyCart("kiosk");
				}
			});
			lblCancelbutton.setHorizontalAlignment(SwingConstants.CENTER);
			lblCancelbutton.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblCancelbutton.setBounds(22, 464, 59, 40);
		}
		return lblCancelbutton;
	}

	private JLabel getLblConfirm() {
		if (lblConfirm == null) {
			lblConfirm = new JLabel("담기");
			lblConfirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = kioskorder.Outer_Table.getRowCount();

					for (int j = 0; j < i; j++) {
						kioskorder.Outer_Table.removeRow(0);
					}
					lblAddbutton.setVisible(false);
					kioskoption.setVisible(false);
					kioskorder.setVisible(true);
					lblReButton.setVisible(true);

					lblPayButton.setVisible(true);
					lblConfirm.setVisible(false);

					KioskOrderDao orderdao = new KioskOrderDao();
					KioskSetOptionDao optiondao = new KioskSetOptionDao();

					String wkmenuname = menuname;
					String wkmmanageid = optiondao.getMenuId(menuname);
					String wkcustid = "kiosk";
					int wkquantity = Integer.parseInt(kioskoption.lblQuantity.getText());
					String wkoption = kioskoption.hotice + kioskoption.shot + kioskoption.cream + kioskoption.syrup;
					boolean check = orderdao.checkCart(wkcustid, wkmenuname, wkoption);
					if (check == true) {
						orderdao.AddQuantity(wkmenuname, wkcustid, wkoption, wkquantity);
					} else {
						orderdao.AddCart(wkmmanageid, wkcustid, wkquantity, wkoption);
					}
					kioskorder.searchCart(wkcustid);
				}

			});
			lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
			lblConfirm.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblConfirm.setBounds(379, 464, 59, 40);
		}
		return lblConfirm;
	}

	private JLabel getLblPayButton() {
		if (lblPayButton == null) {
			lblPayButton = new JLabel("결제");
			lblPayButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					KioskOrderDao dao = new KioskOrderDao();
					if (kioskorder.paywithpoint == true) {
						if (dao.checkPoint(kioskorder.tfPhone.getText()) < sumPrice()) {
//							JOptionPane.showMessageDialog(null, "포인트 잔액이 부족합니다");
						} else {
							dao.usePoint(kioskorder.tfPhone.getText(), getCost());
							Pay();
						}
					} else {
//						JOptionPane.showMessageDialog(null, "결제가 완료되었습니다");
						Pay();
					}

					if (kioskorder.addpoint == true) {
						dao.addPoint(kioskorder.tfPhone.getText(), (int) (sumPrice() * 0.1));
					}
				}
			});
			lblPayButton.setHorizontalAlignment(SwingConstants.CENTER);
			lblPayButton.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblPayButton.setBounds(379, 464, 59, 40);
		}
		return lblPayButton;
	}

	private JLabel getLblReButton() {
		if (lblReButton == null) {
			lblReButton = new JLabel("더담기");
			lblReButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panel.Inner_Table.clearSelection();
					kioskoption.setOptionDefault();
					kioskorder.setVisible(false);
					panel.setVisible(true);
					lblReButton.setVisible(false);
					lblAddbutton.setVisible(false);
					lblConfirm.setVisible(false);
					lblPayButton.setVisible(false);
				}
			});
			lblReButton.setHorizontalAlignment(SwingConstants.CENTER);
			lblReButton.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblReButton.setBounds(318, 464, 59, 40);
		}
		return lblReButton;
	}

	private void reset() {
		panel.Inner_Table.clearSelection();
		lblAddbutton.setVisible(false);
		lblCancelbutton.setVisible(false);
		lblorderbutton.setVisible(true);
		panel.setVisible(false);
		kioskoption.setVisible(false);
		kioskoption.setOptionDefault();
		kioskorder.setVisible(false);
		lblReButton.setVisible(false);
		kioskoption.lblMenuName.setText("");
		lblPayButton.setVisible(false);
		kioskorder.panelPoint.setVisible(false);
		kioskorder.lblNewLabel_1_1.setBackground(new Color(240, 240, 240));
		kioskorder.lblNewLabel_1.setBackground(new Color(240, 240, 240));
		kioskorder.tfPhone.setText(null);
		kioskorder.lblStep2.setVisible(false);
		kioskorder.lblpointtrue.setVisible(false);
		kioskorder.lblpointtrue.setBackground(new Color(240, 240, 240));
		kioskorder.lblpointfalse.setBackground(new Color(240, 240, 240));
		kioskorder.lblpointfalse.setVisible(false);
		kioskorder.lblStep3.setVisible(false);
		kioskorder.lblwithpoint.setVisible(false);
		kioskorder.lblwithpoint.setBackground(new Color(240, 240, 240));
		kioskorder.lblwithcard.setBackground(new Color(240, 240, 240));
		kioskorder.lblwithcard.setVisible(false);
		kioskorder.tfPhone.setText(null);
		kioskorder.phone = new ArrayList<String>();
		dao0.emptyCart("kiosk");
	}

	private int getCost() {
		int sum = 0;
		for (int i = 0; i < kioskorder.Inner_Table.getRowCount(); i++) {
			sum = sum + (int) kioskorder.Inner_Table.getValueAt(i, 4);
		}

		return sum;
	}

	private void Pay() {
		KioskOrderDao dao = new KioskOrderDao();
		KioskSetOptionDao dao2 = new KioskSetOptionDao();
		Random rd = new Random();
		String menuid;
		String option;
		int quantity;
		String custid;
		int price;
		String place;
		ArrayList<Integer> stfid = dao.searchStaff();
		int stf = 0;

		for (int i = 0; i < kioskorder.Inner_Table.getRowCount(); i++) {
			menuid = (String) kioskorder.Inner_Table.getValueAt(i, 0);
			option = (String) kioskorder.Inner_Table.getValueAt(i, 4);
			quantity = Integer.parseInt((String) kioskorder.Inner_Table.getValueAt(i, 2));
			if (kioskorder.addpoint == false && kioskorder.paywithpoint == false) {
				custid = "kiosk";
			} else {
				custid = dao.searchCustomerByPhone(kioskorder.tfPhone.getText());
			}
			price = Integer.parseInt((String) kioskorder.Inner_Table.getValueAt(i, 3));
			place = kioskorder.place;
			stf = stfid.get(rd.nextInt(stfid.size()));
			dao.Order(stf, menuid, option, quantity, custid, price, place);
		}
		reset();
	}

	private int sumPrice() {
		int price = 0;
		for (int i = 0; i < kioskorder.Inner_Table.getRowCount(); i++) {
			price += Integer.parseInt((String) kioskorder.Inner_Table.getValueAt(i, 3));
		}
		return price;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자 메뉴");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					kioskmanage.setVisible(true);
				}
			});
			lblNewLabel.setBounds(93, 474, 62, 22);
		}
		return lblNewLabel;
	}
}
