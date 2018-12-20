package ggb.s8.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ggb.s8.bll.AdminBLL;
import ggb.s8.model.User;

public class AdminPeo extends JPanel {
	private JTable table;
	private String[] columnNames = { "姓名", "ID", "状态", "注册时间", "最后登录", "最后登出" };
	DefaultTableModel dtm;

	/**
	 * Create the panel.
	 */
	public AdminPeo() {
		setBorder(null);
		setBackground(Color.WHITE);
		setSize(900, 543);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 146, 784, 216);
		add(scrollPane);

		table = new JTable();
		dtm = (DefaultTableModel) table.getModel();// 创建model
		dtm.setColumnIdentifiers(columnNames);// 创建表头，表头的类型可以是vector 或者Object[]
		scrollPane.setViewportView(table);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(AdminPeo.class.getResource("/ggb/s8/ui/\u6309\u94AE.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sc = table.getSelectedRow();
				String id = (String) table.getValueAt(sc, 1);
				AdminBLL.resetPass(id);
				JOptionPane.showMessageDialog(null, "用户" + id + " 密码重置为123456，成功", null, JOptionPane.PLAIN_MESSAGE);

			}
		});

		JLabel lblNewLabel = new JLabel("\u91CD\u7F6E\u5BC6\u7801");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(270, 406, 64, 28);
		add(lblNewLabel);

		JLabel label = new JLabel("\u5F3A\u5236\u4E0B\u7EBF");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(540, 406, 64, 28);
		add(label);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(205, 406, 195, 31);
		add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sc = table.getSelectedRow();
				String id = (String) table.getValueAt(sc, 1);
				AdminBLL.comOff(id);
				JOptionPane.showMessageDialog(null, "用户" + id + "强制下线，成功", null, JOptionPane.PLAIN_MESSAGE);
				updateTable();
				table.updateUI();
			}
		});
		button_1.setIcon(new ImageIcon(AdminPeo.class.getResource("/ggb/s8/ui/\u6309\u94AE.png")));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(null);
		button_1.setBounds(474, 406, 195, 31);
		add(button_1);
		updateTable();
	}

	void updateTable() {
		ArrayList<User> userlist = AdminBLL.returnAllUser();
		dtm.setRowCount(0);
		for (User user : userlist) {
			Vector<String> v1 = new Vector<String>();
			v1.add(user.name);
			v1.add(user.id);
			v1.add(user.state);
			v1.add(new SimpleDateFormat("yyyy-MM-dd").format(user.registertime));
			v1.add(new SimpleDateFormat("yyyy-MM-dd").format(user.lastlogin));
			v1.add(new SimpleDateFormat("yyyy-MM-dd").format(user.lastlogout));
			dtm.addRow(v1);
		}
	}
}
