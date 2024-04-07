Feature: Products filter

  Scenario:
    Given niezarejestrowany użytkownik znajduje się na stronie głównej sklepu
    When niezarejestrowany użytkownik filtruje produkty w kategorii ubrania
    Then wyświetliły się filtrowane produkty
