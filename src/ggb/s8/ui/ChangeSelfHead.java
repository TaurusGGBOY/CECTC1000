package ggb.s8.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import ggb.s8.bll.UserBLL;
import ggb.s8.dal.MySQLHelper;
import ggb.s8.model.Client;

public class ChangeSelfHead extends JFrame {

	private JPanel contentPane;
	public String head = "h1";
	JButton h1 = new JButton("");
	JButton h2 = new JButton("");
	JButton h3 = new JButton("");
	JButton h4 = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSelfHead frame = new ChangeSelfHead();
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
	public ChangeSelfHead() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 510);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Border bbBorder = new Border() {

			@Override
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				g.setColor(new Color(42, 153, 234));
				g.drawRect(x, y, width - 1, height - 1);
			}

			@Override
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return new Insets(1, 1, 1, 1);
			}
		};

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setExtendedState(JFrame.ICONIFIED); // 最小化
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 6, 20, 20);
		ImageIcon image1 = new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/icon_small.png"));
		image1.setImage(image1.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),
				Image.SCALE_DEFAULT));

		h1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h1.setBorder(bbBorder);
				h2.setBorder(null);
				h3.setBorder(null);
				h4.setBorder(null);
				head = "h1";
			}
		});
		h1.setBounds(50, 150, 40, 40);
		ImageIcon image2 = new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/h1.png"));
		image2.setImage(image2.getImage().getScaledInstance(h1.getWidth(), h1.getHeight(), Image.SCALE_DEFAULT));
		h1.setIcon(image2);
		h1.setContentAreaFilled(false);
		h1.setBorder(bbBorder);

		contentPane.add(h1);

		lblNewLabel_1.setIcon(new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/icon_20.png")));

		contentPane.add(lblNewLabel_1);

		JLabel label_1 = new JLabel("\u63A8\u8350\u5934\u50CF");
		label_1.setForeground(Color.GRAY);
		label_1.setBounds(36, 6, 53, 20);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u5173\u95ED");
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(274, 479, 30, 20);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u786E\u5B9A");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(199, 479, 30, 20);
		contentPane.add(label_3);
		btnNewButton.setIcon(new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/-_grey.png")));
		btnNewButton.setBounds(285, 6, 20, 20);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelfInfo().setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/x_grey.png")));
		button.setBounds(310, 6, 20, 20);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		contentPane.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.curruser.head = head;
				UserBLL.updateUserInfo(Client.curruser);
				new MySQLHelper().setProperty("head", Client.curruser.head);
				new SelfInfo().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/\u53D1\u9001\u6309\u94AE.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(180, 480, 65, 20);
		contentPane.add(button_1);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelfInfo().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/\u6309\u94AE2.png")));
		btnNewButton_1.setBounds(255, 480, 65, 20);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				ChangeSelfHead.class.getResource("/ggb/s8/ui/\u7F16\u8F91\u8D44\u6599\u6807\u9898\u680F.png")));
		lblNewLabel.setBounds(0, 0, 340, 33);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("");
		ImageIcon image = new ImageIcon(
				ChangeSelfHead.class.getResource("/ggb/s8/ui/\u7F16\u8F91\u8D44\u6599\u4E0B\u9762.png"));
		image.setImage(image.getImage().getScaledInstance(JLabel.WIDTH, JLabel.HEIGHT, Image.SCALE_DEFAULT));
		label.setIcon(image);
		label.setBounds(0, 467, 340, 43);
		contentPane.add(label);

		JLabel lblNewLabel_2 = new JLabel("\u7ECF\u5178\u5934\u50CF");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(125, 61, 84, 20);
		contentPane.add(lblNewLabel_2);
		h2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h1.setBorder(null);
				h2.setBorder(bbBorder);
				h3.setBorder(null);
				h4.setBorder(null);
				head = "h2";
			}
		});

		h2.setContentAreaFilled(false);
		h2.setBorder(null);
		h2.setBounds(120, 150, 40, 40);
		ImageIcon image3 = new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/h2.png"));
		image3.setImage(image3.getImage().getScaledInstance(h2.getWidth(), h2.getHeight(), Image.SCALE_DEFAULT));
		h2.setIcon(image3);

		contentPane.add(h2);
		h3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h1.setBorder(null);
				h2.setBorder(null);
				h3.setBorder(bbBorder);
				h4.setBorder(null);
				head = "h3";
			}
		});

		h3.setContentAreaFilled(false);
		h3.setBorder(null);
		h3.setBounds(190, 150, 40, 40);
		ImageIcon image4 = new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/h3.png"));
		image4.setImage(image4.getImage().getScaledInstance(h3.getWidth(), h3.getHeight(), Image.SCALE_DEFAULT));
		h3.setIcon(image4);

		contentPane.add(h3);
		h4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h1.setBorder(null);
				h2.setBorder(null);
				h3.setBorder(null);
				h4.setBorder(bbBorder);
				head = "h4";
			}
		});

		h4.setContentAreaFilled(false);
		h4.setBorder(null);
		h4.setBounds(260, 150, 40, 40);
		ImageIcon image5 = new ImageIcon(ChangeSelfHead.class.getResource("/ggb/s8/ui/h4.png"));
		image5.setImage(image5.getImage().getScaledInstance(h4.getWidth(), h4.getHeight(), Image.SCALE_DEFAULT));
		h4.setIcon(image5);
		contentPane.add(h4);

	}
}
