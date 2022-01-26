Feature: Validation for Wiki Search Page

Scenario: Search on wiki Search Page with default  settings
	Given User navigates to "WikiSearchPage"
	When User enters text "Gmail" in "SearchTextBox"
	And Clicks on "SearchButton"
	Then Extract title of "FirstSearchResult" and check if it contains "Gmail"
	And Take the screenshot of search result
	
Scenario: Select the checkbox and validate correct namespace selected
	Given User navigates to "WikiSearchPage"
	When Clicks on "SearchIn"
	And Clicks on "GeneralHelp"
	Then Extract number of namespace added should be 3
	
Scenario: Provide garbage value and see the search result
	Given User navigates to "WikiSearchPage"
	When User enters text "!#$%^^&()__)&^%$#" in "SearchTextBox"
	And Clicks on "SearchButton"
	Then Validate text displayed is "There were no results matching the query." at location "NoSearchResult"