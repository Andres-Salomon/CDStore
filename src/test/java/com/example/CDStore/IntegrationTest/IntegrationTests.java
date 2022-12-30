package com.example.CDStore.IntegrationTest;

import com.example.CDStore.model.dtos.ArtistDto;
import com.example.CDStore.model.dtos.CDDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    ObjectWriter writer=new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer().withDefaultPrettyPrinter();

    //ArtistController
    @Test
    public void testArtistController() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/all",""))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("artista1"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void artistControllerGetAllTest() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/all",""))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("artista1"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void artistControllerGetByNameTest() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/byname")
                        .param("name","artista1"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("artista1"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void artistControllerGetCDsOfArtistTest() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/cds")
                        .param("artist","artista2"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].title").value("cd2"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void artistControllerGetSongsOfArtistTest() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/songs")
                        .param("artist","artista1"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].title").value("cancion1"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }
    @Test
    public void artistControllerCreateArtistTest() throws Exception{
        ArtistDto payload= new ArtistDto("artistaABCD");

        String  payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/artist/create")
                                .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"));
    }

    @Test
    public void artistControllerPutArtistTest() throws Exception{
        ArtistDto payload= new ArtistDto("DCBAartista");

        String  payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/artist/put")
                        .param("id","3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void artistControllerDeleteArtistTest() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete("/artist/del")
                        .param("id","3"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }




    //CDController

    @Test
    public void cdControllerGetAll() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/cd/all",""))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].title").value("cd1"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void cdControllerGetByTitle() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/cd/bytitle")
                        .param("title","cd2"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].year").value("1964"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void cdControllerGetByPrice() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/cd/byprice")
                        .param("price","25"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[3].year").value("1987"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void cdControllerGetByYear() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/artist/songs")
                        .param("artist","artista1"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].title").value("cancion1"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }
    @Test
    public void cdControllerGetByArtist() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get("/cd/cd")
                        .param("artist","artista3"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[3].year").value("2004"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }

    @Test
    public void cdControllerCreateCD() throws Exception{
        CDDto payload= new CDDto("anewcd1",1982,32);

        String  payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/cd/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void cdControllerPutCDTest() throws Exception{
        CDDto payload= new CDDto("newercdhere",1998,28);

        String  payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/cd/put")
                        .param("id","3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void cdControllerDeleteCD() throws Exception{
        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete("/cd/del")
                        .param("id","3"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals("application/json",mvcResult.getResponse().getContentType());
    }
}
