package com.zhenghaigang.mapper;


import com.zhenghaigang.entity.Story;

public interface StoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Story record);

    int insertSelective(Story record);

    Story selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Story record);

    int updateByPrimaryKey(Story record);
}