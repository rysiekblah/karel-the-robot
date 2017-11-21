Feature: User can create a new game with given nubmer of streets and avenues

  Scenario: If user gives 0 streets and 0 avenues no drawing should be performed
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '0' streets and '0' avenues
    Then drawing lines should be performed '0' times

  Scenario: If user gives 1 street and 1 avenue 2 drawing are expected, one horizontal and one vertical line
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '1' streets and '1' avenues
    Then drawing should be performed '1' times with arguments x1='0' y1='250' x2='500' y2='250'
    Then drawing should be performed '1' times with arguments x1='250' y1='0' x2='250' y2='500'

  Scenario: If user gives 2 streets and 2 avenues then 4 drawing are expected
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '2' streets and '2' avenues
    Then drawing should be performed '1' times with arguments x1='50' y1='0' x2='50' y2='500'
    Then drawing should be performed '1' times with arguments x1='450' y1='0' x2='450' y2='500'
    Then drawing should be performed '1' times with arguments x1='0' y1='50' x2='500' y2='50'
    Then drawing should be performed '1' times with arguments x1='0' y1='450' x2='500' y2='450'
