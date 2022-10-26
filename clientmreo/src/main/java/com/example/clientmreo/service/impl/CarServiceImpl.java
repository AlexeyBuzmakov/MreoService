package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.CarDto;
import com.example.clientmreo.dto.OwnerDto;
import com.example.clientmreo.mapper.MreoMapper;
import com.example.clientmreo.repository.CarRepository;
import com.example.clientmreo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final MreoMapper mreoMapper;

    /**Метод проверяем на null возвращаемое значение метода CarRepository
     * по входящим аргументам
     * в зависимости от результатов проверки происходит обновление или добавление
     * в таблицу car_table, используя интерфейс CarRepository
     */
    @Override
    @Transactional
    public void updateCarTable(String brand, String model, int yearIssue, String vinNumber, String number, OwnerDto ownerDto, Long ownerId) {
        if(carRepository.getCarEntityByVinNumber(vinNumber) == null) {
            CarDto carDto = new CarDto();
            carDto.setBrand(brand);
            carDto.setModel(model);
            carDto.setYearIssue(yearIssue);
            carDto.setVinNumber(vinNumber);
            carDto.setNumber(number);
            carDto.setOwnerDto(ownerDto);
            carRepository.save(mreoMapper.getCarEntity(carDto));
            return;
        }
        carRepository.updateCarTable(ownerId, vinNumber);
    }
}
