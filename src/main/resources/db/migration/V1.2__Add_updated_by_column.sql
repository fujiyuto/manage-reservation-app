ALTER TABLE reservations
ADD COLUMN updated_by BIGINT UNSIGNED,
ADD CONSTRAINT fk_reservations_updated_by 
    FOREIGN KEY (updated_by) REFERENCES users(id);