Feature: Test my website
#
#  Scenario: Open my website and verify functionality
#    Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
#    When I select the state Washington
#    And I click the Search button
#    Then I verify "8" results
#
#   Scenario: Open my website and verify functionality
#     Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
#     Then I search for "Design-Bid-Build,Precast Approach Slab"
#     And I click the Search button
#     Then I verify "15" results

#  Scenario: Open my website and verify functionality
#    Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
#    Then I select Beam Material "Steel"
#    Then I select Spans "> Three-span"
#    Then I search for "Full-Depth Precast Deck Panel w/o PT"
#    And I click the Search button
#    Then I verify "15" results

#  Scenario: Open my website and verify functionality
#    Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
#    Then I select the Construction Equipment Category "Lateral Slide"
#    Then I select the Construction Equipment Category "Longitudinal Launch"
#    Then I select the location "Urban"
#    Then I select the Traffic Impact Category "Tier 1 (within 1 day)"
#    Then I select the Traffic Impact Category "Tier 2 (within 3 days)"
#    Then I search for " incentive / disincentive clause"
#    And I click the Search button
#    Then I verify "13" results
#
  Scenario: Open my website and verify functionality
    Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
    Then I select the location "Urban"
    Then I select the state "Utah"
    Then I select the state "Massachusetts"
    Then I select the Construction Equipment Category "SPMTs"
    Then I select the total bridge length range "150" to "500"
    Then I search for "Improved work-zone safety, CIP substructure under traffic , FDcBs"
    Then I select the max span length range "100" to "200"
    And I click the Search button
    Then I verify "1" results

  Scenario: Open my website and verify functionality
    Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
    Then I select Funding Source "Federal Only"
    Then I select Funding Source "Local"
    Then I select the Average Daily Traffic Range "500" to "2000"
    Then I select the Year built range "2015" to "2024"
    Then I search for "AID Demo"
    And I click the Search button
    Then I verify "1" results

  Scenario: Open my website and verify functionality
    Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
    Then I search for "Longitudinal Launch"
    And I click the Search button
    Then I verify "1" results

  Scenario: Open my website and verify functionality
    Given I open the browser and navigate to "https://eicdev.fiu.edu/utcdbresearch/search"
    Then I search for "CIP substructure under traffic"
    And I click the Search button
    Then I verify "18" results




