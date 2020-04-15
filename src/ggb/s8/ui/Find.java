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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ggb.s8.bll.UserBLL;
import ggb.s8.model.QQgroup;
import ggb.s8.model.User;

public class Find extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Find frame = new Find();
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
    public Find() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 620, 440);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setExtendedState(JFrame.ICONIFIED); // ��С��
            }
        });

        JLabel label_4 = new JLabel("\u67E5\u627E");
        label_4.setForeground(Color.WHITE);
        label_4.setFont(new Font("����", Font.BOLD, 13));
        label_4.setBounds(476, 93, 36, 23);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("\u521B\u5EFA\u7FA4");
        label_5.setForeground(Color.WHITE);
        label_5.setFont(new Font("����", Font.BOLD, 13));
        label_5.setBounds(546, 93, 47, 23);
        contentPane.add(label_5);

        JButton button_3 = new JButton("");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new CreateGroup().setVisible(true);
                setVisible(false);
            }
        });
        button_3.setIcon(new ImageIcon(Find.class.getResource("/ggb/s8/ui/\u6CE8\u518C\u6309\u94AE.png")));
        button_3.setContentAreaFilled(false);
        button_3.setBorder(null);
        button_3.setBounds(539, 93, 60, 22);
        contentPane.add(button_3);

        JButton button_2 = new JButton("");

        button_2.setIcon(new ImageIcon(Find.class.getResource("/ggb/s8/ui/\u53D1\u9001\u6309\u94AE.png")));
        button_2.setContentAreaFilled(false);
        button_2.setBorder(null);
        button_2.setBounds(463, 92, 60, 22);
        contentPane.add(button_2);
        btnNewButton.setIcon(new ImageIcon(Find.class.getResource("/ggb/s8/ui/-_grey.png")));
        btnNewButton.setBounds(559, 20, 20, 20);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorder(null);
        contentPane.add(btnNewButton);

        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainChat().setVisible(true);
                setVisible(false);
            }
        });
        button.setIcon(new ImageIcon(Find.class.getResource("/ggb/s8/ui/x_grey.png")));
        button.setBounds(579, 20, 20, 20);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        contentPane.add(button);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(73, 85, 357, 40);
        contentPane.add(textField);

        JLabel label_3 = new JLabel("\u60CA\u5929\u4E00\u5251");
        label_3.setForeground(Color.BLACK);
        label_3.setFont(new Font("����", Font.PLAIN, 18));
        label_3.setBounds(116, 208, 104, 40);
        contentPane.add(label_3);

        JLabel label = new JLabel("85357635");
        label.setForeground(Color.BLACK);
        label.setFont(new Font("����", Font.PLAIN, 18));
        label.setBounds(230, 208, 141, 40);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u6635\u79F0");
        label_1.setForeground(Color.GRAY);
        label_1.setFont(new Font("����", Font.PLAIN, 18));
        label_1.setBounds(10, 208, 82, 91);
        ImageIcon image = new ImageIcon(Login.class.getResource("/ggb/s8/ui/h1.png"));
        image.setImage(
                image.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
        label_1.setIcon(image);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("\u6DFB\u52A0");
        label_2.setForeground(Color.WHITE);
        label_2.setFont(new Font("����", Font.BOLD, 13));
        label_2.setBounds(129, 259, 36, 23);
        contentPane.add(label_2);

        JButton button_1 = new JButton("");
        button_1.setIcon(new ImageIcon(Find.class.getResource("/ggb/s8/ui/\u53D1\u9001\u6309\u94AE.png")));
        button_1.setContentAreaFilled(false);
        button_1.setBorder(null);
        button_1.setBounds(116, 258, 60, 22);
        contentPane.add(button_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
        lblNewLabel.setForeground(Color.BLUE);
        lblNewLabel.setBounds(206, 136, 165, 23);
        contentPane.add(lblNewLabel);

        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String id = label.getText();
                if (id.substring(0, 1).equals("u")) {
                    if (UserBLL.addFriend(id)) {
                        lblNewLabel.setText("��ӳɹ�");
                    } else {
                        lblNewLabel.setText("���ʧ��");
                    }
                } else if (id.substring(0, 1).equals("Q")) {
                    if (UserBLL.addGroup(id)) {
                        lblNewLabel.setText("��ӳɹ�");
                    } else {
                        lblNewLabel.setText("���ʧ��");
                    }
                }

            }
        });

        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String id = textField.getText();
                String head = "";
                String name = "";
                if (id.substring(0, 1).equals("u")) {
                    User user = UserBLL.returnuser(id);
                    head = user.head;
                    name = user.name;
                } else if (id.substring(0, 1).equals("Q")) {
                    QQgroup qgroup = UserBLL.returnGroup(id);
                    head = qgroup.head;
                    name = qgroup.name;
                }
                label.setText(id);
                label_3.setText(name);
                ImageIcon image1 = new ImageIcon(Login.class.getResource("/ggb/s8/ui/" + head + ".png"));
                image1.setImage(image1.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(),
                        Image.SCALE_DEFAULT));
                label_1.setIcon(image1);

            }
        });
    }
}
