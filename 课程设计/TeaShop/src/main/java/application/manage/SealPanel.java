package application.manage;

import dataAccess.dao.TbDealMapper;
import dataAccess.entity.TbDeal;
import dataAccess.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class SealPanel extends JPanel {

    private final JTable orderTable;
    private final JTable dailySummaryTable;
    private final JTable monthlySummaryTable;
    private final TbDealMapper tbDealMapper;

    public SealPanel() {
        SqlSession session = MyBatisUtil.getSession();
        TbDealMapper tbDealMapper = session.getMapper(TbDealMapper.class);
        this.tbDealMapper = tbDealMapper;
        setSize(new Dimension(665, 597));
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Orders tab
        JPanel ordersPanel = new JPanel(new BorderLayout());
        orderTable = new JTable(new DefaultTableModel(new Object[]{"订单ID", "日期", "金额", "状态"}, 0));
        ordersPanel.add(new JScrollPane(orderTable), BorderLayout.CENTER);
        tabbedPane.addTab("订单列表", ordersPanel);

        // Daily Summary tab
        JPanel dailySummaryPanel = new JPanel(new BorderLayout());
        dailySummaryTable = new JTable(new DefaultTableModel(new Object[]{"日期", "总金额"}, 0));
        dailySummaryPanel.add(new JScrollPane(dailySummaryTable), BorderLayout.CENTER);
        tabbedPane.addTab("每日汇总", dailySummaryPanel);

        // Monthly Summary tab
        JPanel monthlySummaryPanel = new JPanel(new BorderLayout());
        monthlySummaryTable = new JTable(new DefaultTableModel(new Object[]{"月份", "总金额"}, 0));
        monthlySummaryPanel.add(new JScrollPane(monthlySummaryTable), BorderLayout.CENTER);
        tabbedPane.addTab("每月汇总", monthlySummaryPanel);

        add(tabbedPane, BorderLayout.CENTER);

        loadOrderData();
        loadDailySummaryData();
        loadMonthlySummaryData();
    }

    private void loadOrderData() {
        List<TbDeal> orders = tbDealMapper.findAll();
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);
        for (TbDeal order : orders) {
            model.addRow(new Object[]{order.getDd_Id(), order.getDd_Date(), order.getTotal(), order.getStatus()});
        }
    }

    private void loadDailySummaryData() {
        List<Map<String, Object>> dailySummary = tbDealMapper.getTotalAmountByDay();
        DefaultTableModel model = (DefaultTableModel) dailySummaryTable.getModel();
        model.setRowCount(0);
        for (Map<String, Object> summary : dailySummary) {
            model.addRow(new Object[]{summary.get("day"), summary.get("total_amount")});
        }
    }

    private void loadMonthlySummaryData() {
        List<Map<String, Object>> monthlySummary = tbDealMapper.getTotalAmountByMonth();
        DefaultTableModel model = (DefaultTableModel) monthlySummaryTable.getModel();
        model.setRowCount(0);
        for (Map<String, Object> summary : monthlySummary) {
            model.addRow(new Object[]{summary.get("month"), summary.get("total_amount")});
        }
    }

}

