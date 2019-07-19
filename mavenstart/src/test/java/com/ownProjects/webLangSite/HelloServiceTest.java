package com.ownProjects.webLangSite;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {

private final static String WELCOME="Hello";
    @Test
    public void test_nullName_prepareGreetings_returns_Default_Name() throws Exception {
        //given
        var mockRepository=new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.of(new Lang(null,WELCOME,null));
            }
        };
        var sysUndTEST=new HelloService(mockRepository);
        // when
        var result=sysUndTEST.prepareGreetings(null,"-1");
        //then
        assertEquals(WELCOME+" "+HelloService.DEFAULT_NAME+" !",result);
    }
    @Test
    public void test_name_prepareGreetings_returns_Name() throws Exception {
        //given
        var mockRepository=new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.of(new Lang(null,WELCOME,null));
            }
        };
        var sysUndTEST=new HelloService(mockRepository);
        String name="test";
        //when
        var result=sysUndTEST.prepareGreetings(name,"-1");
        //then
        assertEquals(WELCOME+" "+name+" !",result);
    }
    @Test
    public void test_nullLang_prepareGreetings_returns_DefaultLangId() throws Exception {
        //given
        var defaultIdWelcome="Ciao";
        var mockRepository=new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                if (id.equals(HelloService.DEFAULT_LANG.getId())){
                    return Optional.of(new Lang(null,defaultIdWelcome,null));
                }
                return Optional.empty();
            }
        };
        var sysUndTEST=new HelloService(mockRepository);
        String name="test";
        //when
        var result=sysUndTEST.prepareGreetings(null,null);
        //then
        assertEquals(defaultIdWelcome+" "+HelloService.DEFAULT_NAME+" !",result);
    }
    @Test
    public void test_nonExistingLang_prepareGreetings_returns_DefaultLangId() throws Exception {
        //given
        var defaultIdWelcome="Ciao";
        var mockRepository=new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                if (id.equals(HelloService.DEFAULT_LANG.getId())){
                    return Optional.empty();
                }
                return Optional.empty();
            }
        };
        var sysUndTEST=new HelloService(mockRepository);
        String name="test";
        //when
        var result=sysUndTEST.prepareGreetings(null,"-1");
        //then
        assertEquals(HelloService.DEFAULT_LANG.getMessage()+" "+HelloService.DEFAULT_NAME+" !",result);
    }
    @Test
    public void test_textLang_prepareGreetings_returns_DefaultLangId() throws Exception {
        //given
        var defaultIdWelcome="Ciao";
        var mockRepository=new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                if (id.equals(HelloService.DEFAULT_LANG.getId())){
                    return Optional.of(new Lang(null,defaultIdWelcome,null));
                }
                return Optional.empty();
            }
        };
        var sysUndTEST=new HelloService(mockRepository);
        String name="test";
        //when
        var result=sysUndTEST.prepareGreetings(null,"abc");
        //then
        assertEquals(defaultIdWelcome+" "+HelloService.DEFAULT_NAME+" !",result);
    }
}
