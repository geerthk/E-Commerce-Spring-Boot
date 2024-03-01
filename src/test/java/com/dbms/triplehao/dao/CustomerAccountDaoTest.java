package com.dbms.triplehao.dao;

import com.dbms.triplehao.entity.CustomerAccount;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAccountDaoTest {
    @Autowired
    private CustomerAccountDao customerAccountDao;

    @Test
    @Ignore
    public void insertCustomerAccount()
    {
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setUsername("Nate.LZH@hotmail.com");
        customerAccount.setPassword("123456");
        int effectedNum = customerAccountDao.insertCustomerAccount(customerAccount);
        assertEquals(1,effectedNum);
    }
    @Test
    //@Ignore
    public void queryCountCustomer() {
        int result = customerAccountDao.queryCountCustomer();
        assertEquals(1,result);
    }

    @Test
    public void searchCustomerAccount() {
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setUsername("test.user@example.com");
        customerAccount.setPassword("testpassword");
        customerAccountDao.insertCustomerAccount(customerAccount);

        List<CustomerAccount> searchResult = customerAccountDao.searchCustomerAccount("test.user@example.com");

        assertEquals(1, searchResult.size());
        assertEquals("test.user@example.com", searchResult.get(0).getUsername());

        customerAccountDao.deleteCustomerAccountByUsername("test.user@example.com");
    }

    @Test
    public void queryCountCustomerWithMultipleAccounts() {

        CustomerAccount account1 = new CustomerAccount();
        account1.setUsername("user1@example.com");
        account1.setPassword("password1");
        customerAccountDao.insertCustomerAccount(account1);

        CustomerAccount account2 = new CustomerAccount();
        account2.setUsername("user2@example.com");
        account2.setPassword("password2");
        customerAccountDao.insertCustomerAccount(account2);

        int result = customerAccountDao.queryCountCustomer();

        assertEquals(2, result);

        customerAccountDao.deleteCustomerAccountByUsername("user1@example.com");
        customerAccountDao.deleteCustomerAccountByUsername("user2@example.com");
    }

}
