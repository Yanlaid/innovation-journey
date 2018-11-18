package cn.shen.mysolrj;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.junit.Test;

import java.io.IOException;

public class D {
    @Test
    public void testDelete1() throws IOException, SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        server.deleteById("5L");
        server.commit();
    }
    @Test
    public void testDelete2() throws IOException, SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        server.deleteByQuery("title:9");
        server.commit();
    }
}
