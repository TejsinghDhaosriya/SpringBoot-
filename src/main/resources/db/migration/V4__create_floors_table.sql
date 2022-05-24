create table if not exists floors (
    id bigserial primary key,
    name varchar(200) not null,
    building_id bigserial not null,
    active boolean,
    enabled boolean,
    created_date timestamp with time zone,
    last_modified_date timestamp with time zone
);