package com.rabex.express.core.data;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Consumer;

import static com.rabex.express.core.data.Sort.Direction.unsorted;

public class Sort implements Iterable<Sort.Order>{
    private List<Order> orders;
    public static final Sort.Direction DEFAULT_DIRECTION;
    public static final Sort UNSORTED = by(List.of());

    static {
        DEFAULT_DIRECTION = Sort.Direction.ASC;
    }

    public Sort(List<Order> list) {
        this.orders = list;
    }

    public Sort(Direction direction, List<String> list) {
        orders = list.stream().map((p) -> new Order(p, direction)).toList();
    }

    public boolean isUnsorted(){
        return orders.isEmpty();
    }

    @Override
    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    @Override
    public void forEach(Consumer<? super Order> action) {
        orders.forEach(action);
    }

    @Override
    public Spliterator<Order> spliterator() {
        return orders.spliterator();
    }

    public static class Order{
        private String property;
        private Direction direction;

        public Order(String property, Direction direction) {
            this.property = property;
            this.direction = direction;
        }

        public String getProperty() {
            return property;
        }

        public Direction getDirection() {
            return direction;
        }
    }

    public static Sort by(String... properties) {
        return properties.length == 0 ? unsorted() : new Sort(DEFAULT_DIRECTION, Arrays.asList(properties));
    }

    public static Sort by(List<Order> orders) {
        return orders.isEmpty() ? unsorted() : new Sort(orders);
    }

    public static Sort by(Order... orders) {
        return new Sort(Arrays.asList(orders));
    }

    public static Sort by(Direction direction, String... properties) {

        return by(Arrays.stream(properties).map(p -> new Order(p, direction)).toList());
    }

    public enum Direction{
        ASC,
        DESC;

        private Direction() {
        }

        public boolean isAscending() {
            return this.equals(ASC);
        }

        public boolean isDescending() {
            return this.equals(DESC);
        }

        public static Direction fromString(String value) {
            try {
                return valueOf(value.toUpperCase(Locale.US));
            } catch (Exception var2) {
                Exception e = var2;
                throw new IllegalArgumentException(String.format("Invalid value '%s' for orders given; Has to be either 'desc' or 'asc' (case insensitive)", value), e);
            }
        }

        public static Optional<Direction> fromOptionalString(String value) {
            if (StringUtils.isEmpty(value)) {
                return Optional.empty();
            } else {
                try {
                    return Optional.of(fromString(value));
                } catch (IllegalArgumentException var2) {
                    return Optional.empty();
                }
            }
        }

        public static Sort unsorted() {
            return UNSORTED;
        }
    }

}
