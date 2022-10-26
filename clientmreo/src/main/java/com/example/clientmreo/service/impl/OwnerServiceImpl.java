package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.OwnerDto;
import com.example.clientmreo.mapper.MreoMapper;
import com.example.clientmreo.repository.OwnerRepository;
import com.example.clientmreo.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final MreoMapper mreoMapper;

    /**Метод проверяет на null возвращаемое значение из таблицы owner_table
     * в случае положительного результат происходит добавление в таблицу owner_table
     * используя интерфейс OwnerRepository
     */
    @Override
    @Transactional
    public void updateOwnerTable(String name, String patronymic, String surname, String driverLicense) {
        if(ownerRepository.getOwnerEntityByDriverLicense(driverLicense) == null) {
            OwnerDto ownerDto = new OwnerDto();
            ownerDto.setName(name);
            ownerDto.setPatronymic(patronymic);
            ownerDto.setSurname(surname);
            ownerDto.setDriverLicense(driverLicense);
            ownerRepository.save(mreoMapper.getOwnerEntity(ownerDto));
        }
    }
    @Override
    public Long getIdOwner(String driverLicense) {
        return ownerRepository.getOwnerEntityByDriverLicense(driverLicense).getId();
    }

    @Override
    public OwnerDto getOwnerDto(String driverLicense) {
        return mreoMapper.getOwnerDto(ownerRepository.getOwnerEntityByDriverLicense(driverLicense));
    }
}
