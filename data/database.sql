-- Table: person_info
CREATE TABLE person_info
(
    id           CHAR(26) PRIMARY KEY,
    phone_number VARCHAR(15)  NOT NULL,
    full_name    VARCHAR(64)  NOT NULL,
    email        VARCHAR(320) NULL
);

-- Table: delivery_failed_action
CREATE TABLE delivery_failed_action
(
    id          CHAR(26) PRIMARY KEY,
    name        VARCHAR(45) NOT NULL,
    description TEXT        NULL
);

-- Table: shipping_services
CREATE TABLE shipping_services
(
    id                          CHAR(26) PRIMARY KEY,
    name                        VARCHAR(45)                           NOT NULL,
    short_description           TEXT                                  NULL,
    details                     TEXT                                  NULL,
    shipping_method_coefficient DECIMAL                               NOT NULL,
    unit_cost                   DECIMAL                               NOT NULL,
    created_at                  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at                  TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
);

-- Table: shipping_method
CREATE TABLE shipping_method
(
    id            CHAR(26) PRIMARY KEY,
    fee           DECIMAL                               NOT NULL,
    name          VARCHAR(45)                           NOT NULL,
    description   TEXT                                  NULL,
    image         TEXT                                  NULL,
    expected_time INT                                   NULL,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
);

-- Table: users
CREATE TABLE users
(
    id                 CHAR(26) PRIMARY KEY,
    hash_password      VARCHAR(70)                                      NOT NULL,
    full_name          VARCHAR(64)                                      NOT NULL,
    default_address_id CHAR(26)                                         NULL,
    deleted            BOOLEAN                                          NOT NULL DEFAULT FALSE,
    status             ENUM ('active', 'inactive', 'banned', 'pending') NOT NULL,
    email              VARCHAR(128) UNIQUE                              NOT NULL,
    verified_at        TIMESTAMP                                        NULL,
    refresh_token      VARCHAR(255)                                     NULL,
    avatar             VARCHAR(320)                                     NULL,
    created_at         TIMESTAMP                                                 DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at         TIMESTAMP                                                 DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    FOREIGN KEY (default_address_id) REFERENCES address (id)
);

-- Table: roles
CREATE TABLE roles
(
    id         CHAR(26) PRIMARY KEY,
    name       ENUM ('admin', 'user', 'staff')       NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
);

