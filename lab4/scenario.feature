Feature: Web pages test

  Scenario: Test bedroom
    Given Open home page
    When Choose bedroom
    Then Verify bedroom results

   Scenario: Test news
    Given Open home page
    When Choose news
    Then Verify news results

  Scenario: Test double bed
    Given Open bed page
    When Choose double bed
    Then Verify double bed results

  Scenario: Test сhildren bed
    Given Open bed page
    When Choose children bed
    Then Verify children bed results

  Scenario: Test dekor
    Given Open catalog 
    When Choose dekor
    Then Verify dekor results

  Scenario: Test food
    Given Open catalog
    When Choose food
    Then Verify food results
