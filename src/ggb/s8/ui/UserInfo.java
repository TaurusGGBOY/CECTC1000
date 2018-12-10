package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ggb.s8.model.Client;
import ggb.s8.model.User;

public class UserInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo(Client.curruser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInfo(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 510);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainChat().setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(UserInfo.class.getResource("/ggb/s8/ui/x_1.png")));
		button.setBounds(310, 10, 20, 20);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UserInfo.class.getResource("/ggb/s8/ui/340_280.png")));
		lblNewLabel.setBounds(0, 0, 340, 260);
		contentPane.add(lblNewLabel);

		JLabel lblXxx = new JLabel(user.sign, JLabel.CENTER);
		lblXxx.setBounds(77, 275, 207, 15);
		contentPane.add(lblXxx);

		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(90, 335, 33, 15);
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("\u6635\u79F0");
		label.setForeground(Color.GRAY);
		label.setBounds(90, 365, 33, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u624B\u673A");
		label_1.setForeground(Color.GRAY);
		label_1.setBounds(90, 395, 33, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u90AE\u7BB1");
		label_2.setForeground(Color.GRAY);
		label_2.setBounds(90, 425, 33, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u804C\u4E1A");
		label_3.setForeground(Color.GRAY);
		label_3.setBounds(90, 455, 33, 15);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel(user.id);
		label_4.setBounds(133, 335, 82, 15);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel(user.name);
		label_5.setBounds(133, 365, 82, 15);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel(user.tel);
		label_6.setBounds(133, 395, 82, 15);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel(user.mail);
		label_7.setBounds(133, 425, 162, 15);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel(user.career);
		label_8.setBounds(133, 455, 82, 15);
		contentPane.add(label_8);
	}
}
