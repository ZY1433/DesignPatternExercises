package application.cook;

import application.order.DetailLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FrontFrame extends JFrame {

    /**
     * Create the frame.
     */

    public static List<DetailLabel> list2 = new ArrayList<>();
    public static JPanel panel = new JPanel();
    public static JLabel label_3;
    public static JLabel label_4;
    public static JScrollPane scrollPane;
    public static JLabel lblNewLabel_1;
    public static JLabel label_1;
    public static JLabel lblNewLabel;
    static ImageIcon img;
    private static JLabel label;
    private final JPanel contentPane;
    private final JLabel label_2;
    private final JLabel label_5;

    public FrontFrame() {
        setResizable(false);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon.png"))).getImage());


        setTitle("客户窗口");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 537, 530);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 184, 433);
        scrollPane.setSize(184, 433);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        contentPane.add(scrollPane);


        scrollPane.add(panel);
        scrollPane.setViewportView(panel);
        panel.setPreferredSize(new Dimension(237, 0));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        img = new ImageIcon("src/main/resources/img/2.jpg");
        lblNewLabel = new JLabel("");
        img.setImage(img.getImage().getScaledInstance(270, 250, Image.SCALE_DEFAULT));
        lblNewLabel.setIcon(img);
        lblNewLabel.setBounds(204, 52, 267, 194);
        lblNewLabel.setOpaque(false);
        contentPane.add(lblNewLabel);


        img = new ImageIcon("src/main/resources/img/1.jpg");
        img.setImage(img.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
        lblNewLabel_1 = new JLabel("图片2");
        lblNewLabel_1.setIcon(img);
        lblNewLabel_1.setBounds(204, 256, 128, 129);
        lblNewLabel_1.setOpaque(true);
        contentPane.add(lblNewLabel_1);

        label = new JLabel("图片3");
        img = new ImageIcon("src/main/resources/img/3.jpg");
        img.setImage(img.getImage().getScaledInstance(128, 128, Image.SCALE_DEFAULT));
        label.setIcon(img);
        label.setBounds(345, 256, 128, 129);
        label.setOpaque(true);
        contentPane.add(label);

        label_1 = new JLabel("总价:");
        label_1.setBounds(387, 397, 42, 15);
        contentPane.add(label_1);

        label_2 = new JLabel("应收:");
        label_2.setBounds(387, 422, 42, 15);
        contentPane.add(label_2);

        label_3 = new JLabel("0");
        label_3.setHorizontalAlignment(SwingConstants.RIGHT);
        label_3.setBounds(429, 397, 42, 15);
        contentPane.add(label_3);

        label_4 = new JLabel("0");
        label_4.setHorizontalAlignment(SwingConstants.RIGHT);
        label_4.setBounds(429, 422, 42, 15);
        contentPane.add(label_4);

        label_5 = new JLabel("人气饮品");
        label_5.setFont(new Font("宋体", Font.PLAIN, 18));
        label_5.setBounds(302, 14, 72, 28);
        contentPane.add(label_5);


    }


}
