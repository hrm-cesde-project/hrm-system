package co.edu.cesde.hrm.contracting.application.usecase;

import co.edu.cesde.hrm.contracting.application.dto.EmpleadoActivoDTO;
import co.edu.cesde.hrm.contracting.application.port.output.EvaluacionNotifPort;
import co.edu.cesde.hrm.contracting.application.port.output.FormacionNotifPort;
import co.edu.cesde.hrm.contracting.application.port.output.NominaNotifPort;
import co.edu.cesde.hrm.contracting.application.port.output.RetencionNotifPort;

public class ContratacionUseCase {

    private final NominaNotifPort nomina;
    private final FormacionNotifPort formacion;
    private final RetencionNotifPort retencion;
    private final EvaluacionNotifPort evaluacion;

    public ContratacionUseCase(
            NominaNotifPort nomina,
            FormacionNotifPort formacion,
            RetencionNotifPort retencion,
            EvaluacionNotifPort evaluacion
    ) {
        this.nomina = nomina;
        this.formacion = formacion;
        this.retencion = retencion;
        this.evaluacion = evaluacion;
    }

    public void contratarEmpleado() {

        System.out.println("Empleado contratado");

        EmpleadoActivoDTO dto = new EmpleadoActivoDTO();
        dto.id = 1L;
        dto.nombres = "Juan";
        dto.salarioBase = 2000.0;

        try {
            nomina.notificar(dto);
        } catch (Exception e) {
            System.out.println("Error nomina");
        }

        try {
            formacion.notificar(dto);
        } catch (Exception e) {
            System.out.println("Error formacion");
        }

        try {
            retencion.notificar(dto);
        } catch (Exception e) {
            System.out.println("Error retencion");
        }

        try {
            evaluacion.notificar(dto);
        } catch (Exception e) {
            System.out.println("Error evaluacion");
        }
    }
}