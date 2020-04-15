package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ggb.s8.bll.UserBLL;
import ggb.s8.model.Client;

public class ChangeSelfInfo extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangeSelfInfo frame = new ChangeSelfInfo();
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
    public ChangeSelfInfo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 375, 510);
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
        ImageIcon image1 = new ImageIcon(ChangeSelfInfo.class.getResource("/ggb/s8/ui/icon_small.png"));
        image1.setImage(image1.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),
                Image.SCALE_DEFAULT));
        lblNewLabel_1.setIcon(new ImageIcon(ChangeSelfInfo.class.getResource("/ggb/s8/ui/icon_20.png")));

        contentPane.add(lblNewLabel_1);

        JLabel label_1 = new JLabel("\u7F16\u8F91\u8D44\u6599");
        label_1.setForeground(Color.GRAY);
        label_1.setBounds(36, 6, 53, 20);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("\u5173\u95ED");
        label_2.setForeground(Color.BLACK);
        label_2.setBounds(304, 479, 30, 20);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("\u4FDD\u5B58");
        label_3.setForeground(Color.BLACK);
        label_3.setBounds(229, 479, 30, 20);
        contentPane.add(label_3);
        btnNewButton.setIcon(new ImageIcon(ChangeSelfInfo.class.getResource("/ggb/s8/ui/-_grey.png")));
        btnNewButton.setBounds(330, 10, 20, 20);
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
        button.setIcon(new ImageIcon(ChangeSelfInfo.class.getResource("/ggb/s8/ui/x_grey.png")));
        button.setBounds(350, 10, 20, 20);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        contentPane.add(button);

        JButton button_1 = new JButton("");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client.curruser.name = textField.getText();
                Client.curruser.sign = textField_1.getText();
                Client.curruser.sex = textField_2.getText();
                try {
                    Client.curruser.birth = new SimpleDateFormat("yyyy-MM-dd").parse(textField_3.getText());
                } catch (ParseException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                Client.curruser.hometown = textField_4.getText();
                Client.curruser.place = textField_5.getText();
                Client.curruser.career = textField_6.getText();
                Client.curruser.company = textField_7.getText();
                Client.curruser.school = textField_8.getText();
                Client.curruser.tel = textField_9.getText();
                Client.curruser.mail = textField_10.getText();
                UserBLL.updateUserInfo(Client.curruser);
                new SelfInfo().setVisible(true);
                setVisible(false);

            }
        });
        button_1.setIcon(new ImageIcon(ChangeSelfInfo.class.getResource("/ggb/s8/ui/\u6309\u94AE2.png")));
        button_1.setContentAreaFilled(false);
        button_1.setBorder(null);
        button_1.setBounds(210, 480, 65, 20);
        contentPane.add(button_1);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SelfInfo().setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_1.setIcon(new ImageIcon(ChangeSelfInfo.class.getResource("/ggb/s8/ui/\u6309\u94AE2.png")));
        btnNewButton_1.setBounds(285, 480, 65, 20);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setBorder(null);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(
                ChangeSelfInfo.class.getResource("/ggb/s8/ui/\u7F16\u8F91\u8D44\u6599\u6807\u9898\u680F.png")));
        lblNewLabel.setBounds(0, 0, 375, 33);
        contentPane.add(lblNewLabel);

        JLabel label = new JLabel("");
        ImageIcon image = new ImageIcon(
                ChangeSelfInfo.class.getResource("/ggb/s8/ui/\u7F16\u8F91\u8D44\u6599\u4E0B\u9762.png"));
        image.setImage(image.getImage().getScaledInstance(JLabel.WIDTH, JLabel.HEIGHT, Image.SCALE_DEFAULT));
        label.setIcon(image);
        label.setBounds(0, 467, 375, 43);
        contentPane.add(label);

        JLabel label_4 = new JLabel("\u6635  \u79F0");
        label_4.setForeground(Color.GRAY);
        label_4.setBounds(10, 50, 39, 15);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("\u7B7E  \u540D");
        label_5.setForeground(Color.GRAY);
        label_5.setBounds(10, 80, 39, 15);
        contentPane.add(label_5);

        JLabel label_6 = new JLabel("\u6027  \u522B");
        label_6.setForeground(Color.GRAY);
        label_6.setBounds(10, 150, 39, 15);
        contentPane.add(label_6);

        JLabel label_7 = new JLabel("\u751F  \u65E5");
        label_7.setForeground(Color.GRAY);
        label_7.setBounds(195, 150, 39, 15);
        contentPane.add(label_7);

        JLabel label_8 = new JLabel("\u6545  \u4E61");
        label_8.setForeground(Color.GRAY);
        label_8.setBounds(10, 190, 39, 15);
        contentPane.add(label_8);

        JLabel label_9 = new JLabel("\u6240\u5728\u5730");
        label_9.setForeground(Color.GRAY);
        label_9.setBounds(195, 190, 39, 15);
        contentPane.add(label_9);

        JLabel label_10 = new JLabel("\u804C  \u4E1A");
        label_10.setForeground(Color.GRAY);
        label_10.setBounds(10, 230, 39, 15);
        contentPane.add(label_10);

        JLabel label_11 = new JLabel("\u516C  \u53F8");
        label_11.setForeground(Color.GRAY);
        label_11.setBounds(10, 265, 39, 15);
        contentPane.add(label_11);

        JLabel label_12 = new JLabel("\u5B66  \u6821");
        label_12.setForeground(Color.GRAY);
        label_12.setBounds(10, 300, 39, 15);
        contentPane.add(label_12);

        JLabel label_13 = new JLabel("\u624B  \u673A");
        label_13.setForeground(Color.GRAY);
        label_13.setBounds(10, 335, 39, 15);
        contentPane.add(label_13);

        JLabel label_14 = new JLabel("\u90AE  \u7BB1");
        label_14.setForeground(Color.GRAY);
        label_14.setBounds(10, 370, 39, 15);
        contentPane.add(label_14);

        textField = new JTextField(Client.curruser.name);
        textField.setBounds(50, 50, 300, 18);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField(Client.curruser.sign);
        textField_1.setColumns(10);
        textField_1.setBounds(50, 80, 300, 60);
        contentPane.add(textField_1);

        textField_2 = new JTextField(Client.curruser.sex);
        textField_2.setColumns(10);
        textField_2.setBounds(50, 150, 115, 18);
        contentPane.add(textField_2);

        textField_3 = new JTextField(String.valueOf(Client.curruser.birth));
        textField_3.setColumns(10);
        textField_3.setBounds(235, 150, 115, 18);
        contentPane.add(textField_3);

        textField_4 = new JTextField(Client.curruser.hometown);
        textField_4.setColumns(10);
        textField_4.setBounds(50, 190, 115, 18);
        contentPane.add(textField_4);

        textField_5 = new JTextField(Client.curruser.place);
        textField_5.setColumns(10);
        textField_5.setBounds(235, 190, 115, 18);
        contentPane.add(textField_5);

        textField_6 = new JTextField(Client.curruser.career);
        textField_6.setColumns(10);
        textField_6.setBounds(50, 230, 300, 18);
        contentPane.add(textField_6);

        textField_7 = new JTextField(Client.curruser.company);
        textField_7.setColumns(10);
        textField_7.setBounds(50, 265, 300, 18);
        contentPane.add(textField_7);

        textField_8 = new JTextField(Client.curruser.school);
        textField_8.setColumns(10);
        textField_8.setBounds(50, 300, 300, 18);
        contentPane.add(textField_8);

        textField_9 = new JTextField(Client.curruser.tel);
        textField_9.setColumns(10);
        textField_9.setBounds(50, 335, 300, 18);
        contentPane.add(textField_9);

        textField_10 = new JTextField(Client.curruser.mail);
        textField_10.setColumns(10);
        textField_10.setBounds(50, 370, 300, 18);
        contentPane.add(textField_10);
    }
}
