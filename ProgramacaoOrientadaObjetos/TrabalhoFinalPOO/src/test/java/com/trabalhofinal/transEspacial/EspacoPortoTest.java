package com.trabalhofinal.transEspacial;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EspacoPortoTest {

  EspacoPorto espacoPorto = new EspacoPorto(1, "a", 0.1, 0.2, 0.3);
  @Test
  void testGetCoordX() {
    assertEquals(0.1, espacoPorto.getCoordX());
  }

  @Test
  void testGetCoordY() {
    assertEquals(0.2, espacoPorto.getCoordY());
  }

  @Test
  void testGetCoordZ() {
    assertEquals(0.3, espacoPorto.getCoordZ());
  }

  @Test
  void testGetNome() {
    assertEquals("a", espacoPorto.getNome());
  }

  @Test
  void testGetNumero() {
    assertEquals(1, espacoPorto.getNumero());
  }

  @Test
  void testSetCoordX() {
    espacoPorto.setCoordX(3);
    assertEquals(3, espacoPorto.getCoordX());
  }

  @Test
  void testSetCoordY() {
    espacoPorto.setCoordY(1);
    assertEquals(1, espacoPorto.getCoordY());
  }

  @Test
  void testSetCoordZ() {
    espacoPorto.setCoordZ(7);
    assertEquals(7, espacoPorto.getCoordZ());
  }

  @Test
  void testSetNome() {
    espacoPorto.setNome("b");
    assertEquals("b", espacoPorto.getNome());
  }

  @Test
  void testSetNumero() {
    espacoPorto.setNumero(9);
    assertEquals(9, espacoPorto.getNumero());
  }
}
