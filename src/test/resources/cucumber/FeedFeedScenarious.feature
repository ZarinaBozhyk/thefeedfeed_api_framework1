Feature: FeedFeed testing

  Scenario Outline: Test Pies page
    Given I get pies recipe information and save it
    Then I check at least one recipe has rating more than "<count>"
    Then I check at least one recipe has pies:
      | Coconut Pies               |
      | Cranberry Pies & Tarts     |
      | Cream Pies                 |
      | Pear Pies                  |
      | Pecan Pie                  |
      | Rhubarb Pies               |
      | Sweet Potato & Squash Pies |
    Examples:
      | count |
      | 1     |

  Scenario: Test Home Page block
    When I get My FeedFeed block info and save it
    Then I check username is equal to main url
    Then I check date of updated image is equal to created date

  Scenario: calculate add
    Given I have a calc with numbers
    When I ask it to say add
    Then it should answer with add result

  Scenario: Adding a and b
    Given I have variable a
    And I have variable b
    When I add a and b
    Then I display the sum

  Scenario: Test Home Page block
    When I get My FeedFeed block info and save it
    Then I check username is equal to main url
    Then I check date of updated image is equal to created date

  Scenario: calculate add1
    Given I have a calc with numbers
    When I ask it to say add
    Then it should answer with add result

  Scenario: Adding a and b1
    Given I have variable a
    And I have variable b
    When I add a and b
    Then I display the sum

  Scenario: Test Home Page block1
    When I get My FeedFeed block info and save it
    Then I check username is equal to main url
    Then I check date of updated image is equal to created date

  Scenario: calculate add2
    Given I have a calc with numbers
    When I ask it to say add
    Then it should answer with add result

  Scenario: Adding a and b2
    Given I have variable a
    And I have variable b
    When I add a and b
    Then I display the sum

  Scenario: Test Home Page block2
    When I get My FeedFeed block info and save it
    Then I check username is equal to main url
    Then I check date of updated image is equal to created date

  Scenario: calculate add3
    Given I have a calc with numbers
    When I ask it to say add
    Then it should answer with add result

  Scenario: Adding a and b3
    Given I have variable a
    And I have variable b
    When I add a and b
    Then I display the sum

  Scenario: Test Home Page block3
    When I get My FeedFeed block info and save it
    Then I check username is equal to main url
    Then I check date of updated image is equal to created date

  Scenario: calculate add4
    Given I have a calc with numbers
    When I ask it to say add
    Then it should answer with add result

  Scenario: Adding a and b4
    Given I have variable a
    And I have variable b
    When I add a and b
    Then I display the sum



