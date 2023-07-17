package com.oops.ratzlord.appointmentscheduler.dao;

import com.oops.ratzlord.appointmentscheduler.entity.ExchangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Integer> {
}
