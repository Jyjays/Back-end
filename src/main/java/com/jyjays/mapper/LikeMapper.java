package com.jyjays.mapper;

import com.jyjays.domain.Like;
import com.jyjays.dto.LikeDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LikeMapper {

    @Insert("insert into article_like(id, `like`)VALUES (#{id},#{like}) ;")
    void setLike(LikeDto likeDto);

    @Update("update article_like set `like` = `like`+1 where id=#{id}")
    int increaseLike(int id);

    @Select("select * from article_like where id=#{id}")
    Like getLike(int id);

    @Delete("delete from article_like where id=#{id}")
    int deleteLike(int id);
}
