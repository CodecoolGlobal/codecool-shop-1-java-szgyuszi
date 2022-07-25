DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS "order" CASCADE;
DROP TABLE IF EXISTS supplier CASCADE;
DROP TABLE IF EXISTS movie CASCADE;
CREATE TABLE category
(
    id    SERIAL PRIMARY KEY,
    genre VARCHAR(20) NOT NULL
);
CREATE TABLE "user"
(
    id       SERIAL PRIMARY KEY,
    name     VARCHAR NOT NULL,
    email    VARCHAR NOT NULL,
    order_id INT     NOT NULL

);

CREATE TABLE "order"
(
    id         SERIAL PRIMARY KEY,
    user_id    INT     NOT NULL,
    movie_name VARCHAR NOT NULL,
    price      INT     NOT NULL

);

CREATE TABLE supplier
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL

);

CREATE TABLE movie
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR NOT NULL,
    url         VARCHAR NOT NULL,
    price       DOUBLE PRECISION  NOT NULL,
    description VARCHAR NOT NULL,
    img         VARCHAR NOT NULL,
    category_id INT     NOT NULL,
    supplier_id INT     NOT NULL

);
ALTER TABLE ONLY "user"
    ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES "order" (id);

ALTER TABLE ONLY "order"
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user" (id);

ALTER TABLE ONLY "movie"
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES "category" (id),
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES "supplier" (id);

INSERT INTO category VALUES (1, 'horror');
INSERT INTO category VALUES (2, 'action');
INSERT INTO category VALUES (3, 'comedy');


INSERT INTO movie VALUES (1, 'Legally Blonde', 'https://www.youtube.com/embed/vWOHwI_FgAo', 9.99, 'Elle Woods, a sorority girl who attempts to win back her ex-boyfriend Warner Huntington III by getting a Juris Doctor degree at Harvard Law School, and in the process, overcomes stereotypes against blondes and triumphs as a successful lawyer through unflappable self-confidence and fashion/beauty knowhow',
                          'src/main/webapp/static/img/product_1.jpg', 1, 1);
INSERT INTO movie VALUES (2, 'Troll 2', 'https://www.youtube.com/embed/CkNB0w1fYKk', 5.99, 'The plot concerns a family pursued by vegetarian goblins who seek to transform them into plants so that they can eat them.',
                          'src/main/webapp/static/img/product_2.jpg', 1, 2);
INSERT INTO movie VALUES (3, 'Gremlins', 'https://www.youtube.com/embed/WeNVftiefOE', 7.99, 'Gremlins is a 1984 American comedy horror film directed by Joe Dante and written by Chris Columbus. It draws on legends of folkloric mischievous creatures that cause malfunctions',
                          'src/main/webapp/static/img/product_3.jpg', 1, 3);
INSERT INTO movie VALUES (4, 'Tropic Thunder', 'https://www.youtube.com/embed/ASJvlHExnMA', 12.99, 'The film stars Stiller, Jack Black, Robert Downey Jr., Jay Baruchel, and Brandon T. Jackson as a group of prima donna actors making a Vietnam War film. When their frustrated director (Steve Coogan) drops them in the middle of a jungle, they are forced to rely on their acting skills to survive the real action and danger.',
                          'src/main/webapp/static/img/product_4.jpg', 2, 4);
INSERT INTO movie VALUES (5, 'The Room', 'https://www.youtube.com/embed/9-dIdFXeFhs', 10.99, 'Johnny is a successful bank executive who lives quietly in a San Francisco townhouse with his fiancée, Lisa. One day, putting aside any scruple, she seduces Johnnys best friend, Mark. From there, nothing will be the same again.',
                          'src/main/webapp/static/img/product_5.jpg', 3, 5);
INSERT INTO movie VALUES (6, 'Abraham Lincoln  : Vampire Hunter', 'https://www.youtube.com/embed/wZp7eBStN1U', 7.99, 'Abraham Lincoln, the 16th President of the United States, discovers vampires are planning to take over the United States. He makes it his mission to eliminate them.',
                          'src/main/webapp/static/img/product_6.jpg', 2, 6);
INSERT INTO movie VALUES (7, 'Spaceballs', 'https://www.youtube.com/embed/jhb1--ibhFE', 5.99, 'A star-pilot for hire and his trusty sidekick must come to the rescue of a princess and save Planet Druidia from the clutches of the evil Spaceballs.',
                   'src/main/webapp/static/img/product_7.jpg', 2, 7);
INSERT INTO movie VALUES (8, 'Sharknado', 'https://www.youtube.com/embed/M-pXDoe5a0E', 10.99, 'When a freak hurricane swamps Los Angeles, natures deadliest killer rules sea, land, and air as thousands of sharks terrorize the waterlogged populace.',
                   'src/main/webapp/static/img/product_8.jpg', 3, 8);
INSERT INTO movie VALUES (9, 'Pineapple Express', 'https://www.youtube.com/embed/BWZt4v6b1hI', 12.99, 'A process server and his marijuana dealer wind up on the run from hitmen and a corrupt police officer after he witnesses his dealer s boss murder a competitor while trying to serve papers on him.',
                          'src/main/webapp/static/img/product_9.jpg', 3, 9);
INSERT INTO movie VALUES (10, 'White Chicks', 'https://www.youtube.com/embed/aeVkbNka9HM', 7.99, 'Two disgraced FBI agents go way undercover in an effort to protect hotel heiresses the Wilson sisters from a kidnapping plot.',
                          'src/main/webapp/static/img/product_10.jpg', 2, 10);
INSERT INTO movie VALUES (11, 'Movie 43', 'https://www.youtube.com/embed/A9fBCkwDW8c', 10.99, 'A series of interconnected short films follows a washed-up producer as he pitches insane story lines featuring some of the biggest stars in Hollywood"',
                          'src/main/webapp/static/img/product_11.jpg', 1, 11);
INSERT INTO movie VALUES (12, 'Scary Movie', 'https://www.youtube.com/embed/HTLPULt0eJ4', 7.99, 'A year after disposing of the body of a man they accidentally killed, a group of dumb teenagers are stalked by a bumbling serial killer.',
                   'src/main/webapp/static/img/product_9.jpg', 1, 12);
