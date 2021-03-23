Feature: Perform CRUD Operations

  Scenario Outline: To Perform the GET Operation on Employe DB
    Given The "<Base_URI>" for Get Operation
    When User perform the Get Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                        | Response_Code |
      | http://localhost:8088/employees |           200 |

  Scenario Outline: To Perform the GET Operation on GitHub
    Given The "<Base_URI>" for Get Operation
    When User perform the Get Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                                      | Response_Code |
      | https://api.github.com/users/Seeker-777/repos |           200 |

  Scenario Outline: To Perform the POST Operation on GitHub
    Given The "<Base_URI>" for Post Operation and token is "<Token>"
    When User perform the Post Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                          | Response_Code | Token                                    |
      | https://api.github.com/user/repos |           201 | 425bc1c5ed6e9b63b63895f1fe71cd5377764e12 |

  Scenario Outline: To Perform the PATCH Operation on GitHub
    Given The "<Base_URI>" for Patch Operation and token is "<Token>"
    When User perform the Patch Operation
    Then Response should not be null
    And "<Response_Code>" should be as expected

    Examples: 
      | Base_URI                                             | Response_Code | Token                                    |
      | https://api.github.com/repos/Seeker-777/Postman_Rest |           200 | 425bc1c5ed6e9b63b63895f1fe71cd5377764e12 |
