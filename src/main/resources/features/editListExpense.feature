Feature: edit list expense
    As a owner
    I want to edit expense list
    
Scenario: edit icome id 1 in expense list
    When I record income is in with detail is by dad amount 500 baht
    Then total is 500
    When I edit icome id 1 with detail is mom and amount is 300 exists
    Then total is 300

Scenario: edit expense id 1 in expense list
    When I record expense is in with detail is by kfc amount 200 baht
    Then total is -200
    When I edit expense id 1 with detail is mc and amount is 100 exists
    Then total is -100

Scenario: edit expense id 2 in expense list
    When I record income is in with detail is by dad amount 500 baht
    Then total is 500
    When I record expense is in with detail is by kfc amount 200 baht
    Then total is 300
    When I edit expense id 2 with detail is mc and amount is 100 exists
    Then total is 400
