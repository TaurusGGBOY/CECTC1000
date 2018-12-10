package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import ggb.s8.model.Client;

public class Logining extends JFrame {

	private JPanel contentPane;

	private Timer timer;
	private int count = 0;

	public void initTimer() {

		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				if (count >= 2) {
					timer.stop();
					if (Client.curruser.id.substring(0, 1).equals("u"))
						new MainChat().setVisible(true);
					else if (Client.curruser.id.substring(0, 1).equals("a"))
						new AdminMain().setVisible(true);

					setVisible(false);
				}
			}
		});
		timer.start();

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logining frame = new Logining();
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
	public Logining() {

		initTimer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 330);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 242, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setExtendedState(JFrame.ICONIFIED); // ×îÐ¡»¯
			}
		});
		btnNewButton.setIcon(new ImageIcon(Logining.class.getResource("/ggb/s8/ui/-_1.png")));
		btnNewButton.setBounds(369, 10, 20, 20);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setIcon(new ImageIcon(Logining.class.getResource("/ggb/s8/ui/x_1.png")));
		button.setBounds(400, 10, 20, 20);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Logining.class.getResource("/ggb/s8/ui/title2.png")));
		lblNewLabel.setBounds(0, 0, 430, 160);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u53D6   \u6D88");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(190, 280, 45, 31);
		contentPane.add(label);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				new Login().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Logining.class.getResource("/ggb/s8/ui/\u6309\u94AE.png")));
		btnNewButton_1.setBounds(115, 280, 195, 31);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		contentPane.add(btnNewButton_1);

		JLabel label_1 = new JLabel("");
		ImageIcon image = new ImageIcon(Login.class.getResource("/ggb/s8/ui/" + Client.curruser.head + ".png"));
		image.setImage(image.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		label_1.setIcon(image);
		label_1.setBounds(166, 170, 80, 80);
		contentPane.add(label_1);
	}
}
