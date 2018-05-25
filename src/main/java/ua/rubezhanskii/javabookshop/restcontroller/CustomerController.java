package ua.rubezhanskii.javabookshop.restcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class CustomerController {


/*
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

*/


}
