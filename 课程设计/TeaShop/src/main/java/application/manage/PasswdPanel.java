package application.manage;


//import businessLogic.manage.AlterPass;
import Presentation.ManageGUI;
import dataAccess.dao.EmployeMapper;
import dataAccess.entity.Employe;
import dataAccess.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PasswdPanel extends JPanel {
    String basePass;
    String realPass;
    private final JTextField textField;
    private final JPasswordField textField2;


    public PasswdPanel() throws ClassNotFoundException {


        setLayout(null);
        setSize(new Dimension(665, 597));

        JButton btnNewButton = new JButton("验证");

        btnNewButton.setBounds(404, 276, 93, 23);
        add(btnNewButton);

        JLabel label = new JLabel("账号：");
        label.setBounds(78, 280, 73, 15);
        add(label);

        JLabel label2 = new JLabel("密码：");
        label2.setBounds(78, 320, 73, 15);
        add(label2);

        JButton button_3 = new JButton("退出");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button_3.setBounds(523, 523, 93, 23);
        add(button_3);

        JLabel lblNewLabel = new JLabel("<html><u><i>修改口令</i></u></html>");
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                new AlterPass().setVisible(true);
            }
        });
        lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.ITALIC));
        lblNewLabel.setBounds(424, 309, 54, 30);
        add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(161, 277, 118, 21);
        add(textField);

        textField2 = new JPasswordField();
        textField2.setBounds(161, 317, 118, 21);
        add(textField2);

        //验证按钮
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = textField.getText();
                String password = new String(textField2.getPassword());
                String turePass = "";

                SqlSession session = MyBatisUtil.getSession();
                EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
                Employe employe =  employeMapper.query(user);
                turePass = employe.getPasswd();
                MyBatisUtil.closeSession();


                if (password.equals(turePass)) {
                    JOptionPane.showMessageDialog(null, "验证成功！");
                    ManageGUI.panel_1.removeAll();
                    ManageGUI.panel_1.add(new MembPanel());
                    ManageGUI.panel_1.updateUI();
                    ManageGUI.lock = true;
                } else JOptionPane.showMessageDialog(null, "验证失败！");
            }
        });


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("src/main/resources/img/passwd.jpg");
//        img.setImage(img.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
        img.paintIcon(this, g, 0, 0);
    }


}
