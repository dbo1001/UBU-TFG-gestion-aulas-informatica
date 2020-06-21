package com.vaadin.gestionaulasinformatica.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import com.vaadin.gestionaulasinformatica.backend.entity.Reserva;

/**
 * Repositorio para la entidad Reserva con clave primaria de tipo Integer.
 * 
 * @author Lisa
 *
 */
public interface IReservaRepository extends JpaRepository<Reserva, Integer>, JpaSpecificationExecutor<Reserva> {

	@Query("SELECT r FROM Reserva r WHERE (r.fecha + r.horaInicio) > CURRENT_TIMESTAMP")
	List<Reserva> findReservasAPartirMomentoActual();

}
