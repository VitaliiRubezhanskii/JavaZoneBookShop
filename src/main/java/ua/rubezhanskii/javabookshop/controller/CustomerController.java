package ua.rubezhanskii.javabookshop.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.rubezhanskii.javabookshop.datamanagement.service.CustomerService;
import ua.rubezhanskii.javabookshop.model.Customer;

@Controller
@RequestMapping("/welcome")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "AdminRegisterCust";
    }



    @RequestMapping(value = "/createCustomer",method = RequestMethod.POST)
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
