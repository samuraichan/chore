DROP TABLE IF EXISTS system_revision CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS chore_entry CASCADE;
DROP TABLE IF EXISTS chore_entry_m CASCADE;

DROP SEQUENCE IF EXISTS hibernate_sequence; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work

CREATE TABLE chore_entry 
(
  id SERIAL PRIMARY KEY,
  category INTEGER,
  chore_date DATE,
  amount DECIMAL,
  memo VARCHAR(200),
  notified VARCHAR(1),
  paid VARCHAR(1),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER
);

CREATE TABLE chore_entry_m
(
  chore_entry_m_id SERIAL PRIMARY KEY, -- required by hibernate
  category INTEGER,
  chore_date DATE,
  amount DECIMAL,
  memo VARCHAR(200),
  notified VARCHAR(1),
  paid VARCHAR(1),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  rev INTEGER, -- required by hibernate
  revtype SMALLINT -- required by hibernate
);

CREATE TABLE category 
(
  id SERIAL PRIMARY KEY,
  name VARCHAR(25),
  created_date timestamp,
  updated_date timestamp,
  active_flag VARCHAR(1),
  version_number INTEGER,
  UNIQUE(name, active_flag)
);

-- see StarterRevisioinEntity.java (hibernate provides a default REVINFO tale if 
-- @RevisionEntity is not provided by the app
CREATE TABLE system_revision
(
  id INTEGER PRIMARY KEY,
  timestamp BIGINT
);


CREATE SEQUENCE hibernate_sequence START 2000; -- in order for @GeneratedValue(strategy = GenerationType.SEQUENCE) to work
