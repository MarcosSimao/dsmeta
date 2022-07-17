package com.dsmeta.backend.service;

import com.dsmeta.backend.model.Sale;
import com.dsmeta.backend.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SaleService {
    private final SaleRepository saleRepository;
    
    public Page<Sale> findAll(String minDate,String maxDate,Pageable pageable){
        LocalDate date= LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min=minDate.equals("") ? date.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max= maxDate.equals("") ? date : LocalDate.parse(maxDate);

        return  saleRepository.findSales(min,max,pageable);
    }
    public Sale findById(Long id){
        Sale sale = saleRepository.findById(id).get();
        return sale;
    }
}
