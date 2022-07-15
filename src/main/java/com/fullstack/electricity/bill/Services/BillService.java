package com.fullstack.electricity.bill.Services;

import com.fullstack.electricity.bill.Model.Bill;

import java.util.Date;
import java.util.List;

public interface BillService {
    Long saveNewBill(String consumerName, String consumerId, Long unitConsumed, Long Amount, Date billDate,
                     Date paidDate);

    Long editBill(Long billId, String consumerName, String consumerId, Long unitConsumed, Long Amount,
                  Date billDate, Date paidDate);

    List<Bill> getAllBills();

    Bill getBillById(Long billId);

    Long deleteBill(Long billId);
}
