package com.example.CDStore.UnitTest;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.example.CDStore.model.service.ICDService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CDServiceTest {
    @Autowired
    private ICDService cdService;

    @Test
    public void getArtistByCDTest(){

        List<ArtistDto> actual=cdService.getArtistOfCD("cd3");
        List<ArtistDto> expected=List.of(new ArtistDto("artista3"));

        Assertions.assertEquals(expected.get(0).getName(),actual.get(0).getName());
    }
    @Test
    public void getCDByArtistTest(){
        List<CDDto> actual=cdService.getCDsByArtist("artista3");
        List<CDDto> expected=List.of(new CDDto("cd3",2004,25.0));

        Assertions.assertEquals(expected.get(0).getYear(),actual.get(0).getYear());
    }

    @Test
    public void getCDByTitleTest(){
        List<CDDto> actual=cdService.getCDsByTitle("cd1");
        List<CDDto> expected=List.of(new CDDto("cd1",1972,25.0));

        Assertions.assertEquals(expected.get(0).getYear(),actual.get(0).getYear());
    }

    @Test
    public void getCDByYearTest(){
        List<CDDto> actual=cdService.getCDsByYear(1972);
        List<CDDto> expected=List.of(new CDDto("cd1",1972,25));

        Assertions.assertEquals(expected.get(0).getYear(),actual.get(0).getYear());
    }

    @Test
    public void getAllCD(){
        List<CDDto> actual=cdService.getAllCDs();
        List<CDDto> expected=List.of(new CDDto("cd1",1973,25.0)
                ,new CDDto("cd2",1964,25.0),new CDDto("cdA",1993,25.0)
                ,new CDDto("cdb",1987,25.0),new CDDto("cd3",2004,25.0));

        Assertions.assertEquals(expected.get(2).getYear(),actual.get(2).getYear());
    }


    @Test
    public void getCDByPriceTest(){
        //not done yet so I left a placeholder.
        Assertions.assertTrue(true==false);
    }

    @Test
    public void getSongByCDTest(){
        //not done yet so I left a placeholder.
        Assertions.assertTrue(true==false);
    }

    @Test
    public void updateCDTest(){
        CDDto actual=cdService.replaceCD(Long.valueOf(3),new CDDto("none",2040,14));
        CDDto expected=new CDDto("none",2040,14);

        cdService.replaceCD(Long.valueOf(3),new CDDto("cdA",1993,25));

        Assertions.assertEquals(expected.getTitle(),actual.getTitle());
    }


    @Test
    public void createCDTest(){
        CDDto actual=cdService.createCD(new CDDto("cdborrable",2145,80));
        CDDto expected=new CDDto("cdborrable",2145,80);

        Assertions.assertEquals(expected.getTitle(),expected.getTitle());
    }
    @Test
    public void deleteCDTest(){
        CDDto actual=cdService.deleteCDById(Long.valueOf(4));
        CDDto expected=new CDDto("artistaborrable",2145,80);

        Assertions.assertEquals(expected.getYear(),actual.getYear());
    }
}
