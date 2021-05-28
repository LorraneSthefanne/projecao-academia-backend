CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO ${schema}.TB_MODALIDADE (ID, NOME, DESCRICAO)
VALUES (uuid_generate_v4(), 'Musculação', ''),
       (uuid_generate_v4(), 'Crossfit', ''),
       (uuid_generate_v4(), 'Jiu-jitsu', ''),
       (uuid_generate_v4(), 'Boxe', ''),
       (uuid_generate_v4(), 'Judo', ''),
       (uuid_generate_v4(), 'Dança', '');
