package org.none.searchapi;

import com.google.api.services.customsearch.Customsearch;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtSCactus
 * @version 1.0
 */
@Service
public class SearchService {
    @Autowired
    private Logger logger;
    private Customsearch cs;

    public SearchService(){
    }

    public SearchResponse search(RequestParams params) throws IOException {
        try {
            String num = params.getNum() == null ? "10" : params.getNum().toString();
            String url = "https://www.google.com/search?q=";
            String charset = "UTF-8";
            String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36 Edge/18.17763";
            String query = String.format("%s", URLEncoder.encode(params.getQuery(), charset));
            Document document = Jsoup.connect(url + query + "&num=" + num)
                    .userAgent(userAgent)
                    .get();
            Elements items = document.getElementsByClass("rc");
            List<SearchResultItem> itemList = new ArrayList<>();
            items.forEach(item -> {
                // rc -> yuRUbf -> a -> href -> attr value
                String currentUrl = item.child(0).child(0).attr("href");
                // rc -> yuRUbf -> a -> LC201b DKV0Md -> span -> data
                String title = item.child(0).child(0).child(1).child(0).text();
                String keyword = "not found";
                String text;
                // if keywords found
                if (item.child(1).child(0).child(0).child(0).childNodes().size() > 1) {
                    // rc -> IsZvec -> div -> aCOpRe -> span -> em -> text
                    keyword = item.child(1).child(0).child(0).child(0).child(0).text();
                    // rc -> IsZvec -> div -> aCOpRe -> span ->  textNode ->text
                    text = item.child(1).child(0).child(0).child(0).text();
                } else {
                    // rc -> IsZvec -> div -> aCOpRe -> span ->  textNode ->text
                    text = item.child(1).child(0).child(0).child(0).text();
                }

          /*  if (!currentUrl.startsWith("https://webcache") && !currentUrl.startsWith("http://webcache")){
                linksList.add(currentUrl);
            }*/
                itemList.add(new SearchResultItem(title, currentUrl, keyword, text));
            });
            return new SearchResponse(itemList, itemList.size());
        }catch (HttpStatusException e){
            return new SearchResponse("Search engine returned status code: "+e.getStatusCode());
        }
    }
}
