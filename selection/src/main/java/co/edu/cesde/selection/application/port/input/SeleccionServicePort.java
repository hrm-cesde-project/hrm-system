package co.edu.cesde.selection.application.port.input;

import co.edu.cesde.selection.application.dto.ProcesoDTO;
import co.edu.cesde.selection.application.dto.EntrevistaCmd;
import java.util.List;

public interface SeleccionServicePort {

    public interface seleccionServicePort {
        ProcesoDTO iniciarProceso(ProcesoDTO dto);

       public void registrarEntrevista(EntrevistaCmd cmd);

        public void aprobar(Long procesoId);

        public void rechazar(Long procesoId, String motivo);

         ProcesoDTO buscarPorId(Long id);

        List<ProcesoDTO> listarAprobados();

        byte[] exportarCSV();
    }
}