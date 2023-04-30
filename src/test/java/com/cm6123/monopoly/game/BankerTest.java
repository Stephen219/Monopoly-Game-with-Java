package com.cm6123.monopoly.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BankerTest {
    // bank variable to be used in the tests
    Banker banker = new Banker();

    @Test
    void testInitialMoney() {
        // test if the initial money is 100000
        assertEquals(100000, banker.getMoney());
        assertFalse(banker.getMoney() == 100001);
    }
    @Test
    void testSetAmount() {
        // test if the set amount method works
        // gien the banker is given 100
        banker.setAmount(100);
        // the money should be 100100
        assertEquals(100100, banker.getMoney());
        // given the banker is given another 100
        banker.setAmount(100);
        // the money should be 100200
        assertEquals(100200, banker.getMoney());
        // given the banker pays -1000
        banker.setAmount(-1000);
        // the money should be 99200
        assertTrue(banker.getMoney() == 99200);
    }
}
