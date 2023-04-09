package org.example.spring.boot.validation.web;

import lombok.extern.slf4j.Slf4j;
import org.example.spring.boot.validation.params.ClassInfoParams;
import org.example.spring.boot.validation.params.SchoolInfoParams;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/school")
@Slf4j
public class MyController {

    @GetMapping(value = "/info/class/{id}")
    public Integer classInfo(@PathVariable @Valid @NotNull Integer id) {
        log.info("Get /school/info/class/{}", id);
        return id;
    }

    @GetMapping(value = "/info/name")
    public String infoName(@Valid @NotNull String name) {
        log.info("Get /school/info/name");
        return name;
    }

    @GetMapping(value = "/info")
    public ClassInfoParams info(@Valid ClassInfoParams params) {
        log.info("Get /school/info");
        return params;
    }

    @PostMapping(value = "/query")
    public SchoolInfoParams query(@RequestBody @Valid SchoolInfoParams params) {
        log.info("Post /school/query");
        return params;
    }
}
