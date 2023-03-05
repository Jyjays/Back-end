package com.jyjays.dto;

import lombok.Data;

@Data
public class LikeDto {
    private int id;
    private int like;


    public LikeDto(int id, int like) {
        this.id=id;
        this.like=like;
    }
}
