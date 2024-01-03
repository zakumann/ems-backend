package com.javaguides.ems.service.impl;

import com.javaguides.ems.dto.EmployeeDto;
import com.javaguides.ems.entity.Employee;
import com.javaguides.ems.mapper.EmployeeMapper;
import com.javaguides.ems.repository.EmployeeRepository;
import com.javaguides.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
