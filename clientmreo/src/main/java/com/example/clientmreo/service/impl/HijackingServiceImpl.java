package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.HijackingDto;
import com.example.clientmreo.feign.TestFeign;
import com.example.clientmreo.service.HijackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HijackingServiceImpl implements HijackingService {
    private final TestFeign testFeign;

    /**Метод проверяет на null возвращаемое значение из таблицы hijacking_table
     * в случае положительного результат происходит проверка date_find из таблицы hijacking_table
     * используя интерфейс FeignClient
     */
    @Override
    public boolean checkHijacking(String vinNumber) {
        HijackingDto hijackingDto = testFeign.getInfoHijacking(vinNumber);
        if (hijackingDto == null) {
            return true;
        }
        return hijackingDto.getDateFind() != null;
    }
}
