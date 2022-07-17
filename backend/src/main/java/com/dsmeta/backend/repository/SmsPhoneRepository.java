package com.dsmeta.backend.repository;

import com.dsmeta.backend.model.SmsPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsPhoneRepository extends JpaRepository<SmsPhone,Long> {
}
