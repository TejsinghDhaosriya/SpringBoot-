CREATE TYPE meter_type AS ENUM ('electricity', 'water');


create table if not exists meters (
    id bigserial primary key,
    name varchar(200) not null,
    zone_id bigserial not null,
    type meter_type,
    active boolean,
    enabled boolean,
    created_date timestamp with time zone,
    last_modified_date timestamp with time zone
);