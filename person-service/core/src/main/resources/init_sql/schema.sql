create table if not exists medical_card
(
    id            bigint not null unique primary key,
    client_status char,
    med_status    char,
    registry_dt   date not null,
    comment       text
);

create table if not exists contact
(
    id bigint not null unique primary key,
    phone_number varchar(32) not null,
    email varchar(128),
    profile_link text
);

create table if not exists illness
(
    id bigint not null unique primary key,
    medical_card_id bigint not null references medical_card (id) on delete cascade,
    type_id bigint,
    heaviness char,
    appearance_dttm timestamp not null,
    recovery_dt date
);

create table if not exists person_data
(
    id bigint not null unique primary key,
    last_name varchar(255) not null,
    first_name varchar(255) not null,
    birth_dt date not null,
    age smallint,
    sex char not null,
    contact_id bigint not null references contact (id) on delete cascade,
    medical_card_id bigint not null references medical_card (id) on delete cascade,
    parent_id bigint check ( parent_id <> id ) references person_data (id)
);

create table if not exists address
(
    id bigint not null unique primary key,
    contact_id bigint not null references contact (id) on delete cascade,
    country_id bigint not null,
    city varchar(255) not null,
    index integer,
    street varchar(255) not null,
    building varchar(32) not null,
    flat varchar(32)
);

create table if not exists users(
    id serial not null primary key,
    login varchar(128) not null,
    password varchar(128) not null
);

create table if not exists roles(
    id serial not null primary key,
    role varchar(32) not null
);

create table if not exists users_roles(
    user_id bigint not null references users(id),
    role_id bigint not null references roles(id)
);


