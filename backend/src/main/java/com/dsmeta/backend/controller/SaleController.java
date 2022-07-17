package com.dsmeta.backend.controller;

import com.dsmeta.backend.model.Sale;
import com.dsmeta.backend.model.SmsPhone;
import com.dsmeta.backend.service.SaleService;
import com.dsmeta.backend.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    private final SmsService smsPhone;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAll(@RequestParam(value = "minDate" ,defaultValue = "") String minDate,
                                              @RequestParam(value = "maxDate",defaultValue = "") String maxDate,
                                              Pageable pageable){
        return ResponseEntity.ok().body(saleService.findAll(minDate,maxDate,pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(saleService.findById(id));
    }

    @GetMapping("/sms/{id}")
    public ResponseEntity<Void> smsPhone(@PathVariable Long id){
        System.out.println(id);
        smsPhone.sendSms(id,"+5581xxxx-xxxx");
     return ResponseEntity.ok().build();
    }
}