-- Table: users_roles
CREATE TABLE users_roles
(
    user_id CHAR(26) NOT NULL,
    role_id CHAR(26) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

-- Table: parcels
CREATE TABLE parcels
(
    id         CHAR(26) PRIMARY KEY,
    name       VARCHAR(64)                           NOT NULL,
    created_by CHAR(26)                              NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    fragile    BOOLEAN                               NOT NULL,
    weight     DECIMAL                               NOT NULL,
    longg      DECIMAL                               NULL,
    high       DECIMAL                               NULL,
    wide       DECIMAL                               NULL,
    FOREIGN KEY (created_by) REFERENCES users (id)
);

-- Table: cod_details
CREATE TABLE cod_details
(
    id             CHAR(26) PRIMARY KEY,
    amount         DECIMAL                  NOT NULL,
    status         ENUM ('pending', 'paid') NOT NULL,
    collected_date DATE                     NOT NULL
);

-- Table: address
CREATE TABLE address
(
    id           CHAR(26) PRIMARY KEY,
    description  TEXT                                          NULL,
    ward         VARCHAR(45)                                   NOT NULL,
    district     VARCHAR(45)                                   NOT NULL,
    province     VARCHAR(45)                                   NOT NULL,
    address_type ENUM ('private_house', 'office', 'different') NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP()         NOT NULL,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP()
);

-- Table: posts
CREATE TABLE posts
(
    id           CHAR(26) PRIMARY KEY,
    address_id   CHAR(26)                              NOT NULL,
    code         VARCHAR(45)                           NOT NULL,
    email        VARCHAR(128)                          NULL,
    phone_number VARCHAR(15)                           NOT NULL,
    manager_id   CHAR(26)                              NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    FOREIGN KEY (address_id) REFERENCES address (id)
);


-- Table: staffs
CREATE TABLE staffs
(
    id           CHAR(26) PRIMARY KEY,
    post_id      CHAR(26)                              NOT NULL,
    position     VARCHAR(45)                           NOT NULL,
    phone_number VARCHAR(15)                           NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    FOREIGN KEY (post_id) REFERENCES posts (id)
);

-- Table: shipments
CREATE TABLE shipments
(
    id                        CHAR(26) PRIMARY KEY,
    receiver_id               CHAR(26)                                                                  NOT NULL,
    sender_id                 CHAR(26)                                                                  NOT NULL,
    receiver_address_id       CHAR(26)                                                                  NOT NULL,
    sender_address_id         CHAR(26)                                                                  NOT NULL,
    method_id                 CHAR(26)                                                                  NOT NULL,
    parcel_id                 CHAR(26)                                                                  NOT NULL,
    delivery_failed_action_id CHAR(26)                                                                  NULL,
    shipping_service_id       CHAR(26)                                                                  NOT NULL,
    status                    ENUM ('pending', 'processed', 'cancelled', 'done', 'returned', 'transit') NOT NULL,
    code                      VARCHAR(255)                                                              NOT NULL,
    note                      TEXT                                                                      NULL,
    receive_at_home           BOOLEAN                                                                   NOT NULL,
    failed_count              INT                                                                       NULL,
    created_at                TIMESTAMP DEFAULT CURRENT_TIMESTAMP()                                     NOT NULL,
    updated_at                TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    FOREIGN KEY (receiver_id) REFERENCES person_info (id),
    FOREIGN KEY (sender_id) REFERENCES person_info (id),
    FOREIGN KEY (receiver_address_id) REFERENCES address (id),
    FOREIGN KEY (sender_address_id) REFERENCES address (id),
    FOREIGN KEY (method_id) REFERENCES shipping_method (id),
    FOREIGN KEY (parcel_id) REFERENCES parcels (id),
    FOREIGN KEY (delivery_failed_action_id) REFERENCES delivery_failed_action (id),
    FOREIGN KEY (shipping_service_id) REFERENCES shipping_services (id)
);

-- Table: trackings
CREATE TABLE trackings
(
    id                  CHAR(26) PRIMARY KEY,
    post_id             CHAR(26)                                                                                                       NOT NULL,
    shipment_id         CHAR(26)                                                                                                       NOT NULL,
    status              ENUM ('pending', 'arrived', 'delivering', 'delivered', 'leaved', 'returning', 'returned', 'created', 'failed') NOT NULL,
    tracking_by         CHAR(26)                                                                                                       NOT NULL,
    destination_post_id CHAR(26)                                                                                                       NOT NULL,
    created_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP()                                                                          NOT NULL,
    updated_at          TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    FOREIGN KEY (post_id) REFERENCES posts (id),
    FOREIGN KEY (shipment_id) REFERENCES shipments (id)
);

-- Table: invoices
CREATE TABLE invoices
(
    id             CHAR(26) PRIMARY KEY,
    cost           DECIMAL                               NOT NULL,
    converted_unit DECIMAL                               NOT NULL,
    status         ENUM ('pending', 'paid')              NOT NULL,
    real_unit      DECIMAL                               NOT NULL,
    export_by      CHAR(26)                              NULL,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NOT NULL,
    updated_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    FOREIGN KEY (export_by) REFERENCES users (id)
);

-- Table: users_tokens
CREATE TABLE users_tokens
(
    id                              CHAR(26) PRIMARY KEY,
    verify_token                    VARCHAR(45) NULL,
    reset_password_token            VARCHAR(45) NULL,
    verify_token_expired_at         TIMESTAMP   NULL,
    reset_password_token_expired_at TIMESTAMP   NULL
);


