Feature: Contact
  yo como usuario
  quiero registrar mis datos personales
  Para que se comuniquen conmigo posteriormente

  #Scenario Outline: Control de envio de informacion
  Scenario: Control de envio de informacion
    Given que estoy en la página de contacto
    When completo el campo de nombre con "Test1" Y lleno el campo de correo electrónico con "test-cucumber-selenium@mailinator.com"
    And completo el campo telefono con "123456" y lleno el campo organizacion con "Test1"
    And acepto los terminos y condiciones
    And verifico que no soy un robot
    And doy clic en el boton Enviar
    Then recibo un mensaje de confirmacion con el texto "Formulario de contacto enviado exitosamente. Nos podremos en contacto con usted!"

    #Examples:
     # |name|email|phone|organization|success_message|
     # |Test1|test-cucumber-selenium@mailinator.com|1234567|Test1|Formulario de contacto enviado exitosamente. Nos podremos en contacto con usted!|

