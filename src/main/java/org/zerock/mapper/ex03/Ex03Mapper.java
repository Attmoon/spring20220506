package org.zerock.mapper.ex03;

import org.apache.ibatis.annotations.Select;

public interface Ex03Mapper {

	@Select("SELECT FirstName FROM Employees WHERE EmployeeID = #{id}") // 파라미터값인 id넣어줌
	String selectNameById(int id);
}
