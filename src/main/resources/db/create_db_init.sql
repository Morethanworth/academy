
create table T_TEAM
(
    id               BIGINT      DEFAULT random() not null primary key,
    name             varchar(40)                         not null,
    product          varchar(40)                         not null,
    created_at       timestamp default now(),
    modified_at      timestamp default now(),
    default_location varchar(10)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_ID;

create table t_rack
(
    id BIGINT DEFAULT random() PRIMARY KEY,
    serial_number    varchar(20)                         not null,
    team_id          BIGINT                                not null
        constraint fk_teamid
            references t_team,
    created_at       timestamp default now(),
    default_location varchar(10),
    status           varchar(20)
        constraint check_status
            check ((status)::text = ANY
        ((ARRAY ['AVAILABLE'::character varying, 'BOOKED'::character varying, 'UNAVAILABLE'::character varying])::text[])),
    modified_at      timestamp default now()
);

CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ID;

create table t_rack_asset
(
    id  BIGINT default random() not null primary key,
    asset_tag varchar(10)                    not null,
    rack_id   BIGINT                           not null
        references t_rack
);

CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ASSET_ID;

create table t_team_member
(
    id          BIGINT      default random() not null primary key,
    name        varchar(40)                         not null,
    team_id     BIGINT                                not null
        references t_team,
    ctw_id      varchar(8)                          not null,
    created_at  timestamp default now(),
    modified_at timestamp default now()
);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_MEMBER_ID;

create table t_booking
(
    id           BIGINT      default random() not null
        primary key,
    rack_id      BIGINT                                not null
        references t_rack,
    requester_id BIGINT                                not null
        references t_team_member,
    book_from    timestamp                           not null,
    book_to      timestamp                           not null,
    created_at   timestamp default now(),
    modified_at  timestamp default now()
);

CREATE SEQUENCE IF NOT EXISTS SEQ_BOOKING_ID;
