package com.trabalhofinal.transEspacial;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransporteTest {
  EspacoPorto espacoOrigem = new EspacoPorto(1, "Daylight", 1, 1, 1);
  EspacoPorto espacoDestino = new EspacoPorto(2, "Moonlight", 2, 2, 2);
  Transporte transporteMaterial = new TransporteMaterial(2, 123, 1, 2, espacoOrigem, espacoDestino, EstadoTransporte.PENDENTE, null, 5, null);
  Transporte transportePessoa = new TransportePessoa(1, 456, 1, 2, espacoOrigem, espacoDestino, EstadoTransporte.PENDENTE, null, 100);
  
  @Test
  void testCalculaCusto() {
    Assertions.assertThat(433012.7018922193).isEqualTo(transporteMaterial.calculaCusto());
    Assertions.assertThat(1732050.8075688772).isEqualTo(transportePessoa.calculaCusto());
  }

  @Test
  void testCalculaDistancia() {
    Assertions.assertThat(1.7320508075688772).isEqualTo(transporteMaterial.calculaDistancia());
    Assertions.assertThat(1.7320508075688772).isEqualTo(transportePessoa.calculaDistancia());
  }

  @Test
  void testGetDestino() {
    assertEquals(2, transporteMaterial.getDestino());
    assertEquals(2, transportePessoa.getDestino());
  }

  @Test
  void testGetEspaconave() {
    assertEquals(null, transporteMaterial.getEspaconave());
    assertEquals(null, transportePessoa.getEspaconave());
  }

  @Test
  void testGetEstado() {
    assertEquals(EstadoTransporte.PENDENTE, transporteMaterial.getEstado());
    assertEquals(EstadoTransporte.PENDENTE, transportePessoa.getEstado());
  }

  @Test
  void testGetIdentificador() {
    assertEquals(123, transporteMaterial.getIdentificador());
    assertEquals(456, transportePessoa.getIdentificador());
  }

  @Test
  void testGetOrigem() {
    assertEquals(1, transporteMaterial.getOrigem());
    assertEquals(1, transportePessoa.getOrigem());
  }

  @Test
  void testGetTipo() {
    assertEquals(2, transporteMaterial.getTipo());
    assertEquals(1, transportePessoa.getTipo());
  }

  @Test
  void testSetDestino() {
    transporteMaterial.setDestino(1);
    transportePessoa.setDestino(1);
    assertEquals(1, transporteMaterial.getDestino());
    assertEquals(1, transportePessoa.getDestino());
  }

  @Test
  void testSetEstado() {
    transporteMaterial.setEstado(EstadoTransporte.TRANSPORTANDO);
    transportePessoa.setEstado(EstadoTransporte.TRANSPORTANDO);
    assertEquals(EstadoTransporte.TRANSPORTANDO, transporteMaterial.getEstado());
    assertEquals(EstadoTransporte.TRANSPORTANDO, transportePessoa.getEstado());
    
  }

  @Test
  void testSetIdentificador() {
    transporteMaterial.setIdentificador(444);
    transportePessoa.setIdentificador(555);
    assertEquals(444, transporteMaterial.getIdentificador());
    assertEquals(555, transportePessoa.getIdentificador());
  }

  @Test
  void testSetOrigem() {
    transporteMaterial.setOrigem(2);
    transportePessoa.setOrigem(2);
    assertEquals(2, transporteMaterial.getOrigem());
    assertEquals(2, transportePessoa.getOrigem());
  }
}
