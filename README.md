# acme-Api-Rest
 ApiRest con springboot y java
la api corre en el puerto 8081 con esta url http://localhost:8081/enviarPedido
url de documentacion de la api http://localhost:8081/swagger-ui/index.html#/pedido-controller/enviarPedido
url repositorio https://github.com/Orlando1913/acme-Api-Rest.git

para probar la api se puede hacer de esta manera

en postman con el metodo POST y la url http://localhost:8081/enviarPedido

y se envia este cuerpo
{
"numPedido": "75630275",
"cantidadPedido": "1",
"codigoEAN": "00110000765191002104587",
"nombreProducto": "Armario INVAL",
"numDocumento": "1113987400",
"direccion": "CR 72B 45 12 APT 301"
}

con esto se podra hacer la prueba