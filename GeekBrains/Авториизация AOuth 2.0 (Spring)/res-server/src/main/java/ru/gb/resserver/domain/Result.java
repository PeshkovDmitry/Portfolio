package ru.gb.resserver.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Result {
    private String id;
    private String url;
    private Integer width;
    private Integer height;
}
