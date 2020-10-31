# Project Name
> Bulls-and-Cows

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Code Examples](#code-examples)
* [Features](#features)
* [Status](#status)

## General info
Bulls and Cows is a code-breaking game. There are two players: the first writes a secret code using different digits, and the second has to guess it. At each turn, the second player writes a number that they think might be the correct answer. Then, the first player grades that answer using bulls and cows as a notation. If a digit in the given answer matches a digit and its position in the code, it's called a "bull." If a given digit appears in the code but it position doesn't match, then it's called a "cow." The first player reveals how many bulls and cows there are. In my version of the game you can generate varying number of digits in a secret code (up to 36 digits).

## Technologies
* java - version 15.0.1

## Code Examples
```
Please, enter the secret code's length:
> 4
Input the number of possible symbols in the code:
> 12
The secret is prepared: **** (0-9, a-b).
Okay, let's start a game!
Turn 1:
> a234
Grade: 1 bull and 1 cow
Turn 2:
> 73b4
Grade: 2 bulls and 1 cow
Turn 3:
> 9374
Grage: 4 bulls
Congratulations! You guessed the secret code.
```
```
Please, enter the secret code's length:
6
Input the number of possible symbols in the code:
37
Error: maximum number of possible symbols in the code is 36 (0-9, a-z).
```
```
Please, enter the secret code's length:
10
Input the number of possible symbols in the code:
12a
Error: incorrect input.
```
## Features
List of features
* Random code generator (up to 36 digits)
* Exception handling

## Status
Project is: _finished_
