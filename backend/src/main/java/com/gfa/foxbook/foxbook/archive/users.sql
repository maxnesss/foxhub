-- Inserting Roles
INSERT INTO role (name) VALUES ('USER');
INSERT INTO role (name) VALUES ('ADMIN');

-- Inserting Technologies
INSERT INTO technologies (name) VALUES ('Java');
INSERT INTO technologies (name) VALUES ('Python');
INSERT INTO technologies (name) VALUES ('JavaScript');
INSERT INTO technologies (name) VALUES ('C++');
INSERT INTO technologies (name) VALUES ('Ruby');
INSERT INTO technologies (name) VALUES ('PHP');
INSERT INTO technologies (name) VALUES ('Swift');
INSERT INTO technologies (name) VALUES ('Go');
INSERT INTO technologies (name) VALUES ('Rust');
INSERT INTO technologies (name) VALUES ('C#');
INSERT INTO technologies (name) VALUES ('HTML');
INSERT INTO technologies (name) VALUES ('CSS');
INSERT INTO technologies (name) VALUES ('SQL');
INSERT INTO technologies (name) VALUES ('Kotlin');
INSERT INTO technologies (name) VALUES ('Perl');
INSERT INTO technologies (name) VALUES ('TypeScript');
INSERT INTO technologies (name) VALUES ('Shell Scripting');
INSERT INTO technologies (name) VALUES ('Scala');
-- Add more technologies as needed

-- Inserting Languages
INSERT INTO languages (name) VALUES ('English');
INSERT INTO languages (name) VALUES ('Spanish');
INSERT INTO languages (name) VALUES ('French');
INSERT INTO languages (name) VALUES ('German');
INSERT INTO languages (name) VALUES ('Mandarin Chinese');
INSERT INTO languages (name) VALUES ('Russian');
INSERT INTO languages (name) VALUES ('Japanese');
INSERT INTO languages (name) VALUES ('Arabic');
INSERT INTO languages (name) VALUES ('Ukrainian');
INSERT INTO languages (name) VALUES ('Italian');
INSERT INTO languages (name) VALUES ('Vietnamese');
INSERT INTO languages (name) VALUES ('Dutch');
INSERT INTO languages (name) VALUES ('Swedish');
-- Add more languages as needed

-- Inserting Users
INSERT INTO users (uuid, first_name, last_name, nickname, email, phone, location, about, complete_projects, years_of_experience, year_of_birth, password, personality, country_residence, facebook, instagram, linkedin, git_hub, optional_page)
VALUES
    (null, 'Bill', 'Gates', 'bill-gates', 'bill@microsoft.com', '+123456789', 'United States', 'Co-founder of Microsoft', '2431', '30+', 1955, '$2a$10$LinZPL8BnsNZzQ3.eg6rQu0xpw.mSKnyY2R69I7Ab0iWOv4ZHbms6', 'Innovative, philanthropic', 'United States', 'https://www.facebook.com/billgates', 'https://www.instagram.com/billgates', 'https://www.linkedin.com/in/billgates', 'https://github.com/billgates', 'https://www.example.com/billgates'),
    (null, 'Steve', 'Jobs', 'steve-jobs', 'steve@apple.com', '+987654321', 'United States', 'Co-founder of Apple', '6546', '30+', 1955, '$2a$10$LinZPL8BnsNZzQ3.eg6rQu0xpw.mSKnyY2R69I7Ab0iWOv4ZHbms6', 'Visionary, creative', 'United States', 'https://www.facebook.com/stevejobs', 'https://www.instagram.com/stevejobs', 'https://www.linkedin.com/in/stevejobs', 'https://github.com/stevejobs', 'https://www.example.com/stevejobs'),
    (null, 'Elon', 'Musk', 'elon-musk', 'elon@tesla.com', '+123456789', 'United States', 'CEO of SpaceX and Tesla', '232', '20+', 1971, '$2a$10$LinZPL8BnsNZzQ3.eg6rQu0xpw.mSKnyY2R69I7Ab0iWOv4ZHbms6', 'Innovative, ambitious', 'United States', 'https://www.facebook.com/elonmusk', 'https://www.instagram.com/elonmusk', 'https://www.linkedin.com/in/elonmusk', 'https://github.com/elonmusk', 'https://www.example.com/elonmusk'),
    (null, 'Jeff', 'Bezos', 'jeff-bezos', 'jeff@amazon.com', '+987654321', 'United States', 'Founder of Amazon', '4563', '30+', 1964, '$2a$10$LinZPL8BnsNZzQ3.eg6rQu0xpw.mSKnyY2R69I7Ab0iWOv4ZHbms6', 'Visionary, customer-centric', 'United States', 'https://www.facebook.com/jeffbezos', 'https://www.instagram.com/jeffbezos', 'https://www.linkedin.com/in/jeffbezos', 'https://github.com/jeffbezos', 'https://www.example.com/jeffbezos'),
    (null, 'Larry', 'Page', 'larry-page', 'larry@google.com', '+234567890', 'United States', 'Co-founder of Google', '1210', '20+', 1973, '$2a$10$LinZPL8BnsNZzQ3.eg6rQu0xpw.mSKnyY2R69I7Ab0iWOv4ZHbms6', 'Innovative, forward-thinking', 'United States', 'https://www.facebook.com/larrypage', 'https://www.instagram.com/larrypage', 'https://www.linkedin.com/in/larrypage', 'https://github.com/larrypage', 'https://www.example.com/larrypage'),
    (null, 'Mark', 'Zuckerberg', 'mark-zuckerberg', 'mark@facebook.com', '+345678901', 'United States', 'CEO of Facebook', '30', '15+', 1984, '$2a$10$LinZPL8BnsNZzQ3.eg6rQu0xpw.mSKnyY2R69I7Ab0iWOv4ZHbms6', 'Entrepreneurial, social', 'United States', 'https://www.facebook.com/markzuckerberg', 'https://www.instagram.com/markzuckerberg', 'https://www.linkedin.com/in/markzuckerberg', 'https://github.com/markzuckerberg', 'https://www.example.com/markzuckerberg'),
    (null, 'Sundar', 'Pichai', 'sundar-pichai', 'sundar@aplhabet.com', '+456789012', 'United States', 'CEO of Google', '2', '15+', 1972, '$2a$10$LinZPL8BnsNZzQ3.eg6rQu0xpw.mSKnyY2R69I7Ab0iWOv4ZHbms6', 'Visionary, inclusive', 'United States', 'https://www.facebook.com/sundarpichai', 'https://www.instagram.com/sundarpichai', 'https://www.linkedin.com/in/sundarpichai', 'https://github.com/sundarpichai', 'https://www.example.com/sundarpichai');
