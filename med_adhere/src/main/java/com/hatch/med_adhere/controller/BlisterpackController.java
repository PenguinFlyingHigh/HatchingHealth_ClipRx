package com.hatch.med_adhere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatch.med_adhere.Payload.PopRequest;
import com.hatch.med_adhere.model.BlisterPop;
import com.hatch.med_adhere.repository.BlisterpackRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@RestController
@RequestMapping("/blisterpack")
public class BlisterpackController
{
    @Autowired
    private BlisterpackRepository blisterpackRepository;

    public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXX";
    public static final String AUTH_TOKEN = "<auth token>";

    @GetMapping("/pop/{id}")
    public ResponseEntity<?> getBlisterpack(
            @PathVariable Integer id) {
        BlisterPop blisterPop = blisterpackRepository.findByBlisterpackId(id);
        return ResponseEntity.ok(blisterPop);
    }

    @PutMapping("/pop")
    public ResponseEntity<?> postBlisterpack(
            @RequestBody PopRequest popRequest) {

        BlisterPop blisterPop = new BlisterPop(popRequest.getTimeReceived(), popRequest.getRow(), popRequest.getColumn());
        BlisterPop result = this.blisterpackRepository.save(blisterPop);

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+<to phone number>"),
                new com.twilio.type.PhoneNumber("+<from phone number (by twilio)>"),
                String.format("Pill with row %s and column %s was popped at %s",
                        popRequest.getRow(), popRequest.getColumn(), popRequest.getTimeReceived()))
                .create();

        return ResponseEntity.ok(result);
    }
}
