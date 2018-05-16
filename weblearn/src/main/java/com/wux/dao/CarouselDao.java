package com.wux.dao;

import com.wux.entity.Carousel;
import com.wux.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */
@Repository
public interface CarouselDao {
    Carousel findCarousel(@Param("id") Integer id);
    List<Carousel> findAll();
    void addCarousel(Carousel carousel);
    void removeCarousel(@Param("id") Integer id);
    void modifyCarousel(Carousel carousel);
}
