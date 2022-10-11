package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.dto.ViewCartDto;
import com.coffeex.kioskdao.KioskOrderDao;
import com.coffeex.kioskdao.KioskViewMenuDao;
import com.coffeex.util.DBConnect;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTextField;
import java.awt.Color;

public class KioskOrder extends JPanel {

	public ArrayList<String> phone = new ArrayList<String>();
	public final DefaultTableModel Outer_Table = new DefaultTableModel();
	public static String selectedname;
	private JScrollPane scrollPane;
	public JTable Inner_Table;
	public JPanel panelPoint;
	public JTextField tfPhone;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_1_1;
	public JLabel lblpointfalse;
	public JLabel lblpointtrue;
	public JLabel lblStep2;
	public JLabel lblwithcard;
	public JLabel lblwithpoint;
	public JLabel lblStep3;
	private JLabel lblKey1;
	private JLabel lblKey2;
	private JLabel lblKey3;
	private JLabel lblKey6;
	private JLabel lblKey5;
	private JLabel lblKey4;
	private JLabel lblKey7;
	private JLabel lblKey8;
	private JLabel lblKey9;
	private JLabel lblKeyDelete;
	private JLabel lblKey0;
	private JLabel lblKeyInsert;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;

	public String place;
	public String paywith;
	private JLabel lblNewLabel_2_1;
	public boolean paywithpoint;
	public boolean addpoint;
	public boolean havingpoint;
	public JLabel lblNewLabel_4;

