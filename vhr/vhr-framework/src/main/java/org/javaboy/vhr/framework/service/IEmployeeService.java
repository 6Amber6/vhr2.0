package org.javaboy.vhr.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.javaboy.vhr.framework.entity.Employee;
import org.javaboy.vhr.framework.entity.RespPageBean;

import java.util.Date;
import java.util.List;

public interface IEmployeeService extends IService<Employee> {

    RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope);

    Integer addEmp(Employee employee);

    Integer maxWorkID();

    Integer deleteEmpByEid(Integer id);

    Integer updateEmp(Employee employee);

    Integer addEmps(List<Employee> list);

    RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size);

    Integer updateEmployeeSalaryById(Integer eid, Integer sid);

    Employee getEmployeeById(Integer empId);
}
