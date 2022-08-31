package com.tsyrkunou.react.conroller;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsyrkunou.react.dao.SportDao;
import com.tsyrkunou.react.model.Sport;

@RestController
@RequestMapping("/sport")
@RequiredArgsConstructor
public class SportController {
    private final SportDao sportDao;

    @GetMapping("/stream")
    public Flux<Sport> getAllSports(){
        return sportDao.parseJson();
    }
}
