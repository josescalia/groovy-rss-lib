groovy-rss-lib
==============
Website:[http://josescalia.net](http://josescalia.net)

####Description
This is just another rss library, but this time using **Groovy Script**.

####How To :
Using Groovy Rss Lib is simple

Here's sample code in groovy :

<pre>
class RssAgent(){
    static void main(String[] args) {
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
}</pre>

