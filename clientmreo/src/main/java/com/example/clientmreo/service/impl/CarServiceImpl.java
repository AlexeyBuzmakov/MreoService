package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.OwnerCarDto;
import com.example.clientmreo.entity.Car;
import com.example.clientmreo.entity.Owner;
import com.example.clientmreo.mapper.MreoMapper;
import com.example.clientmreo.repository.CarRepository;
import com.example.clientmreo.repository.OwnerRepository;
import com.example.clientmreo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final MreoMapper mreoMapper;

    /**
     * Метод проверяем на null возвращаемое значение метода CarRepository
     * по входящим аргументам
     * в зависимости от результатов проверки происходит обновление или добавление
     * в таблицу car_table, используя интерфейс CarRepository
     */
    @Override
    @Transactional
    public void updateCar(OwnerCarDto ownerCarDto) {
        Owner owner = ownerRepository.getOwnerByDriverLicense(ownerCarDto.getDriverLicense())
                .orElse(mreoMapper.getOwner(ownerCarDto));
        Car car = carRepository.getCarByVinNumber(ownerCarDto.getVinNumber())
                .orElse(mreoMapper.getCar(ownerCarDto));
        car.setOwner(owner);
        carRepository.save(car);
    }
}
