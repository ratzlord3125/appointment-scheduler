package com.oops.ratzlord.appointmentscheduler.service;

public interface ScheduledTasksService {
    void updateAllAppointmentsStatuses();

    void issueInvoicesForCurrentMonth();
}
