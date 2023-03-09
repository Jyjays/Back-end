package com.jyjays.service;

import com.jyjays.domain.Like;
import com.jyjays.dto.LikeDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LikeService {

    public void setlike(LikeDto likeDto);

    public boolean increaseLike(int id);

    public Like selectLike(int id);

    public boolean deleteLike(int id);

}