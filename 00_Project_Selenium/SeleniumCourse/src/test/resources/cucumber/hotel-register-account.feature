Feature: Register account

  Scenario: user can create new account

    Given użytkownik znajduje się na stronie głównej hotelu
    When użytkownik tworzy nowe konto z Jan Sobieski i hasłem 12345
    Then konto użytkownika zostało utworzone
