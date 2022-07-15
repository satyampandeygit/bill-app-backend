package com.fullstack.electricity.bill.Controller;

import com.fullstack.electricity.bill.Model.Bill;
import com.fullstack.electricity.bill.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/")
    public ResponseEntity<List<Bill>> getAllAvailableBills(){
        List<Bill> allBills = billService.getAllBills();
        return new ResponseEntity<>(allBills, HttpStatus.OK);
    }

    @GetMapping("/bill/{bill_id}")
    public ResponseEntity<Bill> getParticularBill(@PathVariable Long bill_id){
        try{

            Bill bill = billService.getBillById(bill_id);

            return new ResponseEntity<>(bill,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<List<Bill>> saveBill(@RequestBody Bill bill){
        try{
            Long id = billService.saveNewBill(
                    bill.getConsumer_name(),
                    bill.getConsumer_id(),
                    bill.getUnit_consumed(),
                    bill.getAmount(),
                    bill.getBill_date(),
                    bill.getPaid_date()
            );

            List<Bill> allBills = billService.getAllBills();

            return new ResponseEntity<>(allBills, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{bill_id}/edit")
    public ResponseEntity<Long> updateBill(@PathVariable Long bill_id,@RequestBody Bill toEditBill){
        try{
            System.out.println(toEditBill.toString());
            bill_id = billService.editBill(
                    bill_id,
                    toEditBill.getConsumer_name(),
                    toEditBill.getConsumer_id(),
                    toEditBill.getUnit_consumed(),
                    toEditBill.getAmount(),
                    toEditBill.getBill_date(),
                    toEditBill.getPaid_date()
            );

            return new ResponseEntity<>(bill_id, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{bill_id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long bill_id){
        try{
            billService.deleteBill(bill_id);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
