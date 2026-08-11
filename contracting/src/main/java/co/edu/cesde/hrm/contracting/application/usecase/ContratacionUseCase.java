package co.edu.cesde.hrm.contracting.application.usecase;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ContratacionUseCase {

    public String exportarCSV(String estadoEmpleado) {

        List<Map<String, String>> empleados = new ArrayList<>();

        Map<String, String> e1 = new HashMap<>();
        e1.put("empleado_id", "1");
        e1.put("nombres", "Juan");
        e1.put("apellidos", "Perez");
        e1.put("cargo", "AUXILIAR LOGISTICO");
        e1.put("departamento", "LOGISTICA");
        e1.put("estado_empleado", "ACTIVO");
        e1.put("tipo_contrato", "FIJO");
        e1.put("salario_base", "2000000");
        e1.put("fecha_ingreso", "20-05-2023");
        e1.put("fecha_fin_contrato", "");
        e1.put("estado_contrato", "VIGENTE");

        Map<String, String> e2 = new HashMap<>();
        e2.put("empleado_id", "2");
        e2.put("nombres", "Maria");
        e2.put("apellidos", "Gomez");
        e2.put("cargo", "AUXILIAR DE ASEO");
        e2.put("departamento", "ASEO");
        e2.put("estado_empleado", "INACTIVO");
        e2.put("tipo_contrato", "INDEFINIDO");
        e2.put("salario_base", "3000000");
        e2.put("fecha_ingreso", "20-05-2023");
        e2.put("fecha_fin_contrato", "17-09-2025");
        e2.put("estado_contrato", "FINALIZADO");

        empleados.add(e1);
        empleados.add(e2);

        if (estadoEmpleado != null && !estadoEmpleado.isEmpty()) {
            empleados.removeIf(e -> !e.get("estado_empleado").equalsIgnoreCase(estadoEmpleado));
        }

        StringBuilder csv = new StringBuilder();

        csv.append("empleado_id,nombres,apellidos,cargo,departamento,estado_empleado,tipo_contrato,salario_base,fecha_ingreso,fecha_fin_contrato,estado_contrato\n");

        if (empleados.isEmpty()) {
            return csv.toString();
        }

        for (Map<String, String> e : empleados) {
            csv.append(escape(e.get("empleado_id"))).append(",")
                    .append(escape(e.get("nombres"))).append(",")
                    .append(escape(e.get("apellidos"))).append(",")
                    .append(escape(e.get("cargo"))).append(",")
                    .append(escape(e.get("departamento"))).append(",")
                    .append(escape(e.get("estado_empleado"))).append(",")
                    .append(escape(e.get("tipo_contrato"))).append(",")
                    .append(escape(e.get("salario_base"))).append(",")
                    .append(escape(e.get("fecha_ingreso"))).append(",")
                    .append(escape(e.get("fecha_fin_contrato"))).append(",")
                    .append(escape(e.get("estado_contrato")))
                    .append("\n");
        }

        return csv.toString();
    }

    private String escape(String valor) {
        if (valor == null) return "";

        if (valor.contains(",") || valor.contains("\"")) {
            valor = valor.replace("\"", "\"\"");
            return "\"" + valor + "\"";
        }

        return valor;
    }
}