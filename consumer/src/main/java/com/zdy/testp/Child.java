package com.zdy.testp;

import org.springframework.beans.FatalBeanException;

/**
 * @author zdy
 */
public class Child  {
    private String age;

    private Father father;

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "age='" + age + '\'' +
                ", father=" + father +
                '}';
    }
}
