package com.zhenghaigang.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * Created by zhg on 2018/3/29.
 */
public class MyProcessor implements PageProcessor {
    // 抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public Site getSite() {
        return site;
    }
    public void process(Page page) {
        page.putField("title",
                page.getHtml().xpath("//*[@class=\"introduce\"]/h1/text()").toString());
        page.putField("introduction",
                page.getHtml().xpath("//*[@class=\"jj\"]/text()").toString());
        page.putField("author",
                page.getHtml().xpath("//*[@class=\"bq\"]/span[2]/a/@author/text()").toString());
        /*page.putField("时间",
                page.getHtml().xpath("/*//*[@class=\"bq\"]/span/text()").toString());
        page.putField("状态",
                page.getHtml().xpath("/*//*[@class=\"bq\"]/span[3]").toString());
        page.putField("点击",
                page.getHtml().xpath("/*//*[@class=\"bq\"]/span[4]").toString());*/
    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("开始爬取...");
        startTime = System.currentTimeMillis();
        Spider.create(new MyProcessor()).addUrl("https://www.xswu.org/2/2841/").thread(1).run();
        endTime = System.currentTimeMillis();
        System.out.println("爬取结束，耗时约" + ((endTime - startTime) / 1000) + "秒，抓取了"+"条记录");
    }
}

