Feature: add new list expense
    As a owner
    I want to add new expense list

Scenario: Add new income
    When I record income is in with detail is by dad amount 500 baht
    Then total is 500

Scenario: Add new expense
    When I record expense is in with detail is by kfc amount 200 baht
    Then total is -200

Scenario: Add income and expense
    When I record income is in with detail is by dad amount 500 baht
    When I record expense is in with detail is by kfc amount 200 baht
    Then total is 300




