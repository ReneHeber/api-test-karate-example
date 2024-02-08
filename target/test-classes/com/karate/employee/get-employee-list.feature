Feature: Get employee list

  Background:
    * url 'http://localhost:8080/api/v1'

  Scenario: Fetch list of employees

    Given path 'employee/all'
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And match $ == read('employees.json')