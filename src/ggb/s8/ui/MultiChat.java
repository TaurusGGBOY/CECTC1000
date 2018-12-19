package ggb.s8.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import ggb.s8.bll.UserBLL;
import ggb.s8.model.Client;
import ggb.s8.model.QQgroup;

public class MultiChat extends JPanel {
	private JTextField textField;
	JTextPane textPane;
	Socket socket;
	PrintWriter pWriter;
	BufferedReader bReader;
	JPanel panel;

	/**
	 * Create the panel.
	 */
	public MultiChat(QQgroup qQgroup) {
		setBackground(Color.WHITE);
		setBounds(0, 0, 701, 511);
		setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 550, 370);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 550, 370);
		panel.add(scrollPane);

		textPane = new JTextPane();
		textPane.setText(qQgroup.record);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 370, 550, 40);
		add(panel_1);

		JLabel label = new JLabel("\u53D1 \u9001");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(480, 109, 30, 20);
		panel_1.add(label);

		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(461, 109, 63, 22);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(550, 0, 151, 511);
		add(panel_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(0, 0, 150, 25);
		panel_2.add(panel_4);

		JLabel lblNewLabel = new JLabel("\u6210\u5458");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		panel_4.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 25, 150, 486);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 150, 486);
		scrollPane_1.setOpaque(true);
		scrollPane_1.setBackground(Color.WHITE);
		panel_5.add(scrollPane_1);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(panel_6);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(BorderFactory.createLineBorder(new Color(157, 157, 157)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 410, 550, 100);
		add(panel_3);

		JLabel label_1 = new JLabel("\u53D1 \u9001");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(484, 70, 30, 20);
		panel_3.add(label_1);

		JButton button_1 = new JButton("");

		button_1.setIcon(new ImageIcon(MultiChat.class.getResource("/ggb/s8/ui/\u53D1\u9001\u6309\u94AE.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(465, 70, 63, 22);
		panel_3.add(button_1);

		textField = new JTextField();
		textField.setBounds(0, 0, 550, 60);
		textField.setBorder(null);
		panel_3.add(textField);
		textField.setColumns(10);

		try {
			// 创建一个套接字
			socket = new Socket("127.0.0.1", 28888);
			// 创建一个往套接字中写数据的管道，即输出流，给服务器发送信息
			pWriter = new PrintWriter(socket.getOutputStream());
			// 创建一个从套接字读数据的管道，即输入流，读服务器的返回信息
			bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strName = Client.curruser.name;
				String strMsg = textField.getText();
				if (!strMsg.equals("")) {
					// 通过输出流将数据发送给服务器
					UserBLL.AddRecord(strMsg);
					pWriter.println(strName + " 说：" + strMsg);
					pWriter.flush();
					// 清空文本框
					textField.setText("");
					updateRecord(Client.currchat);
				}
			}
		});

		// 启动线程
		new GetMsgFromServer().start();

	}

	class GetMsgFromServer extends Thread {
		public void run() {
			while (this.isAlive()) {
				try {
					String strMsg = bReader.readLine();
					if (strMsg != null) {
						// 在文本域中显示聊天信息
						System.out.println("当前聊天" + Client.currchat);
						updateRecord(Client.currchat);

					}
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	void updateRecord(String id) {
		String record = UserBLL.returnGroup(id).record;
		textPane.setText(record);
		panel.revalidate();
		panel.updateUI();
	}
}
