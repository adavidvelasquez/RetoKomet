@Test
Feature: Quiero validar petsStore api
  Se quiere validar el metodo get y post de la api petstore

  @case1
  Scenario: obtener una mascota por su id
    Given quiero consultar la mascota con el id 2
    When valido el metodo get
    Then valido la respuesta en el body

  @case2
  Scenario: crear una nueva mascota
    Given tengo la data para crear la mascota
    When valido el metodo post
    Then valido la respuesta en el body post
