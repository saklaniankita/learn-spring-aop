package com.in28minutes.learnspringaop.aop.data;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        return new int[]{11, 22, 33, 44, 55};
    }
}
