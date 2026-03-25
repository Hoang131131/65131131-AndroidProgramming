package ntu.hoang.newsapp;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RSSParser {

    public static List<News> getRSS(String urlString) {
        List<News> list = new ArrayList<>();

        try {
            URL url = new URL(urlString);
            InputStream input = url.openStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(input, null);

            boolean insideItem = false;

            String title="", link="", pubDate="", desc="", imgUrl="";

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();

                switch (eventType) {

                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")) {
                            insideItem = true;
                        }

                        if (insideItem) {
                            if (tagName.equalsIgnoreCase("title")) {
                                title = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("link")) {
                                link = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("pubDate")) {
                                pubDate = parser.nextText();
                            } else if (tagName.equalsIgnoreCase("description")) {
                                desc = parser.nextText();

                                // lấy ảnh
                                if (desc.contains("src=\"")) {
                                    int start = desc.indexOf("src=\"") + 5;
                                    int end = desc.indexOf("\"", start);
                                    imgUrl = desc.substring(start, end);

                                    int q = imgUrl.indexOf("?");
                                    if (q > 0) imgUrl = imgUrl.substring(0, q);
                                }

                                String summary = desc.substring(desc.lastIndexOf("</br>") + 5).trim();

                                list.add(new News(title, link, pubDate, imgUrl, summary));
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagName.equalsIgnoreCase("item")) {
                            insideItem = false;
                        }
                        break;
                }

                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}