CREATE TABLE IF NOT EXISTS locations (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(255) NOT NULL,
    zip_code VARCHAR(10) NOT NULL UNIQUE,
    founding_date DATE NOT NULL,
    population INTEGER NOT NULL CHECK (population > 0),
    CONSTRAINT unique_name_zip UNIQUE (name, zip_code)
    );

CREATE TABLE IF NOT EXISTS properties (
                                          id SERIAL PRIMARY KEY,
                                          property_type VARCHAR(50) NOT NULL,
    rooms DECIMAL(3,1) NOT NULL CHECK (rooms > 0),
    area DECIMAL(10,2) NOT NULL CHECK (area > 0),
    location_id INTEGER NOT NULL REFERENCES locations(id) ON DELETE CASCADE,
    price NUMERIC(15,2) NOT NULL CHECK (price > 0),
    sale_date DATE
    );
