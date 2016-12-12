Feature: A few tests

// @persistent indicates that created objects should not be deleted automatically
@persistent
Scenario: My first test
	Given I'm logged in as "sy"
	And I open an editor "MY_EDITOR" from table "00:01" with command "NEW" for record ""
	And I set field "such" to "MY_SUCH"
	When I save the current editor
	Then field "nummer" is not empty
	And field "such" has value "MY_SUCH"
	
@persistent
Scenario: My second test with a custom step
	Given I'm logged in as "sy"
	And I open an editor "MY_EDITOR" from table "04:05" with command "NEW" for record ""
	And I set field "such" to "MY_SUCH"
	When I save the current editor
	When I press button "([^"]*)"
	Then field "nummer" is not empty
	And field "such" has value "ALTERED"