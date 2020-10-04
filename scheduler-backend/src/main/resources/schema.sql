CREATE SCHEMA scheduler;
USE scheduler;

CREATE TABLE IF NOT EXISTS work_tasks (
    id INT NOT NULL UNIQUE AUTO_INCREMENT,
    priority INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    difficulty INT NOT NULL,
    duration INT NOT NULL,
    included TINYINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS non_work_tasks (
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    duration INT NOT NULL,
    interval_in_hours INT NOT NULL,
    is_sleep TINYINT NOT NULL, 
    is_meal TINYINT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tasks(
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL, 
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    is_work_task TINYINT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS astronaut(
	id INT NOT NULL UNIQUE AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    age_group VARCHAR(20) NOT NULL,
    amount_of_sleep_in_hours DOUBLE NOT NULL,
    jetlag_adjustment_in_days INT NOT NULL,
    mission_start_time DATETIME NOT NULL,
    mission_end_time DATETIME NOT NULL,
	PRIMARY KEY (id)
);
