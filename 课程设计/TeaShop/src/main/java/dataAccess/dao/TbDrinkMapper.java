package dataAccess.dao;



import dataAccess.entity.TbDrink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbDrinkMapper {

    int deleteByPrimaryKey(Integer dId);

    int insert(TbDrink record);

    int insertSelective(TbDrink record);

    TbDrink selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(TbDrink record);

    int updateByPrimaryKey(TbDrink record);

    List<TbDrink> queryLike(@Param("d_Name") String d_Name);

    List<TbDrink> findAll();


}