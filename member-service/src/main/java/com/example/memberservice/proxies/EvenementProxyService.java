package com.example.memberservice.proxies;


import com.example.memberservice.beans.EvenementBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EVENEMENT-SERVICE")
public interface EvenementProxyService {
    @GetMapping("/evenements/{id}")
    public EvenementBean findEvenementById(@PathVariable Long id);
}
