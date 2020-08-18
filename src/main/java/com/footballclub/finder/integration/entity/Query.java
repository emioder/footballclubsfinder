package com.footballclub.finder.integration.entity;

import java.util.List;

public class Query {
    private SearchInfo searchinfo;
    private List<PageInfo> search;

    public SearchInfo getSearchinfo() {
        return searchinfo;
    }

    public void setSearchinfo(SearchInfo searchinfo) {
        this.searchinfo = searchinfo;
    }

    public List<PageInfo> getSearch() {
        return search;
    }

    public void setSearch(List<PageInfo> search) {
        this.search = search;
    }
}
