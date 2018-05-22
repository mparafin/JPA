package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */

@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal commissionPct;
	private BigDecimal departmentId;
	private String email;
	private BigDecimal employeeId;
	private String firstName;
	private Date hireDate;
	private String jobId;
	private String lastName;
	private BigDecimal managerId;
	private String phoneNumber;
	private BigDecimal salary;

	public Employee() {
	}

	public Employee(String p_first_name, String p_last_name, String p_email, String p_phone_number, Date p_hire_date, String p_job_id, int p_salary, int p_manager_id, int p_department_id) {
		//employeeId = new BigDecimal(253);
		firstName = p_first_name;
		lastName = p_last_name;
		email = p_email;
		phoneNumber = p_phone_number;
		hireDate = p_hire_date;
		jobId = p_job_id;
		salary = new BigDecimal(p_salary);
		managerId = new BigDecimal(p_manager_id);
		departmentId = new BigDecimal(p_department_id);
	}


	@Column(name="COMMISSION_PCT")
	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}


	@Column(name="DEPARTMENT_ID")
	public BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	@Column(nullable=false, length=25)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")
	@SequenceGenerator(name="EMP_SEQ", allocationSize=25, sequenceName="SEQ_EMPLOYEE_ID")
	@Column(name="EMPLOYEE_ID", precision=6)
	public BigDecimal getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(BigDecimal employeeId) {
		this.employeeId = employeeId;
	}


	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE", nullable=false)
	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	@Column(name="JOB_ID")
	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	@Column(name="LAST_NAME", nullable=false, length=25)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="MANAGER_ID")
	public BigDecimal getManagerId() {
		return this.managerId;
	}

	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}


	@Column(name="PHONE_NUMBER")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(precision=8, scale=2)
	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}