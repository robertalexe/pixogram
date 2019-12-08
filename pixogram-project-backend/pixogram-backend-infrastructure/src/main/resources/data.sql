INSERT INTO APP_USERS (EMAIL, PASSWORD, PROFILE_PICTURE_ID, ACTIVE, FIRST_NAME, LAST_NAME) VALUES ('USER1@PIXOGRAM.COM', 'password', '9b559fe0-57ec-444c-af0b-8082a0d5e102', true, 'USER1', 'John');
INSERT INTO APP_USERS (EMAIL, PASSWORD, PROFILE_PICTURE_ID, ACTIVE, FIRST_NAME, LAST_NAME) VALUES ('USER2@PIXOGRAM.COM', 'password', 'daf08dcf-39eb-491d-90c4-456874a4e6b1', true, 'USER2', 'Therry');
INSERT INTO APP_USERS (EMAIL, PASSWORD, PROFILE_PICTURE_ID, ACTIVE, FIRST_NAME, LAST_NAME) VALUES ('USER3@PIXOGRAM.COM', 'password', 'e37f8215-ecdc-4394-a67c-90c6bcde340d', true, 'USER3', 'Niki');

INSERT INTO USER_PICTURES (PICTURE_ID, OWNER_EMAIL, IMAGE_PATH, PICTURE_NAME, DESCRIPTION, SHARED_TO_FOLLOWERS) VALUES ('7a62b699-8c70-463d-ab40-1a14e555a80e', 'USER1@PIXOGRAM.COM', 'C:\Users\Robert\Desktop\pixogram\pixogram\pixogram-project-back\uploads\7a62b699-8c70-463d-ab40-1a14e555a80e', 'pic1', 'com1', true);
INSERT INTO USER_PICTURES (PICTURE_ID, OWNER_EMAIL, IMAGE_PATH, PICTURE_NAME, DESCRIPTION, SHARED_TO_FOLLOWERS) VALUES ('9b559fe0-57ec-444c-af0b-8082a0d5e102', 'USER1@PIXOGRAM.COM', 'C:\Users\Robert\Desktop\pixogram\pixogram\pixogram-project-back\uploads\9b559fe0-57ec-444c-af0b-8082a0d5e102', 'pic2', 'com2', true);
INSERT INTO USER_PICTURES (PICTURE_ID, OWNER_EMAIL, IMAGE_PATH, PICTURE_NAME, DESCRIPTION, SHARED_TO_FOLLOWERS) VALUES ('701d8dce-4500-4ee7-be21-ede976f228c2', 'USER2@PIXOGRAM.COM', 'C:\Users\Robert\Desktop\pixogram\pixogram\pixogram-project-back\uploads\701d8dce-4500-4ee7-be21-ede976f228c2', 'pic3', 'com3', true);
INSERT INTO USER_PICTURES (PICTURE_ID, OWNER_EMAIL, IMAGE_PATH, PICTURE_NAME, DESCRIPTION, SHARED_TO_FOLLOWERS) VALUES ('450627c1-bbe4-4cbf-85ba-318b1ed9041c', 'USER1@PIXOGRAM.COM', 'C:\Users\Robert\Desktop\pixogram\pixogram\pixogram-project-back\uploads\450627c1-bbe4-4cbf-85ba-318b1ed9041c', 'pic4', 'com4', true);
INSERT INTO USER_PICTURES (PICTURE_ID, OWNER_EMAIL, IMAGE_PATH, PICTURE_NAME, DESCRIPTION, SHARED_TO_FOLLOWERS) VALUES ('daf08dcf-39eb-491d-90c4-456874a4e6b1', 'USER2@PIXOGRAM.COM', 'C:\Users\Robert\Desktop\pixogram\pixogram\pixogram-project-back\uploads\daf08dcf-39eb-491d-90c4-456874a4e6b1', 'pic5', 'com5', true);
INSERT INTO USER_PICTURES (PICTURE_ID, OWNER_EMAIL, IMAGE_PATH, PICTURE_NAME, DESCRIPTION, SHARED_TO_FOLLOWERS) VALUES ('e37f8215-ecdc-4394-a67c-90c6bcde340d', 'USER3@PIXOGRAM.COM', 'C:\Users\Robert\Desktop\pixogram\pixogram\pixogram-project-back\uploads\e37f8215-ecdc-4394-a67c-90c6bcde340d', 'pic6', 'com6', true);


