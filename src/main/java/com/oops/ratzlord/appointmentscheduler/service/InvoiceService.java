package com.oops.ratzlord.appointmentscheduler.service;

import com.oops.ratzlord.appointmentscheduler.entity.Invoice;
import com.oops.ratzlord.appointmentscheduler.security.CustomUserDetails;

import java.io.File;
import java.util.List;

public interface InvoiceService {
    void createNewInvoice(Invoice invoice);

    Invoice getInvoiceByAppointmentId(int appointmentId);

    Invoice getInvoiceById(int invoiceId);

    List<Invoice> getAllInvoices();

    void changeInvoiceStatusToPaid(int invoiceId);

    void issueInvoicesForConfirmedAppointments();

    String generateInvoiceNumber();

    File generatePdfForInvoice(int invoiceId);

    boolean isUserAllowedToDownloadInvoice(CustomUserDetails user, Invoice invoice);
}

