import org.josescalia.http.rss.model.RssHeader;
import org.josescalia.http.rss.util.RssCore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by josescalia on 3/23/14.
 */
public class RssAgentTest {

    RssCore core;
    RssHeader rss;

    @Before
    public void init() {
        core = new RssCore();
        core.setBaseUrl("http://rss.vivanews.com");
        core.setUrlPath("/get/bola");
    }

    @Test
    public void testGetRssHeader() throws Exception {
        rss = core.getWebRss();

        assert rss != null;
        assert rss.getRssHeaderTitle().length() > 0;
        assert rss.getRssHeaderDescription().length() > 0;
        assert rss.getRssHeaderLink().length() > 0;

    }

    @After
    public void printResult(){
        System.out.println("Print All Header Property");
        System.out.println("Header Title\t\t: " + rss.getRssHeaderTitle());
        System.out.println("Header Description\t: " + rss.getRssHeaderDescription());
        System.out.println("Header Link\t\t\t: " + rss.getRssHeaderLink());
        System.out.println("Header Generator\t: " + rss.getRssHeaderGenerator());
        System.out.println("\n\nAnd the rss item contains :" + rss.getRssItemList().size() +" Items");
    }
}
