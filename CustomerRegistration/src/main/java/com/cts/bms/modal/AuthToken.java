package com.cts.bms.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthToken {

    private String token;
    private String username;
    private String id;

}