package db.javaschool.session_11.application.services;

import db.javaschool.session_11.application.controller.WebController;
import db.javaschool.session_11.application.entities.Customer;
import db.javaschool.session_11.application.entities.CustomerDTO;
import db.javaschool.session_11.application.entities.CustomerEntity;
import db.javaschool.session_11.application.entities.SearchObj;
import db.javaschool.session_11.application.repositories.CustomerJPARepository;
import db.javaschool.session_11.application.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    CustomerJPARepository customerJPARepository;

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customers = customerJPARepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (CustomerEntity customer : customers) {
            customerDTOS.add(new CustomerDTO(customer));
        }
        return customerDTOS;

    }

    public CustomerDTO getCustomerById(long id) {
        Optional<CustomerEntity> customerOp = customerJPARepository.findById(id);
        CustomerEntity result = customerOp.orElse(null);
        return new CustomerDTO(result);
    }

    public boolean deleteCustomerById(long id) {
        boolean result = true;
        try {

            customerJPARepository.deleteById(id);

        } catch (Exception e) {
            result = false;

        }
        return result;
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity(customerDTO);
        logger.info("Customer entity to be updated: {}", customerEntity);
        customerJPARepository.save(customerEntity);
    }

    public void addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity(customerDTO);
        customerJPARepository.save(customerEntity);
    }

    public List<CustomerEntity> searchCustomers(SearchObj searchObj) {
        return customerJPARepository
                .findByUsernameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCaseOrderByUsernameDesc
                        (searchObj.getQuery(), searchObj.getQuery(), searchObj.getQuery());
    }
}
