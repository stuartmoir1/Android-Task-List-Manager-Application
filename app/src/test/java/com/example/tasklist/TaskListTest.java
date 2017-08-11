package com.example.tasklist;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by stuartmoir on 11/08/2017.
 */

public class TaskListTest {

    @Test
    public void getTaskListTest() {
        TaskList taskList = new TaskList();
        assertEquals(5, taskList.getList().size());
    }
}