package ggb.s8.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import ggb.s8.bll.UserBLL;
import ggb.s8.model.Client;
import ggb.s8.model.User;

public class SingleChat extends JPanel {
	private JTextArea textField;
	private String record;
	JTextArea recordPanel;
	Socket socket;
	PrintWriter pWriter;
	BufferedReader bReader;
	JPanel panel;

	/**
	 * Create the panel.
	 */
	public SingleChat(User user) {
		record = UserBLL.singleRecord(user).record;
		setBackground(Color.WHITE);
		setBounds(0, 0, 701, 511);
		setLayout(null);

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 701, 370);
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 701, 370);
		panel.add(scrollPane);

		recordPanel = new JTextArea();
		scrollPane.setViewportView(recordPanel);
		recordPanel.setText(record);
		recordPanel.setLineWrap(true); // 激活自动换行功能
		recordPanel.setWrapStyleWord(true);
		recordPanel.setEditable(false);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBounds(0, 370, 701, 141);
		panel_2.setBackground(Color.WHITE);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u53D1\u9001");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(646, 111, 30, 15);
		panel_2.add(lblNewLabel);

		textField = new JTextArea();
		textField.setBounds(0, 0, 701, 101);
		textField.setBorder(null);
		textField.setLineWrap(true); // 激活自动换行功能
		textField.setWrapStyleWord(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(0, 0, 701, 101);
		scrollPane_1.setViewportView(textField);
		scrollPane_1.setBorder(null);
		panel_2.add(scrollPane_1);

		JButton button = new JButton("");

		button.setIcon(new ImageIcon(SingleChat.class.getResource("/ggb/s8/ui/\u53D1\u9001\u6309\u94AE.png")));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(626, 107, 65, 22);
		panel_2.add(button);

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

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strName = Client.curruser.name;
				String strMsg = textField.getText();
				if (!strMsg.equals("")) {
					// 通过输出流将数据发送给服务器
					UserBLL.AddRecord(strMsg);
					pWriter.println(strName + " 说：" + strMsg);
					pWriter.flush();
					// 清空文本框
					textField.setText("");
					updateRecord(user);
				}
			}
		});
		// 启动线程
		new GetMsgFromServer().start();

		// 接收服务器的返回信息的线程

	}

	class GetMsgFromServer extends Thread {
		public void run() {
			while (this.isAlive()) {
				try {
					String strMsg = bReader.readLine();
					if (strMsg != null) {
						// 在文本域中显示聊天信息
						User user = UserBLL.returnuser(Client.currchat);
						updateRecord(user);
					}
					Thread.sleep(200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	void updateRecord(User user) {
		String record = UserBLL.singleRecord(user).record;
		recordPanel.setText(record);
		panel.revalidate();
		panel.repaint();
		panel.updateUI();
	}
}
