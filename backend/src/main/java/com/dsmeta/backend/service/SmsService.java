package com.dsmeta.backend.service;

import com.dsmeta.backend.model.Sale;
import com.dsmeta.backend.model.SmsPhone;
import com.dsmeta.backend.repository.SmsPhoneRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmsService {
  private final static Long id =1L;
  private final SmsPhoneRepository smsPhoneRepository;
  private final SaleService saleService;


    public void sendSms(Long id,String phone) {
        Sale sale=saleService.findById(id);
        SmsPhone smsPhone=smsPhoneRepository.findById(SmsService.id).get();
        Twilio.init(smsPhone.getSmsId(), smsPhone.getSmsKey());

        PhoneNumber to = new PhoneNumber(phone);
        PhoneNumber from = new PhoneNumber(smsPhone.getPhoneFrom());
        String msg= "Ola , senhor "+sale.getSellerName()+" o seu valor é "+sale.getAmount();
        Message message = Message.creator(to, from, msg).create();

        System.out.println(message.getSid());
    }
}
