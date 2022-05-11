package org.zerock.domain.ex01;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeDto {
	private String firstName;
	private String lastName;
	@DateTimeFormat
	private String birthDate;
	private String photo;
	private String notes;
}
