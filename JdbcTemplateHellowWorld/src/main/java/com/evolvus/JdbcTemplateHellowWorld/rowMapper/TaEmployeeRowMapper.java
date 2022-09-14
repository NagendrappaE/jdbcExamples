package com.evolvus.JdbcTemplateHellowWorld.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.evolvus.JdbcTemplateHellowWorld.bean.TaEmployee;

public class TaEmployeeRowMapper implements RowMapper<TaEmployee> {

	public TaEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
		TaEmployee obj = new TaEmployee();

		obj.setEmpIdl(rs.getLong("EMPID"));
		obj.setEmpName(rs.getString("EMPLOYEENAME"));
		obj.setDoj(rs.getDate("DOJ"));
		obj.setSalary(rs.getBigDecimal("SALARY"));
		return obj;
	}

}
