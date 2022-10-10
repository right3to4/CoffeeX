package com.coffeex.kiosk;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.kioskdao.KioskViewMenuDao;
import com.coffeex.util.DBConnect;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.awt.Color;

public class KioskSetOption extends JPanel {
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JLabel lblICE;
	private JLabel lblHOT;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_2;
	public JLabel lblQuantity;
	private JLabel lblOption;
	private JLabel lblNewLabel_1_1;
	private JLabel lblLightShot;
	private JLabel lblHeavyShot;
	private JLabel lblBasicShot;
	private JSeparator separator_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNoCream;
	private JLabel lblWithCream;
	private JLabel lblNewLabel_1_1_1_1;
	private JSeparator separator_1_1_1;
	private JLabel lblNoSyrup;
	private JLabel lblNutSyrup;
	private JLabel lblVanillaSyrup;
	public JLabel lblMenuName;

	public String hotice = "HOT";
	public String shot = "";
	public String cream = "";
	public String syrup = "";

	/**
	 * Create the panel.
	 */
	public KioskSetOption() {
		setLayout(null);
		add(getSeparator());
		add(getSeparator_1());
		add(getLblNewLabel_1());
		add(getLblICE());
		add(getLblHOT());
		add(getLblNewLabel_2());
		add(getLblNewLabel_2_2());
		add(getLblQuantity());
		add(getLblOption());
		add(getLblNewLabel_1_1());
		add(getLblLightShot());
		add(getLblHeavyShot());
		add(getLblBasicShot());
		add(getSeparator_1_1());
		add(getLblNewLabel_1_1_1());
		add(getLblNoCream());
		add(getLblWithCream());
		add(getLblNewLabel_1_1_1_1());
		add(getSeparator_1_1_1());
		add(getLblNoSyrup());
		add(getLblNutSyrup());
		add(getLblVanillaSyrup());
		add(getLblMenuName());
		lblMenuName.setText(KioskInit.menuname);
	}

