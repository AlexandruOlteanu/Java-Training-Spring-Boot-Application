package db.javaschool.session_11.application.controller;

import db.javaschool.session_11.application.entities.CustomerDTO;
import db.javaschool.session_11.application.entities.CustomerEntity;
import db.javaschool.session_11.application.entities.SearchObj;
import db.javaschool.session_11.application.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;
import java.util.UUID;


@Controller
@RequestMapping(value = "/web")
public class WebController {
    Logger logger = LoggerFactory.getLogger(WebController.class);

    private CustomerService customerService;

    @Autowired
    public WebController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/")
    public String index() {
        logger.info("This is index request");
        return "index";
    }

    @RequestMapping(value = "/customers")
    public ModelAndView customers() {
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        logger.warn("Customer list: {}", customerDTOList);

        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("message", "Customers Management Page");
        modelAndView.addObject("customers", customerDTOList);
        modelAndView.addObject("searchObj", SearchObj.builder().build());
        return modelAndView;
    }

    @RequestMapping(value = "/customers/edit/{id}")
    public ModelAndView customerEdit(@PathVariable(value = "id") long id) {
        CustomerDTO customer= customerService.getCustomerById(id);
        logger.warn("Customer: {}", customer);

        ModelAndView modelAndView = new ModelAndView("customer-edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @RequestMapping(value = "/customers/edit", method = RequestMethod.POST)
    public String customerEdit(@ModelAttribute("customer") CustomerDTO customerDTO) {

        logger.info("Customer to be updated : {}", customerDTO);
        customerService.updateCustomer(customerDTO);
        return "redirect:/web/customers";
    }
    @RequestMapping(value = "/customers/delete/{id}")
    public String customerDelete(@PathVariable(value = "id") long id) {
       // CustomerDTO customer= customerService.getCustomerById(id);
        boolean status = customerService.deleteCustomerById(id);
        ModelAndView modelAndView = new ModelAndView("customer-delete");
        modelAndView.addObject("status", status);
        logger.error("Delete status: {}", status);
        return "redirect:/web/customers/";
    }

    @RequestMapping(value = "/customers/add/")
    public ModelAndView addCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
//        Random random = new Random();
//        customerDTO.setId(random.nextLong(10,50));
        ModelAndView modelAndView = new ModelAndView("customer-add");
        modelAndView.addObject("customer", customerDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/customers/add/customer", method = RequestMethod.POST)
    public String addNewCustomer(@ModelAttribute("customer") CustomerDTO customerDTO) {
       logger.warn("customer to add: {}", customerDTO);
       customerService.addCustomer(customerDTO);
        return "redirect:/web/customers/";
    }

    @RequestMapping(value = "/customers/search", method = RequestMethod.POST)
    public ModelAndView searchCustomer(@ModelAttribute("searchObj")SearchObj searchObj) {
        logger.warn("customer to search: {}", searchObj);
        List<CustomerEntity> foundCustomers = customerService.searchCustomers(searchObj);
        logger.info("When searching for {} the result was: {}", searchObj.getQuery(), foundCustomers);
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("message", "Search Results:");
        modelAndView.addObject("customers", foundCustomers);
        modelAndView.addObject("searchObj", SearchObj.builder().build());


        return modelAndView;
    }


}
