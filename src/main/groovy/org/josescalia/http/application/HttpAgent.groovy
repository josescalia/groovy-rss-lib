package org.josescalia.http.application

import org.josescalia.http.rss.util.RssCore

/**
 * Created by josescalia on 3/23/14.
 */
class HttpAgent {


    static void main(String[] args) {
        //println "Hello Groovy"
        def rssHeader = new RssCore(baseUrl:"http://rss.vivanews.com",urlPath: "/get/bola").getWebRss()

        println "-------------------------------------Rss Header---------------------------------------------------"
        println "Title\t\t: " + rssHeader.rssHeaderTitle
        println "Description\t: " + rssHeader.rssHeaderDescription
        println "Link\t\t: " + rssHeader.rssHeaderLink
        println "Generator\t: " + rssHeader.rssHeaderGenerator
        println "--------------------------------------------------------------------------------------------------"

        rssHeader.rssItemList.each {
            println "---------------------------------------------------------------------------------------------------"
            println "Title\t\t:" + it.rssItemTitle
            println "Description\t:" + it.rssItemDescription
            println "Guid\t\t:" + it.rssItemGuid
            println "Link\t\t:" + it.rssItemLink
            println "\n"
        }
    }
}
