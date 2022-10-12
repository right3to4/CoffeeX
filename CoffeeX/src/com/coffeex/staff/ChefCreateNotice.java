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
import com.coffeex.staffdao.StaffViewNoticeDao;

import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ChefCreateNotice {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField tfTitle;
	private JEditorPane epText;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JTable Inner_Notice;
	private final DefaultTableModel Outer_Notice = new DefaultTableModel();
	private JTextField tfInsertDate;
	private JLabel lblNewLabel_2_1;
	private JTextField tfUpdateDate;
	private JLabel lblNewLabel_2_1_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefCreateNotice window = new ChefCreateNotice();
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
	public ChefCreateNotice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				OrderNoticeTableInit();
				searchAction();
				
			}
		});
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfTitle());
		frame.getContentPane().add(getEpText());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfInsertDate());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTfUpdateDate());
		frame.getContentPane().add(getLblNewLabel_2_1_1());
		frame.setDefaultCloseOperation(2);
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
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("공지사항");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblNewLabel_1.setBounds(31, 72, 99, 26);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfTitle() {
		if (tfTitle == null) {
			tfTitle = new JTextField();
			tfTitle.setEnabled(false);
			tfTitle.setBounds(66, 221, 503, 26);
			tfTitle.setColumns(10);
		}
		return tfTitle;
	}
	private JEditorPane getEpText() {
		if (epText == null) {
			epText = new JEditorPane();
			epText.setBounds(31, 297, 538, 256);
		}
		return epText;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			scrollPane.setBounds(31, 110, 538, 99);
			scrollPane.setViewportView(getInner_Notice());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("제목");
			lblNewLabel_2.setBounds(31, 226, 39, 16);
		}
		return lblNewLabel_2;
	}
	private JTable getInner_Notice() {
		if (Inner_Notice == null) {
			Inner_Notice = new JTable();
			Inner_Notice.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			Inner_Notice.setShowHorizontalLines(false);
			Inner_Notice.setShowVerticalLines(false);
			Inner_Notice.setShowGrid(false);
			Inner_Notice.setModel(Outer_Notice);
		}
		return Inner_Notice;
	}
	private JTextField getTfInsertDate() {
		if (tfInsertDate == null) {
			tfInsertDate = new JTextField();
			tfInsertDate.setEnabled(false);
			tfInsertDate.setColumns(10);
			tfInsertDate.setBounds(180, 259, 166, 26);
		}
		return tfInsertDate;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("등록일자");
			lblNewLabel_2_1.setBounds(135, 264, 63, 16);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTfUpdateDate() {
		if (tfUpdateDate == null) {
			tfUpdateDate = new JTextField();
			tfUpdateDate.setEnabled(false);
			tfUpdateDate.setColumns(10);
			tfUpdateDate.setBounds(403, 259, 166, 26);
		}
		return tfUpdateDate;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("수정일자");
			lblNewLabel_2_1_1.setBounds(358, 264, 63, 16);
		}
		return lblNewLabel_2_1_1;
	}
	//-----------------function------------
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

		Inner_Notice.setAutoResizeMode(Inner_Notice.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		int width = 50;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		width = 200;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = Inner_Notice.getColumnModel().getColumn(vColIndex);
		width = 140;
		col.setPreferredWidth(width);

	}
	private void searchAction() {

	StaffViewNoticeDao dao = new StaffViewNoticeDao();
	ArrayList<NoticeDto> dtoList = dao.NoticeselectList();

	int listCount = dtoList.size();

	for (int index = 0; index < listCount; index++) {
		String temp = Integer.toString(dtoList.get(index).getNoticeid()) ;
		String[] qTxt = { temp, dtoList.get(index).getNoticetitle(), dtoList.get(index).getNoticeinsertdate(),dtoList.get(index).getNoticeupdatedate() };
		Outer_Notice.addRow(qTxt);
	}
}
	private void tableClick() {
	int i = Inner_Notice.getSelectedRow();
	String wkNoticeid = (String) Inner_Notice.getValueAt(i, 0);

	StaffViewNoticeDao dao = new StaffViewNoticeDao(Integer.parseInt(wkNoticeid));

	NoticeDto dto = dao.tableClick();

	tfTitle.setText(dto.getNoticetitle());
	tfInsertDate.setText(dto.getNoticeinsertdate());
	tfUpdateDate.setText(dto.getNoticeupdatedate());
	epText.setText(dto.getNoticetext());
}
	
}
