package com.coffeex.staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.coffeex.dto.ShopDto;
import com.coffeex.staffdao.ChefManageShopDao;
import com.coffeex.staffdao.ManagerAddStaffDao;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChefManageShop {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JButton btnSearch;
	private JTextField tfSearch;
	private JLabel lblNewLabel_3;
	private JTextField tfId;
	private JLabel lblNewLabel_3_3;
	private JTextField tfAddress;
	
	private JButton btnClear;
	private JButton btnDelete;
	private JButton btnInsert;
	private JTextField tfPhone;
	private JLabel lblNewLabel_3_3_1;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
    private JButton btnFilePath;
	private JLabel lblImage;
	
	
	// file 정리
	ArrayList<ShopDto> beanList = null;
	
	private JTextField tfFilePath;
	private JLabel lblImage1;
	private JLabel lblNewLabel_3_3_1_2;
	private JTextField tfOpening;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefManageShop window = new ChefManageShop();
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
	public ChefManageShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("지점등록/삭제");
		frame.getContentPane().setBackground(new Color(238, 238, 238));
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getTfSearch());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfId());
		frame.getContentPane().add(getLblNewLabel_3_3());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getBtnClear());
		frame.getContentPane().add(getBtnDelete());
		frame.getContentPane().add(getBtnInsert());
		frame.getContentPane().add(getTextField_3());
		frame.getContentPane().add(getBtnFilePath());
		frame.getContentPane().add(getLblNewLabel_3_3_1());
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getScrollPane());
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("매장 이미지 위치");
		lblNewLabel_3_3_1_1.setBounds(19, 248, 117, 16);
		frame.getContentPane().add(lblNewLabel_3_3_1_1);
		
		tfFilePath = new JTextField();
		tfFilePath.setColumns(10);
		tfFilePath.setBounds(19, 263, 130, 26);
		frame.getContentPane().add(tfFilePath);
		frame.getContentPane().add(getLblImage1());
		frame.getContentPane().add(getLblNewLabel_3_3_1_2());
		frame.getContentPane().add(getTfOpening());
		frame.setDefaultCloseOperation(2);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit(); 			// <--***************************************************
				queryAction();          // <--***************************************************
			}
			@Override
			public void windowClosing(WindowEvent e) {
				closingAction();       	// <--***************************************************
			}
		});
	}
	
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("파일 경로");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnFilePath.setBounds(48, 299, 101, 16);
		}
		return btnFilePath;
	}	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("  CoffeeX");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
			lblNewLabel.setBackground(new Color(148, 128, 96));
			lblNewLabel.setBounds(0, 0, 600, 50);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("지점검색");
			lblNewLabel_2.setBounds(373, 73, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnSearch.setBounds(463, 101, 117, 29);
		}
		return btnSearch;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setColumns(10);
			tfSearch.setBounds(337, 101, 130, 26);
		}
		return tfSearch;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Shop ID");
			lblNewLabel_3.setBounds(19, 90, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(19, 105, 130, 26);
		}
		return tfId;
	}
	private JLabel getLblNewLabel_3_3() {
		if (lblNewLabel_3_3 == null) {
			lblNewLabel_3_3 = new JLabel("주소");
			lblNewLabel_3_3.setBounds(19, 130, 61, 16);
		}
		return lblNewLabel_3_3;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(19, 145, 130, 26);
		}
		return tfAddress;
	}
	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("초기화");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearColumn();
				}
			});
			btnClear.setBounds(171, 399, 117, 29);
		}
		return btnClear;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제하기");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(deleteAction() == true) {
						JOptionPane.showMessageDialog(null, tfAddress.getText()+"님의 정보가 삭제 되었습니다.");
						conditionQuery();
//						tableInit();
						clearColumn();
					}else {
						JOptionPane.showMessageDialog(null,"DB작업중 문제가 발생했습니다. \n행정실로 문의 하세요.");
					}
					
				}
			});
			btnDelete.setBounds(452, 399, 117, 29);
		}
		return btnDelete;
	}
	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("등록하기");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i_chk = insertFieldCheck();
					if(i_chk == 0) {
						insertAction();
						JOptionPane.showMessageDialog(null, tfId.getText()+"님의 정보가 입력 되었습니다.");
//						conditionQuery();
						clearColumn();
					}else {
						JOptionPane.showMessageDialog(null, tfId.getText()+"님의 중복확인을 확인해주세요.");
					}
