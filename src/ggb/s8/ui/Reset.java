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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ggb.s8.bll.UserBLL;

public class Reset extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reset frame = new Reset();
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
    public Reset() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 510);
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

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(10, 6, 20, 20);
        ImageIcon image1 = new ImageIcon(Reset.class.getResource("/ggb/s8/ui/icon_small.png"));
        image1.setImage(image1.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),
                Image.SCALE_DEFAULT));
        lblNewLabel_1.setIcon(new ImageIcon(Reset.class.getResource("/ggb/s8/ui/icon_20.png")));

        contentPane.add(lblNewLabel_1);

        JLabel label_1 = new JLabel("\u91CD\u7F6E\u5BC6\u7801");
        label_1.setForeground(Color.GRAY);
        label_1.setBounds(36, 6, 53, 20);
        contentPane.add(label_1);

        JLabel label_4 = new JLabel("\u91CD   \u7F6E");
        label_4.setForeground(Color.WHITE);
        label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
        label_4.setBounds(148, 447, 45, 31);
        contentPane.add(label_4);

        JButton button_2 = new JButton("");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (UserBLL.checkid(textField.getText())) {
                    UserBLL.reset(textField.getText());
                    JOptionPane.showMessageDialog(null, "����������Ϊ123456", "�ɹ�", JOptionPane.PLAIN_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(null, "û������û�", "ʧ��", JOptionPane.PLAIN_MESSAGE);
                new Login().setVisible(true);
                setVisible(false);
            }

        });
        button_2.setIcon(new ImageIcon(Reset.class.getResource("/ggb/s8/ui/\u6309\u94AE.png")));
        button_2.setContentAreaFilled(false);
        button_2.setBorder(null);
        button_2.setBounds(75, 447, 195, 31);
        contentPane.add(button_2);
        btnNewButton.setIcon(new ImageIcon(Reset.class.getResource("/ggb/s8/ui/-_grey.png")));
        btnNewButton.setBounds(290, 10, 20, 20);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorder(null);
        contentPane.add(btnNewButton);

        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);
                setVisible(false);
            }
        });
        button.setIcon(new ImageIcon(Reset.class.getResource("/ggb/s8/ui/x_grey.png")));
        button.setBounds(310, 10, 20, 20);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        contentPane.add(button);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(
                new ImageIcon(Reset.class.getResource("/ggb/s8/ui/\u7F16\u8F91\u8D44\u6599\u6807\u9898\u680F.png")));
        lblNewLabel.setBounds(0, 0, 340, 33);
        contentPane.add(lblNewLabel);

        JLabel label = new JLabel("\u8D26\u53F7");
        label.setForeground(Color.GRAY);
        label.setFont(new Font("����", Font.PLAIN, 18));
        label.setBounds(20, 209, 50, 40);
        contentPane.add(label);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(70, 209, 250, 40);
        contentPane.add(textField);
        ImageIcon image = new ImageIcon(Reset.class.getResource("/ggb/s8/ui/\u7F16\u8F91\u8D44\u6599\u4E0B\u9762.png"));
        image.setImage(image.getImage().getScaledInstance(JLabel.WIDTH, JLabel.HEIGHT, Image.SCALE_DEFAULT));
    }
}
