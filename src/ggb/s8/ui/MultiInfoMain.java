package ggb.s8.ui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ggb.s8.model.QQgroup;

public class MultiInfoMain extends JPanel {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public MultiInfoMain(QQgroup qQgroup) {
        setBackground(Color.WHITE);
        setBounds(0, 0, 440, 360);
        setLayout(null);

        JLabel label = new JLabel("\u7FA4\u4ECB\u7ECD");
        label.setForeground(Color.GRAY);
        label.setBounds(10, 58, 54, 15);
        add(label);

        JLabel lblNewLabel = new JLabel(qQgroup.introduce);
        lblNewLabel.setBounds(74, 58, 273, 172);
        add(lblNewLabel);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
    }
}
