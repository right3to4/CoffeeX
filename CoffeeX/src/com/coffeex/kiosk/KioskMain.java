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

public class KioskMain {

	// 구성: 아래쪽은 공통 부분, 위쪽을 패널로 구현하여 변경하여 화면 전환

	private JFrame frame;
	private JLabel lblorderbutton;
	private KioskOrder panel; // 주문하기 패널
	private JLabel lblAddbutton;
	private JLabel lblCancelbutton;
	private KioskOption kioskoption; // 옵션선택 패널

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KioskMain window = new KioskMain();
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
	public KioskMain() {
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
			}
		});
		frame.setBounds(100, 100, 466, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel());
		frame.getContentPane().add(getLblorderbutton());
		frame.getContentPane().add(getLblAddbutton());
		frame.getContentPane().add(getLblCancelbutton());
		frame.getContentPane().add(getKioskoption());

	}

	private JLabel getLblorderbutton() {
		if (lblorderbutton == null) {
			lblorderbutton = new JLabel("");
			lblorderbutton.setBounds(157, 463, 117, 40);
			lblorderbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // 주문하기 버튼 클릭 시
					panel.setVisible(true);
					lblAddbutton.setVisible(true);
					lblCancelbutton.setVisible(true);
					lblorderbutton.setVisible(false);
				}
			});
			lblorderbutton
					.setIcon(new ImageIcon(KioskMain.class.getResource("/com/coffeex/kiosk/image/orderbutton.JPG")));

		}
		return lblorderbutton;
	}

	private KioskOrder getPanel() {
		if (panel == null) {
			panel = new KioskOrder();
			panel.setBounds(12, 10, 426, 444);
			panel.setLayout(null);
		}
		return panel;
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
					lblAddbutton.setVisible(false);
					lblCancelbutton.setVisible(false);
					lblorderbutton.setVisible(true);
					panel.setVisible(false);
					kioskoption.setVisible(false);
				}
			});
			lblCancelbutton.setHorizontalAlignment(SwingConstants.CENTER);
			lblCancelbutton.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblCancelbutton.setBounds(308, 464, 59, 40);
		}
		return lblCancelbutton;
	}

	private KioskOption getKioskoption() {
		if (kioskoption == null) {
			kioskoption = new KioskOption();
			kioskoption.setBounds(12, 10, 426, 444);
			kioskoption.setLayout(null);
		}
		return kioskoption;
	}
}
