# Project Name
> Bulls-and-Cows

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Code Example](#code-example)
* [Features](#features)
* [Status](#status)

## General info
Bulls and Cows is a code-breaking game. There are two players: the first writes a secret code using different digits, and the second has to guess it. At each turn, the second player writes a number that they think might be the correct answer. Then, the first player grades that answer using bulls and cows as a notation. If a digit in the given answer matches a digit and its position in the code, it's called a "bull." If a given digit appears in the code but it position doesn't match, then it's called a "cow." The first player reveals how many bulls and cows there are. In my version of the game you can generate varying number of digits in a secret code (up to 36 digits).

## Technologies
* java - version 15.0.1

## Code Example
```
Input the length of the secret code:
> 4
Input the number of possible symbols in the code:
> 16
The secret is prepared: **** (0-9, a-f).
Okay, let's start a game!
Turn 1:
> 1a34
Grade: 1 bull and 1 cow
Turn 2:
> b354
Grade: 2 bulls and 1 cow
Turn 3:
> 93b4
Grade: 4 bulls
Congratulations! You guessed the secret code.
```

## Features
List of features ready
* Random code generator (up to 36 digits)

To-do list:
* Handling various errors

## Status
Project is: _in progress_
