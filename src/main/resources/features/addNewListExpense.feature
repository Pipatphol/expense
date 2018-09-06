Feature: add new list expense
    As a owner
    I want to add new expense list

Scenario: Add new income
    When I record income is in with detail is by dad amount 500 baht
    Then total is 500

Scenario: Add new expense
    When I record expense is out with detail is Mc amount 100 baht
    Then total is -100

Scenario: Add new income and new expense list
    When I record income is in with detail is by dad amount 500 baht
    And I record expense is out with detail is Mc amount 100 baht
    Then total is 400



