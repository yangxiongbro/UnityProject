package org.example.spring.boot.validation.params;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ClassInfoParams {
    @NotBlank(message = "班级id不能为null，或者只包含空格")
    private String classId;

    @NotBlank(message = "班级名不能为null，或者只包含空格")
    private String className;

}
