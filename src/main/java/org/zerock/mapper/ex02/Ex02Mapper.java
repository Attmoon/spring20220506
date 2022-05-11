package org.zerock.mapper.ex02;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ex01.CustomerDto;

public interface Ex02Mapper {
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = #{id}") // 파라미터값인 id넣어줌
	String selectNameById(int id);
	
	@Select("SELECT CustomerName, Address FROM Customers WHERE CustomerId = #{id}")
	CustomerDto selectCustomerById(int id);

	
}
