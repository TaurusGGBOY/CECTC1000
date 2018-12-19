package ggb.s8.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ggb.s8.bll.AdminBLL;

public class AdminStatics extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminStatics() {
		setBorder(null);
		setBackground(Color.WHITE);
		setSize(900, 543);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5728\u7EBF\u4EBA\u6570");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		lblNewLabel.setBounds(370, 83, 105, 53);
		add(lblNewLabel);

		JLabel label = new JLabel(String.valueOf(AdminBLL.returnOLNum()));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label.setBounds(370, 138, 105, 53);
		add(label);

		JLabel label_1 = new JLabel("\u6CE8\u518C\u4EBA\u6570");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label_1.setBounds(370, 192, 105, 53);
		add(label_1);

		JLabel label_3 = new JLabel("\u521B\u5EFA\u7FA4\u7EC4");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label_3.setBounds(370, 303, 105, 53);
		add(label_3);

		JLabel label_4 = new JLabel(String.valueOf(AdminBLL.returnGroupNum()));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label_4.setBounds(370, 357, 105, 53);
		add(label_4);

		JLabel label_2 = new JLabel(String.valueOf(AdminBLL.returnRegisterNum()));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 24));
		label_2.setBounds(370, 255, 105, 53);
		add(label_2);
	}
}
