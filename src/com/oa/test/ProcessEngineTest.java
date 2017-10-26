package com.oa.test;

import org.jbpm.api.ProcessEngine;
import org.junit.Test;

/**
 * Created by Administrator on 2017-10-23.
 */
public class ProcessEngineTest extends BaseSpring{
    @Test
    public void testProcessEngine(){
        ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
    }
}
