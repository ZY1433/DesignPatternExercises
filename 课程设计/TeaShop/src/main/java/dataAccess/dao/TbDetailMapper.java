package dataAccess.dao;


import dataAccess.entity.TbDetail;
import dataAccess.entity.TbDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbDetailMapper {

    int deleteByPrimaryKey(TbDetailKey key);

    int insert(TbDetail record);

    int insertSelective(TbDetail record);


    TbDetail selectByPrimaryKey(TbDetailKey key);

    int updateByPrimaryKeySelective(TbDetail record);

    int updateByPrimaryKey(TbDetail record);

    List<TbDetail> selectById(@Param("dd_id") String dd_id);


}