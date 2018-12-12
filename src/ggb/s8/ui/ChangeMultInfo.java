package ggb.s8.ui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ggb.s8.model.QQgroup;

public class ChangeMultInfo extends JPanel {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ChangeMultInfo(QQgroup qQgroup) {
		setBackground(Color.WHITE);
		setBounds(0, 0, 440, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
	}
}
