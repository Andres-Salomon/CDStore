package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.entity.Artist;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICDService {

    CDDto createCD(CDDto cdDto);

    List<CDDto> getAllCDs();

    List<CDDto> getCDsByTitle(String title);
    List<CDDto> getCDsByArtist(String artistName);

    List<CDDto> getCDsByYear(int year);

    List<ArtistDto> getArtistOfCD(String cd);

    List<SongDto> getSongsOfCD(String cdTitle);

    CDDto replaceCD(Long id, CDDto cd);

    CDDto deleteCDById(Long id);

    List<CDDto> getCDsByPrice(double price);
}
