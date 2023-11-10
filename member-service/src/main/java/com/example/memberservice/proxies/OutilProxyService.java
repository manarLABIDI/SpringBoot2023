package com.example.memberservice.proxies;


import com.example.memberservice.beans.OutilBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "OUTIL-SERVICE")
public interface OutilProxyService {
    @GetMapping("/outils/{id}")
    public OutilBean findOutilById(@PathVariable(name = "id") Long id);
}
