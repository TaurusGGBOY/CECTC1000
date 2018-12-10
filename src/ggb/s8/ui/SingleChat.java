package ggb.s8.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import ggb.s8.bll.UserBLL;
import ggb.s8.model.User;

public class SingleChat extends JPanel {
	private JTextArea textField;
	private String record;

	/**
	 * Create the panel.
	 */
	public SingleChat(User user) {
		record = UserBLL.singleRecord(user);
		setBackground(Color.WHITE);
		setBounds(0, 0, 701, 511);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 701, 370);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 701, 370);
		panel.add(scrollPane);

		JTextArea recordPanel = new JTextArea();
		scrollPane.setViewportView(recordPanel);
		recordPanel.setText(record);
		recordPanel.setLineWrap(true); // 激活自动换行功能
		recordPanel.setWrapStyleWord(true);
		recordPanel.setEditable(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBounds(0, 370, 701, 141);
		panel_2.setBackground(Color.WHITE);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u53D1\u9001");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(646, 111, 30, 15);
		panel_2.add(lblNewLabel);

		textField = new JTextArea();
		textField.setBounds(0, 0, 701, 101);
		textField.setBorder(null);
		textField.setLineWrap(true); // 激活自动换行功能
		textField.setWrapStyleWord(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 0, 701, 101);
		scrollPane_1.setViewportView(textField);
		scrollPane_1.setBorder(null);
		panel_2.add(scrollPane_1);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(SingleChat.class.getResource("/ggb/s8/ui/\u53D1\u9001\u6309\u94AE.png")));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(626, 107, 65, 22);
		panel_2.add(button);
	}
}