INSERT INTO USER_PICTURE_COMMENTS (ID, PICTURE_ID, COMMENT) VALUES ( 'b458d886-a4e9-4144-b587-526a779fce24', '7a62b699-8c70-463d-ab40-1a14e555a80e', 'Beautiful!');
INSERT INTO USER_PICTURE_COMMENTS (ID, PICTURE_ID, COMMENT) VALUES ( 'b458d886-a4e9-4144-b587-526a779fce14', '7a62b699-8c70-463d-ab40-1a14e555a80e', 'Gorgeous!');
INSERT INTO USER_PICTURE_COMMENTS (ID, PICTURE_ID, COMMENT) VALUES ( 'b458d886-a4e9-4144-b587-526a779fce34', '701d8dce-4500-4ee7-be21-ede976f228c2', 'Awesome!');
INSERT INTO USER_PICTURE_COMMENTS (ID, PICTURE_ID, COMMENT) VALUES ( 'b458d886-a4e9-4144-b587-526a779fce44', 'daf08dcf-39eb-491d-90c4-456874a4e6b1', 'Great!');
INSERT INTO USER_PICTURE_COMMENTS (ID, PICTURE_ID, COMMENT) VALUES ( 'b458d886-a4e9-4144-b587-526a779fce54', 'e37f8215-ecdc-4394-a67c-90c6bcde340d', 'Gr8!!');

INSERT INTO FOLLOWERS (ID, FOLLOWER_ID, FOLLOWED_ID) VALUES ( 'b458d886-a4e9-4144-b587-526a779fce25', 'USER1@PIXOGRAM.COM', 'USER2@PIXOGRAM.COM' );
INSERT INTO FOLLOWERS (ID, FOLLOWER_ID, FOLLOWED_ID) VALUES ( 'b458d886-a4e9-4144-b587-526a779fce15', 'USER1@PIXOGRAM.COM', 'USER3@PIXOGRAM.COM' );
INSERT INTO FOLLOWERS (ID, FOLLOWER_ID, FOLLOWED_ID) VALUES ( 'b458d886-a4e9-4144-b587-526a679fce25', 'USER2@PIXOGRAM.COM', 'USER1@PIXOGRAM.COM' );
INSERT INTO FOLLOWERS (ID, FOLLOWER_ID, FOLLOWED_ID) VALUES ( 'b458d886-a4e9-4142-b587-526a679fce25', 'USER2@PIXOGRAM.COM', 'USER3@PIXOGRAM.COM' );
INSERT INTO FOLLOWERS (ID, FOLLOWER_ID, FOLLOWED_ID) VALUES ( 'b458d886-a4e9-4142-b587-516a679fce25', 'USER2@PIXOGRAM.COM', 'USER3@PIXOGRAM.COM' );
INSERT INTO FOLLOWERS (ID, FOLLOWER_ID, FOLLOWED_ID) VALUES ( 'b458d886-a4e9-4142-b587-526a678fce25', 'USER3@PIXOGRAM.COM', 'USER1@PIXOGRAM.COM' );

INSERT INTO PICTURE_LIKED_BY (OWNER_EMAIL, USER_EMAIL) VALUES ('7a62b699-8c70-463d-ab40-1a14e555a80e', 'USER1@PIXOGRAM.COM');
INSERT INTO PICTURE_LIKED_BY (OWNER_EMAIL, USER_EMAIL) VALUES ('701d8dce-4500-4ee7-be21-ede976f228c2', 'USER2@PIXOGRAM.COM');
INSERT INTO PICTURE_LIKED_BY (OWNER_EMAIL, USER_EMAIL) VALUES ('e37f8215-ecdc-4394-a67c-90c6bcde340d', 'USER3@PIXOGRAM.COM');
