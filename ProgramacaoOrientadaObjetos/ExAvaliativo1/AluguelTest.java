import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class AluguelTest {
    private Aluguel aluguelTest = new Aluguel (null, null, null, 0, null);
    private Alugavel alugavel = new Alugavel("Fusca", 0000, 30.00, 2004, "IVK0323");

    @Test
    public void getSetNome() {
        aluguelTest.setNome("Mateus Campos");
        boolean estaCerto = false;
        if(aluguelTest.getNome().equals("Mateus Campos")) {
            estaCerto = true;
        }
        assertTrue(estaCerto);
    }

    @Test
    public void getSetData() {
        aluguelTest.setNome("28/02");
        boolean estaCerto = false;
        if(aluguelTest.getNome().equals("28/02")) {
            estaCerto = true;
        }
        assertTrue(estaCerto);
    }

    @Test
    public void getSetCpf() {
        aluguelTest.setCpf("111.222.333-44");
        boolean estaCerto = false;
        if(aluguelTest.getCpf().equals("111.222.333-44")) {
            estaCerto = true;
        }
        assertTrue(estaCerto);
    }

    @Test
    public void getSetPeriodo() {
        aluguelTest.setPeriodo(5);
        assertEquals(5, aluguelTest.getPeriodo());
    }

    @Test
    public void getSetAlugavel() {
        aluguelTest.setAlugavel(alugavel);
        boolean estaCerto = false;
        if(aluguelTest.getAlugavel() == alugavel){
            estaCerto = true;
        }
        assertTrue(estaCerto);
    }
}
