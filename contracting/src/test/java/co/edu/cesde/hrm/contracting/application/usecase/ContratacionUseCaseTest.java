package co.edu.cesde.hrm.contracting.application.usecase;

import co.edu.cesde.hrm.contracting.application.exception.NotFoundException;
import co.edu.cesde.hrm.contracting.application.port.output.ContratacionPersistencePort;
import co.edu.cesde.hrm.contracting.domain.enums.EstadoContrato;
import co.edu.cesde.hrm.contracting.domain.enums.EstadoEmpleado;
import co.edu.cesde.hrm.contracting.domain.enums.TipoContrato;
import co.edu.cesde.hrm.contracting.domain.model.Contrato;
import co.edu.cesde.hrm.contracting.domain.model.Empleado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContratacionUseCaseTest {

    @Mock
    private ContratacionPersistencePort persistencePort;

    @InjectMocks
    private ContratacionUseCase useCase;

    @Test
    void renovarContrato_debeMarcarAnteriorComoRenovadoYCrearNuevoVigente() {
        Contrato actual = new Contrato(
                10L,
                1L,
                TipoContrato.TERMINO_FIJO,
                new BigDecimal("2500000"),
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 6, 30),
                EstadoContrato.VIGENTE,
                null
        );

        when(persistencePort.findContratoById(10L)).thenReturn(Optional.of(actual));
        when(persistencePort.saveContrato(any(Contrato.class))).thenAnswer(invocation -> invocation.getArgument(0));

        useCase.renovarContrato(10L, LocalDate.of(2026, 12, 31));

        ArgumentCaptor<Contrato> captor = ArgumentCaptor.forClass(Contrato.class);
        verify(persistencePort, times(2)).saveContrato(captor.capture());

        Contrato contratoAnterior = captor.getAllValues().get(0);
        Contrato contratoNuevo = captor.getAllValues().get(1);

        assertThat(contratoAnterior.getEstado()).isEqualTo(EstadoContrato.RENOVADO);
        assertThat(contratoNuevo.getEstado()).isEqualTo(EstadoContrato.VIGENTE);
        assertThat(contratoNuevo.getFechaInicio()).isEqualTo(LocalDate.of(2026, 7, 1));
        assertThat(contratoNuevo.getFechaFin()).isEqualTo(LocalDate.of(2026, 12, 31));
        assertThat(contratoNuevo.getEmpleadoId()).isEqualTo(1L);
    }

    @Test
    void terminarContrato_debeRetirarEmpleadoYTerminarContrato() {
        Contrato contrato = new Contrato(
                55L,
                7L,
                TipoContrato.TERMINO_FIJO,
                new BigDecimal("1800000"),
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 4, 30),
                EstadoContrato.VIGENTE,
                null
        );
        Empleado empleado = new Empleado(
                7L,
                99L,
                "Ana",
                "Pérez",
                "ana@example.com",
                "Analista",
                "TI",
                EstadoEmpleado.ACTIVO,
                LocalDate.of(2026, 1, 1)
        );

        when(persistencePort.findContratoById(55L)).thenReturn(Optional.of(contrato));
        when(persistencePort.findEmpleadoById(7L)).thenReturn(Optional.of(empleado));
        when(persistencePort.saveContrato(any(Contrato.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(persistencePort.saveEmpleado(any(Empleado.class))).thenAnswer(invocation -> invocation.getArgument(0));

        useCase.terminarContrato(55L, "Fin del vínculo");

        assertThat(contrato.getEstado()).isEqualTo(EstadoContrato.TERMINADO);
        assertThat(contrato.getMotivoTerminacion()).isEqualTo("Fin del vínculo");
        assertThat(empleado.getEstado()).isEqualTo(EstadoEmpleado.RETIRADO);
        verify(persistencePort).saveContrato(contrato);
        verify(persistencePort).saveEmpleado(empleado);
    }

    @Test
    void terminarContrato_debeFallarSiNoExisteElContrato() {
        when(persistencePort.findContratoById(404L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> useCase.terminarContrato(404L, "Motivo"))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("No existe el contrato solicitado");
    }
}
