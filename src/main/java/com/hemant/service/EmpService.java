package com.hemant.service;

import com.hemant.exception.EmpNotFoundException;
import com.hemant.model.dto.EmpDto;
import com.hemant.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hemant.model.mapper.EmpMapper.empMapper;

@Service
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository empRepository;

    public EmpDto getEmp(Integer id) {
        return empRepository.findByEmpId(id)
                .map(empMapper::toDto)
                .orElseThrow(() -> new EmpNotFoundException("Emp not found id: " + id));
    }

    public List<EmpDto> getAllEmp() {
        return empMapper.toDtoList(empRepository.findAll());
    }

    public EmpDto sameEmp(EmpDto empDto) {
        return empMapper.toDto(empRepository.save(empMapper.toEntity(empDto)));
    }

    public String deleteEmp(Integer empId) {
        empRepository.findByEmpId(empId).ifPresentOrElse(empRepository::delete,
                () ->{ throw new EmpNotFoundException("EmpId is not found:" + empId);});
        return "EmpId is deleted:" + empId;
    }
}
