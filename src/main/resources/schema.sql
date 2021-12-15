-- Clear Schema
DROP TABLE IF EXISTS "public"."changes";
DROP TABLE IF EXISTS "public"."address";
DROP TABLE IF EXISTS "public"."shop";
DROP TABLE IF EXISTS "public"."users";

-- Create Schema
CREATE TABLE IF NOT EXISTS "public"."users"
(
    "id"            varchar(25)     PRIMARY KEY,
    "name"          varchar(25)     NOT NULL,
    "nationality"   varchar(25)     NULL,
    "deleted"       boolean         NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS "public"."shop"
(
    "id"            varchar(25)     PRIMARY KEY,
    "user_id"       varchar(25)     NOT NULL,
    "name"          varchar(25)     NOT NULL,
    "category"      varchar(25)     NULL,
    "deleted"       boolean         NULL DEFAULT false,
    CONSTRAINT "fk_user"
      FOREIGN KEY("user_id") 
	  REFERENCES "users"("id")
);

CREATE TABLE IF NOT EXISTS "public"."address"
(
    "id"            varchar(25)     PRIMARY KEY,
    "shop_id"       varchar(25)     NOT NULL,
    "city"          varchar(25)     NULL,
    "country"       varchar(25)     NOT NULL,
    "postal_code"   varchar(25)     NULL,
    "deleted"       boolean         NULL DEFAULT false,
    CONSTRAINT "fk_shop"
      FOREIGN KEY("shop_id") 
	  REFERENCES "shop"("id")
);

CREATE TABLE IF NOT EXISTS "public"."changes"
(
    "id"            serial                      PRIMARY KEY,
    "entity"        varchar(25)                 NOT NULL,
    "entity_id"     varchar(25)                 NOT NULL,
    "created_date"  timestamp with time zone    DEFAULT CURRENT_TIMESTAMP,
    "before"        varchar(25)                 NULL,
    "after"         varchar(25)                 NULL,
    "status"        varchar(25)                 NULL,
    "deleted"       boolean                     NULL DEFAULT false
);