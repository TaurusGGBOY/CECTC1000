package ggb.s8.ui;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ggb.s8.model.User;

public class OneChat extends JButton {
	public User user = new User();

	/**
	 * Create the frame.
	 */
	public OneChat(User us) {

		setOpaque(true);
		setBackground(new Color(250, 250, 250));

		ImageIcon image = new ImageIcon(OneChat.class.getResource("/ggb/s8/ui/" + us.head + ".png"));
		image.setImage(image.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		setIcon(image);

		setText(us.name + "                          ");
		user.clone(us);

	}
}
