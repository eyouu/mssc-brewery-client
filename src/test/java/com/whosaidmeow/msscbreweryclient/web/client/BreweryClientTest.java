package com.whosaidmeow.msscbreweryclient.web.client;

import com.whosaidmeow.msscbreweryclient.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient underTest;

    @Test
    void shouldGetBeerById() {
        BeerDTO result = underTest.getBeerById(UUID.randomUUID());

        assertNotNull(result);
    }

    @Test
    void shouldSaveNewBeer() {
        BeerDTO beerDTO = BeerDTO.builder().beerName("New beer").build();

        URI uri = underTest.saveNewBeer(beerDTO);

        assertNotNull(uri);
    }

    @Test
    void shouldUpdateBeer() {
        BeerDTO beerDTO = BeerDTO.builder().beerName("New beer").build();

        underTest.updateBeer(UUID.randomUUID(), beerDTO);
    }

    @Test
    void shouldDeleteBeer() {
        underTest.deleteBeer(UUID.randomUUID());
    }
}