package dataAccess.util;

import application.order.DetailLabel;
import application.order.Drink;
import application.order.Drink_label;
import application.order.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class DBUtil {

    private static Connection conn;

    //#start   getConnection()
    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String URL = "jdbc:mysql://127.0.0.1:3306/teashop?useSSL=false&autoReconnect=true";
        String USER = "root";
        String PASSWORD = "123456";

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }

    public static void printDrink(Connection conn, JPanel panel, String name) throws SQLException {
        MainFrame.labelList.clear();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from tb_drink,tb_category where tb_drink.c_id=tb_category.c_id and tb_drink.status ='在售' and tb_category.status='正常'");
        while (rs.next()) {

            if (rs.getString(7).equals(name)) {
                Drink_label tp = new Drink_label(rs.getString("d_name"), rs.getString("price"));
                if (panel.getComponentCount() >= 6) {
                    panel.setSize(new Dimension(135, panel.getHeight() + 75));
                    panel.setPreferredSize(new Dimension(135, panel.getHeight() + 75));


                }
                panel.add(tp);
                MainFrame.labelList.add(tp);

            } else continue;

        }
        panel.revalidate();


        rs.close();
        st.close();
        conn.close();


    }




    public static Drink fillDrink(Connection conn, Drink drink, String name, Statement st) throws SQLException {


        ResultSet rs = st.executeQuery("select c_id,d_id from tb_drink where d_name='" + name + "'");
        while (rs.next()) {

            drink.setC_id(rs.getString(1));
            drink.setD_id(rs.getString(2));
        }
        String temp = drink.getC_id();


        rs = st.executeQuery("select c_name from tb_category where c_id='" + temp + "'");
        while (rs.next()) {

            drink.setC_name(rs.getString(1));

        }

        return drink;
    }


    public static String commit(Connection conn, Statement st, java.util.List<Drink> dList, String m_id, String isMeb, int point, int e_id) throws SQLException {
        java.util.Date date = new java.util.Date();
        DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
        DateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String daynum = null;
        String dd_id;
        String dd_date;
        float total = 0;
        String strdate = "";
        String today = "";
        int num = 0;

        ResultSet rs = st.executeQuery("select dd_id from tb_deal");
        while (rs.next()) {
            daynum = rs.getString(1);
            strdate = daynum.substring(0, 8);
            daynum = daynum.substring(8);

        }
        today = dateformat.format(date);


        dd_date = dateformat2.format(date);


        //如果不是同一天就从0开始;

        if (today.equals(strdate)) {
            int inum = Integer.parseInt(daynum) + 1;
            daynum = String.valueOf(Integer.parseInt(daynum) + 1);
            if (inum < 10) {
                daynum = "000" + inum;
            } else if (inum >= 10 && inum < 100) {
                daynum = "00" + inum;
            } else if (inum >= 100 && inum < 1000) {
                daynum = "0" + inum;
            }
        } else daynum = "0001";
        dd_id = dateformat.format(date);
        dd_id += daynum;
        dd_date = dateformat2.format(date);

        dList = rmRepeat(dList);

        for (Drink drink : dList) {
            float i = (float) drink.getNum();
            total += drink.getAfprice() * i;
            num += drink.getNum();
        }

        ResultSet rt = null;
        st.execute("insert into tb_deal values('" + dd_id + "','" + dd_date + "','" + total + "','" + e_id + "','" + isMeb + "','" + m_id + "'," + point + "," + num + ",'有效') ");

        for (Drink drink : dList) {
            st.execute("insert into tb_detail(dd_id,c_id,c_name,d_id,d_name,num,price)   values('" + dd_id + "','" + drink.getC_id() + "','" + drink.getC_name() + "','" + drink.getD_id() + "','" + drink.getName() + "','" + drink.getNum() + "'," + drink.getAfprice() * drink.getNum() + ") ");

        }

        if (isMeb.equals("是")) {
            rt = st.executeQuery("select m_id,point from tb_member where m_id=" + m_id);
            while (rt.next()) {
                point += rt.getInt(2);
            }


            st.execute("update tb_member set point=" + point + " where m_id=" + m_id);
        }


        JOptionPane.showMessageDialog(null, "下单成功！");

        return daynum + dd_date;

    }


    public static int cancel(java.util.List<DetailLabel> dList, String name, java.util.List<Drink> drinkList, String other) {
        int num = 0;
        for (DetailLabel detailLabel : dList) {
            if (detailLabel.name.equals(name) && detailLabel.other.equals(other) && detailLabel.isRemove) {
                //System.out.println("移除");
                num = dList.indexOf(detailLabel);
            }
        }
        dList.remove(num);
        int rint = num;
        if (drinkList != null) {
            for (Drink drink : drinkList) {
                if (drink.getName().equals(name)) {
                    num = drinkList.indexOf(drink);
                }
            }
            drinkList.remove(num);
        }

        return rint;
    }

    public static void cancel(java.util.List<DetailLabel> dList, String name, java.util.List<Drink> drinkList, String other, int rnum) {
        int num = 0;
        for (DetailLabel detailLabel : dList) {
            if (detailLabel.name.equals(name) && detailLabel.other.equals(other) && detailLabel.isRemove) {
                //System.out.println("移除");
                num = dList.indexOf(detailLabel);
            }
        }
        dList.remove(rnum);

        if (drinkList != null) {
            for (Drink drink : drinkList) {
                if (drink.getName().equals(name)) {
                    num = drinkList.indexOf(drink);
                }
            }
            drinkList.remove(num);
        }


    }


    public static void printDetail(java.util.List<DetailLabel> dList, JPanel panel) {
        panel.removeAll();

        for (DetailLabel detailLabel : dList) {
            panel.add(detailLabel);


        }
        panel.updateUI();

    }

    public static java.util.List<Drink> rmRepeat(List<Drink> dList) {

        Drink drink, drink2;

        for (int i = 0; i < dList.size(); i++) {
            for (int j = i + 1; j < dList.size(); j++) {
                drink = dList.get(i);
                drink2 = dList.get(j);
                if (drink.getD_id().equals(drink2.getD_id())) {
                    if (drink.getAfprice() == drink2.getAfprice()) {
                        dList.remove(j);
                        j--;
                        drink.setNum(drink.getNum() + 1);
                    }

                }

            }
        }


        return dList;


    }

}
