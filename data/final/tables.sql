CREATE OR REPLACE TABLE address
(
    id           char(26)                                      NOT NULL,
    description  text                                          NULL,
    ward         varchar(45)                                   NOT NULL,
    district     varchar(45)                                   NOT NULL,
    province     varchar(45)                                   NOT NULL,
    address_type enum ('private_house', 'office', 'different') NOT NULL,
    created_at   timestamp DEFAULT current_timestamp()         NOT NULL,
    modified_at  timestamp DEFAULT current_timestamp()         NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE person_info
(
    id           char(26)     NOT NULL,
    phone_number varchar(15)  NOT NULL,
    full_name    varchar(64)  NOT NULL,
    email        varchar(320) NULL,
    PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE users
(
    id            char(26)                                         NOT NULL,
    hash_password varchar(70)                                      NOT NULL,
    full_name     varchar(64)                                      NOT NULL,
    deleted       tinyint(1) DEFAULT 0                             NOT NULL,
    status        enum ('active', 'inactive', 'banned', 'pending') NOT NULL,
    email         varchar(128)                                     NOT NULL,
    verified_at   timestamp                                        NULL,
    refresh_token varchar(255)                                     NULL,
    avatar        varchar(320)                                     NULL,
    created_at    timestamp  DEFAULT current_timestamp()           NOT NULL,
    modified_at   timestamp  DEFAULT current_timestamp()           NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT email
        UNIQUE (email)
);

CREATE OR REPLACE TABLE cod_details
(
    id             char(26)                 NOT NULL,
    amount         decimal                  NOT NULL,
    status         enum ('pending', 'paid') NOT NULL,
    collected_date date                     NOT NULL,
    PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE roles
(
    id          char(26)                              NOT NULL,
    name        enum ('admin', 'user', 'staff')       NOT NULL,
    created_at  timestamp DEFAULT current_timestamp() NOT NULL,
    modified_at timestamp DEFAULT current_timestamp() NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE users_roles
(
    user_id char(26) NOT NULL,
    role_id char(26) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT users_roles_ibfk_1
        FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT users_roles_ibfk_2
        FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE OR REPLACE INDEX role_id
    ON users_roles (role_id);

CREATE OR REPLACE TABLE shipping_services
(
    id                char(26)                              NOT NULL,
    name              varchar(45)                           NOT NULL,
    slug              varchar(45)                           NULL,
    short_description text                                  NULL,
    details           text                                  NULL,
    image             text                                  NULL,
    expected_time     text                                  NULL,
    expected_day      tinyint   DEFAULT 3                   NULL,
    service_type      enum ('add_on', 'delivery')           NOT NULL,
    created_at        timestamp DEFAULT current_timestamp() NOT NULL,
    modified_at       timestamp DEFAULT current_timestamp() NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id)
);

CREATE OR REPLACE TABLE pricing_tiers
(
    id             char(26)                              NOT NULL,
    description    text                                  NULL,
    service_id     char(26)                              NOT NULL,
    weight_start   float     DEFAULT 0                   NULL,
    weight_end     float     DEFAULT 0                   NULL,
    step_increment float     DEFAULT 0                   NULL,
    price_per_step decimal   DEFAULT 0                   NULL,
    shipping_range enum ('IN_PROVINCE', 'OUT_PROVINCE')  NOT NULL,
    base_price     decimal   DEFAULT 0                   NULL,
    created_at     timestamp DEFAULT current_timestamp() NOT NULL,
    updated_at     timestamp DEFAULT current_timestamp() NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT pricing_tiers_ibfk_1
        FOREIGN KEY (service_id) REFERENCES shipping_services (id)
            ON DELETE CASCADE
);

CREATE OR REPLACE INDEX service_id
    ON pricing_tiers (service_id);

CREATE OR REPLACE TABLE surcharge_tiers
(
    id             char(26)                                               NOT NULL,
    description    text                                                   NULL,
    service_id     char(26)                                               NOT NULL,
    weight_start   float                      DEFAULT 0                   NULL,
    weight_end     float                      DEFAULT 0                   NULL,
    step_increment float                      DEFAULT 0                   NULL,
    price_per_step decimal                    DEFAULT 0                   NULL,
    base_price     decimal                    DEFAULT 0                   NULL,
    unit_type      enum ('VNĐ', 'kg', 'none') DEFAULT 'none'              NULL,
    created_at     timestamp                  DEFAULT current_timestamp() NOT NULL,
    updated_at     timestamp                  DEFAULT current_timestamp() NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT fk_service_id
        FOREIGN KEY (service_id) REFERENCES shipping_services (id)
);


CREATE OR REPLACE TABLE posts
(
    id           char(26)                                                           NOT NULL,
    address_id   char(26)                                                           NOT NULL,
    title        varchar(45)                         DEFAULT 'Bưu cục chưa đặt tên' NULL,
    code         varchar(45)                                                        NOT NULL,
    email        varchar(128)                                                       NULL,
    phone_number varchar(15)                                                        NOT NULL,
    manager_id   char(26)                                                           NOT NULL,
    status       enum ('AVAILABLE', 'NOT_AVAILABLE') DEFAULT 'AVAILABLE'            NOT NULL,
    created_at   timestamp                           DEFAULT current_timestamp()    NOT NULL,
    modified_at  timestamp                           DEFAULT current_timestamp()    NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT posts_ibfk_1
        FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE OR REPLACE INDEX address_id
    ON posts (address_id);

CREATE OR REPLACE TABLE staffs
(
    id           char(26)                              NOT NULL,
    post_id      char(26)                              NOT NULL,
    position     varchar(45)                           NOT NULL,
    phone_number varchar(15)                           NOT NULL,
    created_at   timestamp DEFAULT current_timestamp() NOT NULL,
    modified_at  timestamp DEFAULT current_timestamp() NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT staffs_ibfk_1
        FOREIGN KEY (post_id) REFERENCES posts (id)
);

CREATE OR REPLACE INDEX post_id
    ON staffs (post_id);

CREATE OR REPLACE TABLE customers
(
    id                 char(26)    NOT NULL,
    default_address_id char(26)    NULL,
    phone_number       varchar(45) NULL,
    full_name          varchar(45) NULL,
    email              varchar(45) NULL,
    company_name       varchar(45) NULL,
    industry           varchar(45) NULL,
    channel            varchar(45) NULL,
    PRIMARY KEY (id),
    CONSTRAINT customers_ibfk_1
        FOREIGN KEY (id) REFERENCES users (id)
);


CREATE OR REPLACE TABLE parcels
(
    id          char(26)                              NOT NULL,
    name        varchar(64)                           NOT NULL,
    created_by  char(26)                              NOT NULL,
    created_at  timestamp DEFAULT current_timestamp() NOT NULL,
    modified_at timestamp DEFAULT current_timestamp() NOT NULL ON UPDATE current_timestamp(),
    weight      decimal                               NOT NULL,
    longg       decimal                               NULL,
    high        decimal                               NULL,
    wide        decimal                               NULL,
    PRIMARY KEY (id),
    CONSTRAINT parcels_ibfk_1
        FOREIGN KEY (created_by) REFERENCES users (id)
);


CREATE OR REPLACE TABLE delivery_failed_action
(
    id          char(26)    NOT NULL,
    name        varchar(45) NOT NULL,
    description text        NULL,
    PRIMARY KEY (id)
);


CREATE OR REPLACE TABLE orders
(
    id                        char(26)                                                                  NOT NULL,
    receiver_id               char(26)                                                                  NOT NULL,
    sender_id                 char(26)                                                                  NOT NULL,
    receiver_address_id       char(26)                                                                  NOT NULL,
    sender_address_id         char(26)                                                                  NOT NULL,
    parcel_id                 char(26)                                                                  NOT NULL,
    delivery_failed_action_id char(26)                                                                  NULL,
    shipping_service_id       char(26)                                                                  NOT NULL,
    status                    enum ('pending', 'processed', 'cancelled', 'done', 'returned', 'transit') NOT NULL,
    code                      varchar(255)                                                              NOT NULL,
    note                      text                                                                      NULL,
    receive_at_home           tinyint(1)                                                                NOT NULL,
    failed_count              int                                                                       NULL,
    created_at                timestamp DEFAULT current_timestamp()                                     NOT NULL,
    modified_at               timestamp DEFAULT current_timestamp()                                     NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT orders_ibfk_1
        FOREIGN KEY (receiver_id) REFERENCES person_info (id),
    CONSTRAINT orders_ibfk_2
        FOREIGN KEY (sender_id) REFERENCES person_info (id),
    CONSTRAINT orders_ibfk_3
        FOREIGN KEY (receiver_address_id) REFERENCES address (id),
    CONSTRAINT orders_ibfk_4
        FOREIGN KEY (sender_address_id) REFERENCES address (id),
    CONSTRAINT orders_ibfk_5
        FOREIGN KEY (parcel_id) REFERENCES parcels (id),
    CONSTRAINT orders_ibfk_6
        FOREIGN KEY (delivery_failed_action_id) REFERENCES delivery_failed_action (id),
    CONSTRAINT orders_ibfk_7
        FOREIGN KEY (shipping_service_id) REFERENCES shipping_services (id)
);

CREATE OR REPLACE TABLE order_surcharges
(
    order_id     char(26) NOT NULL,
    surcharge_id char(26) NOT NULL,
    PRIMARY KEY (order_id, surcharge_id),
    CONSTRAINT order_surcharges_ibfk_1
        FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT order_surcharges_ibfk_2
        FOREIGN KEY (surcharge_id) REFERENCES surcharge_tiers (id)
);

CREATE OR REPLACE INDEX surcharge_id
    ON order_surcharges (surcharge_id);

CREATE OR REPLACE INDEX delivery_failed_action_id
    ON orders (delivery_failed_action_id);

CREATE OR REPLACE INDEX parcel_id
    ON orders (parcel_id);

CREATE OR REPLACE INDEX receiver_address_id
    ON orders (receiver_address_id);

CREATE OR REPLACE INDEX receiver_id
    ON orders (receiver_id);

CREATE OR REPLACE INDEX sender_address_id
    ON orders (sender_address_id);

CREATE OR REPLACE INDEX sender_id
    ON orders (sender_id);

CREATE OR REPLACE INDEX shipping_service_id
    ON orders (shipping_service_id);

CREATE OR REPLACE INDEX created_by
    ON parcels (created_by);

CREATE OR REPLACE TABLE shipping_address
(
    address_id     char(26) NOT NULL,
    person_info_id char(26) NOT NULL,
    customer_id    char(26) NOT NULL,
    PRIMARY KEY (person_info_id, address_id, customer_id),
    CONSTRAINT shipping_address_ibfk_1
        FOREIGN KEY (address_id) REFERENCES address (id),
    CONSTRAINT shipping_address_ibfk_2
        FOREIGN KEY (customer_id) REFERENCES customers (id),
    CONSTRAINT shipping_address_ibfk_3
        FOREIGN KEY (person_info_id) REFERENCES person_info (id)
);

CREATE OR REPLACE INDEX address_id
    ON shipping_address (address_id);

CREATE OR REPLACE INDEX customer_id
    ON shipping_address (customer_id);

CREATE OR REPLACE TABLE tracking_records
(
    id          varchar(26)                                                                                            NOT NULL,
    order_id    varchar(26)                                                                                            NULL,
    pos_id      varchar(26)                                                                                            NULL,
    action      enum ('PROCESSING', 'CREATED', 'DELIVERING', 'ARRIVED', 'RETURNING', 'RETURNED', 'RECEIVED', 'FAILED') NULL,
    executed_by varchar(26)                                                                                            NULL,
    staff       varchar(26)                                                                                            NULL,
    created_at  timestamp DEFAULT current_timestamp()                                                                  NOT NULL,
    updated_at  timestamp DEFAULT current_timestamp()                                                                  NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT fk_executor_id
        FOREIGN KEY (executed_by) REFERENCES staffs (id)
            ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_order_id
        FOREIGN KEY (order_id) REFERENCES orders (id)
            ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_pos_id
        FOREIGN KEY (pos_id) REFERENCES posts (id)
            ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_staff_id
        FOREIGN KEY (staff) REFERENCES staffs (id)
            ON UPDATE CASCADE ON DELETE SET NULL
);


CREATE OR REPLACE TABLE users_tokens
(
    id                              char(26)    NOT NULL,
    verify_token                    varchar(45) NULL,
    reset_password_token            varchar(45) NULL,
    verify_token_expired_at         timestamp   NULL,
    reset_password_token_expired_at timestamp   NULL,
    PRIMARY KEY (id)
);


CREATE OR REPLACE TABLE invoices
(
    id             char(26)                              NOT NULL,
    cost           decimal                               NOT NULL,
    converted_unit decimal                               NOT NULL,
    status         enum ('pending', 'paid')              NOT NULL,
    real_unit      decimal                               NOT NULL,
    export_by      char(26)                              NULL,
    created_at     timestamp DEFAULT current_timestamp() NOT NULL,
    modified_at    timestamp DEFAULT current_timestamp() NOT NULL ON UPDATE current_timestamp(),
    PRIMARY KEY (id),
    CONSTRAINT invoices_ibfk_1
        FOREIGN KEY (export_by) REFERENCES users (id)
);

CREATE OR REPLACE INDEX export_by
    ON invoices (export_by);
