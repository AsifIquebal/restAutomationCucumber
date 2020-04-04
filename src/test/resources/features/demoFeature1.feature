
Feature: Rest API Call with Cucumber demo

  Scenario: verify albums api
    When user send a GET request to "http://jsonplaceholder.typicode.com/albums"
    Then status code should be 200

  Scenario: validate Album Size
    When user sends a GET request to "http://jsonplaceholder.typicode.com/albums"
    Then album size should be 100

  Scenario: validate Users Company
    When user calls the user api "http://jsonplaceholder.typicode.com/users"
    Then on response user "Leanne Graham" should belong to company "Romaguera-Crona"

  Scenario: validate Photos API
    When user calls the photos api "http://jsonplaceholder.typicode.com/photos"
    Then on response following details should present
    |key|value|
    |url[0]|https://via.placeholder.com/600/92c952|
    |url[4999]|https://via.placeholder.com/600/6dd9cb|