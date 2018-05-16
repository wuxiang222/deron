package com.wux.dao;

import com.wux.entity.Cuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/5/4.
 */
@Repository
public interface CuserDao {
    List<Cuser> showCuser(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    Integer showTotalCuser();

    void removeCuser(@Param("id")String id);

    void updateCuser(Cuser cuser);

    void insertCuser(Cuser cuser);

    Cuser login(@Param("username")String username, @Param("password")String password);
}
