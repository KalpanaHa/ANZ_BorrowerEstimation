Feature: Borrowing calculator

  Scenario Outline: Estimate borrowing for given data(Test case 1)
    Given user is on loan estimation page
    And user Enters the eligibility data "<ApplicatonType>" "<dependents>" "<propertyBuy>""<income>" "<otherIncome>" "<livingExpense>""<currentHomeLoan>""<otherLoan>" "<otherCommitment>" "<totalCreditCardLimit>"
    When user clicks how much borrow button
    Then user validate the borrowing estimation as "$479,000"
    Examples: 
      | ApplicatonType | dependents | propertyBuy     | income | otherIncome | livingExpense | currentHomeLoan | otherLoan | otherCommitment | totalCreditCardLimit |
      | Single         |          0 | Home to live in |  80000 |       10000 |           500 |               0 |       100 |               0 |                10000 |

  Scenario Outline: Click on start over to clear the form(Test case 2)
    Given user is on loan estimation page
    And user Enters the eligibility data "<ApplicatonType>" "<dependents>" "<propertyBuy>""<income>" "<otherIncome>" "<livingExpense>""<currentHomeLoan>""<otherLoan>" "<otherCommitment>" "<totalCreditCardLimit>"
    When user clicks how much borrow button
    # Then user validate the borrowing estimation as "479000"
    Then user clicks on Start over button to clear the form

    Examples: 
      | ApplicatonType | dependents | propertyBuy     | income | otherIncome | livingExpense | currentHomeLoan | otherLoan | otherCommitment | totalCreditCardLimit |
      | Single         |          0 | Home to live in |  80000 |       10000 |           500 |               0 |       100 |               0 |                10000 |

  Scenario Outline: Enter only $1 for living expenses and all fields are 0 (Test case 3)
    Given user is on loan estimation page
    And user Enters the eligibility data "<ApplicatonType>" "<dependents>" "<propertyBuy>""<income>" "<otherIncome>" "<livingExpense>""<currentHomeLoan>""<otherLoan>" "<otherCommitment>" "<totalCreditCardLimit>"
    When user clicks how much borrow button
    Then user validate the error message

    Examples: 
      | ApplicatonType | dependents | propertyBuy     | income | otherIncome | livingExpense | currentHomeLoan | otherLoan | otherCommitment | totalCreditCardLimit |
      | Single         |          0 | Home to live in |      0 |           0 |             1 |               0 |         0 |               0 |                    0 |
