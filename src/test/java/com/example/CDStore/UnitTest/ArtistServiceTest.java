package com.example.CDStore.UnitTest;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.dtos.SongDto;
import com.example.CDStore.model.service.IArtistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ArtistServiceTest {

    @Autowired
    private IArtistService artistService;

    @Test
    public void getSongsByArtistTest(){

        List<SongDto> actual=artistService.getSongsOfArtist("artista1");
        List<SongDto> expected=List.of(new SongDto("cancion1",3,3.0),
                new SongDto("cancion2",3,4.0));

        Assertions.assertEquals(expected.get(0).getTitle(),actual.get(0).getTitle());
    }
    @Test
    public void getCDsByArtistTest(){
        List<CDDto> actual=artistService.getCDsOfArtist("artista1");
        List<CDDto> expected=List.of(new CDDto("cd1",1972,25.0));

        Assertions.assertEquals(expected.get(0).getTitle(),actual.get(0).getTitle());
    }
    @Test
    public void getArtistByNameTest(){
        List<ArtistDto> actual=artistService.getArtistsByName("artista1");
        List<ArtistDto> expected=List.of(new ArtistDto("artista1"));

        Assertions.assertEquals(expected.get(0).getName(),actual.get(0).getName());
    }
    @Test
    public void getAllArtist(){
        List<ArtistDto> actual=artistService.getAllArtists();
        List<ArtistDto> expected=List.of(new ArtistDto("artista1")
        ,new ArtistDto("artista2"),new ArtistDto("artista3"));

        Assertions.assertEquals(expected.get(1).getName(),actual.get(1).getName());
    }
    @Test
    public void updateArtistTest(){
        ArtistDto actual=artistService.replaceArtist(Long.valueOf(3),new ArtistDto("none"));
        ArtistDto expected=new ArtistDto("none");

        artistService.replaceArtist(Long.valueOf(3),new ArtistDto("artista3"));

        Assertions.assertEquals(expected.getName(),actual.getName());
    }


    @Test
    public void createTest(){
        ArtistDto actual=artistService.createArtist(new ArtistDto("artistaborrable"));
        ArtistDto expected=new ArtistDto("artistaborrable");

        Assertions.assertEquals(expected.getName(),actual.getName());
    }
    @Test
    public void deleteArtistTest(){
        ArtistDto actual=artistService.deleteArtistById(Long.valueOf(4));
        ArtistDto expected=new ArtistDto("artistaborrable");

        Assertions.assertEquals(expected.getName(),actual.getName());
    }

}
