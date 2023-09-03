package com.acme.acmeApiRest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
public class PedidoController {

    @PostMapping(value = "/enviarPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> enviarPedido(@RequestBody PedidoRequest pedidoRequest) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            String xmlPedido = objectMapper.writeValueAsString(pedidoRequest);
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            HttpEntity<String> requestEntity = new HttpEntity<>(xmlPedido, headers);

            String url = "https://run.mocky.io/v3/19217075-6d4e-4818-98bc-416d1feb7b84";
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String responseXML = responseEntity.getBody();

                // Convertir la respuesta XML a JSON
                JsonNode jsonResponse = xmlMapper.readTree(responseXML);
                String jsonResponseString = objectMapper.writeValueAsString(jsonResponse);

                return ResponseEntity.ok(jsonResponseString);
            } else {
                return ResponseEntity.status(responseEntity.getStatusCode()).body("Error en la solicitud SOAP");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la conversión o en la solicitud");
        }
    }
}
