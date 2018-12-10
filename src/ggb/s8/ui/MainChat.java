package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ggb.s8.bll.UserBLL;
import ggb.s8.dal.MySQLHelper;
import ggb.s8.model.Client;
import ggb.s8.model.User;

public class MainChat extends JFrame {

	private JPanel contentPane;
	JScrollPane scrollPane = new JScrollPane();
	JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainChat frame = new MainChat();
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
	public MainChat() {
		setBackground(Color.WHITE);
		new MySQLHelper().setProperty("head", Client.curruser.head);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelfInfo().setVisible(true);
				setVisible(false);
			}
		});
		ImageIcon image = new ImageIcon(Login.class.getResource("/ggb/s8/ui/" + Client.curruser.head + ".png"));
		image.setImage(image.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		button_2.setIcon(image);
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setBounds(27, 10, 40, 40);
		contentPane.add(button_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainChat.class.getResource("/ggb/s8/ui/\u804A\u5929\u56FE\u6807.png")));
		lblNewLabel_1.setBounds(354, 13, 54, 39);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2
				.setIcon(new ImageIcon(MainChat.class.getResource("/ggb/s8/ui/\u5411\u4E0A\u7684\u7BAD\u5934.png")));
		lblNewLabel_2.setBounds(378, 50, 10, 10);
		contentPane.add(lblNewLabel_2);

		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Friends().setVisible(true);
				setVisible(false);
			}
		});
		button_5.setIcon(new ImageIcon(MainChat.class.getResource("/ggb/s8/ui/\u597D\u53CB.png")));
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setBounds(442, 14, 30, 30);
		contentPane.add(button_5);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED); // ×îÐ¡»¯
			}
		});
		button.setIcon(new ImageIcon(MainChat.class.getResource("/ggb/s8/ui/-_1.png")));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(829, 18, 20, 20);
		contentPane.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setIcon(new ImageIcon(MainChat.class.getResource("/ggb/s8/ui/x_1.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(859, 18, 20, 20);
		contentPane.add(button_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainChat.class.getResource("/ggb/s8/ui/\u804A\u5929\u4E0A\u8FB9\u6846.png")));
		lblNewLabel.setBounds(0, 0, 900, 57);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 900, 34);
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		contentPane.add(panel);
		panel.setLayout(null);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// panel_1.add(new OneChat("h4", "sadsad", "asdasd"));
				User user = new User();
				if (!Client.currchat.id.equals(user.id)) {
					new UserInfo(Client.currchat).setVisible(true);
					setVisible(false);
				}
			}
		});
		button_3.setIcon(new ImageIcon(MainChat.class.getResource("/ggb/s8/ui/\u8BBE\u7F6E1.png")));
		button_3.setBounds(855, 2, 30, 30);
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		panel.add(button_3);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 90, 200, 511);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(panel_1);

		panel_1.setBorder(null);
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 200, 511);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		contentPane.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(199, 89, 701, 511);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 701, 511);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		panel_3.add(new MainTip());

		List<String> result = Arrays.asList(Client.curruser.friend.split(","));
		User user = new User();
		for (String re : result) {
			user.clone(UserBLL.returnuser(re));
			JButton onechat = new JButton();
			onechat.setOpaque(true);
			onechat.setBackground(new Color(250, 250, 250));

			ImageIcon image1 = new ImageIcon(OneChat.class.getResource("/ggb/s8/ui/" + user.head + ".png"));
			image1.setImage(image1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			onechat.setIcon(image1);

			onechat.setText(user.name + "                          " + user.id);
			onechat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str[] = onechat.getText().split("                          ");
					panel_2.removeAll();
					Client.currchat = UserBLL.returnuser(str[1]);
					panel_2.add(new SingleChat(UserBLL.returnuser(str[1])));
					panel_2.revalidate();
					panel_2.updateUI();
				}
			});
			panel_1.add(onechat);
			panel_1.revalidate();
		}
	}
}
