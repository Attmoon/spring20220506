package org.zerock.mapper.ex02;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;

public interface Ex02Mapper {
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = #{id}") // 파라미터값인 id넣어줌
	String selectNameById(int id);
	
	@Select("SELECT CustomerName Name, Address, City, Country FROM Customers WHERE CustomerId = #{id}")
	CustomerDto selectCustomerById(int id);
	// 테이블의 컬럼명과 javabeans의 필드명이 같지않을수 있는데
	// 이때 테이블의 컬럼명에 별칭을줘서 javabeans의 필드명과 일치시켜주면됨

	@Select("SELECT FirstName, LastName, BirthDate FROM Employees WHERE EmployeeId = #{id}")
	EmployeeDto selectEmployeeById(int id);
	
	@Insert("INSERT INTO Customers"
			+ " (CustomerName, ContactName, City, Country, Address, PostalCode) "
			+ "VALUES (#{customerName}, #{contactName}, #{city}, #{country}, #{address}, #{postalCode})")
				// java beans의 프로퍼티명
	int insertCustomer(CustomerDto customer);
	
	@Insert("INSERT INTO Employees"
			+ " (LastName, FirstName, BirthDate, Photo, Notes) "
			+ "VALUES (#{lastName}, #{firstName}, #{birthDate}, #{photo}, #{notes})")
	int insertEmployee(EmployeeDto employee);
	
	@Select("SELECT EmployeeID id, FirstName, LastName, Photo, Notes, BirthDate "
			+ "FROM Employees ORDER BY EmployeeID ")
	List<EmployeeDto> listEmployee();
	
	@Select("SELECT CustomerID cid, CustomerName, ContactName, Address, City, PostalCode, Country "
			+ "FROM Customers ORDER BY CustomerID ")
	List<CustomerDto> listCustomer();
	
	@Select("SELECT CustomerID cid, "
			+ "CustomerName, "
			+ "ContactName, "
			+ "Address, "
			+ "City, "
			+ "PostalCode, "
			+ "Country "
			+ "FROM Customers "
			+ "LIMIT #{from}, #{row} ")
	List<CustomerDto> listCustomerPage(@Param("from") int from,@Param("row") int row); 
	// 2개이상 파라미터가 있을때는 컴파일할때 잃어버리는 이름을 유지할수있도록 param어노테이션 붙여야함
	
	@Select("SELECT Count(CustomerID) FROM Customers ")
	int countCustomers();
}
