Feature: Register account

  Scenario: user can create new account

    Given użytkownik znajduje się na stronie głównej hotelu
    When użytkownik tworzy nowe konto z Jan Sobieski i hasłem 12345
    Then konto użytkownika zostało utworzone


    Scenario Outline:
      Given użytkownik znajduje się na stronie głównej hotelu
      When użytkownik tworzy nowe konto z <name> <surname> i hasłem <password>
      Then konto użytkownika zostało utworzone

      Examples:

      | name | surname | password |
      | Jan | Sobieski | 12345 |
      | Jan | Kowalski | 56789 |
      | Jacek | Placek | 123789 |
      | Lucek | Jakis | asdfghj |