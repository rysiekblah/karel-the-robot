Feature: Add wall

  Scenario: User put a wall on North
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '2' streets and '2' avenues
    Then drawing lines should be performed '4' times
    When a user puts a wall at crossroad street: '1' and avenue: '1' on 'North'
    Then drawing should be performed '1' times with arguments x1='0' y1='400' x2='100' y2='400'

  Scenario: User put a wall on South
    Given a message handler and window properties width='500' heigh='500' granulation='100'
    When a user provides '2' streets and '2' avenues
    Then drawing lines should be performed '4' times
    When a user puts a wall at crossroad street: '1' and avenue: '1' on 'South'
    Then drawing should be performed '1' times with arguments x1='0' y1='500' x2='100' y2='500'