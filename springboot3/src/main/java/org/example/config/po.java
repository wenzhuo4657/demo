package org.example.config;

import org.springframework.boot.availability.AvailabilityState;
import org.springframework.context.ApplicationEvent;

public class po extends ApplicationEvent  {

    private po(Object source) {
        super(source);
    }

    public static po build(Object source){
        po po = new po(source);
        return  po;
    }

}
