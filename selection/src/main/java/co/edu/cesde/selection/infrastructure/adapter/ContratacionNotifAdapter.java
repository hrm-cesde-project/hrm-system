package co.edu.cesde.selection.infrastructure.adapter;

import co.edu.cesde.selection.application.port.output.ContratacionNotifPort;
import co.edu.cesde.selection.domain.ProcesoSeleccion;
import org.springframework.stereotype.Component;

@Component
public class ContratacionNotifAdapter implements ContratacionNotifPort {

    @Override
    public void notificarCandidatoAprobado(ProcesoSeleccion proceso) {

        System.out.println("\n========================================================");
        System.out.println("📢 [ADAPTADOR NOTIFICACIÓN] ¡Alerta de Selección Activada!");
        System.out.println("========================================================");

        if (proceso != null) {
            System.out.println("📧 Enviando correo a: contratacion@cesde.edu.co");
            System.out.println("💼 Asunto: Nuevo candidato preseleccionado listo para contratación");

            // Si te sale error en getNombreCargo(), revisa cómo se llama el getter en tu clase ProcesoSeleccion
            // System.out.println("📝 Detalle: El proceso para el cargo de '" + proceso.getNombreCargo() + "' ha sido APROBADO.");
            System.out.println("🚀 Acción: Solicitando al módulo 'contracting' iniciar el proceso legal.");
        } else {
            System.out.println("⚠️ Alerta: Se intentó notificar un proceso, pero los datos llegaron vacíos.");
        }

        System.out.println("========================================================\n");
    }
}