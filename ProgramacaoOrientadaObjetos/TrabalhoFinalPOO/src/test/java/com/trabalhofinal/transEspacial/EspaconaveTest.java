package com.trabalhofinal.transEspacial;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

public class EspaconaveTest {
    Espaconave espaconaveSubLuz = new Subluz(1, "alfa", 11, 0.1, "nuclear", null);

    Espaconave espaconaveFTL = new FTL(2, "charlie", 22, 2.1, 200, null);

    @Test
    void testGetTipo() {
        assertEquals(1, espaconaveSubLuz.getTipo());
        assertEquals(2,espaconaveFTL.getTipo());
    }

    @Test
    void testGetNome() {
        assertEquals("alfa", espaconaveSubLuz.getNome());
        assertEquals("charlie", espaconaveFTL.getNome());
    }

    @Test
    void testGetEspacoPorto() {
        assertEquals(11, espaconaveSubLuz.getEspacoPorto());
        assertEquals(22, espaconaveSubLuz.getEspacoPorto());
    }

    @Test
    void testGetVelocidade() {
        assertEquals(0.1, ((Subluz)espaconaveSubLuz).getVelMaxImpulso());
        assertEquals(2.1, ((FTL)espaconaveFTL).getVelMaxWarp());
    }

    @Test
    void testGetCombQtdMax() {
        assertEquals("nuclear", ((Subluz)espaconaveSubLuz).getCombustivel());
        assertEquals(200, ((FTL)espaconaveFTL).getQtdMax());
    }

    @Test
    void testGetTransporte() {
        assertEquals(null, ((Subluz)espaconaveSubLuz).getTransporte());
        //assertEquals
    }



}
