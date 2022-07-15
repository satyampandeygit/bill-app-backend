package com.fullstack.electricity.bill.Services;

import com.fullstack.electricity.bill.Exceptions.BillNotFoundException;
import com.fullstack.electricity.bill.Exceptions.InvalidBodyRequest;
import com.fullstack.electricity.bill.Model.Bill;
import com.fullstack.electricity.bill.Repositries.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BillServiceImpl implements BillService{

    @Autowired
    private BillRepository billRepository;

    @Override
    public Long saveNewBill(String consumerName, String consumerId, Long unitConsumed, Long Amount, Date billDate, Date paidDate) {
        try {
            Bill newBill = new Bill();

            newBill.setConsumer_name(consumerName);
            newBill.setConsumer_id(consumerId);
            newBill.setUnit_consumed(unitConsumed);
            newBill.setAmount(Amount);
            newBill.setBill_date(billDate);
            newBill.setPaid_date(paidDate);

            newBill.setPaid(paidDate != null);
            System.out.println(newBill.toString());
            return billRepository.save(newBill).getBill_id();
        }catch(Exception e){
            System.out.println("Save New Bill Exception: " + e);
            throw new InvalidBodyRequest("Invalid Body to save data");
        }
    }

    @Override
    public Long editBill(Long billId, String consumerName, String consumerId, Long unitConsumed, Long Amount, Date billDate, Date paidDate) {
        try{
            Bill bill = billRepository.findById(billId).get();

            bill.setConsumer_name(consumerName);
            bill.setConsumer_id(consumerId);
            bill.setUnit_consumed(unitConsumed);
            bill.setAmount(Amount);
            bill.setBill_date(billDate);
            bill.setPaid_date(paidDate);

            return billId;
        }catch(Exception e){
            System.out.println("Edit bill exception: " + e);
            throw new BillNotFoundException("Bill Not found with given ID");
        }
    }

    @Override
    public List<Bill> getAllBills() {
        try{
            return billRepository.findAll();
        }catch(Exception E){
            System.out.println("Get All Bill Exception: " + E);
            return new ArrayList<>();
        }
    }

    @Override
    public Bill getBillById(Long billId) {
        try{
            return billRepository.findById(billId).get();
        }catch(Exception e){
            System.out.println("Get Bill by Id Exception: " + e);
            throw new BillNotFoundException("Bill Not found with given ID");
        }
    }

    @Override
    public Long deleteBill(Long billId) {
        try{
            billRepository.deleteById(billId);
            return billId;
        }catch(Exception e){
            System.out.println("Delete Bill Exception: " + e);
            throw new BillNotFoundException("Bill Not found with given ID");
        }
    }
}
