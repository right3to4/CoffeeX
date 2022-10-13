package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.coffeex.kiosk.KioskInit;
import com.coffeex.staffdao.StaffLoginDao;
import com.coffeex.util.CustomerInfo;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StaffLogin {

   private JFrame frmCoffeex;
   private JLabel lblNewLabel;
   private JLabel lblNewLabel_1;
   private JTextField tfId;
   private JLabel lblNewLabel_2;
   private JLabel lblNewLabel_2_1;
   private JPasswordField pwfPw;
   private JLabel lbLogIn;
   private JButton btnNewButton;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               StaffLogin window = new StaffLogin();
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
   public StaffLogin() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frmCoffeex = new JFrame();
      frmCoffeex.setTitle("CoffeeX");
      frmCoffeex.setBounds(100, 100, 500, 400);
      frmCoffeex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frmCoffeex.getContentPane().setLayout(null);
      frmCoffeex.getContentPane().add(getLblNewLabel());
      frmCoffeex.getContentPane().add(getLblNewLabel_1());
      frmCoffeex.getContentPane().add(getTfId());
      frmCoffeex.getContentPane().add(getLblNewLabel_2());
      frmCoffeex.getContentPane().add(getLblNewLabel_2_1());
      frmCoffeex.getContentPane().add(getPwfPw());
      frmCoffeex.getContentPane().add(getLbLogIn());
      frmCoffeex.getContentPane().add(getBtnNewButton());
      
   }
   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("  CoffeeX");
         lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
         lblNewLabel.setForeground(Color.WHITE);
         lblNewLabel.setOpaque(true);
         lblNewLabel.setBackground(new Color(148, 128, 96));
         lblNewLabel.setBounds(0, 0, 500, 50);
      }
      return lblNewLabel;
   }
   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("로그인");
         lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel_1.setBounds(167, 62, 150, 50);
      }
      return lblNewLabel_1;
   }
   private JTextField getTfId() {
      if (tfId == null) {
         tfId = new JTextField();
         tfId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
         tfId.setBounds(179, 162, 160, 26);
         tfId.setColumns(10);
      }
      return tfId;
   }
   private JLabel getLblNewLabel_2() {
      if (lblNewLabel_2 == null) {
         lblNewLabel_2 = new JLabel("ID");
         lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
         lblNewLabel_2.setBounds(130, 162, 40, 26);
      }
      return lblNewLabel_2;
   }
   private JLabel getLblNewLabel_2_1() {
      if (lblNewLabel_2_1 == null) {
         lblNewLabel_2_1 = new JLabel("PW");
         lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
         lblNewLabel_2_1.setBounds(130, 197, 52, 26);
      }
      return lblNewLabel_2_1;
   }
   private JPasswordField getPwfPw() {
      if (pwfPw == null) {
         pwfPw = new JPasswordField();
         pwfPw.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
         pwfPw.setBounds(179, 200, 160, 26);
      }
      return pwfPw;
   }
   private JLabel getLbLogIn() {
      if (lbLogIn == null) {
         lbLogIn = new JLabel("로그인");
         lbLogIn.addMouseListener(new MouseAdapter() {
         	@Override
         	public void mouseClicked(MouseEvent e) {
         		
         		StaffLoginDao staffLoginDao = new StaffLoginDao(Integer.parseInt(tfId.getText()),String.valueOf(pwfPw.getPassword()));
         		
         		boolean check1 = staffLoginDao.loginAction();
				if (check1 == true) {
					CustomerInfo.staffid = Integer.parseInt(tfId.getText());
			
					staffLoginDao.positionAction();
					if (CustomerInfo.position.equals("점장") == true) {
						ManagerViewOrders.main(null);
					}else if(CustomerInfo.position.equals("관리자") == true) {
						ChiefSearchSales.main(null);
					}
					else {
						StaffViewOrders.main(null);
					//알바페이

					}
					JOptionPane.showMessageDialog(null, CustomerInfo.staffname + "님 로그인 되었습니다.");
					frmCoffeex.setVisible(false);
					staffLoginDao.belongAction();

				}else {

					JOptionPane.showMessageDialog(null, " 다시 로그인 해주세요 ");

				}
         		
         	}
         });
         lbLogIn.setHorizontalAlignment(SwingConstants.CENTER);
         lbLogIn.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
         lbLogIn.setForeground(Color.WHITE);
         lbLogIn.setOpaque(true);
         lbLogIn.setBackground(new Color(148, 128, 96));
         lbLogIn.setBounds(116, 267, 262, 26);
      }
      return lbLogIn;
   }
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("키오스크 Test");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					KioskInit.main(null);
					frmCoffeex.setVisible(false);
				}
			});
			btnNewButton.setBounds(0, 337, 117, 29);
		}
		return btnNewButton;
	}
}