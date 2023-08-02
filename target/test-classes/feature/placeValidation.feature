Feature: Validate google place 
@test 
Scenario: Validate success new adress on server 
	Given create payload with request 
	When user send "addPlaceAPI" request with "delete" method 
	Then validate status code is 200 
	And "status" value in body is "OK" 
	And "scope" value in body is "APP"
