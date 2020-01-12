DROP TABLE    logs;
        DROP SEQUENCE logging_event_id_seq;
        CREATE SEQUENCE logging_event_id_seq MINVALUE 1 START 1;
        CREATE TABLE logs
        (
        ID        BIGINT DEFAULT nextval('logging_event_id_seq') PRIMARY KEY,
        DATE        date NOT NULL,
        LOG_LEVEL VARCHAR(254) NOT NULL,
        MESSAGE       VARCHAR(254) NOT NULL,
        EXCEPTION VARCHAR(254) NOT NULL
        );