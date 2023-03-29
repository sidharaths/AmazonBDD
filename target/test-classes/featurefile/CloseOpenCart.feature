#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Open and Close Feature Feautre of cart

  @tag1
  Scenario: Open and close Cart Feature
    Given USer Must Be Signed in
    And Cart Must have one Product
   
    When close the Browser
    And Reopen Website "https://www.amazon.ca/gp/cart/view.html?ref_=sw_gtc"
    
    Then Product should be at cart
 
  