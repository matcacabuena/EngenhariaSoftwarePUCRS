import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlugavelTest {
    private Alugavel alugavel = new Alugavel(null, 0, 0, 0, null);

    @Test
    public void getSetNome() {
        alugavel.setNome("Fusca");
        boolean estaCerto = false;
        if (alugavel.getNome().equals("Fusca")) {
            estaCerto = true;
        }
        assertTrue(estaCerto);
    }

    @Test
    public void getSetCodigo() {
        alugavel.setCodigo(0000);
        assertEquals(0000, alugavel.getCodigo());
    }

    @Test
    public void getSetPrecoDiario() {
        alugavel.setPrecoDiario(250.00);
        assertEquals(250.00, alugavel.getPrecoDiario());
    }

    @Test
    public void getSetPlaca() {
        alugavel.setPlaca("IVE1603");
        boolean estaCerto = false;
        if(alugavel.getPlaca().equals("IVE1603")) {
            estaCerto = true;
        }
        assertTrue(estaCerto);
    }

    @Test
    public void getSetAno() {
        alugavel.setAno(2006);
        assertEquals(2006, alugavel.getAno());
    }
}
