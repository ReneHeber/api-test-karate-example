Feature: Create employee

  Background:
    #* call read('classpath:karate-config.js')
    #* url baseUrl
    * url 'http://localhost:8080/api/v1'
    
  #Accessing config file value
  #Scenario: Config Author Demo
  #  Given print author

  Scenario: Create a employee

    Given path 'employee'
    And header Content-Type = 'application/json'
    And request { "id": "1", "name": "Sarah"}
    When method POST
    Then status 200
    And match $ == {name: "Sarah", message: "Successfully created employee"}

  Scenario Outline: Create multiple users

    Given path 'employee'
    And header Content-Type = 'application/json'
    And request { "id": '<id>', "name": '<name>'}
    When method POST
    Then status 200
    And match $ == {name: '<name>', message: "Successfully created employee"}

    Examples:

      | id | name   |
      | 2  | Jesse  |
      | 3  | Julia  |
      | 4  | Svenja |

    Scenario Outline: Create multiple users part 2
  
      Given path 'employee'
      And header Content-Type = 'application/json'
      And request { "id": '<id>', "name": '<name>'}
      When method POST
      Then status 200
      And match $.name == '<name>'
      And match $ contains {name: '#notnull'}
      And match $ contains {name: '#string'}
  
      Examples:
  
        | id | name   |
        | 5  | Kim    |
        | 6  | Freya  |