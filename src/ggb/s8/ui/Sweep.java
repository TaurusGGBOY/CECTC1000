package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import ggb.s8.bll.UserBLL;
import ggb.s8.model.Client;

public class Sweep extends JFrame {

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
					Client.curruser = UserBLL.returnuser("u2016112462");
					new Logining().setVisible(true);
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
					Sweep frame = new Sweep();
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
	public Sweep() {
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
				setExtendedState(JFrame.ICONIFIED); // 最小化
			}
		});

		JLabel lblNewLabel_3 = new JLabel("\u7528CECTC1000\u626B\u63CF\u4E8C\u7EF4\u7801\u5B89\u5168\u767B\u5F55");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(120, 72, 203, 15);
		contentPane.add(lblNewLabel_3);
		btnNewButton.setIcon(new ImageIcon(Sweep.class.getResource("/ggb/s8/ui/-_1.png")));
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
		button.setIcon(new ImageIcon(Sweep.class.getResource("/ggb/s8/ui/x_1.png")));
		button.setBounds(400, 10, 20, 20);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sweep.class.getResource("/ggb/s8/ui/\u4E0A\u8FB9\u68461.png")));
		lblNewLabel.setBounds(0, 0, 430, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Sweep.class.getResource("/ggb/s8/ui/\u4E8C\u7EF4\u7801.png")));
		lblNewLabel_4.setBounds(78, 129, 120, 120);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Sweep.class.getResource("/ggb/s8/ui/\u624B\u673A.png")));
		lblNewLabel_5.setBounds(226, 97, 163, 173);
		contentPane.add(lblNewLabel_5);

		JLabel label_1 = new JLabel("\u8FD4   \u56DE");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(195, 280, 45, 31);
		contentPane.add(label_1);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				setVisible(false);
				timer.stop();
			}
		});
		button_3.setIcon(new ImageIcon(Sweep.class.getResource("/ggb/s8/ui/\u6309\u94AE.png")));
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		button_3.setBounds(120, 280, 195, 31);
		contentPane.add(button_3);
	}
}
