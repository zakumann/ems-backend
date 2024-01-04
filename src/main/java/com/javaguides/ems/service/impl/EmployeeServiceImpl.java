package com.javaguides.ems.service.impl;

import com.javaguides.ems.dto.EmployeeDto;
import com.javaguides.ems.entity.Employee;
import com.javaguides.ems.exception.ResourceNotFoundException;
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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with  given id : " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
