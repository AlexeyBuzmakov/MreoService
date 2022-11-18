package com.example.clientmreo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**Интефрейс используется для связи с другими микросервисами и
 * получения возвращаемых значений их методов на основании FeignClient
 */
@FeignClient(name = "test", url = "localhost:8081")
public interface Feign {
    @GetMapping("/insurance/get-info-insurance/{numberCar}")
    ResponseEntity<?> getInfoInsurance(@PathVariable String numberCar);

    @GetMapping("/dps/get-info-hijacking/{vinNumber}")
    ResponseEntity<?> getInfoHijacking(@PathVariable String vinNumber);

    @GetMapping("/dps/get-info-penalty/{numberCar}")
    ResponseEntity<?> getInfoPenalty(@PathVariable String numberCar);
}
