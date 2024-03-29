package com.example.demo.login.domain.model;

import java.util.Date;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;


@Data
public class SignupForm {

    @NotBlank(groups = ValidGroup1.class)
    @Email(groups = ValidGroup2.class)
    private String userId;

    @NotBlank(groups = ValidGroup1.class)
    @Length(min = 4, max = 100, groups = ValidGroup2.class)
    @Pattern(regexp="^[azAZ09]+$", groups = ValidGroup3.class)
    private String password;

    @NotBlank(groups = ValidGroup1.class)
    private String userName;

    @NotNull(groups = ValidGroup1.class)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    @Min(value = 20, groups = ValidGroup2.class)
    @Max(value = 100, groups = ValidGroup2.class)
    private int age;

    @AssertFalse(groups = ValidGroup2.class)
    private boolean marriage;
}

/*
@NotBlank(message = "{require_check}")
    @Email(message = "{email_check}")
    private String userId;

    @NotBlank(message = "{require_check}")
    @Length(min = 4, max = 100, message = "{length_check}")
    @Pattern(regexp="^[azAZ09]+$", message = "{pattern_check}")
    private String password;

    @NotBlank(message = "{require_check}")
    private String userName;

    @NotNull(message = "{require_check}")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    @Min(value = 20, message = "{min_check}")
    @Max(value = 100, message = "{max_check}")
    private int age;

    @AssertFalse(message = "{false_check}")
    private boolean marriage;
 */
