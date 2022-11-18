package com.example.clientmreo.controller;

import com.example.clientmreo.dto.OwnerCarDto;
import com.example.clientmreo.service.MreoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/mreo")
@RequiredArgsConstructor
public class MreoController {
    private final MreoService mreoService;

    /**
     * Метод возвращает результат постановки авто на учёт в виде кода состояния http запроса
     * 200 - авто успешно поставлено на учёт
     * 400 - невозможно поставить авто на учёт по каким либо причинам
     */
    @PostMapping("/registration")
    public ResponseEntity<?> registration(@Valid @RequestBody OwnerCarDto ownerCarDto) {
        if(mreoService.registration(ownerCarDto))
            return ResponseEntity.ok().body("Successfully");
        return ResponseEntity.badRequest().body("Unsuccessfully");
    }
}

