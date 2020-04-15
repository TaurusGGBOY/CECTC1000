package ggb.s8.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultTreeCellRenderer;

public class Test3 extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Test3 frame = new Test3();
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
    public Test3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.BLACK);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JPanel panel = new JPanel();
        panel.setSize(10, 10);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 93, 158);
        panel.setBackground(Color.BLUE);
        scrollPane.setViewportView(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        contentPane.add(scrollPane);
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(10, 199, 93, 23);
        contentPane.add(btnNewButton);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(275, 10, 93, 145);
        contentPane.add(panel_1);

        JTree tree = new JTree();
        DefaultTreeCellRenderer dtcr = new DefaultTreeCellRenderer();// �������ڵ�Ļ�����
        ImageIcon leafIcon = new ImageIcon("src/ggb/s8/ui/����Ա.png");
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            tree.setCellRenderer(renderer);
        }

        tree.setCellRenderer(dtcr);// �������Ľڵ������
        dtcr.setOpenIcon(new ImageIcon("src/ggb/s8/ui/��ά��ͼ��1.png"));
        dtcr.setClosedIcon(new ImageIcon("src/ggb/s8/ui/��ʼ��.png"));
        dtcr.setLeafIcon(new ImageIcon("src/ggb/s8/ui/����Ա.png"));
        tree.putClientProperty("JTree.lineStyle", "Angled");
        panel_1.add(tree);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(120, 50, 100, 100);
        contentPane.add(panel_2);

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);

        JLabel lblAsdfsdaf = new JLabel("asdfsdaf");
        panel_3.add(lblAsdfsdaf);

        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel_2.removeAll();
                panel_2.add(new Test2());
            }
        });
        btnNewButton_1.setBounds(127, 179, 93, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("fasdfsafdsa");
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.setIcon(new ImageIcon(Test3.class.getResource("/ggb/s8/ui/h2.png")));
        btnNewButton_2.setBounds(92, 209, 293, 42);
        contentPane.add(btnNewButton_2);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panel.add(new JButton("12345"));
                panel.revalidate();
            }
        });

    }
}
