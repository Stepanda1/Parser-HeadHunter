import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.io.IOException;
import java.lang.annotation.ElementType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        List<String> arrayLinks = new ArrayList<String>();
        for (int page = 0; page < 31; page++) {
            Document document = Jsoup.connect("https://perm.hh.ru/search/vacancy?from=suggest_post&ored_clusters=true&area=1&hhtmFrom=vacancy_search_list&hhtmFromLabel=vacancy_search_line&search_field=name&search_field=company_name&search_field=description&enable_snippets=false&text=Project+manager&page=" + page).get();
            Elements a = document.select("h2 > span > a[href]");
            for (Element link: a) {
                arrayLinks.add(link.attr("href"));
            }
        }

        for (int i = 0; i < arrayLinks.size(); i++)
        {
            String getLink = arrayLinks.get(i);
            Document doc = Jsoup.connect(getLink).get();
            Elements span = doc.select("span");
            List<String> level = span.eachText();
            if (level.size()>7)
                System.out.println(level.get(7));
        }
    }
}