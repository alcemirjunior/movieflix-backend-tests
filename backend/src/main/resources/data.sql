INSERT INTO tb_user (name, email, password) VALUES ('Bob Brow', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Maria', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Action');
INSERT INTO tb_genre (name) VALUES ('Comedy');
INSERT INTO tb_genre (name) VALUES ('Terror');

INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 1', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 1);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 2', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 2);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 3', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 3);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 4', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 1);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 5', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 2);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 6', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 3);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 7', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 1);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 8', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 2);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 9', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 3);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id) VALUES ('spider-man 10', 'o homem aranha', 2011, 'teste', 'é um filme de 2011', 1);


