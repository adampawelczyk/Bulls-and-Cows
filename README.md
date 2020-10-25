# Project Name
> Bulls-and-Cows

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Code Example](#code-example)
* [Features](#features)
* [Status](#status)

## General info
Bulls and Cows is a code-breaking game. There are two players: the first writes a secret code using different digits, and the second has to guess it. At each turn, the second player writes a number that they think might be the correct answer. Then, the first player grades that answer using bulls and cows as a notation. If a digit in the given answer matches a digit and its position in the code, it's called a "bull." If a given digit appears in the code but it position doesn't match, then it's called a "cow." The first player reveals how many bulls and cows there are. In my version of the game you can generate varying number of digits in a secret code (up to 10 digits).

## Technologies
* java - version 15.0.1

## Code Example
```
Please, enter the secret code's length:
4
Okay, let's start a game!
Turn 1:
1234
Grade: 1 cow(s).
Turn 2:
1256
Grade: 3 cow(s).
Turn 3:
2534
Grade: 2 bull(s).
Turn 4:
2650
Grade: 2 bull(s) and 2 cow(s).
Turn 5:
2560
Grade: 4 bull(s).
Congratulations! You guessed the secret code.
```

## Features
List of features ready
* Random code generator (up to 10 digits)

To-do list:
* Improve code generator (Add support for more than 10 symbols by adding letters)
* Handling various errors

## Status
Project is: _in progress_
