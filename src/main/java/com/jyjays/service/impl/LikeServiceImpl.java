package com.jyjays.service.impl;

import com.jyjays.domain.Like;
import com.jyjays.dto.LikeDto;
import com.jyjays.mapper.LikeMapper;
import com.jyjays.service.LikeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LikeServiceImpl implements LikeService {
    @Resource
    private LikeMapper likeMapper;

    @Override
    public void setlike(LikeDto likeDto) {
        likeMapper.setLike(likeDto);
    }

    @Override
    public void increaseLike(int id) {
        likeMapper.increaseLike(id);
    }

    @Override
    public Like selectLike(int id) {
        return likeMapper.getLike(id);
    }

    @Override
    public boolean deleteLike(int id) {
        return likeMapper.deleteLike(id)>0;
    }
}

