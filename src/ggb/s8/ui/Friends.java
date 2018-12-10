package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import ggb.s8.model.Client;

public class Friends extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Friends frame = new Friends();
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
	public Friends() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button_2 = new JButton("");
		ImageIcon image = new ImageIcon(Login.class.getResource("/ggb/s8/ui/" + Client.curruser.head + ".png"));
		image.setImage(image.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		button_2.setIcon(image);
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setBounds(25, 10, 40, 40);
		contentPane.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelfInfo().setVisible(true);
				setVisible(false);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Friends.class.getResource("/ggb/s8/ui/\u597D\u53CB_active.png")));
		lblNewLabel_1.setBounds(442, 18, 54, 39);
		contentPane.add(lblNewLabel_1);

		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainChat().setVisible(true);
				setVisible(false);
			}
		});
		button_5.setIcon(new ImageIcon(Friends.class.getResource("/ggb/s8/ui/\u804A\u5929_\u4E0D\u6D3B\u52A8.png")));
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setBounds(368, 15, 30, 30);
		contentPane.add(button_5);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED); // ��С��
			}
		});
		button.setIcon(new ImageIcon(Friends.class.getResource("/ggb/s8/ui/-_1.png")));
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
		button_1.setIcon(new ImageIcon(Friends.class.getResource("/ggb/s8/ui/x_1.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(859, 18, 20, 20);
		contentPane.add(button_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Friends.class.getResource("/ggb/s8/ui/\u804A\u5929\u4E0A\u8FB9\u6846.png")));
		lblNewLabel.setBounds(0, 0, 900, 57);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 200, 34);
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton button_4 = new JButton("\u597D\u53CB");

		button_4.setForeground(new Color(33, 149, 235));
		button_4.setContentAreaFilled(false);
		button_4.setBorder(null);
		button_4.setBounds(45, 4, 40, 22);
		panel.add(button_4);

		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Friends.class.getResource("/ggb/s8/ui/\u8BBE\u7F6E1.png")));
		button_3.setBounds(855, 2, 30, 30);
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		panel.add(button_3);

		JButton btnQun = new JButton("\u7FA4\u804A");
		btnQun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_4.setForeground(Color.gray);
				btnQun.setForeground(new Color(33, 149, 235));

			}
		});
		btnQun.setForeground(Color.GRAY);
		btnQun.setContentAreaFilled(false);
		btnQun.setBorder(null);
		btnQun.setBounds(125, 4, 40, 22);
		panel.add(btnQun);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_4.setForeground(new Color(33, 149, 235));
				btnQun.setForeground(Color.gray);
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 89, 200, 511);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 200, 511);
		scrollPane.setBorder(null);
		panel_1.add(scrollPane);

		DefaultMutableTreeNode dmtmRoot = new DefaultMutableTreeNode("�ҵĺ���");
		JTree tree = new JTree(dmtmRoot);
		tree.setRootVisible(true);
		String str[] = Client.curruser.friend.split(",");
		for (String string : str) {
			dmtmRoot.add(new DefaultMutableTreeNode(string));
		}
		tree.expandRow(0);
		scrollPane.setViewportView(tree);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(199, 56, 701, 544);
		contentPane.add(panel_2);
	}
}