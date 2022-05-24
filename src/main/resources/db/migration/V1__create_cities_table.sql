create table if not exists cities (
    id bigserial primary key,
    name varchar(200) not null,
    pincode varchar(50) unique not null,
    active boolean,
    enabled boolean,
    created_date timestamp with time zone,
    last_modified_date timestamp with time zone
);