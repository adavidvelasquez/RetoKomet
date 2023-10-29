@Test
Feature: Reserva para un Viaje Espacial
  Se quiere realizar una reserva para un viaje espacial y realizar el checkout

  @case1
  Scenario: Reservar destino y realizar checkout
    Given ingrese con usuario "usuario" y contraseña "constraseña"
    When ingreso la informacion necesaria del destino
    Then  procedo con el checkout
