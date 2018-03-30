package com.zhenghaigang.pipeline;

import com.zhenghaigang.entity.Story;
import com.zhenghaigang.mapper.StoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;
import java.util.Set;

/**
 * 用于保存数据到数据库
 * Created by zhg on 2018/3/29.
 */
@Repository
public class MyPipeline implements Pipeline{
    @Autowired
    private StoryMapper storyMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> map = resultItems.getAll();
        Story story = new Story();
        story.setTitle(map.get("title").toString());
        story.setAuthor(map.get("author").toString());
        story.setIntroduction(map.get("introduction").toString());
        storyMapper.insert(story);

    }
}
