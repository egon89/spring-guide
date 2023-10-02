package com.egon.guide.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class LombokDto {
    private String name;
    private LocalDate birthday;
}
