package ggb.s8.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class MultiChat extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public MultiChat() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 701, 511);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 550, 370);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 550, 370);
		panel.add(scrollPane);

		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 370, 550, 40);
		add(panel_1);

		JLabel label = new JLabel("\u53D1 \u9001");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(480, 109, 30, 20);
		panel_1.add(label);

		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(461, 109, 63, 22);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(550, 0, 151, 511);
		add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 0, 150, 25);
		panel_2.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 25, 150, 486);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 150, 486);
		scrollPane_1.setOpaque(true);
		scrollPane_1.setBackground(Color.WHITE);
		panel_5.add(scrollPane_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(panel_6);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 410, 550, 100);
		add(panel_3);

		JLabel label_1 = new JLabel("\u53D1 \u9001");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(484, 70, 30, 20);
		panel_3.add(label_1);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(MultiChat.class.getResource("/ggb/s8/ui/\u53D1\u9001\u6309\u94AE.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(465, 70, 63, 22);
		panel_3.add(button_1);

		textField = new JTextField();
		textField.setBounds(0, 0, 550, 60);
		textField.setBorder(null);
		panel_3.add(textField);
		textField.setColumns(10);
	}
}
