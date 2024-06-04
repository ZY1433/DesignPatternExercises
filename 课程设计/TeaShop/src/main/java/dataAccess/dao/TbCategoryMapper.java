package dataAccess.dao;


import dataAccess.entity.TbCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCategoryMapper {


    int deleteByPrimaryKey(Integer cId);

    int insert(TbCategory record);

    int insertSelective(TbCategory record);

    TbCategory selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(TbCategory record);

    int updateByPrimaryKey(TbCategory record);

    List<TbCategory> queryLike(@Param("c_Name") String c_Name);

    void delCate(@Param("c_Name") String c_Name);

}