//						int check = insertAction();
//						if(check == 1) {
//							JOptionPane.showMessageDialog(null, tfStaffName.getText()+"님의 정보가 입력 되었습니다.");
//							conditionQuery();
//							clearColumn();
//						}
//					}
				}
			});
			btnInsert.setBounds(317, 399, 117, 29);
		}
		return btnInsert;
	}

	private JTextField getTextField_3() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(19, 185, 130, 26);
		}
		return tfPhone;
	}
	private JLabel getLblNewLabel_3_3_1() {
		if (lblNewLabel_3_3_1 == null) {
			lblNewLabel_3_3_1 = new JLabel("전화번호");
			lblNewLabel_3_3_1.setBounds(19, 170, 61, 16);
		}
		return lblNewLabel_3_3_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Shop ID", "주소", "전화번호"}));
			comboBox.setBounds(227, 102, 106, 27);
		}
		return comboBox;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(161, 135, 408, 241);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable(){ 								// <--****************
				public Class getColumnClass(int column) { 				// <--****************
			        return (column == 0) ? Icon.class : Object.class; 	// <--****************
			      }
			};
		/*
			Inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton() == 1) {
					//	tableClick();
					}
				}
			});
		*/
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setRowHeight(100); 		// <--***************************************************
			Inner_Table.setShowVerticalLines(false);
			Inner_Table.setShowHorizontalLines(false);
			//Inner_Table.setShowGrid(false);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	//--------------------------------------funtcion-------------------------------
	private void tableInit() {
		
		Outer_Table.addColumn("가게이미지");
		Outer_Table.addColumn("ShopID");
		Outer_Table.addColumn("주소");
		Outer_Table.addColumn("전화번호");
		
		Outer_Table.setColumnCount(4);
		
		int i = Outer_Table.getRowCount();
		
		for(int j = 0; j<i; j++) {
			
			Outer_Table.removeRow(0);
		}
		
		Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
		
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
		width = 200;
		col.setPreferredWidth(width);
		
	}
	//가게정보 입력
		
	private void insertAction() {
		String id = tfId.getText().trim();
		String address = tfAddress.getText().trim();
		String phone = tfPhone.getText().trim();
		String opening = tfOpening.getText().trim();
		//String photoname = tfPhoton.getText();
		//String  = tfRelation.getText();
		
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText().trim());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File f = new File(tfFilePath.getText());
		//Dao dbaction = new Dao(name, telno, address, email, relation, input);
		ChefManageShopDao dbaction = new ChefManageShopDao(id, address, phone, f.getName(), input, opening); 
		
		boolean aaa = dbaction.insertAction();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, tfId.getText()+" 님의 정보가 입력 되었습니다.!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다! \n 시스템관리자에 문의하세요!");                    
		}		
		
		//return aaa;
	}
	//등록시 빈칸 체크
	
	private int insertFieldCheck() {
		int i = 0;
		String message = "";
		if(tfId.getText().trim().length() == 0) {
			i++;
			message = "Shop ID를";
			tfId.requestFocus();
		}
		if(tfAddress.getText().trim().length() == 0) {
			i++;
			message = "주소를";
			tfAddress.requestFocus();
		}
		
		if(tfPhone.getText().trim().length() == 0) {
			i++;
			message = "전화번호을";
			tfPhone.requestFocus();
		}

		if(tfFilePath.getText().trim().length() == 0) {
			i++;
			message = "이미지 파일의 경로를";
			tfFilePath.requestFocus();
		}

		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요!");
		}
		return i;
	}
	

	//사원정보 삭제
	private Boolean deleteAction() {
		
		int custid = Integer.parseInt(tfId.getText());
		
		ManagerAddStaffDao dao = new ManagerAddStaffDao();
		boolean check = dao.deleteAction(custid);
		
		return check;
	}
	private void clearColumn() {
		tfId.setText("");
		tfAddress.setText("");
		tfPhone.setText("");
		tfFilePath.setText("");
	}
	private void conditionQuery() {
		
		int i = comboBox.getSelectedIndex();
		String conditionQueryColumn = "";
		switch(i) {
		case 0:
			conditionQueryColumn = "staffid";
			break;
		case 1:
			conditionQueryColumn = "staffname";
			break;
		case 2:
			conditionQueryColumn = "staffphone";
			break;
		default:
			break;
		}
		tableInit();
		clearColumn();
		queryAction();
		//conditionQueryAction(conditionQueryColumn);
	}
	
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		lblImage1.setIcon(new ImageIcon(filePath));
		lblImage1.setHorizontalAlignment(SwingConstants.CENTER);
	}	
	
	
	/*
	private void conditionQueryAction(String conditionQueryColumn) {
		
		ChefManageShopDao dao = new ChefManageShopDao();
		ArrayList<ShopDto> dtoList = dao.conditionList();
		
		int listCount = dtoList.size();
		
		for(int index=0; index<listCount; index++) {
			String temp = Integer.toString(dtoList.get(index).getStaffid());
			String[] qTxt = {temp, dtoList.get(index).getStaffname(), dtoList.get(index).getStaffphone(),dtoList.get(index).getStaffinitdate()};
			Outer_Table.addRow(qTxt);
			
		}
	}
	*/
	
	private void queryAction() {
		ChefManageShopDao dbAction = new ChefManageShopDao();
		beanList = dbAction.selectList();
		
		int listcount = beanList.size();
		
		for(int index=0; index < listcount; index++) {
			ImageIcon icon = new ImageIcon("./"+beanList.get(index).getShopphotoname());
			
			
			
			Object[] tempData = {icon, beanList.get(index).getShopid(),beanList.get(index).getShopaddress(),beanList.get(index).getShopphone()};
			Outer_Table.addRow(tempData);		
		}
		
		
		
	}
	
	private void closingAction() {
		for(int index=0; index < beanList.size();index++) {
			File file = new File("./"+beanList.get(index).getShopphotoname());
			file.delete();
		}
	}
	private JLabel getLblImage1() {
		if (lblImage1 == null) {
			lblImage1 = new JLabel("");
			lblImage1.setBounds(12, 315, 137, 138);
		}
		return lblImage1;
	}
	private JLabel getLblNewLabel_3_3_1_2() {
		if (lblNewLabel_3_3_1_2 == null) {
			lblNewLabel_3_3_1_2 = new JLabel("매장 운영시간");
			lblNewLabel_3_3_1_2.setBounds(19, 210, 130, 16);
		}
		return lblNewLabel_3_3_1_2;
	}
	private JTextField getTfOpening() {
		if (tfOpening == null) {
			tfOpening = new JTextField();
			tfOpening.setColumns(10);
			tfOpening.setBounds(19, 225, 130, 26);
		}
		return tfOpening;
	}
}
