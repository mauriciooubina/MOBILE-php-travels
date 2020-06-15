Feature: As a potential client i need to book a flight in the PHPTravel webpage

  @Demo
  Scenario: As a user I want to navigate PHPTravel and complete a booking process for a round trip
    Given The app is loaded correctly
    When the client searchs for a flight in economy from buenos aires to madrid for the date 15-12-2020 and 20-12-2020
    And its for 2 adult 1 child 1 infant
    And clicks the 1 result writing email mauriciooubina@gmail.com password estoesunapruebA123
    And completes with name Jorge Surname Lopez email jorgelopez@hotmail.com phone 1023456789 birthday 1995-3-2 passport 54342 expiration 2023-5-2 nationality Argentina
    And pays with Visa number 4263982640269298 expiration month 3 year 2022 cvv 837
    Then A reservation number is not provide
