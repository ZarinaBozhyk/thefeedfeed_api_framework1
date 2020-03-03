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