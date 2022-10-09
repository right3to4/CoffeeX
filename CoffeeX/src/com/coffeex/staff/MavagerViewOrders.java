package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MavagerViewOrders {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MavagerViewOrders window = new MavagerViewOrders();
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
	public MavagerViewOrders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbStaffPayManege = new JLabel("사원급여관리");
		lbStaffPayManege.setVisible(false);
		JLabel lbStaffInsertDel = new JLabel("사원등록/삭제");
		lbStaffInsertDel.setVisible(false);
		
		JLabel lbStaffManage = new JLabel("사원관리");
		lbStaffManage.addMouseListener(new MouseAdapter() {
			int i = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				if(i%2 == 1) {
					lbStaffManage.setForeground(Color.black);
					lbStaffPayManege.setVisible(true);
					lbStaffInsertDel.setVisible(true);	
				}else {
					lbStaffManage.setForeground(Color.white);
					lbStaffPayManege.setVisible(false);
					lbStaffInsertDel.setVisible(false);
				}
				i++;
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("마이페이지");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(760, 0, 140, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("메뉴등록");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(608, 0, 140, 50);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("판매내역조회");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel_1_1_1.setBounds(456, 0, 140, 50);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		lbStaffManage.setHorizontalAlignment(SwingConstants.CENTER);
		lbStaffManage.setForeground(Color.WHITE);
		lbStaffManage.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lbStaffManage.setBounds(304, 0, 140, 50);
		frame.getContentPane().add(lbStaffManage);
		
		JLabel lblNewLabel = new JLabel("  CoffeeX");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel.setBackground(new Color(148, 128, 96));
		lblNewLabel.setBounds(0, 0, 900, 50);
		frame.getContentPane().add(lblNewLabel);
		
//		JLabel lbStaffPayManege = new JLabel("사원급여관리");
		lbStaffPayManege.setHorizontalAlignment(SwingConstants.CENTER);
		lbStaffPayManege.setForeground(Color.BLACK);
		lbStaffPayManege.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lbStaffPayManege.setBounds(304, 50, 140, 28);
		frame.getContentPane().add(lbStaffPayManege);
		
		
		lbStaffInsertDel.setHorizontalAlignment(SwingConstants.CENTER);
		lbStaffInsertDel.setForeground(Color.BLACK);
		lbStaffInsertDel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lbStaffInsertDel.setBounds(304, 79, 140, 28);
		frame.getContentPane().add(lbStaffInsertDel);
		
		JLabel lblNewLabel_2 = new JLabel("직급");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(10, 62, 97, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("이름");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(10, 100, 125, 28);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		
		
	}
}
