package dataAccess.dao;


import dataAccess.entity.TbDeal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TbDealMapper {

    int insert(TbDeal record);

    List<TbDeal> findAll();

    List<TbDeal> queryLike(@Param("dd_id") String dd_id, @Param("m_id") String m_id);

    void upDate(TbDeal record);

    void deleteDeal(@Param("dd_id") String dd_id);


    // 按月查询总金额
    List<Map<String, Object>> getTotalAmountByMonth();

    List<Map<String, Object>> getTotalAmountByDay();
}