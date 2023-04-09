package org.example.common.spring.boot.web;

import org.example.common.spring.boot.vo.ClassInfoVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/school")
public class MyController {

    @GetMapping(value = "/query")
    public StringBuilder query() {
        return new StringBuilder(("测试"));
    }

    @GetMapping(value = "/num")
    public Integer num() {
        return 1;
    }

    @GetMapping(value = "/class/info")
    public ClassInfoVO classInfo() {
        ClassInfoVO classInfo = new ClassInfoVO();
        classInfo.setClassId("id");
        classInfo.setClassName("name");
        return classInfo;
    }
}
