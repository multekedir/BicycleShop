package com.revature.utility;

import org.junit.Test;

import static com.revature.utility.SQLBuilder.*;
import static org.junit.Assert.assertEquals;

public class SQLBuilderTest {

    @Test
    public void testInsertInto() {
        String insert = insertInto("users", "username", "password");
        assertEquals("insert into user (username,password) values (?,?)", insert.toLowerCase());
    }

    @Test
    public void testUpdate() {
        String update = updateSQL("users", "username", "username", "password");
        assertEquals("update users set username=?,password=? where username=?", update.toLowerCase());

    }

    @Test
    public void testSelectWhere() {
        String select = selectWhere("users", "&", "username", "password");
        assertEquals("select  * from users where username = ? & password = ?  ", select.toLowerCase());
    }

    @Test
    public void testSelectAll() {
        String select = selectAll("users");
        assertEquals("select  * from users", select.toLowerCase());
    }
}