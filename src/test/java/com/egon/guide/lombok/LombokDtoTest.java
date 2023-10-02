package com.egon.guide.lombok;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LombokDtoTest {

    @Test
    void ShouldCreateAnObject() {
        var dto = new LombokDto("Name", LocalDate.EPOCH);

        assertThat(dto).isNotNull();
        assertThat(dto.getName()).isEqualTo("Name");
        assertThat(dto.getBirthday()).isEqualTo(LocalDate.EPOCH);
    }

    @Test
    void ShouldCreateAnObjectFromBuilder() {
        var dto = LombokDto.builder()
                .name("Name")
                .birthday(LocalDate.EPOCH)
                .build();

        assertThat(dto).isNotNull();
        assertThat(dto.getName()).isEqualTo("Name");
        assertThat(dto.getBirthday()).isEqualTo(LocalDate.EPOCH);
    }

}