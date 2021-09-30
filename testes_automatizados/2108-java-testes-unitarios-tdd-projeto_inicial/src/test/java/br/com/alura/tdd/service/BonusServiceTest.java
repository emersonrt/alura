package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal(12000)));

        assertEquals(bonus, BigDecimal.ZERO);
    }

    @Test
    void bonusDeveriaSer10PorcentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal(9000)));

        assertEquals(bonus, new BigDecimal("900.0"));
    }

    @Test
    void bonusDeveriaSer10PorcentoDoSalarioParaSalarioIgualA10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal(10000)));

        assertEquals(bonus, new BigDecimal("1000.0"));
    }
}