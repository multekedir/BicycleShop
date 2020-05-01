package com.revature.utility;

import org.junit.Test;

import static com.revature.utility.SQLBuilder.insertInto;
import static org.junit.Assert.assertEquals;

public class SQLBuilderTest {

    @Test
    public void testInsertInto() {
        String insert = insertInto("user", "username", "password");
        assertEquals("insert into user (username,password) values (?,?);", insert.toLowerCase());
    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testSelectWhere() {

    }
}