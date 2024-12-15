package com.rabex.express.core.data;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class DefaultPage<T> implements Page<T> {
    private List<T> content;
    private int page;
    private int totalPage;
    private int totalElement;
    private int limit;
    private static final int START_PAGE = 1;

    public DefaultPage(List<T> content, Integer page, Integer totalPage, Integer totalElement, Integer limit) {
        this.content = content;
        this.page = page;
        this.totalPage = totalPage;
        this.totalElement = totalElement;
        this.limit = limit;
    }

    @Override
    public int getTotalPage() {
        return totalElement;
    }

    @Override
    public Collection<T> getContent() {
        return content;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getLimit() {
        return limit;
    }

    @Override
    public boolean isFirst() {
        return page == START_PAGE;
    }

    @Override
    public boolean isLast() {
        return page == endPage();
    }

    @Override
    public int getNextPage() {
        if (isLast())
            return page;
        return 0;
    }

    @Override
    public int getPreviousPage() {
        if (isFirst()) {
            return START_PAGE;
        }
        return page--;
    }

    @Override
    public <U> Page<U> map(Function<T, U> callback) {
        return Page.of(
                content.stream().map(callback).toList(),
                page,
                totalPage,
                totalElement,
                limit
        );
    }

    private int endPage() {
        return totalPage - (1 - START_PAGE);
    }

    public static void main(String[] args) {
        DefaultPage<String> page = new DefaultPage<>(List.of("1", "3", "4"), 1, 5, 15, 3);
        System.out.println(page.isFirst());
    }
}
