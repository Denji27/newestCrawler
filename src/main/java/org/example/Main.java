package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> links = new ArrayList<>();
        for (int i = 1; i<=30; i++){
            UrlCrawler urlCrawler = new UrlCrawler("https://dantri.com.vn/the-thao/bong-da-chau-au/trang-" + i + ".htm", links);
            urlCrawler.linkCrawl(links);
        }
        for (int i = 1; i<=30; i++){
            UrlCrawler urlCrawler = new UrlCrawler("https://dantri.com.vn/the-thao/bong-da-trong-nuoc/trang-" + i + ".htm", links);
            urlCrawler.linkCrawl(links);
        }
        for (int i = 1; i<=30; i++){
            UrlCrawler urlCrawler = new UrlCrawler("https://dantri.com.vn/the-thao/tennis/trang-" + i + ".htm", links);
            urlCrawler.linkCrawl(links);
        }

        for(String link : links){
            ContentCrawler contentCrawler = new ContentCrawler(link);
            contentCrawler.crawl();
        }



//        ContentCrawler contentCrawler =
//                new ContentCrawler("");
//        contentCrawler.crawl();
    }
}