package com.wux.service;

import com.wux.entity.Carousel;
import com.wux.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/18.
 */
public interface CarouselService {
    Carousel findCarousel(@Param("id") String id);
    List<Carousel> findAll();
    void addCarousel(Carousel carousel);
    void removeCarousel(@Param("id") Integer id);
    void modifyCarousel(Carousel carousel);
}
