DROP TABLE IF EXISTS conferences;

CREATE TABLE conferences (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  place VARCHAR(250) NOT NULL,
  date DATE NOT NULL
);

INSERT INTO conferences (name, place, date) VALUES ('OReilly', 'London', '2022-09-17');
INSERT INTO conferences (name, place, date) VALUES ('TDC', 'São Paulo', '2022-08-17');
INSERT INTO conferences (name, place, date) VALUES ('MTC', 'Belo Horizonte', '2022-09-20');
INSERT INTO conferences (name, place, date) VALUES ('Agile Brazil', 'Rio de Janeiro', '2022-09-30');
