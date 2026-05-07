package co.edu.cesde.recruitment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/aspirantes")
public class AspiranteController {

    @PostMapping
    public ResponseEntity<Object> registrarAspirante(@RequestBody Map<String, Object> body) {
        
        if (isInvalid(body)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Campos obligatorios faltantes.");
        }

        String email = body.get("email").toString();

        if (checkEmailExists(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: El email ya existe.");
        }

        body.put("id", UUID.randomUUID().toString());
        body.put("estado", "REGISTRADO");
        
        saveAspirante(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    private boolean isInvalid(Map<String, Object> body) {
        String[] required = {"nombres", "apellidos", "email", "cargo"};
        for (String field : required) {
            if (!body.containsKey(field) || body.get(field) == null) return true;
        }
        return false;
    }

    private boolean checkEmailExists(String email) {
        return false; 
    }

    private void saveAspirante(Map<String, Object> body) {
    }
}