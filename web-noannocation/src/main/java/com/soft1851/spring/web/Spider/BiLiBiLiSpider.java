package com.soft1851.spring.web.Spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.soft1851.spring.web.entity.Rank;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/28 9:57
 * @Version 1.0
 **/
public class BiLiBiLiSpider {
    public static final int SUCCESS = 200;


    /**
     * HttpClient和JSoup爬取B站排行榜
     */
    public static List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        String userAgent = "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
        String url = "https://www.bilibili.com/ranking?spm_id_from=333.851.b_7072696d61727950616765546162.3";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Thread.sleep(4000);
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpClient.execute(httpGet, context);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            if (statusCode == SUCCESS){
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    //res是页面
                    String res = EntityUtils.toString(entity);
                    Document document =  Jsoup.parse(res);
                    Elements scripts = document.getElementsByTag("script");
                    String wholeData = scripts.get(5).html();
                    String data = wholeData.substring(wholeData.indexOf("rankList") + 10, wholeData.indexOf("rankRouteParams") - 2);
                    JSONArray jsonArray = JSONArray.parseArray(data);
                    jsonArray.forEach(o->{
                        JSONObject json = JSONObject.parseObject(o.toString());
                        Rank rank = Rank.builder()
                                .title(json.getString("title"))
                                .author(json.getString("author"))
                                .pic(json.getString("pic"))
                                .duration(json.getString("duration"))
                                .build();
                    });

//                    Elements elements = document.getElementsByClass("rank-item");
//                    for (Element element:elements) {
//                        String num = element.child(0).text();
//                        Element contentEle = element.child(1);
//                        String title = contentEle.select(".title").text();
//                        Elements img = contentEle.select(".lazy-img img");
//                        String cover = img.attr("src");
//                        Rank rank = Rank.builder().id(Integer.parseInt(num)).title(title).cover(cover).build();
//                        ranks.add(rank);
//                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ranks;
    }

    public static void getItems() throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(60 * 1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage("https://list.jd.com/list.html?cat=9987,653,655");
        List<HtmlDivision> divs = page.getByXPath("//div[@id='plist']//ul//li[@class='gl-item']//div[@class='gl-i-wrap j-sku-item']");
        System.out.println(divs);
        for (HtmlDivision div : divs) {
            DomNodeList<DomNode> childs = div.getChildNodes();
            String name = "";
            String price = "";
            String comments = "";
            for (DomNode dn:childs) {
                NamedNodeMap map = dn.getAttributes();
                Node node = map.getNamedItem("class");
                if (node!=null){
                    String value = node.getNodeValue();
                    if (value.contains("p-name")) {
                        name = dn.asText();
                    } else if (value.contains("p-price")) {
                        price = dn.asText();
                    } else if (value.contains("p-commit")) {
                        comments = dn.asText();
                    }
                }
            }
            System.out.println(name+"//"+price+"//"+comments);
        }
    }


    public static void main(String[] args) throws IOException {
//        for (Rank rank : getRanks()) {
//            System.out.println(rank);
//        }
        getItems();
    }
}
