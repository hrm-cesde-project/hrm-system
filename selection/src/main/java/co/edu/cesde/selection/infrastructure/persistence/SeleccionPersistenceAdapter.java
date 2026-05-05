package co.edu.cesde.selection.infrastructure.persistence;

import org.springframework.stereotype.Component;



@Component
public class SeleccionPersistenceAdapter {


    private final SeleccionJpaRepo repository;

    public SeleccionPersistenceAdapter(SeleccionJpaRepo repository) {
        this.repository = repository;
    }
}