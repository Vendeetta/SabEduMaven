package edu.javacourse.studentorder.dao;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleRunner {

    public static void main(String[] args) {
        SimpleRunner sr = new SimpleRunner();
        
        sr.runTests();
    }

    private void runTests() {
        try {
            Class aClass = Class.forName("edu.javacourse.studentorder.dao.DictionaryDaoImplTest");
            Constructor constructor = aClass.getConstructor();
            Object entity = constructor.newInstance();

            Method[] methods = aClass.getMethods();
            for (Method m : methods){
                if (m.getAnnotation(Test.class) != null) {
                    m.invoke(entity);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
