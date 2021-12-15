-- Insert Mock Data
INSERT INTO "users" ("id", "name", "nationality")
VALUES ('USR-TEST-00001', 'John Doe', 'Indonesian'),
       ('USR-TEST-00002', 'Lorem Ipsum', 'Indonesian');

INSERT INTO "shop" ("id", "user_id", "name", "category")
VALUES ('SHP-TEST-00001', 'USR-TEST-00001', 'Johhny`s Kitchen', 'FOOD_AND_BEVERAGES'),
       ('SHP-TEST-00002', 'USR-TEST-00001', 'Johhny`s Shop', 'RETAIL'),
       ('SHP-TEST-00003', 'USR-TEST-00002', 'Lorem`s Ticket Booth', 'RETAIL');

INSERT INTO "address" ("id", "shop_id", "city", "country", "postal_code")
VALUES ('ADR-TEST-00001', 'SHP-TEST-00001', 'Jakarta', 'Indonesia', '10260'),
       ('ADR-TEST-00002', 'SHP-TEST-00001', 'Bandung', 'Indonesia', '40124'),
       ('ADR-TEST-00003', 'SHP-TEST-00002', 'Jakarta', 'Indonesia', '10320'),
       ('ADR-TEST-00004', 'SHP-TEST-00003', 'Jakarta', 'Indonesia', '10120');

INSERT INTO "changes" ("entity", "entity_id", "before", "after", "status")
VALUES ('USER', 'USR-TEST-00001', 'Canadian', 'Indonesian', 'APPROVED'),
       ('SHOP', 'SHP-TEST-00001', 'Johhny`s Kitchen', 'Burger King', 'REJECTED'),
       ('ADDRESS', 'ADR-TEST-00002', '40100', '40110', 'APPROVED'),
       ('ADDRESS', 'ADR-TEST-00002', '40110', '40124', 'APPROVED');
