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
import javax.swing.text.DefaultCaret;

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
        recordPanel.setCaretPosition(recordPanel.getText().length());
        recordPanel.setLineWrap(true); // �����Զ����й���
        recordPanel.setWrapStyleWord(true);
        recordPanel.setEditable(false);
        DefaultCaret caret = (DefaultCaret) recordPanel.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

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
        textField.setLineWrap(true); // �����Զ����й���
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

        recordPanel.setCaretPosition(recordPanel.getText().length());

        try {
            // ����һ���׽���
            socket = new Socket("127.0.0.1", 28888);
            // ����һ�����׽�����д���ݵĹܵ��������������������������Ϣ
            pWriter = new PrintWriter(socket.getOutputStream());
            // ����һ�����׽��ֶ����ݵĹܵ����������������������ķ�����Ϣ
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
                    // ͨ������������ݷ��͸�������
                    UserBLL.AddRecord(strMsg);
                    pWriter.println(strName + " ˵��" + strMsg);
                    pWriter.flush();
                    // ����ı���
                    textField.setText("");
                    updateRecord(user);
                }
            }
        });
        // �����߳�
        new GetMsgFromServer().start();

        // ���շ������ķ�����Ϣ���߳�

    }

    class GetMsgFromServer extends Thread {
        public void run() {
            while (this.isAlive()) {
                try {
                    String strMsg = bReader.readLine();
                    if (strMsg != null) {
                        // ���ı�������ʾ������Ϣ
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
        recordPanel.setCaretPosition(recordPanel.getText().length());
        panel.revalidate();
        panel.repaint();
        panel.updateUI();
    }
}
