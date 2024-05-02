package com.in28minutes.learnspringaop.aop.business;

import com.in28minutes.learnspringaop.aop.annotations.TrackTime;
import com.in28minutes.learnspringaop.aop.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax(){
        int[] array = dataService1.retrieveData();
        return Arrays.stream(array).max().orElse(0);
    }
}
