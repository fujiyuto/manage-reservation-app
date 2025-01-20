CREATE TABLE IF NOT EXISTS time_slots (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hour INTEGER NOT NULL CHECK (hour >= 0 AND hour <= 23),
    minute INTEGER NOT NULL CHECK (minute IN (0, 15, 30, 45)),
    UNIQUE (hour, minute)
);

INSERT INTO time_slots (hour, minute)
WITH RECURSIVE hours AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1
    FROM hours
    WHERE hour < 23
),
minutes AS (
    SELECT 0 AS minute
    UNION ALL
    SELECT 15
    UNION ALL
    SELECT 30
    UNION ALL
    SELECT 45
)
SELECT hour, minute
FROM hours
CROSS JOIN minutes
ORDER BY hour, minute;