package cn.shen.demo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class LuceneIndexCreate {
    /**
     * 索引数据创建
     * 步骤
     * 1. 构建文档对象
     * new  Docement()
     * 2.构建文档的数据
     * 各种数据结构
     * 3.构建索引数据保存位置
     * 3-1：构建索引写出器
     * new  IndexWriter(...)
     * 3-2：:....
     */
    @Test
    public void testIndexCreate() throws IOException {
        // 创建文档对象
        Document document = new Document();
        // 创建并添加字段信息。
        document.add(new StringField("id", "1", Field.Store.YES));
        // 这里我们title字段需要用TextField，即创建索引又会被分词。StringField会创建索引，但是不会被分词
        document.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));


        // 索引目录类,指定索引在硬盘中的位置
        Directory directory = FSDirectory.open(new File("indexDir"));

        // 创建分词器对象
        Analyzer analyzer = new StandardAnalyzer();


        // 索引写出工具的配置对象
        IndexWriterConfig conf = new IndexWriterConfig(Version.LATEST, analyzer);
        // 创建索引的写出工具类。参数：索引的目录和配置信息
        IndexWriter indexWriter = new IndexWriter(directory, conf);

        // 把文档交给IndexWriter
        indexWriter.addDocument(document);
        // 提交
        indexWriter.commit();
        // 关闭
        indexWriter.close();

    }

    @Test
    public void testIndexCteate2() throws IOException {
        Document document = new Document();
        document.add(new StringField("id", "1", Field.Store.YES));
        document.add(new TextField("title", "woshi沈欣然", Field.Store.YES));
        Directory directory = FSDirectory.open(new File("testIndex"));
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new StandardAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, config);
        indexWriter.addDocument(document);
        indexWriter.commit();
        indexWriter.close();

    }

    @Test
    public void testIndexCreate3() throws IOException {
        Document document = new Document();
        document.add(new StringField("id", "1", Field.Store.YES));
        document.add(new TextField("title", "构建文档对象", Field.Store.YES));
        Directory directory = FSDirectory.open(new File("tessIndex"));
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new StandardAnalyzer());
        IndexWriter writer = new IndexWriter(directory, config);
        writer.addDocument(document);
        writer.commit();
        writer.close();
    }

    @Test
    public void testIKAnalyzer() throws IOException {
        Document document = new Document();
        document.add(new TextField("title", "构建文档的数据结构", Field.Store.YES));
        document.add(new StoredField("Double", 3.567));
        Directory directory = FSDirectory.open(new File("IKTestFile"));
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
        IndexWriter writer = new IndexWriter(directory, config);
        writer.addDocument(document);
        writer.commit();
        writer.close();
    }

    @Test
    public void testIKAnalyzerConfig() throws IOException {
        Document document = new Document();
        document.add(new TextField("title", "在困难时期，共克时艰，不是吧", Field.Store.YES));
        Directory directory = FSDirectory.open(new File("IKTestFile"));
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
        IndexWriter writer = new IndexWriter(directory, config);
        writer.addDocument(document);
        writer.commit();
        writer.close();
    }

    @Test
    public void testIndexWriterConfig() throws IOException {
        Document document = new Document();
        document.add(new TextField("title", "那时候吃的饭菜", Field.Store.YES));
        Directory directory = FSDirectory.open(new File("Myca"));
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
        config.setOpenMode(IndexWriterConfig.OpenMode.APPEND);
        IndexWriter writer = new IndexWriter(directory, config);
        writer.addDocument(document);
        writer.commit();
        writer.close();


    }

    @Test
    public void testCreate3() throws IOException {
        Document document = new Document();
        Document document1 = new Document();
        Document document2 = new Document();
        Document document3 = new Document();
        document.add(new TextField("title", "那sdfahsf", Field.Store.YES));
        document1.add(new TextField("title", "那时候吃反对v你的饭菜", Field.Store.YES));
        document2.add(new TextField("title", "那时候发射器日本年轻啊菜", Field.Store.YES));
        document3.add(new TextField("title", "那时打法杀我VBAS的饭菜", Field.Store.YES));
        Directory directory = FSDirectory.open(new File("Myca"));
        ArrayList<Document> documents = new ArrayList<>();
        documents.add(document);
        documents.add(document1);
        documents.add(document2);
        documents.add(document3);
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter writer = new IndexWriter(directory, config);
        writer.addDocuments(documents);
        writer.commit();
        writer.close();
    }

    @Test
    public void testCreate2() throws Exception {
        // 创建文档的集合
        Collection<Document> docs = new ArrayList<>();
        // 创建文档对象
        Document document1 = new Document();
        document1.add(new StringField("id", "1", Field.Store.YES));
        document1.add(new TextField("title", "谷歌地图之父跳槽facebook", Field.Store.YES));
        docs.add(document1);
        // 创建文档对象
        Document document2 = new Document();
        document2.add(new StringField("id", "2", Field.Store.YES));
        document2.add(new TextField("title", "谷歌地图之父加盟FaceBook", Field.Store.YES));
        docs.add(document2);
        // 创建文档对象
        Document document3 = new Document();
        document3.add(new StringField("id", "3", Field.Store.YES));
        document3.add(new TextField("title", "谷歌地图创始人拉斯离开谷歌加盟Facebook", Field.Store.YES));
        docs.add(document3);
        // 创建文档对象
        Document document4 = new Document();
        document4.add(new StringField("id", "4", Field.Store.YES));
        document4.add(new TextField("title", "谷歌地图之父跳槽Facebook与Wave项目取消有关", Field.Store.YES));
        docs.add(document4);
        // 创建文档对象
        Document document5 = new Document();
        document5.add(new StringField("id", "5", Field.Store.YES));
        document5.add(new TextField("title", "谷歌地图之父拉斯加盟社交网站Facebook", Field.Store.YES));
        docs.add(document5);

        // 索引目录类,指定索引在硬盘中的位置
        Directory directory = FSDirectory.open(new File("indexDir"));
        // 引入IK分词器
        Analyzer analyzer = new IKAnalyzer();
        // 索引写出工具的配置对象
        IndexWriterConfig conf = new IndexWriterConfig(Version.LATEST, analyzer);
        // 设置打开方式：OpenMode.APPEND 会在索引库的基础上追加新索引。OpenMode.CREATE会先清空原来数据，再提交新的索引
        conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        // 创建索引的写出工具类。参数：索引的目录和配置信息
        IndexWriter indexWriter = new IndexWriter(directory, conf);
        // 把文档集合交给IndexWriter
        indexWriter.addDocuments(docs);
        // 提交
        indexWriter.commit();
        // 关闭
        indexWriter.close();
    }

    @Test
    public void testSerach() throws IOException, ParseException {
        //    索引目录对象
        Directory directory = FSDirectory.open(new File("indexDir"));
        //    索引读取工具
        DirectoryReader reader = DirectoryReader.open(directory);
        //    索引搜索工具
        IndexSearcher searcher = new IndexSearcher(reader);
        //    创建查询解析器
        QueryParser parser = new QueryParser(Version.LATEST, "title", new IKAnalyzer());
        // 创建查询对象
        Query query = parser.parse("谷歌地图之父拉斯");

        //    搜索数据 TopDocs 按照匹配度得分排名前多少的文档信息
        TopDocs docs = searcher.search(query, 10);
        //    获取总条数 docs.totalHits
        System.out.println("查询到的数据有 " + docs.totalHits + " 条");
        //    获取得分对象数组，包含文档编号，文档得分
        ScoreDoc[] scoreDocs = docs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            //    取出文档编号
            int docId = scoreDoc.doc;
            Document document = reader.document(docId);
            System.out.println("id--" + document.get("id"));
            System.out.println("title--" + document.get("title"));
            System.out.println("得分--" + scoreDoc.score);
        }

    }

    @Test
    public void testSeraech() throws IOException, ParseException {
        FSDirectory dir = FSDirectory.open(new File("indexDir"));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        QueryParser parser = new QueryParser(Version.LATEST, "title", new IKAnalyzer());
        Query query = parser.parse("谷歌");
        TopDocs docs = searcher.search(query, 5);
        System.out.println("共查询到  " + docs.totalHits + " 条");
        ScoreDoc[] scoreDocs = docs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = reader.document(doc);
            System.out.println("id为 " + document.get("id"));
            System.out.println("title 为 " + document.get("title"));
            System.out.println("得分为  " + scoreDoc.score);
        }
    }

    @Test
    public void testSeraph2() throws IOException, ParseException {
        //    获取索引目录对象
        FSDirectory dir = FSDirectory.open(new File("indexDir"));
        //    获取索引读取对象
        DirectoryReader reader = DirectoryReader.open(dir);
        //    获取索引搜索对象
        IndexSearcher searcher = new IndexSearcher(reader);
        /*
            创建查询解析器对象
                参数：设定Lucene版本，查询的字段名，使用的分词器
         */
        QueryParser parser = new QueryParser(Version.LATEST, "title", new IKAnalyzer());
        //创建查询对象
        Query query = parser.parse("谷歌地图");
        /*
        获取搜索结果
         */
        TopDocs docs = searcher.search(query, 10);
        System.out.println("一共查到条数 " + docs.totalHits);
        ScoreDoc[] scoreDocs = docs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            System.out.println("分数为---" + scoreDoc.score);
            Document document = reader.document(doc);
            System.out.println("id---" + document.get("id"));
            System.out.println("title+++" + document.get("title"));
        }
    }

    @Test
    public void testSearch3() throws IOException, ParseException {

        FSDirectory dir = FSDirectory.open(new File("indexDir"));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        QueryParser parser = new QueryParser(Version.LATEST, "title", new IKAnalyzer());
        Query query = parser.parse("谷歌");
        TopDocs topDocs = searcher.search(query, 10);
        System.out.println("共查询到+++" + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document doc1 = searcher.doc(doc);
            System.out.println("id+++" + doc1.get("id"));
            System.out.println(" c'v");

        }

    }

    @Test
    public void testSearch4() throws IOException, ParseException {
        FSDirectory dir = FSDirectory.open(new File("indexDir"));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        //QueryParser queryParser = new QueryParser(Version.LATEST, "title", new IKAnalyzer());
        MultiFieldQueryParser queryParser = new MultiFieldQueryParser(Version.LATEST, new String[]{"id", "title"}, new IKAnalyzer());
        Query query = queryParser.parse("1");
        TopDocs topDocs = searcher.search(query, 10);
        System.out.println("共查询到+++" + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = searcher.doc(doc);
            System.out.println("id为++" + document.get("id"));
            System.out.println("title为+++" + document.get("title"));
        }
    }

    public void search(Query query) throws IOException {
        FSDirectory dir = FSDirectory.open(new File("indexDir"));
        DirectoryReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        TopDocs topDocs = searcher.search(query, 10);
        System.out.println("共查询到+++" + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            Document doc = searcher.doc(scoreDoc.doc);
            System.out.println("id为+++" + doc.get("id"));
            System.out.println("title为+++" + doc.get("title"));
            System.out.println("得分为+++" + scoreDoc.score);

        }

    }

    @Test
    public void testSeath5() throws ParseException, IOException {
        QueryParser parser = new QueryParser(Version.LATEST, "title", new IKAnalyzer());
        Query query = parser.parse("facebook");
        search(query);
    }

    @Test
    public void testTermQuery() throws IOException {
        TermQuery query = new TermQuery(new Term("title", "取消"));
        search(query);
    }

    @Test
    public void testWildCardQuery() throws IOException {
        WildcardQuery title = new WildcardQuery(new Term("title", "*f*"));
        search(title);
    }

    @Test
    public void testFuzzyQuery() throws IOException {
        /*
        maxEdits：最大错误：0-2之间
        * */
        FuzzyQuery fuzzyQuery = new FuzzyQuery(new Term("title", "胡歌"), 1);
        search(fuzzyQuery);
    }

    @Test
    public void testNumberRangeQuery() throws IOException {
        Query query = NumericRangeQuery.newLongRange("id", 1L, 5L, true, true);
        search(query);
    }

    @Test
    public void testBooleanQuery() throws IOException {
        Query query1 = NumericRangeQuery.newLongRange("id", 1L, 2l, true, true);
        Query query2 = NumericRangeQuery.newLongRange("id", 2l, 4l, true, true);
        BooleanQuery booleanClauses = new BooleanQuery();
        booleanClauses.add(query1, BooleanClause.Occur.MUST_NOT);
        booleanClauses.add(query2, BooleanClause.Occur.SHOULD);
        search(booleanClauses);
    }
    @Test
    public void testBBB() throws ParseException, IOException {
        QueryParser parser = new QueryParser(Version.LATEST, "title", new IKAnalyzer());
        Query query = parser.parse("谷歌");
        search(query);
    }
    @Test
    public void testUpdate() throws IOException {
        FSDirectory indexDir = FSDirectory.open(new File("indexDir"));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
        IndexWriter indexWriter = new IndexWriter(indexDir, indexWriterConfig);
        Document document = new Document();
        document.add(new StringField("id", "1", Field.Store.YES));
        document.add(new TextField("title", "谷歌地图支付使用支付宝", Field.Store.YES));
        indexWriter.updateDocument(new Term("id","1"), document);
        indexWriter.commit();
        indexWriter.close();
    }
}

