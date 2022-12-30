package com.example.CDStore.model.service;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.entity.Artist;
import com.example.CDStore.model.entity.CD;
import com.example.CDStore.model.entity.Song;
import com.example.CDStore.repository.IArtistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService implements IArtistService {

    private IArtistRepository artistRepository;
    private ModelMapper mapper;

    public ArtistService(IArtistRepository artistRepository,ModelMapper mapper) {
        this.artistRepository = artistRepository;
        this.mapper=mapper;
    }


    @Override
    public ArtistDto createArtist(ArtistDto artistDto) {
        Artist artist= new Artist(artistDto.getName());
        artistRepository.save(artist);
        return artistDto;
    }

    @Override
    public List<ArtistDto> getAllArtists() {
        return artistRepository.findAllArtists().stream().map(artist->mapper.map(artist,ArtistDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ArtistDto> getArtistsByName(String name) {
        List<Artist> artists=artistRepository.findArtistsByName(name);
        return artists.stream().map(artist->mapper.map(artist,ArtistDto.class)).collect(Collectors.toList());
    }


    @Override
    public List<CDDto> getCDsOfArtist(String artist) {
        List<CD> cds=artistRepository.findCDsOfArtist(artist);
        return cds.stream().map(cd->mapper.map(cd,CDDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<SongDto> getSongsOfArtist(String artist) {
        List<Song> songs=artistRepository.findSongsOfArtist(artist);
        return songs.stream().map(song->mapper.map(song,SongDto.class)).collect(Collectors.toList());
    }

    @Override
    public ArtistDto replaceArtist(Long id,ArtistDto artistDto) {
        artistRepository.putArtist(id, artistDto.getName());
        return artistDto;
    }

    @Override
    public ArtistDto deleteArtistById(Long id) {
        Artist artist=artistRepository.findArtistById(id);
        ArtistDto artistDto=new ArtistDto(artist.getName());
        artistRepository.deleteById(id);
        return artistDto;
    }



}
