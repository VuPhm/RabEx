package com.rabex.express.core.data;

public interface Pageable {
    int getLimit();

    int getOffset();

    int getPage();

    Sort getSort();
}
