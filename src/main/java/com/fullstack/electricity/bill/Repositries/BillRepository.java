package com.fullstack.electricity.bill.Repositries;

import com.fullstack.electricity.bill.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
