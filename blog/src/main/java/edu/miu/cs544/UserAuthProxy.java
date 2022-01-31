package edu.miu.cs544;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "authentication-authorization-service", url = "localhost:8080")
public interface UserAuthProxy {
    @GetMapping("/api/user")
    public ResponseEntity<Object> getUser(@RequestHeader HttpHeaders headers);

}
