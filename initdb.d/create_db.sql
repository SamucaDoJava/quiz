DO
$$
BEGIN
    IF NOT EXISTS (
        SELECT FROM pg_database WHERE datname = 'quiz_moba_db'
    ) THEN
        EXECUTE 'CREATE DATABASE quiz_moba_db';
    END IF;
END
$$;
