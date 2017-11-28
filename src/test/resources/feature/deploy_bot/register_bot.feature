Feature: Registering a bot to take a round pf one game

  Scenario: A bot registers to karel system and gets a confirmation that game can be started

  Scenario: A bot registers to the system but name is already taken

  Scenario: A bot is registered already and request a new game but is getting rejection with reason that another game is started

  Scenario: A bot is registered already having a clientId and initiates a new game
    Given a bot with name 'bot-1' and clientId '1'
    When a bot request a new game with strees='5' and avenues='5'
    Then service responds 200OK and gameId any long value
    And service generates a new karel's world
    And service draws more the '1' walls
    And service puts more then '1' beepers
