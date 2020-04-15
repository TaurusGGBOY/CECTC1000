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
import javax.swing.border.EmptyBorder;

public class LoginiFail extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginiFail frame = new LoginiFail();
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
    public LoginiFail() {
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
                setExtendedState(JFrame.ICONIFIED); // ��С��
            }
        });
        btnNewButton.setIcon(new ImageIcon(LoginiFail.class.getResource("/ggb/s8/ui/-_1.png")));
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
        button.setIcon(new ImageIcon(LoginiFail.class.getResource("/ggb/s8/ui/x_1.png")));
        button.setBounds(400, 10, 20, 20);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        contentPane.add(button);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(LoginiFail.class.getResource("/ggb/s8/ui/\u4E0A\u8FB9\u68461.png")));
        lblNewLabel.setBounds(0, 0, 430, 76);
        contentPane.add(lblNewLabel);

        JLabel label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(LoginiFail.class.getResource("/ggb/s8/ui/\u8B66\u544A\u56FE\u6807.png")));
        label_1.setBounds(40, 84, 30, 30);
        contentPane.add(label_1);

        JLabel lblNewLabel_2 = new JLabel("\u627E\u56DE\u5BC6\u7801");
        lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 11));
        lblNewLabel_2.setBounds(302, 307, 54, 15);
        contentPane.add(lblNewLabel_2);

        JLabel label = new JLabel("\u53D6\u6D88");
        label.setFont(new Font("����", Font.PLAIN, 11));
        label.setBounds(375, 307, 30, 15);
        contentPane.add(label);

        JButton button_1 = new JButton("");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reset().setVisible(true);
                setVisible(false);
            }
        });
        button_1.setIcon(new ImageIcon(LoginiFail.class.getResource("/ggb/s8/ui/\u6309\u94AE2.png")));
        button_1.setContentAreaFilled(false);
        button_1.setBorder(null);
        button_1.setBounds(290, 305, 65, 20);
        contentPane.add(button_1);

        JButton button_2 = new JButton("");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                setVisible(false);
            }
        });
        button_2.setFont(new Font("����", Font.PLAIN, 10));
        button_2.setIcon(new ImageIcon(LoginiFail.class.getResource("/ggb/s8/ui/\u6309\u94AE2.png")));
        button_2.setContentAreaFilled(false);
        button_2.setBorder(null);
        button_2.setBounds(355, 305, 65, 20);
        contentPane.add(button_2);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(LoginiFail.class.getResource("/ggb/s8/ui/\u4E0B\u8FB9\u6846.png")));
        lblNewLabel_1.setBounds(0, 298, 430, 32);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel(
                "\u4F60\u8F93\u5165\u7684\u8D26\u6237\u540D\u6216\u5BC6\u7801\u4E0D\u6B63\u786E\uFF0C\u539F\u56E0\u53EF\u80FD\u662F\uFF1A");
        lblNewLabel_3.setBounds(80, 86, 263, 15);
        contentPane.add(lblNewLabel_3);

        JLabel label_2 = new JLabel("1. \u8D26\u53F7\u540D\u8F93\u5165\u6709\u8BEF\uFF1B");
        label_2.setBounds(80, 109, 263, 15);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("2. \u5FD8\u8BB0\u5BC6\u7801\uFF1B");
        label_3.setBounds(80, 134, 263, 15);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("3. \u672A\u533A\u5206\u5B57\u6BCD\u5927\u5C0F\u5199\uFF1B");
        label_4.setBounds(80, 159, 263, 15);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("4. \u672A\u5F00\u542F\u5C0F\u952E\u76D8\uFF1B");
        label_5.setBounds(80, 184, 263, 15);
        contentPane.add(label_5);

        JLabel lblqq = new JLabel("5. \u8D26\u6237\u540D\u672A\u7ED1\u5B9ACECTC1000\u53F7\uFF1B");
        lblqq.setBounds(80, 208, 263, 15);
        contentPane.add(lblqq);

        JLabel lblcectc = new JLabel(
                "\u5982\u679C\u4F60\u7684\u5BC6\u7801\u4E22\u5931\u6216\u9057\u5FD8\uFF0C\u53EF\u627E\u56DE\u5BC6\u7801");
        lblcectc.setBounds(80, 233, 309, 15);
        contentPane.add(lblcectc);
    }
}
