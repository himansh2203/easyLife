package com.example.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {
	private Integer id;
	private String name;
	private String email;
}
