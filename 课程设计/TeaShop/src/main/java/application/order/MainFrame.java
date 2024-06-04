package application.order;

import application.cook.FrontFrame;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dataAccess.util.DBUtil;

public class MainFrame /*extends JFrame*/ {


    public static JTextField textField_2;
    public static List<Drink> drinklist = new ArrayList<>();
    public static List<Drink> drinkPrint = new ArrayList<>();
    public static List<Drink> detaillist = new ArrayList<>();
    public static List<Drink_label> labelList = new ArrayList<>();
    public static List<DetailLabel> detailLabelList = new ArrayList<>();
    public static List<DetailLabel> fdetailLabelList = new ArrayList<>();
    public static JPanel panel_5 = new JPanel();
    public static JPanel panel_4 = new JPanel();
    public static JLabel label_14 = new JLabel("0");
    public static JLabel label_10 = new JLabel("100%");
    public static JLabel label_11 = new JLabel("0");
    public static JLabel label_13 = new JLabel("0");
    public static JSpinner spinner_1;
    public static String sis;
    public static boolean pointEnough = true;
    static float zk = 1.0f;
    static float allzk = 1.0f;
    private static Connection conn;
    private final JScrollPane scrollPane = new JScrollPane();
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private final ButtonGroup buttonGroup_1 = new ButtonGroup();
    private final ButtonGroup buttonGroup_2 = new ButtonGroup();

    public int e_id = 1;
    public JFrame frame;
    JRadioButton B1 = new JRadioButton("正常");
    JRadioButton B2 = new JRadioButton("少冰");
    JRadioButton B3 = new JRadioButton("去冰");
    JRadioButton B4 = new JRadioButton("常温");
    JRadioButton B5 = new JRadioButton("加热");
    Statement st;
    JCheckBox chckbxNewCheckBox = new JCheckBox("珍珠");
    JCheckBox checkBox = new JCheckBox("椰果");
    JCheckBox checkBox_1 = new JCheckBox("泷珠");
    JCheckBox chckbxNewCheckBox_1 = new JCheckBox("布丁");
    JCheckBox chckbxNewCheckBox_2 = new JCheckBox("爆珠");
    JCheckBox chckbxNewCheckBox_3 = new JCheckBox("红豆");
    JSpinner spinner = new JSpinner();
    private JScrollPane scrollPane_1;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JScrollPane scrollPane_2;
    private JRadioButton T1;
    private JRadioButton T2;
    private JRadioButton T3;
    private JRadioButton S1;
    private JRadioButton S2;
    private JRadioButton S3;
    private JButton btnNewButton;
    private JButton button_1;


