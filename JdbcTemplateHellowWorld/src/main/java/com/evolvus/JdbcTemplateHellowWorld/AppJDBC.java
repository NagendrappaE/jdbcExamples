package com.evolvus.JdbcTemplateHellowWorld;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.evolvus.JdbcTemplateHellowWorld.bean.TaEmployee;
import com.evolvus.JdbcTemplateHellowWorld.rowMapper.TaEmployeeRowMapper;

/**
 * Hello world!
 *
 */
public class AppJDBC {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String oracle_jdbc_url = "jdbc:oracle:thin:@localhost:49171:xe";

		String userName = "IDIB";

		String password = "root";

		// creating DS it holds connection objects
		DriverManagerDataSource ds = new DriverManagerDataSource(oracle_jdbc_url, userName, password);

		JdbcTemplate jdbcTemp = new JdbcTemplate(ds);

		String inserrec = "INSERT INTO EMPLOYEE (EMPID,EMPLOYEENAME,DOJ,SALARY) VALUES (?,?,?,?)";

		
		String selectsql="SELECT  *  FROM  EMPLOYEE WHERE EMPID =1";
		
	String	selectsqlAll="SELECT  *  FROM  EMPLOYEE";
		TaEmployee emp = new TaEmployee();

		emp.setDoj(new Date());
		emp.setEmpIdl(2l);
		emp.setEmpName("Nagendra");
		emp.setSalary(new BigDecimal(9900000));

		try {
			/*
			 * int updatedCnt = jdbcTemp.update(inserrec, emp.getEmpIdl(), emp.getEmpName(),
			 * emp.getDoj(), emp.getSalary());
			 */
			//System.out.println("the inserted records " + updatedCnt);
			
			TaEmployee  empObj=jdbcTemp.queryForObject(selectsql, new TaEmployeeRowMapper());
			
			System.out.println(" the returned objec"+empObj);
			
			List<TaEmployee> empObjList= jdbcTemp.query(selectsqlAll, new TaEmployeeRowMapper());
			
			
			System.out.println(" the lust of objec"+empObjList);
			
			
			String selectSqlSingle="SELECT  *  FROM  EMPLOYEE WHERE EMPID =? and EMPLOYEENAME =?";
			
			long empId=1l;
			String empName="nagendra";
			TaEmployee  emps=   jdbcTemp.queryForObject(selectSqlSingle, new Object[] {empId,empName},  new TaEmployeeRowMapper());
				
			System.out.println(" the single object "+emps);
					
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
