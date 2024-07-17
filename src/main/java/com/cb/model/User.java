package com.cb.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private String firstName;
    private String lastName;
}