    /**
     * Create the application.
     *
     * @throws IOException
     */
    public MainFrame(int e_id) throws IOException {
        try {
            this.e_id = e_id;
            //System.out.println(e_id);
            initialize();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    private void initialize() throws ClassNotFoundException, SQLException, IOException {
        createGUI();

        createList();

        //添加饮品按钮
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOver3()) {
                    JOptionPane.showMessageDialog(null, "最多选三种配料！");
                    return;
                }

                Drink drink = creatDrink();

                creatdetail(drink);

                panel_5.updateUI();

                if (panel_5.getComponentCount() > 4) {
                    panel_5.setPreferredSize(new Dimension(237, panel_5.getHeight() + 105));
                    FrontFrame.panel.setPreferredSize(new Dimension(237, panel_5.getHeight() + 105));
                    scrollPane_2.getViewport().setViewPosition(new Point(0, scrollPane_2.getVerticalScrollBar().getMaximum()));
                    FrontFrame.scrollPane.getViewport().setViewPosition(new Point(0, scrollPane_2.getVerticalScrollBar().getMaximum()));
                }
            }
        });


        //计算
        textField_2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        if (Integer.parseInt(textField_2.getText()) < 0) {
                            JOptionPane.showMessageDialog(null, "输入必须大于零!");
                            textField_2.setText("");
                            return;
                        }
                        //13=t2-11
                        float tmp = 0;
                        tmp = Float.parseFloat(textField_2.getText()) - Float.parseFloat(label_11.getText());
                        tmp = (float) (Math.round(tmp * 10)) / 10;
                        label_13.setText(String.valueOf(tmp));
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "请输入大于0的数字!");
                        textField_2.setText("");
                    }

                }
            }
        });

        OrderReceiver receiver = new OrderReceiver();
        OrderCommand submitOrderCommand = new SubmitOrderCommand(receiver);

        //提交订单
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (detaillist.size() == 0) {
                    JOptionPane.showMessageDialog(null, "请先添加饮品");
                    return;
                }

                String m_id = "";
                int point = 0;
                try {
                    String numAndDate = DBUtil.commit(conn, st, detaillist, m_id, "否", point, e_id);
                    submitOrderCommand.execute(numAndDate.substring(0, 4), e_id, numAndDate.substring(4), label_14.getText(), label_11.getText(), detaillist, sis);

//                    new CheckFrame(numAndDate.substring(0, 4), e_id, numAndDate.substring(4), label_14.getText(), label_11.getText(), detaillist, sis);


                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "提交失败！");
                    e1.printStackTrace();
                    return;

                }

                panel_5.removeAll();
                panel_5.setPreferredSize(new Dimension(237, 0));
                panel_5.updateUI();
                FrontFrame.panel.removeAll();
                FrontFrame.panel.updateUI();
                label_14.setText("0");
                label_11.setText("0");
                label_13.setText("0");
                textField_2.setText("0");
                FrontFrame.label_3.setText("0");
                FrontFrame.label_4.setText("0");
                FrontFrame.panel.setPreferredSize(new Dimension(237, 0));
                panel_5.updateUI();
                B1.setSelected(true);
                T1.setSelected(true);
                S2.setSelected(true);
                detaillist.clear();
                detailLabelList.clear();
                fdetailLabelList.clear();

            }
        });
    }

    private Drink creatdetail(Drink drink) {
        float t = 0;
        for (Drink_label drink2 : labelList) {//遍历所有饮品
            if (drink2.isSelect) {
                drink.setName(drink2.lblNewLabel.getText());
                drink.setPrice(Integer.parseInt(drink2.lblNewLabel_1.getText()));
                if (drink.size.desc.equals("大杯")) {
                    drink.setPrice(drink.getPrice() + 2);
                    t = drink.price;
                    t *= zk;
                    t = (float) (Math.round(t * 10)) / 10;
                    drink.setAfprice(t);


                } else if (drink.size.desc.equals("小杯")) {
                    drink.setPrice(drink.getPrice() - 2);
                    t = drink.price;
                    System.out.println(zk);
                    t *= zk;
                    t = (float) (Math.round(t * 10)) / 10;
                    drink.setAfprice(t);

                } else {
                    t = drink.price;
                    t *= zk;
                    t = (float) (Math.round(t * 10)) / 10;
                    drink.setAfprice(t);
                }

                drink.setNum(Integer.parseInt(MainFrame.spinner_1.getModel().getValue().toString()));

                detaillist.add(drink);
            }
        }
        try {
            DBUtil.fillDrink(conn, drink, drink.getName(), st);
            if (detaillist.get(0).num == 0) {
                return drink;
            }
            int tmpprice = 0;
            for (Drink drink3 : detaillist) {
                tmpprice += drink3.price * drink3.num;
            }
            label_14.setText(String.valueOf(tmpprice));
            FrontFrame.label_3.setText(label_14.getText());


            // zk=Float.parseFloat(spinner.getModel().getValue().toString())/100;
            float yingshou = tmpprice * zk;
            yingshou = (float) (Math.round(yingshou * 10)) / 10;
            label_11.setText(String.valueOf(yingshou));
            FrontFrame.label_4.setText(label_11.getText());
            if (!textField_2.getText().equals("0")) {
                int shishou;
                shishou = Integer.parseInt(textField_2.getText());
                label_13.setText(String.valueOf(shishou - yingshou));

                spinner_1.setValue(1);


            }
        } catch (SQLException e1) {

        } catch (IndexOutOfBoundsException e2) {
            JOptionPane.showMessageDialog(null, "请选择饮品!");
            return drink;
        }

        float tpprice = 0;
        tpprice = drink.afprice;

        String other = "加";
        if (chckbxNewCheckBox.isSelected()) {
            other += chckbxNewCheckBox.getText() + " ";
        }
        if (chckbxNewCheckBox_1.isSelected()) {
            other += chckbxNewCheckBox_1.getText() + " ";
        }
        if (chckbxNewCheckBox_2.isSelected()) {
            other += chckbxNewCheckBox_2.getText() + " ";
        }
        if (chckbxNewCheckBox_3.isSelected()) {
            other += chckbxNewCheckBox_3.getText() + " ";
        }
        if (checkBox.isSelected()) {
            other += checkBox.getText() + " ";
        }
        if (checkBox_1.isSelected()) {
            other += checkBox_1.getText() + " ";
        }


        sis = drink.getIce().toString() + "," + drink.getSuger().toString() + "," + drink.getSize().toString();

        if (other == "加") {
            other = "";
        }
        //	System.out.println("afprice:"+drink.afprice);
        DetailLabel tmp = new DetailLabel(drink.name, String.valueOf(drink.num), sis, String.valueOf(tpprice), panel_5, other);
        DetailLabel tmp1 = new DetailLabel(drink.name, String.valueOf(drink.num), sis, String.valueOf(tpprice), panel_5, other);
        panel_5.add(tmp);
        DetailLabel.btnNewButton.setVisible(false);
        FrontFrame.panel.add(tmp1);
        FrontFrame.panel.updateUI();

        detailLabelList.add(tmp);
        fdetailLabelList.add(tmp1);
        return drink;
    }

    private Drink creatDrink() {
        Drink drink = new Drink();
        String swi = null;
        if (B1.isSelected())
            swi = "B1";
        else if (B2.isSelected())
            swi = "B2";
        else if (B3.isSelected())
            swi = "B3";
        else if (B4.isSelected())
            swi = "B4";
        else if (B5.isSelected())
            swi = "B5";

        switch (swi) {
            case "B1":
                drink.setIce(ICE.NOMAL);
                break;
            case "B2":
                drink.setIce(ICE.LESS);
                break;
            case "B3":
                drink.setIce(ICE.NONE);
                break;
            case "B4":
                drink.setIce(ICE.WARM);
                break;
            case "B5":
                drink.setIce(ICE.HOT);
                break;

            default:
                drink.setIce(ICE.NOMAL);
                break;
        }


        if (T1.isSelected())
            swi = "T1";
        else if (T2.isSelected())
            swi = "T2";
        else if (T3.isSelected())
            swi = "T3";

        switch (swi) {
            case "T1":
                drink.setSuger(SUGER.NOMAL);
                break;
            case "T2":
                drink.setSuger(SUGER.HALF);
                break;
            case "T3":
                drink.setSuger(SUGER.NONE);
                break;
            default:
                drink.setSuger(SUGER.NOMAL);
                break;
        }


        if (S1.isSelected())
            swi = "S1";
        else if (S2.isSelected())
            swi = "S2";
        else if (S3.isSelected())
            swi = "S3";

        switch (swi) {
            case "S1":
                drink.setSize(SIZE.L);
                break;
            case "S2":
                drink.setSize(SIZE.M);
                break;
            case "S3":
                drink.setSize(SIZE.S);
                break;
            default:
                drink.setSize(SIZE.M);
                break;
        }
        return drink;
    }

    private void createList() throws SQLException, ClassNotFoundException, IOException {
        conn = DBUtil.getConnection();
        st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tb_category where status='正常'");

        while (rs.next()) {
            if (panel_3.getComponentCount() >= 8) {
                panel_3.setSize(new Dimension(94, panel_3.getHeight() + 100));
                panel_3.setPreferredSize(new Dimension(94, panel_3.getHeight() + 50));

            }
            panel_3.add(new C_label(rs.getString("c_name"), panel_4));
        }

        rs = st.executeQuery("select * from tb_drink where status='在售'");
        while (rs.next()) {
            if (panel_4.getComponentCount() > 6) {
                panel_4.setSize(new Dimension(135, panel_4.getHeight() + 82));
                panel_4.setPreferredSize(new Dimension(135, panel_4.getHeight() + 82));
            }
            Drink_label tp = new Drink_label(rs.getString("d_name"), rs.getString("price"));
            labelList.add(tp);
            panel_4.add(tp);
        }

        frame.setVisible(true);

    }


    public void createGUI() {
        frame = new JFrame();
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/icon.png"))).getImage());

        frame.getContentPane().setBackground(Color.WHITE);
        frame.setTitle("点单界面");
        frame.setResizable(false);
        frame.setBounds(100, 100, 999, 583);
        //frame.setBackground(Color.WHITE);
        frame.setLocation(600, 100);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 10, 99, 474);
        scrollPane.setSize(99, 474);
        frame.getContentPane().add(scrollPane);

        panel_3 = new JPanel();
        panel_3.setPreferredSize(new Dimension(94, 0));
        panel_3.setSize(new Dimension(94, 400));
        FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
        flowLayout.setVgap(10);
        scrollPane.add(panel_3);
        scrollPane.setViewportView(panel_3);


        scrollPane_1 = new JScrollPane();
        scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_1.setBounds(111, 10, 182, 474);
        scrollPane_1.setSize(153, 474);
        frame.getContentPane().add(scrollPane_1);
        panel_4.setPreferredSize(new Dimension(135, 0));
        panel_4.setSize(new Dimension(135, 450));
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        scrollPane_1.add(panel_4);
        scrollPane_1.setViewportView(panel_4);


        panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(274, 10, 164, 474);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        B1.setSelected(true);
        buttonGroup.add(B1);
        B1.setBounds(10, 47, 69, 23);
        panel.add(B1);

        buttonGroup.add(B2);
        B2.setBounds(81, 47, 69, 23);
        panel.add(B2);

        buttonGroup.add(B3);
        B3.setBounds(10, 72, 69, 23);
        panel.add(B3);

        buttonGroup.add(B4);
        B4.setBounds(81, 72, 69, 23);
        panel.add(B4);

        buttonGroup.add(B5);
        B5.setBounds(10, 95, 74, 23);
        panel.add(B5);

        T1 = new JRadioButton("正常");
        T1.setSelected(true);
        buttonGroup_1.add(T1);
        T1.setBounds(10, 173, 69, 23);
        panel.add(T1);

        T2 = new JRadioButton("半糖");
        buttonGroup_1.add(T2);
        T2.setBounds(88, 173, 62, 23);
        panel.add(T2);

        T3 = new JRadioButton("无糖");
        buttonGroup_1.add(T3);
        T3.setBounds(10, 198, 69, 23);
        panel.add(T3);

        S1 = new JRadioButton("大杯");
        buttonGroup_2.add(S1);
        S1.setBounds(10, 255, 69, 23);
        panel.add(S1);

        S2 = new JRadioButton("中杯");
        S2.setSelected(true);
        buttonGroup_2.add(S2);
        S2.setBounds(88, 255, 62, 23);
        panel.add(S2);

        S3 = new JRadioButton("小杯");
        buttonGroup_2.add(S3);
        S3.setBounds(10, 280, 69, 23);
        panel.add(S3);

        spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        spinner_1.setBounds(88, 416, 41, 25);
        panel.add(spinner_1);

        btnNewButton = new JButton("添加");

        btnNewButton.setBounds(46, 448, 72, 23);
        panel.add(btnNewButton);

        chckbxNewCheckBox.setBounds(7, 337, 69, 23);
        panel.add(chckbxNewCheckBox);

        checkBox.setBounds(88, 337, 62, 23);
        panel.add(checkBox);

        checkBox_1.setBounds(7, 362, 62, 23);
        panel.add(checkBox_1);

        chckbxNewCheckBox_1.setBounds(88, 362, 62, 23);
        panel.add(chckbxNewCheckBox_1);

        chckbxNewCheckBox_2.setBounds(7, 387, 72, 23);
        panel.add(chckbxNewCheckBox_2);

        chckbxNewCheckBox_3.setBounds(88, 387, 62, 23);
        panel.add(chckbxNewCheckBox_3);

        JLabel label_12 = new JLabel("杯数:");
        label_12.setBounds(30, 419, 54, 15);
        panel.add(label_12);

        JLabel label_16 = new JLabel("温度");
        label_16.setBounds(63, 22, 54, 15);
        panel.add(label_16);

        JLabel label_17 = new JLabel("甜度");
        label_17.setBounds(63, 152, 54, 15);
        panel.add(label_17);

        JLabel label_18 = new JLabel("大小");
        label_18.setBounds(63, 234, 54, 15);
        panel.add(label_18);

        JLabel label_19 = new JLabel("加料");
        label_19.setBounds(63, 316, 54, 15);
        panel.add(label_19);

        panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBounds(448, 10, 218, 249);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel label = new JLabel("看板");
        ImageIcon img = new ImageIcon("src/main/resources/img/amiya_smile.png");
        img.setImage(img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        label.setIcon(img);
        label.setBounds(10, 10, 200, 200);
        label.setOpaque(true);
        panel_1.add(label);

        JLabel label_4 = new JLabel("今日折扣");
        label_4.setBounds(10, 220, 54, 15);
        panel_1.add(label_4);
        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                label_10.setText(spinner.getModel().getValue().toString() + "%");

                zk = Float.parseFloat(spinner.getModel().getValue().toString()) / 100;
                allzk = zk;
            }
        });

        spinner.setModel(new SpinnerNumberModel(100, 5, 100, 5));
        spinner.setBounds(152, 217, 55, 25);
        panel_1.add(spinner);


        panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_2.setBounds(448, 269, 218, 215);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel label_5 = new JLabel("总价");
        label_5.setBounds(10, 27, 54, 15);
        panel_2.add(label_5);

        JLabel label_6 = new JLabel("折扣");
        label_6.setBounds(10, 66, 54, 15);
        panel_2.add(label_6);

        JLabel label_7 = new JLabel("应收");
        label_7.setBounds(10, 102, 54, 15);
        panel_2.add(label_7);

        JLabel label_8 = new JLabel("实收");
        label_8.setBounds(10, 135, 54, 15);
        panel_2.add(label_8);

        JLabel label_9 = new JLabel("找零");
        label_9.setBounds(10, 169, 54, 15);
        panel_2.add(label_9);

        label_14.setBounds(129, 27, 54, 15);
        panel_2.add(label_14);

        label_10.setBounds(129, 66, 54, 15);
        panel_2.add(label_10);

        label_11.setBounds(129, 102, 54, 15);
        panel_2.add(label_11);

        label_13.setBounds(129, 169, 54, 15);
        panel_2.add(label_13);

        textField_2 = new JTextField();

        textField_2.setText("0");
        textField_2.setBounds(129, 132, 66, 21);
        panel_2.add(textField_2);
        textField_2.setColumns(10);

        scrollPane_2 = new JScrollPane();
        scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane_2.setBounds(674, 10, 269, 433);
        scrollPane_2.setSize(269, 433);
        frame.getContentPane().add(scrollPane_2);

        scrollPane_2.add(panel_5);
        scrollPane_2.setViewportView(panel_5);
        panel_5.setPreferredSize(new Dimension(237, 0));
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        button_1 = new JButton("提交订单");
        button_1.setBounds(775, 464, 93, 23);
        frame.getContentPane().add(button_1);


        JPanel panel_6 = new JPanel();
        panel_6.setBounds(0, 0, 993, 554);
        frame.getContentPane().add(panel_6);
        //zk = Float.parseFloat(spinner.getModel().getValue().toString()) / 100;
    }

    //判断加料数量
    public boolean isOver3() {
        int i = 0;
        if (chckbxNewCheckBox.isSelected()) {
            i++;
        }
        if (checkBox.isSelected()) {
            i++;
        }
        if (checkBox_1.isSelected()) {
            i++;
        }
        if (chckbxNewCheckBox_1.isSelected()) {
            i++;
        }
        if (chckbxNewCheckBox_2.isSelected()) {
            i++;
        }
        if (chckbxNewCheckBox_3.isSelected()) {
            i++;
        }

        return i > 3;

    }
}
