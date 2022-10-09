package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;

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
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(147, 128, 96));
		menuBar.setOpaque(true);
		//menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 900, 50);
		frame.getContentPane().add(menuBar);
		
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
		
		JLabel lblNewLabel = new JLabel("  CoffeeX");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel.setBackground(new Color(148, 128, 96));
		lblNewLabel.setBounds(0, 0, 900, 50);
		frame.getContentPane().add(lblNewLabel);
	}
}
