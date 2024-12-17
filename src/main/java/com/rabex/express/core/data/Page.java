package com.rabex.express.core.data;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public interface Page<T> {
    int getTotalPage();

    Collection<T> getContent();

    int getPage();

    int getLimit();

    boolean isFirst();

    boolean isLast();

    int getNextPage();

    int getPreviousPage();


    static <T> Page<T> of(List<T> content, Integer count, Pageable pageable) {
        return new DefaultPage<>(
                content,
                pageable.getPage(),
                getTotalPage(pageable.getLimit(), count),
                count,
                pageable.getLimit()
        );
    }

    static <T> Page<T> of(List<T> content, Integer page, Integer total, Integer count, Integer limit) {
        return new DefaultPage<>(content, page, total, count, limit);
    }

    private static Integer getTotalPage(Integer size, Integer count) {

        return ((count - 1) / size) + 1;
    }

    <U> Page<U> map(Function<T, U> callback);
}