	/**
	 * Create the panel.
	 */
	public KioskOrder() {
		setBackground(new Color(148, 128, 96));
		setLayout(null);
		add(getScrollPane_1());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getLblNewLabel_1_1());
		add(getLblpointfalse());
		add(getLblpointtrue());
		add(getLblStep2());
		add(getLblwithcard());
		add(getLblwithpoint());
		add(getLblStep3());
		add(getPanelPoint());
		add(getLblNewLabel_4());
		panelPoint.setVisible(false);
		tableInit();
		searchCart("kiosk");
		lblStep2.setVisible(false);
		lblpointtrue.setVisible(false);
		lblpointfalse.setVisible(false);
		lblStep3.setVisible(true);
		lblwithcard.setVisible(true);
		lblwithpoint.setVisible(false);
		lblStep3.setVisible(false);
		lblwithcard.setVisible(false);
		lblwithpoint.setVisible(false);
		
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 44, 250, 261);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}

	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
		}
		Inner_Table.setModel(Outer_Table);
		return Inner_Table;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Step1: 포장 선택");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setOpaque(true);
			lblNewLabel.setBackground(new Color(108, 88, 56));
			lblNewLabel.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
			lblNewLabel.setBounds(250, 44, 176, 27);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("포장");
			lblNewLabel_1.setBackground(new Color(148, 128, 96));
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					place = "포장";
					lblStep2.setVisible(true);
					lblpointtrue.setVisible(true);
					lblpointfalse.setVisible(true);
					lblNewLabel_1.setBackground(new Color(178, 158, 136));
					lblNewLabel_1_1.setBackground(new Color(148, 128, 96));
				}
			});
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(250, 72, 88, 58);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("매장 식사");
			lblNewLabel_1_1.setBackground(new Color(148, 128, 96));
			lblNewLabel_1_1.setOpaque(true);
			lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					place = "매장 식사";
					lblStep2.setVisible(true);
					lblpointtrue.setVisible(true);
					lblpointfalse.setVisible(true);
					lblNewLabel_1_1.setBackground(new Color(178, 158, 136));
					lblNewLabel_1.setBackground(new Color(148, 128, 96));
				}
			});
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(338, 72, 88, 58);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblpointfalse() {
		if (lblpointfalse == null) {
			lblpointfalse = new JLabel("적립안함");
			lblpointfalse.setBackground(new Color(148, 128, 96));
			lblpointfalse.setOpaque(true);
			lblpointfalse.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblStep3.setVisible(true);
					lblwithcard.setVisible(true);
					lblwithpoint.setVisible(true);
					lblpointfalse.setBackground(new Color(178, 158, 136));
					lblpointtrue.setBackground(new Color(148, 128, 96));
					addpoint = false;
				}
			});
			lblpointfalse.setHorizontalAlignment(SwingConstants.CENTER);
			lblpointfalse.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblpointfalse.setBounds(338, 159, 88, 58);
		}
		return lblpointfalse;
	}

	private JLabel getLblpointtrue() {
		if (lblpointtrue == null) {
			lblpointtrue = new JLabel("적립");
			lblpointtrue.setBackground(new Color(148, 128, 96));
			lblpointtrue.setOpaque(true);
			lblpointtrue.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panelPoint.setVisible(true);
					lblStep3.setVisible(true);
					lblwithcard.setVisible(true);
					lblwithpoint.setVisible(true);
					lblpointtrue.setBackground(new Color(178, 158, 136));
					lblpointfalse.setBackground(new Color(148, 128, 96));
					addpoint=true;
				}
			});
			lblpointtrue.setHorizontalAlignment(SwingConstants.CENTER);
			lblpointtrue.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblpointtrue.setBounds(250, 159, 88, 58);
		}
		return lblpointtrue;
	}

	private JLabel getLblStep2() {
		if (lblStep2 == null) {
			lblStep2 = new JLabel("Step2: 포인트 적립 선택");
			lblStep2.setForeground(new Color(255, 255, 255));
			lblStep2.setOpaque(true);
			lblStep2.setBackground(new Color(108, 88, 56));
			lblStep2.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
			lblStep2.setBounds(250, 131, 176, 27);
		}
		return lblStep2;
	}

	private JLabel getLblwithcard() {
		if (lblwithcard == null) {
			lblwithcard = new JLabel("카드");
			lblwithcard.setBackground(new Color(148, 128, 96));
			lblwithcard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblwithcard.setBackground(new Color(178, 158, 136));
					lblwithpoint.setBackground(new Color(148, 128, 96));
					panelPoint.setVisible(false);
					paywithpoint = false;
					KioskInit.lblPayButton.setVisible(true);
				}
			});
			lblwithcard.setOpaque(true);
			lblwithcard.setHorizontalAlignment(SwingConstants.CENTER);
			lblwithcard.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblwithcard.setBounds(338, 247, 88, 58);
		}
		return lblwithcard;
	}

	private JLabel getLblwithpoint() {
		if (lblwithpoint == null) {
			lblwithpoint = new JLabel("포인트");
			lblwithpoint.setBackground(new Color(148, 128, 96));
			lblwithpoint.setOpaque(true);
			lblwithpoint.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panelPoint.setVisible(true);
					lblwithpoint.setBackground(new Color(178, 158, 136));
					lblwithcard.setBackground(new Color(148, 128, 96));
					paywithpoint = true;
					KioskInit.lblPayButton.setVisible(true);
				}
			});
			lblwithpoint.setHorizontalAlignment(SwingConstants.CENTER);
			lblwithpoint.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblwithpoint.setBounds(250, 247, 88, 58);
		}
		return lblwithpoint;
	}

	private JLabel getLblStep3() {
		if (lblStep3 == null) {
			lblStep3 = new JLabel("Step3: 결제 방식 선택");
			lblStep3.setOpaque(true);
			lblStep3.setBackground(new Color(108, 88, 56));
			lblStep3.setForeground(new Color(255, 255, 255));
			lblStep3.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 16));
			lblStep3.setBounds(250, 219, 176, 27);
		}
		return lblStep3;
	}

	private JPanel getPanelPoint() {
		if (panelPoint == null) {
			panelPoint = new JPanel();
			panelPoint.setBackground(new Color(108, 88, 56));
			panelPoint.setBounds(67, 304, 289, 140);
			panelPoint.setLayout(null);
			panelPoint.add(getTfPhone());
			panelPoint.add(getLblKey1());
			panelPoint.add(getLblKey2());
			panelPoint.add(getLblKey3());
			panelPoint.add(getLblKey6());
			panelPoint.add(getLblKey5());
			panelPoint.add(getLblKey4());
			panelPoint.add(getLblKey7());
			panelPoint.add(getLblKey8());
			panelPoint.add(getLblKey9());
			panelPoint.add(getLblKeyDelete());
			panelPoint.add(getLblKey0());
			panelPoint.add(getLblKeyInsert());
			panelPoint.add(getLblNewLabel_3());
			panelPoint.add(getLblNewLabel_2());
			panelPoint.add(getLblNewLabel_2_1());
		}
		return panelPoint;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setEditable(false);
			tfPhone.setBounds(12, 35, 97, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}

	private JLabel getLblKey1() {
		if (lblKey1 == null) {
			lblKey1 = new JLabel("1");
			lblKey1.setBackground(new Color(148, 128, 96));
			lblKey1.setOpaque(true);
			lblKey1.setForeground(new Color(255, 255, 255));
			lblKey1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("1");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey1.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey1.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey1.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey1.setBounds(122, 10, 47, 30);
		}
		return lblKey1;
	}

	private JLabel getLblKey2() {
		if (lblKey2 == null) {
			lblKey2 = new JLabel("2");
			lblKey2.setBackground(new Color(148, 128, 96));
			lblKey2.setOpaque(true);
			lblKey2.setForeground(new Color(255, 255, 255));
			lblKey2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("2");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey2.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey2.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey2.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey2.setBounds(169, 10, 47, 30);
		}
		return lblKey2;
	}

	private JLabel getLblKey3() {
		if (lblKey3 == null) {
			lblKey3 = new JLabel("3");
			lblKey3.setBackground(new Color(148, 128, 96));
			lblKey3.setOpaque(true);
			lblKey3.setForeground(new Color(255, 255, 255));
			lblKey3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("3");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey3.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey3.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey3.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey3.setBounds(216, 10, 47, 30);
		}
		return lblKey3;
	}

	private JLabel getLblKey6() {
		if (lblKey6 == null) {
			lblKey6 = new JLabel("6");
			lblKey6.setBackground(new Color(148, 128, 96));
			lblKey6.setOpaque(true);
			lblKey6.setForeground(new Color(255, 255, 255));
			lblKey6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("6");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey6.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey6.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey6.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey6.setBounds(216, 40, 47, 30);
		}
		return lblKey6;
	}

	private JLabel getLblKey5() {
		if (lblKey5 == null) {
			lblKey5 = new JLabel("5");
			lblKey5.setBackground(new Color(148, 128, 96));
			lblKey5.setOpaque(true);
			lblKey5.setForeground(new Color(255, 255, 255));
			lblKey5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("5");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey5.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey5.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey5.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey5.setBounds(169, 40, 47, 30);
		}
		return lblKey5;
	}

	private JLabel getLblKey4() {
		if (lblKey4 == null) {
			lblKey4 = new JLabel("4");
			lblKey4.setBackground(new Color(148, 128, 96));
			lblKey4.setOpaque(true);
			lblKey4.setForeground(new Color(255, 255, 255));
			lblKey4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("4");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey4.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey4.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey4.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey4.setBounds(122, 40, 47, 30);
		}
		return lblKey4;
	}

	private JLabel getLblKey7() {
		if (lblKey7 == null) {
			lblKey7 = new JLabel("7");
			lblKey7.setBackground(new Color(148, 128, 96));
			lblKey7.setOpaque(true);
			lblKey7.setForeground(new Color(255, 255, 255));
			lblKey7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("7");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey7.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey7.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey7.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey7.setBounds(122, 70, 47, 30);
		}
		return lblKey7;
	}

	private JLabel getLblKey8() {
		if (lblKey8 == null) {
			lblKey8 = new JLabel("8");
			lblKey8.setBackground(new Color(148, 128, 96));
			lblKey8.setOpaque(true);
			lblKey8.setForeground(new Color(255, 255, 255));
			lblKey8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("8");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey8.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey8.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey8.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey8.setBounds(169, 70, 47, 30);
		}
		return lblKey8;
	}

	private JLabel getLblKey9() {
		if (lblKey9 == null) {
			lblKey9 = new JLabel("9");
			lblKey9.setBackground(new Color(148, 128, 96));
			lblKey9.setOpaque(true);
			lblKey9.setForeground(new Color(255, 255, 255));
			lblKey9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("9");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey9.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey9.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey9.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey9.setBounds(216, 70, 47, 30);
		}
		return lblKey9;
	}

	private JLabel getLblKeyDelete() {
		if (lblKeyDelete == null) {
			lblKeyDelete = new JLabel("지움");
			lblKeyDelete.setBackground(new Color(148, 128, 96));
			lblKeyDelete.setOpaque(true);
			lblKeyDelete.setForeground(new Color(255, 255, 255));
			lblKeyDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (tfPhone.getText().length() > 0) {
						phone.remove(phone.size() - 1);
						tfPhone.setText(ArrtoString(phone));
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKeyDelete.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKeyDelete.setBackground(new Color(148, 128, 96));
				}
			});
			lblKeyDelete.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyDelete.setBounds(122, 100, 47, 30);
		}
		return lblKeyDelete;
	}

	private JLabel getLblKey0() {
		if (lblKey0 == null) {
			lblKey0 = new JLabel("0");
			lblKey0.setBackground(new Color(148, 128, 96));
			lblKey0.setOpaque(true);
			lblKey0.setForeground(new Color(255, 255, 255));
			lblKey0.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					phone.add("0");
					tfPhone.setText(ArrtoString(phone));
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblKey0.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKey0.setBackground(new Color(148, 128, 96));
				}
			});
			lblKey0.setHorizontalAlignment(SwingConstants.CENTER);
			lblKey0.setBounds(169, 100, 47, 30);
		}
		return lblKey0;
	}

	private JLabel getLblKeyInsert() {
		if (lblKeyInsert == null) {
			lblKeyInsert = new JLabel("입력");
			lblKeyInsert.setBackground(new Color(148, 128, 96));
			lblKeyInsert.setOpaque(true);
			lblKeyInsert.setForeground(new Color(255, 255, 255));
			lblKeyInsert.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					KioskOrderDao dao = new KioskOrderDao();
					int check = dao.checkCustomerByPhone(tfPhone.getText());

					if (check == 1) {
						panelPoint.setVisible(false);
						addpoint = true;
					} else {
						JOptionPane.showMessageDialog(null, "잘못된 전화번호입니다.");
					}
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					lblKeyInsert.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblKeyInsert.setBackground(new Color(148, 128, 96));
				}
			});
			lblKeyInsert.setHorizontalAlignment(SwingConstants.CENTER);
			lblKeyInsert.setBounds(216, 100, 47, 30);
		}
		return lblKeyInsert;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전화번호");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setBounds(12, 8, 50, 15);
		}
		return lblNewLabel_3;
	}

	private String ArrtoString(ArrayList<String> arr) {
		String str = "";
		for (int i = 0; i < arr.size(); i++) {
			str = str + arr.get(i);
		}
		return str;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("초기화");
			lblNewLabel_2.setBackground(new Color(148, 128, 96));
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tfPhone.setText(null);
					phone = new ArrayList<String>();
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblNewLabel_2.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblNewLabel_2.setBackground(new Color(148, 128, 96));
				}
			});
			lblNewLabel_2.setBounds(83, 100, 39, 30);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("취소");
			lblNewLabel_2_1.setOpaque(true);
			lblNewLabel_2_1.setBackground(new Color(148, 128, 96));
			lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panelPoint.setVisible(false);
					tfPhone.setText(null);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					lblNewLabel_2_1.setBackground(new Color(118, 98, 66));
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					lblNewLabel_2_1.setBackground(new Color(148, 128, 96));
				}
			});
			lblNewLabel_2_1.setBounds(44, 100, 39, 30);
		}
		return lblNewLabel_2_1;
	}

	public void searchCart(String custid) {

		KioskOrderDao dao = new KioskOrderDao();
		ArrayList<ViewCartDto> dtoList = dao.ShowCart(custid);

		int listCount = dtoList.size();

		for (int index = 0; index < listCount; index++) {
			String temp = dtoList.get(index).getMenu();
			String price = Integer.toString(dtoList.get(index).getPrice());
			String quantity = Integer.toString(dtoList.get(index).getQuantity());
			String total = Integer.toString(dtoList.get(index).getQuantity() * dtoList.get(index).getPrice());
			String option = dtoList.get(index).getAddoption();
			String[] qTxt = { temp, price, quantity, total, option };
			Outer_Table.addRow(qTxt);
		}
	}

	private void tableInit() {

		Outer_Table.addColumn("메뉴 이름");
		Outer_Table.addColumn("단가");
		Outer_Table.addColumn("수량");
		Outer_Table.addColumn("합계가격");
		Outer_Table.addColumn("옵션");

		Outer_Table.setColumnCount(5);

		int i = Outer_Table.getRowCount();

		for (int j = 0; j < i; j++) {
			Outer_Table.removeRow(0);
		}

		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		Inner_Table.setRowHeight(50);

		int vColIndex = 0;

		TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = Inner_Table.getColumnModel().getColumn(vColIndex);
		width = 50;
		col.setPreferredWidth(width);
	}

	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel_4.setBounds(172, 10, 114, 34);
		}
		return lblNewLabel_4;
	}
}
