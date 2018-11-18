package cn.shen.mysolrj;

import cn.shen.pojo.Item;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class R {
    @Test
    public void testQueryDocu() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        SolrQuery query = new SolrQuery("title:水果");
        QueryResponse response = server.query(query);
        SolrDocumentList documents = response.getResults();
        System.out.println("共搜索到 " + documents.size() + " 条");
        for (SolrDocument document : documents) {
            System.out.println("id++" + document.get("id"));
            System.out.println("title+++" + document.get("title"));
            System.out.println("Price+++" + document.get("price"));
        }
    }

    @Test
    public void testQueryByJavaBean() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        SolrQuery query = new SolrQuery("title:水果");
        QueryResponse response = server.query(query);
        List<Item> beans = response.getBeans(Item.class);
        for (Item bean : beans) {
            System.out.println(bean);
        }
    }

    @Test
    public void testBooleanQuery() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        SolrQuery query = new SolrQuery("title:甘蔗 or title:榴莲");
        QueryResponse response = server.query(query);
        List<Item> beans = response.getBeans(Item.class);
        for (Item bean : beans) {
            System.out.println(bean);
        }

    }

    @Test
    public void testSimilarityQuery() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        SolrQuery query = new SolrQuery("title:冰~");
        QueryResponse response = server.query(query);
        List<Item> beans = response.getBeans(Item.class);
        for (Item bean : beans) {
            System.out.println(bean);
        }

    }

    @Test
    public void testRangeQuery() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        SolrQuery query = new SolrQuery("price:[0 TO 200]");
        QueryResponse response = server.query(query);
        List<Item> beans = response.getBeans(Item.class);
        for (Item bean : beans) {
            System.out.println(bean);
        }

    }

    @Test
    public void testSortQuery() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");

        SolrQuery query = new SolrQuery("title:水果");
        query.setSort("price", SolrQuery.ORDER.asc);
        QueryResponse response = server.query(query);
        List<Item> beans = response.getBeans(Item.class);
        for (Item bean : beans) {
            System.out.println(bean);
        }

    }

    @Test
    public void testPagedQuery() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        int pageNum = 3;
        int pageSize = 2;
        int start = (pageNum - 1) * pageSize;
        SolrQuery query = new SolrQuery("title:水果");
        query.setSort("price", SolrQuery.ORDER.desc);
        query.setStart(start);
        query.setRows(pageSize);
        QueryResponse response = server.query(query);
        List<Item> items = response.getBeans(Item.class);
        for (Item item : items) {
            System.out.println(item);
        }

    }

    @Test
    public void testHighlightQuery() throws SolrServerException {
        HttpSolrServer server = new HttpSolrServer("http://localhost:8080/solr/core1");
        SolrQuery query = new SolrQuery("title:水果");
        query.setHighlightSimplePre("<font color='red'>");
        query.setHighlightSimplePost("</font>");
        query.addHighlightField("title");
        QueryResponse response = server.query(query);
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        List<Item> beans = response.getBeans(Item.class);
        for (Item item : beans) {
            String id = item.getId();
            System.out.println("id+++" + id);
            System.out.println("title+++"+highlighting.get(id).get("title").get(0));
            System.out.println("price+++"+item.getPrice());
        }
    }
}