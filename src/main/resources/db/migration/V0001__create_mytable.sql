create table if not exists currency (
    id UUID primary key,
    name varchar NOT NULL,
    code varchar NOT NULL,
    created_at timeStamp NOT NULL
);