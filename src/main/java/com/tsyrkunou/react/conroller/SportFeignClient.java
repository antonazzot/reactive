package com.tsyrkunou.react.conroller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.tsyrkunou.react.model.Sport;

@FeignClient(name = "sport", url = "https://sports.api.decathlon.com")
public interface SportFeignClient {
    @GetMapping(value = "/sports")
    List<Sport> getSport();
}