-- Add more users as needed


-- Assigning Roles to Users
INSERT INTO users_roles (users_id, roles_id) VALUES
                                                ((SELECT id FROM users WHERE nickname = 'bill-gates'), (SELECT id FROM role WHERE name = 'USER')),
                                                ((SELECT id FROM users WHERE nickname = 'steve-jobs'), (SELECT id FROM role WHERE name = 'USER')),
                                                ((SELECT id FROM users WHERE nickname = 'elon-musk'), (SELECT id FROM role WHERE name = 'USER')),
                                                ((SELECT id FROM users WHERE nickname = 'jeff-bezos'), (SELECT id FROM role WHERE name = 'USER')),
                                                ((SELECT id FROM users WHERE nickname = 'larry-page'), (SELECT id FROM role WHERE name = 'USER')),
                                                ((SELECT id FROM users WHERE nickname = 'mark-zuckerberg'), (SELECT id FROM role WHERE name = 'USER')),
                                                ((SELECT id FROM users WHERE nickname = 'sundar-pichai'), (SELECT id FROM role WHERE name = 'USER'));

-- Assigning Technologies to Users
INSERT INTO users_technologies (users_id, technologies_id) VALUES
                                                               ((SELECT id FROM users WHERE nickname = 'bill-gates'), (SELECT id FROM technologies WHERE name = 'Java')),
                                                               ((SELECT id FROM users WHERE nickname = 'bill-gates'), (SELECT id FROM technologies WHERE name = 'Python')),
                                                               ((SELECT id FROM users WHERE nickname = 'steve-jobs'), (SELECT id FROM technologies WHERE name = 'JavaScript'));

-- Assigning Languages to Users
INSERT INTO users_languages (users_id, languages_id) VALUES
                                                         ((SELECT id FROM users WHERE nickname = 'bill-gates'), (SELECT id FROM languages WHERE name = 'English')),
                                                         ((SELECT id FROM users WHERE nickname = 'steve-jobs'), (SELECT id FROM languages WHERE name = 'English')),
                                                         ((SELECT id FROM users WHERE nickname = 'bill-gates'), (SELECT id FROM languages WHERE name = 'Spanish')),

                                                         ((SELECT id FROM users WHERE nickname = 'steve-jobs'), (SELECT id FROM languages WHERE name = 'Spanish'));
