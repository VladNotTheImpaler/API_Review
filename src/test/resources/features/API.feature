@ALL
Feature: Syntax API

  Background:
    Given a JWT is generated

  @test1 @t
  Scenario: create an Employee
    Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable


  @test2 @t
  Scenario:Get the created Employee
    Given a request is prepared for retrieving an employee
    When a GET call is made to retrieve the employee
    Then the status code for this employee is 200
    And the employee id "employee.employee_id" matches the globally stored id
    And the employee information under the key "employee" matches the data used to create the employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Borea        |Groza       |MS             |Male      |1951-07-28  |Employed  |Plach Plach,Tansuy Tansuy|

  @hw @t
  Scenario:partially update the created employee
    Given the request is prepared to update the employee firstname to "Borisca"
    When a PATCH call is made to update the employee
    Then the status code is 201
    And the employee updated has the updated firstname "Borisca"

  @test3 @t
  Scenario:get the partially updated employee
    Given a request is prepared for retrieving an employee
    When a GET call is made to retrieve the employee
    Then the status code for this employee is 200
    And the employee id "employee.employee_id" matches the globally stored id
    And the employee information under the key "employee" matches the data used to create the employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Borisca        |Groza       |MS           |Male      |1951-07-28  |Employed  |Plach Plach,Tansuy Tansuy|