package com.rabex.express.core.data;

public class PageRequest implements Pageable{

    int limit;
    int currentPage; // start at 1
    Sort sort;

    public PageRequest(int limit, int currentPage, Sort sort) {
        this.limit = limit;
        this.currentPage = currentPage;
        this.sort = sort;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public int getOffset() {
        return (currentPage - 1) * limit;
    }

    @Override
    public int getPage() {
        return currentPage;
    }

    @Override
    public Sort getSort() {
        return sort;
    }
}
