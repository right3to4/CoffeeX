package com.coffeex.kiosk;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
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
			}
		});
		frame.setBounds(100, 100, 466, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getKioskorder());
		frame.getContentPane().add(getKioskoption());
		frame.getContentPane().add(getLblorderbutton());
		frame.getContentPane().add(getLblAddbutton());
		frame.getContentPane().add(getLblCancelbutton());
		frame.getContentPane().add(getLblAd());
		frame.getContentPane().add(getLblConfirm());

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
					int i = KioskViewMenu.Inner_Table.getSelectedRow();
					KioskViewMenu.selectedname = (String) KioskViewMenu.Inner_Table.getValueAt(i, 1);
					lblConfirm.setVisible(true);
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
					KioskViewMenu.Inner_Table.clearSelection();
					lblAddbutton.setVisible(false);
					lblCancelbutton.setVisible(false);
					lblorderbutton.setVisible(true);
					panel.setVisible(false);
					kioskoption.setVisible(false);
					kioskoption.setOptionDefault();
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
					lblAddbutton.setVisible(false);
					kioskoption.setVisible(false);
					kioskorder.setVisible(true);
				}
			});
			lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
			lblConfirm.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblConfirm.setBounds(379, 464, 59, 40);
		}
		return lblConfirm;
	}
}