	private JSeparator getSeparator() { // 구분선
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 118, 400, 2);
		}
		return separator;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBounds(12, 190, 400, 2);
		}
		return separator_1;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("HOT/ICE");
			lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(12, 130, 120, 50);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblICE() { // 아이스 선택 시
		if (lblICE == null) {
			lblICE = new JLabel("ICE");
			lblICE.setOpaque(true);
			lblICE.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblHOT.setForeground(new Color(0, 0, 0));
					lblHOT.setBackground(new Color(240, 240, 240));
					lblICE.setForeground(new Color(255, 255, 255));
					lblICE.setBackground(new Color(0, 0, 255));
					hotice = "ICE";
				}
			});
			lblICE.setHorizontalAlignment(SwingConstants.CENTER);
			lblICE.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblICE.setBounds(287, 130, 65, 50);
		}
		return lblICE;
	}

	private JLabel getLblHOT() { // 핫 선택 시
		if (lblHOT == null) {
			lblHOT = new JLabel("HOT");
			lblHOT.setOpaque(true);
			lblHOT.setForeground(new Color(255, 255, 255));
			lblHOT.setBackground(new Color(255, 0, 0));
			lblHOT.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblHOT.setForeground(new Color(255, 255, 255));
					lblHOT.setBackground(new Color(255, 0, 0));
					lblICE.setBackground(new Color(240, 240, 240));
					lblICE.setForeground(new Color(0, 0, 0));
					hotice = "HOT";
				}
			});
			lblHOT.setHorizontalAlignment(SwingConstants.CENTER);
			lblHOT.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblHOT.setBounds(161, 130, 65, 50);
		}
		return lblHOT;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("+");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // 수량 늘리기 버튼
					int quant = Integer.parseInt(lblQuantity.getText());
					quant++;
					lblQuantity.setText(Integer.toString(quant));
				}
			});
			lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 25));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(335, 58, 50, 50);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("-");
			lblNewLabel_2_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) { // 수량 줄이기 버튼
					int quant = Integer.parseInt(lblQuantity.getText());
					if (quant > 1) {
						quant--;
					}
					lblQuantity.setText(Integer.toString(quant));
				}
			});
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setFont(new Font("굴림", Font.PLAIN, 25));
			lblNewLabel_2_2.setBounds(214, 58, 50, 50);
		}
		return lblNewLabel_2_2;
	}

	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("1");
			lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuantity.setFont(new Font("굴림", Font.PLAIN, 20));
			lblQuantity.setBounds(273, 58, 65, 50);
		}
		return lblQuantity;
	}

	private JLabel getLblOption() {
		if (lblOption == null) {
			lblOption = new JLabel("옵션선택");
			lblOption.setFont(new Font("굴림", Font.PLAIN, 20));
			lblOption.setHorizontalAlignment(SwingConstants.CENTER);
			lblOption.setBounds(161, 10, 103, 38);
		}
		return lblOption;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("샷 양");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_1.setBounds(12, 202, 120, 50);
		}
		return lblNewLabel_1_1;
	}

	private JLabel getLblLightShot() {
		if (lblLightShot == null) {
			lblLightShot = new JLabel("연하게");
			lblLightShot.setOpaque(true);
			lblLightShot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblBasicShot.setBackground(new Color(240, 240, 240));
					lblHeavyShot.setBackground(new Color(240, 240, 240));
					lblHeavyShot.setForeground(new Color(0, 0, 0));
					lblLightShot.setBackground(new Color(188, 168, 136));
					shot = ", 연하게";
				}
			});
			lblLightShot.setHorizontalAlignment(SwingConstants.CENTER);
			lblLightShot.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblLightShot.setBounds(312, 202, 73, 50);
		}
		return lblLightShot;
	}

	private JLabel getLblHeavyShot() {
		if (lblHeavyShot == null) {
			lblHeavyShot = new JLabel("진하게");
			lblHeavyShot.setOpaque(true);
			lblHeavyShot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblBasicShot.setBackground(new Color(240, 240, 240));
					lblHeavyShot.setBackground(new Color(100, 80, 48));
					lblHeavyShot.setForeground(new Color(255, 255, 255));
					lblLightShot.setBackground(new Color(240, 240, 240));
					shot = ", 진하게";
				}
			});
			lblHeavyShot.setHorizontalAlignment(SwingConstants.CENTER);
			lblHeavyShot.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblHeavyShot.setBounds(227, 202, 73, 50);
		}
		return lblHeavyShot;
	}

	private JLabel getLblBasicShot() {
		if (lblBasicShot == null) {
			lblBasicShot = new JLabel("기본");
			lblBasicShot.setOpaque(true);
			lblBasicShot.setForeground(new Color(0, 0, 0));
			lblBasicShot.setBackground(new Color(148, 128, 96));
			lblBasicShot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblBasicShot.setBackground(new Color(148, 128, 96));
					lblHeavyShot.setBackground(new Color(240, 240, 240));
					lblHeavyShot.setForeground(new Color(0, 0, 0));
					lblLightShot.setBackground(new Color(240, 240, 240));
				}
			});
			lblBasicShot.setHorizontalAlignment(SwingConstants.CENTER);
			lblBasicShot.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblBasicShot.setBounds(144, 202, 73, 50);
		}
		return lblBasicShot;
	}

	private JSeparator getSeparator_1_1() {
		if (separator_1_1 == null) {
			separator_1_1 = new JSeparator();
			separator_1_1.setBounds(12, 262, 400, 2);
		}
		return separator_1_1;
	}

	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("휘핑크림");
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_1_1.setBounds(12, 273, 120, 50);
		}
		return lblNewLabel_1_1_1;
	}

	private JLabel getLblNoCream() {
		if (lblNoCream == null) {
			lblNoCream = new JLabel("안 함");
			lblNoCream.setOpaque(true);
			lblNoCream.setForeground(new Color(0, 0, 0));
			lblNoCream.setBackground(new Color(200, 200, 200));
			lblNoCream.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblNoCream.setBackground(new Color(200, 200, 200));
					lblWithCream.setBackground(new Color(240, 240, 240));
				}
			});
			lblNoCream.setHorizontalAlignment(SwingConstants.CENTER);
			lblNoCream.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNoCream.setBounds(161, 274, 65, 50);
		}
		return lblNoCream;
	}

	private JLabel getLblWithCream() {
		if (lblWithCream == null) {
			lblWithCream = new JLabel("추가");
			lblWithCream.setOpaque(true);
			lblWithCream.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblNoCream.setBackground(new Color(240, 240, 240));
					lblWithCream.setBackground(new Color(200, 200, 200));
					cream = ", 휘핑추가";
				}
			});
			lblWithCream.setHorizontalAlignment(SwingConstants.CENTER);
			lblWithCream.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblWithCream.setBounds(287, 274, 65, 50);
		}
		return lblWithCream;
	}

	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("시럽");
			lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1_1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNewLabel_1_1_1_1.setBounds(12, 345, 120, 50);
		}
		return lblNewLabel_1_1_1_1;
	}

	private JSeparator getSeparator_1_1_1() {
		if (separator_1_1_1 == null) {
			separator_1_1_1 = new JSeparator();
			separator_1_1_1.setBounds(12, 333, 400, 2);
		}
		return separator_1_1_1;
	}

	private JLabel getLblNoSyrup() {
		if (lblNoSyrup == null) {
			lblNoSyrup = new JLabel("안 함");
			lblNoSyrup.setOpaque(true);
			lblNoSyrup.setBackground(new Color(200, 200, 200));
			lblNoSyrup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblNoSyrup.setBackground(new Color(200, 200, 200));
					lblNutSyrup.setBackground(new Color(240, 240, 240));
					lblVanillaSyrup.setBackground(new Color(240, 240, 240));
				}
			});
			lblNoSyrup.setHorizontalAlignment(SwingConstants.CENTER);
			lblNoSyrup.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNoSyrup.setBounds(144, 345, 73, 50);
		}
		return lblNoSyrup;
	}

	private JLabel getLblNutSyrup() {
		if (lblNutSyrup == null) {
			lblNutSyrup = new JLabel("헤이즐넛");
			lblNutSyrup.setOpaque(true);
			lblNutSyrup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblNutSyrup.setBackground(new Color(0xae, 0x9f, 0x80));
					lblNoSyrup.setBackground(new Color(240, 240, 240));
					lblVanillaSyrup.setBackground(new Color(240, 240, 240));
					syrup = ", 헤이즐넛시럽";
				}
			});
			lblNutSyrup.setHorizontalAlignment(SwingConstants.CENTER);
			lblNutSyrup.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblNutSyrup.setBounds(227, 345, 73, 50);
		}
		return lblNutSyrup;
	}

	private JLabel getLblVanillaSyrup() {
		if (lblVanillaSyrup == null) {
			lblVanillaSyrup = new JLabel("바닐라");
			lblVanillaSyrup.setOpaque(true);
			lblVanillaSyrup.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					lblNutSyrup.setBackground(new Color(240, 240, 240));
					lblNoSyrup.setBackground(new Color(240, 240, 240));
					lblVanillaSyrup.setBackground(new Color(0xf3, 0xe5, 0xab));
					syrup = ", 바닐라시럽";
				}
			});
			lblVanillaSyrup.setHorizontalAlignment(SwingConstants.CENTER);
			lblVanillaSyrup.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 20));
			lblVanillaSyrup.setBounds(312, 345, 73, 50);
		}
		return lblVanillaSyrup;
	}

	private JLabel getLblMenuName() {
		if (lblMenuName == null) {
			lblMenuName = new JLabel(KioskInit.menuname);
			lblMenuName.setHorizontalAlignment(SwingConstants.CENTER);
			lblMenuName.setFont(new Font("굴림", Font.PLAIN, 15));
			lblMenuName.setBounds(12, 79, 91, 29);
		}
		return lblMenuName;
	}

	public void setOptionDefault() {
		// HOT or ICE
		lblHOT.setForeground(new Color(255, 255, 255));
		lblHOT.setBackground(new Color(255, 0, 0));
		lblICE.setBackground(new Color(240, 240, 240));
		lblICE.setForeground(new Color(0, 0, 0));
		hotice = "HOT";
		// SHOT
		lblBasicShot.setBackground(new Color(148, 128, 96));
		lblHeavyShot.setBackground(new Color(240, 240, 240));
		lblHeavyShot.setForeground(new Color(0, 0, 0));
		lblLightShot.setBackground(new Color(240, 240, 240));
		shot = "";
		// CREAM
		lblNoCream.setBackground(new Color(200, 200, 200));
		lblWithCream.setBackground(new Color(240, 240, 240));
		cream = "";
		// SYRUP
		lblNoSyrup.setBackground(new Color(200, 200, 200));
		lblNutSyrup.setBackground(new Color(240, 240, 240));
		lblVanillaSyrup.setBackground(new Color(240, 240, 240));
		syrup = "";
		// QUANTITY
		lblQuantity.setText("1");
	}

}
