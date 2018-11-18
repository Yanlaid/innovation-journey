package cn.shen.mysolrj;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;


public class C {
    @Test
    public void testWriter1() throws IOException, SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "5L");
        document.addField("title", "别把榴莲不当水果");
        document.addField("price", 123);
        server.add(document);
        server.commit();
    }

    /**
     * 通过 javaBean来添加数据
     */
    @Test
    public void testWriter2() throws IOException, SolrServerException {
      /*  HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        for (int i = 7; i < 16; i++) {
            Item item = new Item();
            item.setId(i);
            item.setTitle(i+" 是水果么");
            item.setPrice(i);
            server.addBean(item);
            server.commit();
        }
*/
    }

}
