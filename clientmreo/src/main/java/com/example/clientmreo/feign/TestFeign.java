package com.example.clientmreo.feign;

import com.example.clientmreo.dto.InsuranceDto;
import com.example.clientmreo.dto.HijackingDto;
import com.example.clientmreo.dto.PenaltyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**Интефрейс используется для связи с другими микросервисами и
 * получения возвращаемых значений их методов на основании FeignClient
 */

@FeignClient(name = "test", url = "localhost:8081")
public interface TestFeign {
    @GetMapping("/insurance/get-info-insurance")
    InsuranceDto getInfoInsurance(@RequestParam String number);

    @GetMapping("/dps/get-info-hijacking")
    HijackingDto getInfoHijacking(@RequestParam String number);

    @GetMapping("/dps/get-info-penalty")
    List<PenaltyDto> getInfoPenalty(@RequestParam String number);
}
