package com.cm6123.monopoly.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player player =new Player("John",1);
        assertEquals("John", player.getName());
    }
}