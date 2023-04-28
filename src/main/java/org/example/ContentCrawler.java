package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentCrawler {
    private String url;

    public Document crawl(){
        try {
            Connection con = Jsoup.connect(this.url);
            Document doc = con.get();
            if (con.response().statusCode() == 200) {
                System.out.println("Link: " + url);
                System.out.println(doc.title());
//                System.out.println(doc.getElementsByClass("title-page detail").text());
                Collection<Element> authorWraps = doc.getElementsByClass("author-wrap");
                for (Element authorWrap : authorWraps) {
                    String author = authorWrap.select("b").text();
                    System.out.println(author);
                }
                System.out.println(doc.getElementsByClass("author-time").text());
                System.out.println(doc.getElementsByClass("singular-sapo").text());
                System.out.println(doc.getElementsByClass("singular-content").text());
                return doc;
            }
            return null;
        }catch (IOException e){
            return null;
        }
    }
}
