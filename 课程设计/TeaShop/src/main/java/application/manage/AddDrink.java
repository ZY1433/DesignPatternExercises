package application.manage;



import Presentation.ManageGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import dataAccess.util.DBUtil;

public class AddDrink extends JFrame {

    private final ButtonGroup buttonGroup = new ButtonGroup();
    JRadioButton radioButton;
    JRadioButton radioButton_1;
    JComboBox<String> comboBox;
    private final JPanel contentPane;
    private final JTextField textField_1;
    private final JTextField textField_2;

    /**
     * Create the frame.
     */
    public AddDrink(List<String> c_nameArr, int c_index) {
        setResizable(false);
        setTitle("添加饮品");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 357, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("类别名称:");
        lblNewLabel.setBounds(27, 26, 54, 28);
        contentPane.add(lblNewLabel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String status = "";
                    int c_id = 0;

                    if (radioButton.isSelected())
                        status = "在售";
                    else
                        status = "停售";

                    if (textField_1.getText().equals("") || textField_2.getText().equals("") || Integer.parseInt(textField_2.getText()) <= 0) {
                        JOptionPane.showMessageDialog(null, "请输入饮品名并且金额要大于0！！");
                        return;
                    }


                    Connection connection = DBUtil.getConnection();
                    String sql = "select c_id from tb_category where c_name='" + comboBox.getSelectedItem() + "'";
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql);

                    while (rs.next()) {
                        c_id = rs.getInt(1);
                    }

                    sql = "select * from tb_drink where status!='移除'";
                    rs = statement.executeQuery(sql);

                    while (rs.next()) {
                        String s1 = rs.getString(2);

                        if (textField_1.getText().equals(s1)) {
                            JOptionPane.showMessageDialog(null, "已经存在该饮品！");
                            return;
                        }

                    }


                    sql = "insert into tb_drink(d_name,c_id,price,status) "
                            + "values(?,?,?,?) ";
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setString(1, textField_1.getText());
                    st.setInt(2, c_id);
                    st.setInt(3, Integer.parseInt(textField_2.getText()));
                    st.setString(4, status);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "添加成功!");
                    ManageGUI.reflash();
                    DrinkPanel.drinkList.setModel(DrinkPanel.queryCategory(2));
                    DrinkPanel.drinkList.updateUI();
                    dispose();
                } catch (ClassNotFoundException | SQLException e1) {
                    JOptionPane.showMessageDialog(null, "饮品名已经存在！！");
                    e1.printStackTrace();
                }

            }
        });
        button.setBounds(223, 218, 66, 23);
        contentPane.add(button);

        JLabel label = new JLabel("饮品名称:");
        label.setBounds(27, 83, 54, 28);
        contentPane.add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(126, 82, 84, 31);
        contentPane.add(textField_1);

        JLabel label_1 = new JLabel("饮品价格:");
        label_1.setBounds(27, 135, 54, 28);
        contentPane.add(label_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(126, 134, 84, 31);
        contentPane.add(textField_2);

        JLabel label_2 = new JLabel("状态:");
        label_2.setBounds(27, 187, 54, 28);
        contentPane.add(label_2);

        radioButton = new JRadioButton("在售");
        buttonGroup.add(radioButton);
        radioButton.setBounds(116, 190, 77, 23);
        contentPane.add(radioButton);
        radioButton.setSelected(true);

        radioButton_1 = new JRadioButton("停售");
        buttonGroup.add(radioButton_1);
        radioButton_1.setBounds(195, 189, 71, 23);
        contentPane.add(radioButton_1);

        comboBox = new JComboBox<>();
        comboBox.setBounds(124, 30, 130, 28);
        contentPane.add(comboBox);

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

        for (String c_name : c_nameArr) {
            model.addElement(c_name);
        }
        comboBox.setModel(model);

        if (c_index == -1) c_index = 0;
        comboBox.setSelectedIndex(c_index);
        comboBox.updateUI();

    }

}
