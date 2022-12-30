package com.example.CDStore.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersDto {
    private Long id;
    private int cost;
    private List<CDDto> cds;
    private List<SongDto> songs;
}
