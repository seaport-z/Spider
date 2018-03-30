package com.zhenghaigang.scheduled;

import com.zhenghaigang.pipeline.MyPipeline;
import com.zhenghaigang.processor.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * 定时任务
 * Created by zhg on 2018/3/29.
 */
@Component
public class MyScheduled {
    @Autowired
    private MyPipeline myPipeline;

    //@Scheduled(cron = "0 0 0/2 * * ? ")//从0点开始,每2个小时执行一次
    @Scheduled(fixedRate = 100000)
    public void jianShuScheduled() {
        System.out.println("----开始执行定时任务");
        Spider spider = Spider.create(new MyProcessor());
        spider.addUrl("https://www.xswu.org/2/2841/");
        spider.addPipeline(myPipeline);
        spider.thread(1);
        spider.setExitWhenComplete(true);
        spider.start();
        spider.stop();
    }
}
