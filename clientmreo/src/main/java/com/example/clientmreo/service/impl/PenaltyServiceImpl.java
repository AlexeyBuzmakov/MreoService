package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.PenaltyDto;
import com.example.clientmreo.feign.TestFeign;
import com.example.clientmreo.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PenaltyServiceImpl implements PenaltyService {
    private final TestFeign testFeign;

    /**Метод использует FeignClient для получение списка PenaltyDto микросервиса ClientDps
     * и проверка на наличие в этом списке значений
     */
    @Override
    public boolean checkPenalty(String number) {
        List<PenaltyDto>penaltyDtoList = testFeign.getInfoPenalty(number);
        return penaltyDtoList.size() == 0;
    }
}
