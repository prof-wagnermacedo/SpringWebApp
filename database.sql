USE [PJW];

CREATE TABLE [Cars]
(
    [id] INT IDENTITY PRIMARY KEY,
    [name] VARCHAR(50),
    [price] REAL,
    [color] VARCHAR(15)
);

INSERT INTO Cars
    ([name], [price], [color])
VALUES
    ('Mercedes SL', 123400, '#674EA7'),
    ('BMW M6 Coupé', 125000, '#0000FF'),
    ('Audi R8', 136100, '#FF0000');
