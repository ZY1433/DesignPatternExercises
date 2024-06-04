package application.manage;

import dataAccess.dao.EmployeMapper;
import dataAccess.entity.Employe;
import dataAccess.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterPass extends JFrame {

    private final JPanel contentPane;
    private final JTextField userField;
    private final JPasswordField passwordField;
    private final JPasswordField passwordField_2;
    private final JPasswordField passwordField_3;

    /**
     * Create the frame.
     */
    public AlterPass() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 262, 353);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JLabel lblNewLabel = new JLabel("用户名：");
        lblNewLabel.setBounds(10, 46, 54, 28);
        contentPane.add(lblNewLabel);
        setTitle("修改密码");


        JLabel label = new JLabel("原密码：");
        label.setBounds(10, 101, 54, 28);
        contentPane.add(label);

        JLabel label_1 = new JLabel("新密码：");
        label_1.setBounds(10, 152, 66, 28);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("确认密码：");
        label_2.setBounds(10, 203, 66, 28);
        contentPane.add(label_2);

        userField = new JTextField();
        userField.setBounds(91, 44, 102, 34);
        contentPane.add(userField);

        passwordField = new JPasswordField();
        passwordField.setBounds(91, 99, 102, 34);
        contentPane.add(passwordField);

        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(91, 150, 102, 34);
        contentPane.add(passwordField_2);

        passwordField_3 = new JPasswordField();
        passwordField_3.setBounds(91, 200, 102, 34);
        contentPane.add(passwordField_3);


        JButton button = new JButton("确定");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user;
                String oldPass;
                String newPass;
                String rePass;

                user = userField.getText();
                oldPass = new String(passwordField.getPassword());
                newPass = new String(passwordField_2.getPassword());
                rePass = new String(passwordField_3.getPassword());

                SqlSession session = MyBatisUtil.getSession();
                EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
                Employe employe =  employeMapper.query(user);
                String turePass = employe.getPasswd();

                if (!oldPass.equals(turePass)) {
                    JOptionPane.showMessageDialog(null, "原密码错误！");
                    MyBatisUtil.closeSession();
                    return;
                }
                if (newPass.length() <= 0) {
                    JOptionPane.showMessageDialog(null, "请输入密码！");
                    MyBatisUtil.closeSession();
                    return;
                }
                if ( !newPass.equals(rePass) ) {
                    JOptionPane.showMessageDialog(null, "请确认新密码相同！");
                    MyBatisUtil.closeSession();
                    return;
                }
                employeMapper.updatePass(user,newPass);
                session.commit();
                MyBatisUtil.closeSession();
                JOptionPane.showMessageDialog(null, "密码修改成功！");

                dispose();
            }
        });
        button.setBounds(91, 258, 66, 23);
        contentPane.add(button);

    }

}
