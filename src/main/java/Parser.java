import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {

    private static Document getPage()throws IOException{
        String url = "https://yandex.ru/pogoda/krasnodar/details/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;

    }

    public static void main(String[] args) throws IOException {
        Document day = getPage();
//        Element tableWeather = day.select("span[class=forecast-brief__item-day]").first();
        Element tableWeather = day.select("div[class=tabs-panes__pane tabs-panes__pane_active_yes]").first();
        Elements names = tableWeather.select("strong[class=forecast-detailed__day-number]");
        System.out.println(names);
        String date = "";
        System.out.println("    Местное время   Температура   Ощущается как    Давление    Ветер");
    }
}