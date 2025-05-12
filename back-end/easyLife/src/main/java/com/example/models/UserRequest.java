package com.example.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
	private Integer id;
	private String name;
	private String email;
}
