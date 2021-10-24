Feature: Contact
  yo como usuario
  quiero registrar mis datos personales
  Para que se comuniquen conmigo posteriormente

  Scenario: Control de envio de informacion
    Given que estoy en la página de contacto
    When completo el campo de nombre con "Harold" Y lleno el campo de correo electrónico con "hartor14@gmail.com"
    And completo el campo organizacion con "Bits Americas"
    And acepto los terminos y condiciones
    And verifico que no soy un robot
    And doy clic en el boton Enviar
    Then recibo un mensaje de confirmacion con el texto "Formulario de contacto enviado exitosamente. Nos podremos en contacto con usted!"