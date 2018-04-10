package edu.fullerton.csu.jmtran.projectx.messaging.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class TelegramService extends AbstractMessagingService {
    private String baseUrl;
    private String token;

    private String urlTemplate = "{baseUrl}/bot{token}/sendMessage";

    @Override
    public boolean sendMessage(User recipient, Message message) {
        RestTemplate restTemplate = new RestTemplate();

        SendMessage sendMessageRequest = new SendMessage();
        sendMessageRequest.setChatId((String)recipient.getAttributes().get(this.getAttributeKey()));
        sendMessageRequest.setText(message.getMessage());

        String requestUrl = urlTemplate.replace("{baseUrl}", this.getBaseUrl());
        requestUrl = requestUrl.replace("{token}", this.getToken());

        ObjectMapper mapper = new ObjectMapper();

        String requestJson;

        try {
            requestJson = mapper.writeValueAsString(sendMessageRequest);
        }
        catch(JsonProcessingException jpe) {
            return false;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response;
        try {
            response = restTemplate.postForEntity(requestUrl, new HttpEntity<>(requestJson, headers), String.class);
        }
        catch(org.springframework.web.client.ResourceAccessException rae) {
            return false;
        }

        JsonNode root;

        try {
            root = mapper.readTree(response.getBody());
        }
        catch(IOException e) {
            return response.getStatusCode().is2xxSuccessful();
        }

        return root.path("ok").equals("true");
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