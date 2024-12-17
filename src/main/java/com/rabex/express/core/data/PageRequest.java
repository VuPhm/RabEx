package com.rabex.express.core.data;

public class PageRequest implements Pageable{

    private int limit;
    private int currentPage; // start at 1
    private Sort sort;

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



    public static Pageable of(int page, int limit, String... properties){
        return new PageRequest(limit, page, Sort.by(properties));
    }

    public static Pageable of(int page, int limit, Sort sort){
        return new PageRequest(limit, page, sort);
    }
}