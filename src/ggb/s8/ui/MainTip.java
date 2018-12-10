package ggb.s8.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainTip extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainTip() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(701, 511);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainTip.class.getResource("/ggb/s8/ui/\u8FDB\u5165\u4E3B\u754C\u9762.png")));
		lblNewLabel.setBounds(200, 91, 350, 350);
		add(lblNewLabel);

	}
}
