package ggb.s8.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class AdminServer extends JPanel {
	public boolean serverswitch = true;

	/**
	 * Create the panel.
	 */
	public AdminServer() {
		setBorder(null);
		setBackground(Color.WHITE);
		setSize(900, 543);
		setLayout(null);

		JToggleButton toggleButton = new JToggleButton("\u670D\u52A1\u5668:\u5F00");
		toggleButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serverswitch = !serverswitch;
				if (serverswitch) {
					toggleButton.setText("服务器:开");
				} else {
					toggleButton.setText("服务器:关");
					System.exit(0);
				}
			}
		});
		toggleButton.setForeground(new Color(0, 0, 255));
		toggleButton.setBounds(380, 20, 187, 67);
		add(toggleButton);
	}
}
