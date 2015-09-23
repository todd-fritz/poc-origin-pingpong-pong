package org.bk.producer.controller;


import org.bk.producer.domain.Message;
import org.bk.producer.domain.MessageAcknowledgement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class PongController {

    @Value("${reply.message}")
    private String message;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Resource<MessageAcknowledgement> pongMessage(@RequestBody Message input) {
        return new Resource<>(
                new MessageAcknowledgement(input.getId(), input.getPayload(), buildMessage(input)));
    }

    private String buildMessage(Message msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("This is the response to: ");
        sb.append(message);

        InetAddress ip;
        String host;
        try {
            //TODO This may not report ip from correct nic/network/vip
            ip = InetAddress.getLocalHost();
            host = ip.getHostName();
            sb.append(", IP address : " + ip);
            sb.append(", hostname : " + host);

        } catch (UnknownHostException e) {
            sb.append(", error: " + e.getLocalizedMessage());
        }

        return sb.toString();
    }

}
