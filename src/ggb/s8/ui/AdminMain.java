package ggb.s8.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ggb.s8.dal.MySQLHelper;
import ggb.s8.model.Client;

public class AdminMain extends JFrame {

    private JPanel contentPane;
    ChatServer cServer;
    CardLayout card;
    JPanel panel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminMain frame = new AdminMain();
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
    public AdminMain() {
        setBackground(Color.WHITE);
        new MySQLHelper().setProperty("head", Client.curruser.head);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setLocationRelativeTo(null);
        setUndecorated(true);

        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);

        setContentPane(contentPane);
        contentPane.setLayout(null);
        ImageIcon image = new ImageIcon(Login.class.getResource("/ggb/s8/ui/" + Client.curruser.head + ".png"));
        image.setImage(image.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2
                .setIcon(new ImageIcon(AdminMain.class.getResource("/ggb/s8/ui/\u5411\u4E0A\u7684\u7BAD\u5934.png")));
        lblNewLabel_2.setBounds(378, 50, 10, 10);
        contentPane.add(lblNewLabel_2);

        JButton button_5 = new JButton("");
        button_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(panel_2, "p2");
                lblNewLabel_2.setBounds(button_5.getBounds().x + 10, lblNewLabel_2.getBounds().y,
                        (int) lblNewLabel_2.getBounds().getWidth(), (int) lblNewLabel_2.getBounds().getHeight());
                contentPane.updateUI();
            }
        });

        JButton button_2 = new JButton("");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                card.show(panel_2, "p1");
                lblNewLabel_2.setBounds(button_2.getBounds().x + 10, lblNewLabel_2.getBounds().y,
                        (int) lblNewLabel_2.getBounds().getWidth(), (int) lblNewLabel_2.getBounds().getHeight());
                contentPane.updateUI();
            }
        });
        button_2.setIcon(new ImageIcon(AdminMain.class.getResource("/ggb/s8/ui/\u804A\u5929_\u4E0D\u6D3B\u52A8.png")));
        button_2.setContentAreaFilled(false);
        button_2.setBorder(null);
        button_2.setBounds(367, 14, 30, 30);
        contentPane.add(button_2);
        button_5.setIcon(new ImageIcon(AdminMain.class.getResource("/ggb/s8/ui/\u597D\u53CB.png")));
        button_5.setContentAreaFilled(false);
        button_5.setBorder(null);
        button_5.setBounds(442, 14, 30, 30);
        contentPane.add(button_5);

        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.ICONIFIED); // ��С��
            }
        });

        JButton button_3 = new JButton("");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                card.show(panel_2, "p3");
                lblNewLabel_2.setBounds(button_3.getBounds().x + 10, lblNewLabel_2.getBounds().y,
                        (int) lblNewLabel_2.getBounds().getWidth(), (int) lblNewLabel_2.getBounds().getHeight());
                contentPane.updateUI();
            }
        });
        button_3.setIcon(new ImageIcon(AdminMain.class.getResource("/ggb/s8/ui/\u670D\u52A1\u5668.png")));
        button_3.setContentAreaFilled(false);
        button_3.setBorder(null);
        button_3.setBounds(511, 14, 30, 30);
        contentPane.add(button_3);
        button.setIcon(new ImageIcon(AdminMain.class.getResource("/ggb/s8/ui/-_1.png")));
        button.setContentAreaFilled(false);
        button.setBorder(null);
        button.setBounds(829, 18, 20, 20);
        contentPane.add(button);

        JButton button_1 = new JButton("");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button_1.setIcon(new ImageIcon(AdminMain.class.getResource("/ggb/s8/ui/x_1.png")));
        button_1.setContentAreaFilled(false);
        button_1.setBorder(null);
        button_1.setBounds(859, 18, 20, 20);
        contentPane.add(button_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel
                .setIcon(new ImageIcon(AdminMain.class.getResource("/ggb/s8/ui/\u804A\u5929\u4E0A\u8FB9\u6846.png")));
        lblNewLabel.setBounds(0, 0, 900, 57);
        contentPane.add(lblNewLabel);

        panel_2 = new JPanel();
        panel_2.setBorder(null);
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 57, 900, 543);
        contentPane.add(panel_2);

        card = new CardLayout(5, 5);
        panel_2.setLayout(card);

        panel_2.add((new AdminStatics()), "p1");
        panel_2.add((new AdminPeo()), "p2");
        panel_2.add((new AdminServer()), "p3");

        card.show(panel_2, "p1");

        cServer = new ChatServer();

    }
}
