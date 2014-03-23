package org.josescalia.http.rss.util

import groovy.util.slurpersupport.NodeChild
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseDecorator
import org.josescalia.http.rss.model.RssHeader
import org.josescalia.http.rss.model.RssItem

/**
 * Created by josescalia on 3/23/14.
 */
class RssCore {
    String baseUrl
    String urlPath

    RssCore() {
    }


    /**
     * <p>This is the method can be called directly from this class</p>
     * */
    def RssHeader getWebRss() {
        return requestGet()
    }

    /**
     * <p>Static method to get Rss Header</p>
     * @return RssHeader
     * @param xml NodeChild
     * */
    def RssHeader getRssHeader(NodeChild xml) {
        return new RssHeader(rssHeaderTitle: "${xml.channel.title}",
                rssHeaderDescription: "${xml.channel.description}",
                rssHeaderGenerator: "${xml.channel.generator}",
                rssHeaderLink: "${xml.channel.link}")
    }

    /**
     * to get HTTP Response Status
     * */
    def static int getResponseStatus(HttpResponseDecorator response) {
        return response.statusLine.statusCode
    }

    /**
     * <b>Method to get RssItem</b><br>
     * <p>Each Rss Feed have item contains the short story of news that published using their feed
     * </p>
     * @param xml NodeChild
     * @return List : ArrayList of RssItem
     *
     **/
    def List<RssItem> getRssItemList(NodeChild xml) {
        List<RssItem> rssItemList = new ArrayList<RssItem>()
        xml.channel.item.each {
            //println "Title : " + it.title
            rssItemList.add(new RssItem(rssItemTitle:it.title, rssItemDescription: it.description,rssItemGuid:it.guid,rssItemLink: it.link))
        }
        return rssItemList
    }

    /**
     * The static core method
     * @return RssHeader
     * */
    def RssHeader requestGet() {
        def rssHeader = null
        def http = new HTTPBuilder(baseUrl)
        http.get(path: urlPath, contentType: "text/xml") { resp, xml ->
            if (getResponseStatus(resp) == 200) {
                rssHeader = getRssHeader(xml)
                rssHeader.rssItemList = getRssItemList(xml)
            }
        }
        return rssHeader
    }
}
