package application.manage;

import Presentation.ManageGUI;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import dataAccess.util.DBUtil;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddCategory extends JFrame {

    private final JPanel contentPane;
    private final JTextField textField;

    /**
     * Create the frame.
     */
    public AddCategory() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 283, 213);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel lblNewLabel = new JLabel("类别名称:");
        lblNewLabel.setBounds(27, 44, 54, 28);
        contentPane.add(lblNewLabel);
        setTitle("增加类别");
        textField = new JTextField();
        textField.setBounds(127, 41, 66, 31);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DBUtil.getConnection();

                    String sql;
                    Statement st = connection.createStatement();
                    sql = "select * from tb_category where status!='移除'";
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        String s1 = rs.getString(2);

                        if (textField.getText().equals(s1)) {

                            JOptionPane.showMessageDialog(null, "已经存在该类别！");
                            return;
                        }
                    }

                    sql = "insert into tb_category(c_name) value('" + textField.getText() + "')";
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "添加成功!");
                    DrinkPanel.cateList.setModel(DrinkPanel.queryCategory(1));
                    DrinkPanel.cateList.updateUI();
                    ManageGUI.reflash();
                    dispose();
                } catch (MySQLIntegrityConstraintViolationException e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, "已经有这个类别！！");
                } catch (ClassNotFoundException | SQLException e1) {

                    e1.printStackTrace();
                }


            }
        });
        button.setBounds(127, 105, 66, 23);
        contentPane.add(button);
    }

}
