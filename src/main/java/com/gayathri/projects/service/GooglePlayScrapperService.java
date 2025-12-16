package  com.gayathri.projects.service;

import com.gayathri.projects.model.AppDetails;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public  class GooglePlayScrapperService
{

    public AppDetails fetchAppDetails(String appID) throws IOException
    {

        String url = "https://play.google.com/store/apps/details?id=" + appID + "&hl=en&gl=US";
        Document doc = Jsoup.connect(url).get();
        String title = doc.select("h1 span").first().text();
        String developer = doc.select("div.Vbfug span").first().text();
        String rating = doc.select("div.TT9eCd span").first().text();
        String installs = doc.select("div.ClM7O div span").first().text();

        return new AppDetails(appID, title, developer, rating, installs);


    }
}