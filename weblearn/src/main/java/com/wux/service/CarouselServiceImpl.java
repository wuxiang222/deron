package com.wux.service;

import com.wux.dao.CarouselDao;
import com.wux.entity.Carousel;
import com.wux.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuxiang
 * on 2018/4/20.
 */
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDao carouselDao;

    @Override
    public Carousel findCarousel(Integer id) {
        return carouselDao.findCarousel(id);
    }

    @Override
    public List<Carousel> findAll() {
        return carouselDao.findAll();
    }

    @Override
    public void addCarousel(Carousel carousel) {
        carouselDao.addCarousel(carousel);
    }

    @Override
    public void removeCarousel(Integer id) {
        carouselDao.removeCarousel(id);
    }

    @Override
    public void modifyCarousel(Carousel carousel) {
        carouselDao.modifyCarousel(carousel);
    }
}
