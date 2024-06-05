package ru.gb.apiclient.domain;

import lombok.Data;

@Data
public class Result {
    private String id;
    private String url;
    private Integer width;
    private Integer height;
}
