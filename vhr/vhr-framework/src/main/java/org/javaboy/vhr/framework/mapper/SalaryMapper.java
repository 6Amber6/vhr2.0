package org.javaboy.vhr.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.javaboy.vhr.framework.entity.Salary;

import java.util.List;

public interface SalaryMapper extends BaseMapper<Salary> {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaries();
}