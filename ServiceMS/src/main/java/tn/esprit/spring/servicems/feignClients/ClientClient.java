package tn.esprit.spring.servicems.feignClients;

import tn.esprit.spring.servicems.entity.ServiceClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "AuteurMS")
public interface ClientClient {
    @GetMapping("/clients/{id}")
    ServiceClient getClientById(@PathVariable Long id);
}