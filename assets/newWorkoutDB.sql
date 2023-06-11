CREATE DATABASE new_workout_db;
USE new_workout_db;

CREATE TABLE User (
	id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    reward_points INT DEFAULT 0
);

CREATE TABLE Workout (
	id INT PRIMARY KEY AUTO_INCREMENT,
    type VARCHAR(75) NOT NULL,
    calories INT NOT NULL
);

CREATE TABLE User_Workout (
	id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    workout_id INT,
    workout_date DATE,
    reps INT,
    FOREIGN KEY(user_id) REFERENCES User(id),
    FOREIGN KEY(workout_id) REFERENCES Workout(id)
);

CREATE TABLE Goal (
	id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
	start_date DATE,
    end_date DATE,
    workout_goal INT NOT NULL,
    FOREIGN KEY(user_id) REFERENCES User(id)
);

INSERT INTO User VALUES(null, "JohnDoe", "JDoe", 0);
INSERT INTO Workout VALUES(null, "Deadlift(150)", 60);
INSERT INTO User_Workout VALUES(null, 1, 1, '2023-05-23', 5);
INSERT INTO User_Workout VALUES(null, 1, 1, '2023-05-20', 4);
INSERT INTO User_Workout VALUES(null, 1, 1, '2023-03-01', 4);
INSERT INTO Goal VALUES(null, 1, '2023-05-20', '2023-05-27', 3);


-- See how many workouts a user has completed within a given length of time-- 
SELECT 
    COUNT(id) AS 'Completed Workouts',
    (SELECT 
            workout_goal AS 'Goal'
        FROM
            Goal) AS 'Goal'
FROM
    User_Workout
WHERE
    workout_date BETWEEN (SELECT 
            start_date
        FROM
            Goal
        WHERE
            user_id = 1) AND (SELECT 
            end_date
        FROM
            Goal
        WHERE
            user_id = 1);
            
            
            
            
            
            
            
            
            