ALTER TABLE reservations
ADD COLUMN time_slot_id BIGINT UNSIGNED,
ADD CONSTRAINT fk_reservations_time_slots_id
    FOREIGN KEY (time_slot_id) REFERENCES time_slots(id);