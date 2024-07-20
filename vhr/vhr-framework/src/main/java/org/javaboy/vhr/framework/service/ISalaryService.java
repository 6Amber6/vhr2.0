package org.javaboy.vhr.framework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.javaboy.vhr.framework.entity.Salary;

import java.util.List;

public interface ISalaryService extends IService<Salary> {

    List<Salary> getAllSalaries();

    Integer addSalary(Salary salary);

    Integer deleteSalaryById(Integer id);

    Integer updateSalaryById(Salary salary);
}
