package ua.rubezhanskii.javabookshop.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.rubezhanskii.javabookshop.datamanagement.service.CustomerService;
import ua.rubezhanskii.javabookshop.model.Customer;

@Controller
@RequestMapping("/welcome")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public String getIndexPage() {
        return "BookPage";
    }


    @PostMapping(value = "/createCustomer")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        customerService.saveOrUpdate(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);

    }

    @RequestMapping(value = "/delete",method = RequestMethod.PUT)
    public ResponseEntity<Customer> delete(@RequestBody Customer customer){

        customerService.delete(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);


    }
}
