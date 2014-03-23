package org.josescalia.http.rss.model

/**
 * Created by josescalia on 3/23/14.
 */
class RssItem {
    String rssItemTitle
    String rssItemDescription
    String rssItemGuid
    String rssItemLink
    Date rssItemPubDate


    @Override
    public String toString() {
        return "RssItem{" +
                "rssItemTitle='" + rssItemTitle + '\'' +
                ", rssItemDescription='" + rssItemDescription + '\'' +
                ", rssItemGuid='" + rssItemGuid + '\'' +
                ", rssItemLink='" + rssItemLink + '\'' +
                ", rssItemPubDate=" + rssItemPubDate +
                "} " + super.toString();
    }
}
