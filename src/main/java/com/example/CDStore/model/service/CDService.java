package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.entity.CD;
import com.example.CDStore.model.entity.Song;
import com.example.CDStore.repository.ICDRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CDService implements ICDService {

    private ICDRepository cdRepository;
    private ModelMapper mapper;
    public CDService(ICDRepository cdRepository,ModelMapper mapper){
        this.cdRepository=cdRepository;
        this.mapper=mapper;
    }
    @Override
    public CDDto createCD(CDDto cdDto) {
        CD cd= new CD(cdDto.getTitle(),cdDto.getYear(),cdDto.getPrice());
        cdRepository.save(cd);
        return cdDto;
    }

    @Override
    public List<CDDto> getAllCDs() {
        List<CD>cds=cdRepository.findAllCDs();
        List<CDDto>cdDtos=cds.stream().map(cd->new CDDto(cd.getTitle(),cd.getYear(),cd.getPrice())).collect(Collectors.toList());
        return cdDtos;
    }

    @Override
    public List<CDDto> getCDsByTitle(String title) {
        List<CD> cds=cdRepository.findCDsByTitle(title);
        List<CDDto> cdDtos=cds.stream()
                .map(cd-> mapper.map(cd,CDDto.class)).collect(Collectors.toList());
        return cdDtos;
    }


    @Override
    public List<CDDto> getCDsByYear(int year) {
        List<CD> cds=cdRepository.findCDsByYear(year);
        List<CDDto> cdDtos=cds.stream()
                .map(cd-> mapper.map(cd,CDDto.class)).collect(Collectors.toList());
        return cdDtos;
    }


    @Override
    public List<CDDto> getCDsByPrice(double price) {
        List<CD> cds=cdRepository.findCDsByPrice(price);
        List<CDDto> cdDtos=cds.stream().map(cd->mapper.map(cd,CDDto.class)).collect(Collectors.toList());
        return cdDtos;
    }

    @Override
    public List<CDDto> getCDsByArtist(String artist) {
        List<CD> cds=cdRepository.findCDsByArtist(artist);
        List<CDDto> cdDtos=cds.stream()
                .map(cd-> mapper.map(cd,CDDto.class)).collect(Collectors.toList());
        return cdDtos;
    }

    @Override
    public List<ArtistDto> getArtistOfCD(String cd) {
        List<Artist> artists=cdRepository.findArtistByCD(cd);
        return artists.stream().map(artist->mapper.map(artist, ArtistDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongsOfCD(String cdTitle) {
        List<Song> songs=cdRepository.findSongOfCD(cdTitle);
        return songs.stream().map(song->mapper.map(song, SongDto.class)).collect(Collectors.toList());
    }

    @Override
    public CDDto replaceCD(Long id, CDDto cdDto) {
        cdRepository.putCD(id,cdDto.getTitle(),cdDto.getYear(),cdDto.getPrice());
        return cdDto;
    }

    @Override
    public CDDto deleteCDById(Long id) {
//        CD cd=cdRepository.findCDById(id);
//        CDDto cdDto=new CDDto(cd.getTitle(),cd.getYear(),cd.getPrice());
//        cdRepository.deleteById(id);
//        return cdDto;
        return null;
    }

}
