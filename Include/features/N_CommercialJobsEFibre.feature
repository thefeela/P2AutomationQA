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
@Commercial_job_Creation
Feature: Commercial_job_Creation Flow
  I want to use this template for my feature file

  @Commercial_job_Creation
  Scenario Outline:: Commercial job Creation
     Given navigate to Request and Jobs page_CommercialJob
    # When I click on New Job Creation_CommercialJob
     #Then Job creation with <JobCategory> category , <JobType> jobtype and <Subtype> subtype
    # Then I Select the Address_CommercialJob
    # And I Provide Input for CommercialJob
    # Then Click Next after Job Details Entered_CommercialJob
     #Then Verify QuickACtionButtonsJobLevel
    # Then Verify NoOFTasksJobLevel                        
          Then Verify JobTaskSurvey&QuickButton
          Then Verify SurveyType
Examples: 
  |JobCategory|JobType             |Subtype        |
  |Commercial |MetroERetail        |Fiber          |
  