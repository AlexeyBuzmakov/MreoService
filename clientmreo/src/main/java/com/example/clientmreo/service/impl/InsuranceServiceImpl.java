package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.InsuranceDto;
import com.example.clientmreo.feign.TestFeign;
import com.example.clientmreo.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private final TestFeign testFeign;

    /**Метод проверяет на null возвращаемое значение из таблицы insurance_table
     * микросервиса ClientInsurance
     * используя интерфейс FeignClient и в зависимости от результата
     * проверяется дата окончания страхования по date_end
     */
    @Override
    public boolean checkInsurance(String number) {
        InsuranceDto insuranceDto = testFeign.getInfoInsurance(number);
        if(insuranceDto == null) {
            return false;
        }
        return insuranceDto.getDateEnd().isAfter(LocalDate.now());
    }
}
