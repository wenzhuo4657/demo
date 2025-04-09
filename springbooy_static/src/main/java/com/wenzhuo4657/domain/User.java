package com.wenzhuo4657.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public Integer id;
    private String username;
    private String age;
    private String address;
}
