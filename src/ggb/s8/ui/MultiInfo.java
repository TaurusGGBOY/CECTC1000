package ggb.s8.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ggb.s8.model.QQgroup;

public class MultiInfo extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public MultiInfo(QQgroup qQgroup) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 440, 510);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainChat().setVisible(true);
                setVisible(false);
            }
        });

        JLabel lblNewLabel_1 = new JLabel("19\u680B601");
        lblNewLabel_1.setFont(new Font("����", Font.BOLD, 23));
        lblNewLabel_1.setBounds(67, 30, 288, 24);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

        contentPane.add(lblNewLabel_1);

        JLabel label = new JLabel("854357635");
        label.setForeground(Color.GRAY);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("����", Font.PLAIN, 14));
        label.setBounds(67, 51, 288, 20);
        contentPane.add(label);
        button.setIcon(new ImageIcon(MultiInfo.class.getResource("/ggb/s8/ui/x_1.png")));
        button.setBounds(410, 10, 20, 20);
        button.setContentAreaFilled(false);
        button.setBorder(null);
        contentPane.add(button);

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setIcon(new ImageIcon(MultiInfo.class.getResource("/ggb/s8/ui/\u7F16\u8F91\u4FE1\u606F.png")));
        btnNewButton_1.setBounds(360, 78, 50, 50);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setBorder(null);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(MultiInfo.class.getResource("/ggb/s8/ui/\u7FA4\u4FE1\u606F.png")));
        lblNewLabel.setBounds(0, 0, 440, 100);
        contentPane.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 100, 440, 50);
        contentPane.add(panel);

        JButton button_1 = new JButton("\u9996\u9875");

        button_1.setFont(new Font("����", Font.PLAIN, 14));
        button_1.setContentAreaFilled(false);
        button_1.setBorder(null);
        button_1.setBounds(142, 15, 38, 24);
        panel.add(button_1);

        JButton button_2 = new JButton("\u6210\u5458");

        button_2.setFont(new Font("����", Font.PLAIN, 14));
        button_2.setContentAreaFilled(false);
        button_2.setBorder(null);
        button_2.setBounds(235, 15, 38, 24);
        panel.add(button_2);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(null);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 150, 440, 360);
        contentPane.add(panel_2);
        CardLayout card = new CardLayout(5, 5);
        panel_2.setLayout(card);

        panel_2.add((new MultiInfoMain(qQgroup)), "p1");
        panel_2.add((new MultiInfoPeo(qQgroup)), "p2");
        panel_2.add((new ChangeMultInfo(qQgroup)), "p3");
        button_1.setForeground(new Color(26, 146, 237));

        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                card.show(panel_2, "p1");
                button_1.setForeground(new Color(26, 146, 237));
                button_2.setForeground(Color.BLACK);
            }
        });

        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(panel_2, "p2");
                button_1.setForeground(Color.BLACK);
                button_2.setForeground(new Color(26, 146, 237));
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                card.show(panel_2, "p3");
            }
        });

    }
}
