package com.oops.ratzlord.appointmentscheduler.service;

import com.oops.ratzlord.appointmentscheduler.entity.Appointment;

import java.time.LocalDateTime;
import java.util.Date;

public interface JwtTokenService {
    String generateAppointmentRejectionToken(Appointment appointment);

    String generateAcceptRejectionToken(Appointment appointment);

    boolean validateToken(String token);

    int getAppointmentIdFromToken(String token);

    int getCustomerIdFromToken(String token);

    int getProviderIdFromToken(String token);

    ////
    Date convertLocalDateTimeToDate(LocalDateTime localDateTime);
}
