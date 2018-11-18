package cn.shen.pojo;

import org.apache.solr.client.solrj.beans.Field;


public class Item {
    @Field
    private String id;
    @Field
    private String title;
    /*private ArrayList title;*/

    @Field
    private long price;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   /* public ArrayList getTitle() {
        return title;
    }

    public void setTitle(ArrayList title) {
        this.title = title;
    }*/

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
