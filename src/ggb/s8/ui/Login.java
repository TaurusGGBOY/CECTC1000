package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import ggb.s8.bll.UserBLL;
import ggb.s8.dal.MySQLHelper;
import ggb.s8.model.Client;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	JCheckBox checkBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
	JCheckBox checkBox_1 = new JCheckBox("\u81EA\u52A8\u767B\u5F55");
	private Timer timer;
	private int count = 0;

	public void initTimer() {
		if (MySQLHelper.autologin.equals("true")) {
			timer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					count++;
					if (count >= 4) {
						timer.stop();
						if (checkBox_1.isSelected())
							fun_login();

					}
				}
			});
			timer.start();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		new MySQLHelper();
		initTimer();
		setTitle("CECTC1000");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/ggb/s8/ui/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 330);
		setLocationRelativeTo(null);
		setUndecorated(true); // 居中
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
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/ggb/s8/ui/-_1.png")));
		btnNewButton.setBounds(369, 10, 20, 20);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setIcon(new ImageIcon(Login.class.getResource("/ggb/s8/ui/x_1.png")));
		button.setBounds(400, 10, 20, 20);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/ggb/s8/ui/title2.png")));
		lblNewLabel.setBounds(0, 0, 430, 160);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\u767B   \u5F55");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(211, 280, 45, 31);
		contentPane.add(label);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fun_login();
			}
		});
		btnNewButton_1.registerKeyboardAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fun_login();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/ggb/s8/ui/\u6309\u94AE.png")));
		btnNewButton_1.setBounds(134, 280, 195, 31);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorder(null);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField.setBounds(134, 170, 195, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		// 获取焦点
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				textField.requestFocusInWindow();
			}
		});

		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(134, 202, 195, 33);
		contentPane.add(textField_1);

		checkBox.setOpaque(false);
		checkBox.setBackground(Color.WHITE);
		checkBox.setBounds(134, 247, 95, 23);
		checkBox.setForeground(new Color(157, 157, 157));
		contentPane.add(checkBox);

		checkBox_1.setOpaque(false);
		checkBox_1.setBackground(Color.WHITE);
		checkBox_1.setBounds(262, 247, 113, 23);
		checkBox_1.setForeground(new Color(157, 157, 157));
		contentPane.add(checkBox_1);

		JButton button_1 = new JButton("\u6CE8\u518C\u8D26\u53F7");
		button_1.setFocusable(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Register().setVisible(true);
				setVisible(false);
			}
		});
		button_1.setForeground(new Color(78, 155, 232));
		button_1.setBounds(329, 175, 60, 23);
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u627E\u56DE\u5BC6\u7801");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reset().setVisible(true);
				setVisible(false);
			}
		});
		button_2.setFocusable(false);
		button_2.setForeground(new Color(78, 155, 232));
		button_2.setBounds(329, 207, 60, 23);
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		contentPane.add(button_2);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sweep().setVisible(true);
				setVisible(false);
			}
		});
		button_3.setFocusable(false);
		button_3.setIcon(new ImageIcon(Login.class.getResource("/ggb/s8/ui/\u4E8C\u7EF4\u7801\u56FE\u68071.png")));
		button_3.setContentAreaFilled(false);
		button_3.setBorder(null);
		button_3.setBounds(400, 284, 20, 20);
		contentPane.add(button_3);

		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon image = new ImageIcon(
				Login.class.getResource("/ggb/s8/ui/" + new MySQLHelper().getProperty("head") + ".png"));
		image.setImage(image.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(image);
		lblNewLabel_1.setBounds(40, 176, 80, 80);
		contentPane.add(lblNewLabel_1);

		if (MySQLHelper.recordpassword.equals("true") || MySQLHelper.autologin.equals("1")) {
			textField.setText(MySQLHelper.auto_id);
			textField_1.setText(MySQLHelper.auto_password);
			checkBox.setSelected(true);
			if (MySQLHelper.autologin.equals("true")) {
				checkBox_1.setSelected(true);
			}
		}
	}

	void fun_login() {
		String id = textField.getText();
		String password = String.valueOf(textField_1.getPassword());
		new MySQLHelper().setProperty("recordpassword", String.valueOf(checkBox.isSelected()));
		new MySQLHelper().setProperty("autologin", String.valueOf(checkBox_1.isSelected()));
		new MySQLHelper().setProperty("auto_id", textField.getText());
		new MySQLHelper().setProperty("auto_password", String.valueOf(textField_1.getPassword()));

		if (UserBLL.checkidpassword(id, password)) {
			if (id.substring(0, 1).equals("u")) {
				Client.curruser.clone(UserBLL.returnuser(id));
				new Logining().setVisible(true);
				setVisible(false);
			}
			if (id.substring(0, 1).equals("a")) {
				new AdminMain().setVisible(true);
				setVisible(false);
			}
		} else {
			new LoginiFail().setVisible(true);
			setVisible(false);
		}
	}
}
