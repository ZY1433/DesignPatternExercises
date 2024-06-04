package dataAccess.dao;


import dataAccess.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {

    List<Member> findAll();

    List<Member> queryLike(@Param("m_id") String m_id, @Param("name") String name);

    void upDateMember(@Param("memb") Member member, @Param("om_id") String oldm_id);

    void delMember(@Param("m_id") String m_id);

    void addMember(@Param("memb") Member member);


}
