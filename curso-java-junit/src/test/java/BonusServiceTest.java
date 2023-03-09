import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    void bonusDevceriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

//        try {
//            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
//            fail ("Não deu a exception!");
//        } catch (Exception e) {
//        }
    }

    @Test
    public void bonusDeveSerConcedido() {
        BonusService bonus = new BonusService();
        BigDecimal salario = new BigDecimal("2500");
        BigDecimal resultado = bonus.calcularBonus(new Funcionario("Matheus", LocalDate.now(), salario));
        assertEquals(new BigDecimal("250.0"), resultado);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService bonus = new BonusService();
        BigDecimal salario = new BigDecimal("10000");
        BigDecimal resultado = bonus.calcularBonus(new Funcionario("Matheus", LocalDate.now(), salario));
        assertEquals(new BigDecimal("1000.0"), resultado);
    }
}