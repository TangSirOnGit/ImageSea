package com.tang.imagesea.model;

import java.util.List;

/**
 * Created by tangsir on 2016/11/24.
 */

public class CollectionSearchResult {

    private int total;
    private int total_pages;

    private List<CollectionBean> results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<CollectionBean> getResults() {
        return results;
    }

    public void setResults(List<CollectionBean> results) {
        this.results = results;
    }

}
