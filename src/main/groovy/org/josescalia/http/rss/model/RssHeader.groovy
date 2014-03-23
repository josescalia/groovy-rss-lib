package org.josescalia.http.rss.model

/**
 * Created by josescalia on 3/23/14.
 */
class RssHeader {
    String rssHeaderTitle
    String rssHeaderDescription
    String rssHeaderGenerator
    String rssHeaderLink
    List<RssItem> rssItemList


    @Override
    public String toString() {
        return "RssHeader{" +
                "rssHeaderTitle='" + rssHeaderTitle + '\'' +
                ", rssHeaderDescription='" + rssHeaderDescription + '\'' +
                ", rssHeaderGenerator='" + rssHeaderGenerator + '\'' +
                ", rssHeaderLink='" + rssHeaderLink + '\'' +
                ", rssItemList=" + rssItemList +
                "} " + super.toString();
    }
}
