package application.manage;


import dataAccess.util.DBUtil;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterCategory extends JFrame {

    private final JPanel contentPane;
    private final JTextField textField;
    private final JTextField textField_1;

    /**
     * Create the frame.
     */
    public AlterCategory(String name) {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 276, 255);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setTitle("修改类别");
        JLabel lblNewLabel = new JLabel("类别名称:");
        lblNewLabel.setBounds(29, 42, 54, 28);
        contentPane.add(lblNewLabel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        textField = new JTextField(name);
        textField.setEditable(false);
        textField.setBounds(127, 41, 66, 31);
        contentPane.add(textField);
        textField.setColumns(10);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField_1.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "不能为空!");
                        return;
                    }

                    Connection connection = DBUtil.getConnection();
                    String sql;
                    Statement st = connection.createStatement();
                    sql = "select * from tb_category where status!='移除'";
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        String s1 = rs.getString(2);

                        if (textField_1.getText().equals(s1)) {
                            JOptionPane.showMessageDialog(null, "已经存在该类别！");
                            return;
                        }
                    }
                    sql = "update  tb_category set c_name='" + textField_1.getText() + "' where c_name='" + textField.getText() + "'";
                    st = connection.createStatement();
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "修改成功!");
                    DrinkPanel.cateList.setModel(DrinkPanel.queryCategory(1));
                    DrinkPanel.cateList.updateUI();
                    dispose();
                } catch (ClassNotFoundException | SQLException e1) {

                    e1.printStackTrace();
                }


            }
        });
        button.setBounds(127, 143, 66, 23);
        contentPane.add(button);

        JLabel label = new JLabel("修改为:");
        label.setBounds(29, 93, 54, 28);
        contentPane.add(label);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(127, 92, 66, 31);
        contentPane.add(textField_1);
    }

}
