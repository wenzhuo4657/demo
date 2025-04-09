package com.wenzhuo4657.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class userlogin {
    public    Integer id;
   private String username;
   private String password;

}
