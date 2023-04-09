package org.example.spring.boot.validation.params;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class SchoolInfoParams {
    @NotBlank
    private String schoolId;

    @NotBlank
    private String schoolName;

//    在对象属性上使用@Valid注~解
    @Valid
    @NotEmpty
    private List<ClassInfoParams> classList;
}
