package edu.fullerton.csu.jmtran.projectx.messaging.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TelegramService extends AbstractMessagingService {
    @JsonIgnore
    private String baseUrl;
    @JsonIgnore
    private String token;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private String urlTemplate = "{baseUrl}/bot{token}/sendMessage";

    @Override
    public boolean sendMessage(User recipient, Message message) {
        if (recipient.getAttribute(this.attributeKey) == null) {
            logger.info(
                    String.format(
                            "%s doesn't have %s ", recipient.getId(), this.getAttributeKey()));
            return true;
        }

        RestTemplate restTemplate = new RestTemplate();

        SendMessage sendMessageRequest = new SendMessage();
        sendMessageRequest.setChatId(recipient.getAttribute(this.attributeKey));

        sendMessageRequest.setText(message.getMessage());

        String requestUrl = urlTemplate.replace("{baseUrl}", this.getBaseUrl());
        requestUrl = requestUrl.replace("{token}", this.getToken());

        ObjectMapper mapper = new ObjectMapper();

        String requestJson;

        try {
            requestJson = mapper.writeValueAsString(sendMessageRequest);
        } catch (JsonProcessingException jpe) {
            logger.error(jpe.getMessage());

            return false;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response;
        try {
            response =
                    restTemplate.postForEntity(
                            requestUrl, new HttpEntity<>(requestJson, headers), String.class);

            logger.debug(response.getBody());
        } catch (org.springframework.web.client.ResourceAccessException rae) {
            return false;
        }

        JsonNode root;

        try {
            root = mapper.readTree(response.getBody());
        } catch (IOException e) {
            return response.getStatusCode().is2xxSuccessful();
        }

        return root.path("ok").asBoolean();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private class SendMessage {
        private String chatId;
        private String text;

        @JsonProperty("chat_id")
        public String getChatId() {
            return chatId;
        }

        public void setChatId(String chatId) {
            this.chatId = chatId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
