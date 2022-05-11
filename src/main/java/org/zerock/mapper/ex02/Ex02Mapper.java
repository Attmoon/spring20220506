package org.zerock.mapper.ex02;

import org.apache.ibatis.annotations.Select;

public interface Ex02Mapper {
	
	@Select("SELECT CustomerName FROM Customers WHERE CustomerId = #{id}") // 파라미터값인 id넣어줌
	String selectNameById(int id);

	
}
