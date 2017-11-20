# karel-the-robot

## Create a new game

```gherkin
Feature: User can create a new game with given nubmer of streets and avenues

  Scenario: If user gives 0 streets and 0 avenues no drawing should be performed
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '0' streets and '0' avenues
    Then drawing should be performed '0' times with arguments x1='0' y1='0' x2='0' y2='0'

  Scenario: If user gives 1 street and 1 avenue 2 drawing are expected, one horizontal and one vertical line
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '1' streets and '1' avenues
    Then drawing should be performed '1' times with arguments x1='0' y1='250' x2='500' y2='250'
    Then drawing should be performed '1' times with arguments x1='250' y1='0' x2='250' y2='500'
```

## Create a wall

```gherkin
Feature: Add wall at given crossroad and given direction

  Scenario: User put a wall on North
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '2' streets and '2' avenues
    Then drawing lines should be performed '4' times
    When a user puts a wall at crossroad street: '1' and avenue: '1' on 'North'
    Then drawing should be performed '1' times with arguments x1='0' y1='400' x2='100' y2='400'
```

## Tasks
1. Karel with parser and handler
 - unit tests
 - bdd tests

2. Add createWall
 - unit tests
 - bdd test

3. Refactor a parser and handler
 - copy paste solution (handler doesnt have any switch-case, no parser, create a factory which doeas all stuff and return a command)
 - run tests
	- UT fail
	- bdd dont
