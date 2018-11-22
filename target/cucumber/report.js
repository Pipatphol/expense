$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/addNewListExpense.feature");
formatter.feature({
  "line": 1,
  "name": "add new list expense",
  "description": "  As a owner\n  I want to add new expense list",
  "id": "add-new-list-expense",
  "keyword": "Feature"
});
formatter.before({
  "duration": 184494,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Add new income",
  "description": "",
  "id": "add-new-list-expense;add-new-income",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I record income is in with detail is by dad amount 500 baht",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "total is 500",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "dad",
      "offset": 40
    },
    {
      "val": "500",
      "offset": 51
    }
  ],
  "location": "StepDefExpense.i_record_income_is_in(String,int)"
});
formatter.result({
  "duration": 172869477,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "500",
      "offset": 9
    }
  ],
  "location": "StepDefExpense.total_is(int)"
});
formatter.result({
  "duration": 60400712,
  "status": "passed"
});
formatter.before({
  "duration": 18568,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Add new expense",
  "description": "",
  "id": "add-new-list-expense;add-new-expense",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I record expense is in with detail is by kfc amount 200 baht",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "total is -200",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "kfc",
      "offset": 41
    },
    {
      "val": "200",
      "offset": 52
    }
  ],
  "location": "StepDefExpense.i_record_expense_is_in(String,int)"
});
formatter.result({
  "duration": 169877,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 10
    }
  ],
  "location": "StepDefExpense.total_is_negative_value(int)"
});
formatter.result({
  "duration": 98766,
  "status": "passed"
});
formatter.before({
  "duration": 33976,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Add income and expense",
  "description": "",
  "id": "add-new-list-expense;add-income-and-expense",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I record income is in with detail is by dad amount 500 baht",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I record expense is in with detail is by kfc amount 200 baht",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "total is 300",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "dad",
      "offset": 40
    },
    {
      "val": "500",
      "offset": 51
    }
  ],
  "location": "StepDefExpense.i_record_income_is_in(String,int)"
});
formatter.result({
  "duration": 172642,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "kfc",
      "offset": 41
    },
    {
      "val": "200",
      "offset": 52
    }
  ],
  "location": "StepDefExpense.i_record_expense_is_in(String,int)"
});
formatter.result({
  "duration": 208988,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "300",
      "offset": 9
    }
  ],
  "location": "StepDefExpense.total_is(int)"
});
formatter.result({
  "duration": 117728,
  "status": "passed"
});
});