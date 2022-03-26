package com.mozen.springboothibernatesearch.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class SearchRequestDTO {

    @NotBlank
    private String text;

    private List<String> fields = new ArrayList<>();

    @Min(1)
    private int limit;
}
