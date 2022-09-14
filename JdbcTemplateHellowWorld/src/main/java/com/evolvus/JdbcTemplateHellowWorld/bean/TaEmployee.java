package com.evolvus.JdbcTemplateHellowWorld.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TaEmployee {

	private long empIdl;

	private String empName;

	private Date doj;

	private BigDecimal salary;

	public long getEmpIdl() {
		return empIdl;
	}

	public void setEmpIdl(long empIdl) {
		this.empIdl = empIdl;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
