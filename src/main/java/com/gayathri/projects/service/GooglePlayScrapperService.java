package  com.gayathri.projects.service;

import com.gayathri.projects.model.AppDetails;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public  class GooglePlayScrapperService
{

    public AppDetails fetchAppDetails(String appID) throws IOException
    {

        //Creating google play store url
        String url = "https://play.google.com/store/apps/details?id=" + appID + "&hl=en&gl=US";
        //connecting to googleplay store by opening http conect and passes it to doc
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .timeout(10_000)
                .get();
        //extracting values safely
        String title = getSafeText(doc, "h1 span");
        String developer = getSafeText(doc, "div.Vbfug span");
        String rating = getSafeText(doc, "div.TT9eCd span");
        String installs = getSafeText(doc, "div.ClM7O div span");

        return new AppDetails(appID, title, developer, rating, installs);


    }

    /* we are using terinary operator to handle null,
    *means if element is not null then return next if it is
      return N/A*/
    private String getSafeText(Document doc, String cssQuery) {
        Element element = doc.selectFirst(cssQuery);
        return element != null ? element.text() : "N/A";
    }
}