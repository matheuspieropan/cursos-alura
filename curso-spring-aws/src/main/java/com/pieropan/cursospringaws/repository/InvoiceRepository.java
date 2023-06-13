package com.pieropan.cursospringaws.repository;


import com.pieropan.cursospringaws.model.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    Optional<Invoice> findByInvoiceNumber(String invoiceNumber);

    List<Invoice> findAllByCustomerName(String customerName);
}