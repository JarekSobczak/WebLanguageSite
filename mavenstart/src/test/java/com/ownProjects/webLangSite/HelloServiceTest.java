package com.ownProjects.webLangSite;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    private HelloService sysUndTEST=new HelloService();

    @Test
    public void test_null_prepareGreetings_returns_Default_Name() throws Exception {
        //given and when
        var result=sysUndTEST.prepareGreetings(null);
        //then
        assertEquals("Hello "+HelloService.DEFAULT_NAME+" !",result);
    }
    @Test
    public void test_name_prepareGreetings_returns_Name() throws Exception {
        //given
        String name="test";
        //when
        var result=sysUndTEST.prepareGreetings(name);
        //then
        assertEquals("Hello "+name+" !",result);
    }
}
