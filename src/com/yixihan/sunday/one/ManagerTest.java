package com.yixihan.sunday.one;

import org.junit.Test;
import static org.junit.Assert.*;

public class ManagerTest {
    @Test
    public void testManager01(){
        Manager manager1 = new Manager ("A", SalaryLevel.EXECUTIVE, 0.5);
        assertEquals(manager1.salary(), 6000, EmployeeTest.DELTA);
    }
}
