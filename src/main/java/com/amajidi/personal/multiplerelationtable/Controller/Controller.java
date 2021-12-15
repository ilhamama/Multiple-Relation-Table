package com.amajidi.personal.multiplerelationtable.Controller;

import java.util.List;

import com.amajidi.personal.multiplerelationtable.Response.UserDto;
import com.amajidi.personal.multiplerelationtable.Service.MultipleRelationService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/data", produces = "application/json")
public class Controller {

    private final MultipleRelationService multipleRelationService;

    @GetMapping(value = "/user")
    public List<UserDto> getUser(@RequestParam(required = false) String id) {
        log.info("#getUser() with id : {}", id);
        return multipleRelationService.getData(id);
    }
}
