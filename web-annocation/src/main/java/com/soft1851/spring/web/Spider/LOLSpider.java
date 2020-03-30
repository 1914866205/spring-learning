package com.soft1851.spring.web.Spider;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.soft1851.spring.web.entity.Hero;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/28 12:45
 * @Version 1.0
 **/
public class LOLSpider {
    private static final Integer SUCCESS = 200;

    public static List<Hero> getHeros() throws IOException {
        List<Hero> heros = new ArrayList<>();
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(60 * 1000);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage("https://lol.qq.com/data/info-heros.shtml");
        //获取所有a标签
        List<DomNode> divs = page.getByXPath("//div[@class='clearfix info-showbox']//ul[@id='jSearchHeroDiv']//li//a");
        for (DomNode div : divs) {
            //获取这个节点的所有子节点   img  p  span
            DomNodeList<DomNode> childs = div.getChildNodes();
            String name = "";
            String img = "";
            //遍历子节点
            for (DomNode dn:childs) {
                //name
                if (dn.getNodeName().equals("p")){
                    name=dn.getTextContent();
                }
                if (dn.getNodeName().equals("img")){
//                    SiblingDomNodeList[HtmlImage[<img src="//game.gtimg.cn/images/lol/act/img/champion/Annie.png" alt="黑暗之女 安妮">]]
                    img=dn.getChildNodes().toString().split("\"")[1];
                }
                }
            heros.add(Hero.builder().name(name).img(img).build());
        }
        System.out.println(heros);
        return heros;
    }

    /**
     * 忽略非法反射警告  适用于jdk11
     */
    @SuppressWarnings("unchecked")
    public static void disableAccessWarnings() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) throws IOException {
        disableAccessWarnings();
        System.out.println(getHeros());
    }
}
