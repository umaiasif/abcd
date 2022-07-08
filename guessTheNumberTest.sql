DROP DATABASE if exists guessTheNumberTest;
CREATE DATABASE guessTheNumberTest;

USE guessTheNumber;

CREATE TABLE game(
gameId INT PRIMARY KEY auto_increment,
answer CHAR(4),
currentStatus boolean default false);



CREATE TABLE round(
roundId INT PRIMARY KEY auto_increment,
gameId INT NOT NULL,
FOREIGN KEY fk_gameId (gameId)
        REFERENCES game(gameId),
guessNum CHAR(4),
timeOfGuess timestamp default current_timestamp,
result CHAR(7) NOT NULL);

