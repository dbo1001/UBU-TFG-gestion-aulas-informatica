package gestionaulasinformatica.backend.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import gestionaulasinformatica.backend.data.TipoOperacionHR;

/**
 * Entidad que identifica a la tabla HistoricoReserva de la base de datos.
 * 
 * @author Lisa
 *
 */
@Entity
@Table(name = "historico_reservas", schema = "public")
public class HistoricoReservas implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HistoricoReservasPK idOperacionHR;

	@NotNull
	@Column(name = "fecha_operacion")
	private Timestamp fechaHoraOperacion;

	/**
	 * Asociación bidireccional ManyToOne con PropietarioAula para indicar el
	 * responsable de añadir, modificar o eliminar una reserva.
	 * 
	 * Cascade ALL: se realizan todas las operaciones (DETACH, MERGE, PERSIST,
	 * REFRESH, REMOVE)
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "responsable_operacion", referencedColumnName = "id_propietario_aula", insertable = false, updatable = false)
	private PropietarioAula responsableOperacion;

	/**
	 * Constructor de la clase sin parámetros.
	 */
	public HistoricoReservas() {
	}

	/**
	 * Constructor de la clase con parámetros.
	 * 
	 * @param id          Id de la operación (id reserva + tipo operación)
	 * @param fecha       Fecha y hora de la operación
	 * @param responsable Responsable de realizar la operación
	 */
	public HistoricoReservas(HistoricoReservasPK id, Timestamp fecha, PropietarioAula responsable) {
		this.idOperacionHR = id;
		this.fechaHoraOperacion = fecha;
		this.responsableOperacion = responsable;
	}

	/**
	 * Función que devuelve el id de la operación del histórico de reservas.
	 * 
	 * @return ID de la operación del histórico de reservas
	 */
	public HistoricoReservasPK getIdOperacionHR() {
		return this.idOperacionHR;
	}

	/**
	 * Función que establece el id de la operación del histórico de reservas.
	 * 
	 * @param reserva       Reserva sobre la que se ha realizado la operación
	 * @param tipoOperacion Tipo de operación que se ha realizado
	 */
	public void setIdOperacionHR(Reserva reserva, TipoOperacionHR tipoOperacion) {
		this.idOperacionHR.setReserva(reserva);
		this.idOperacionHR.setTipoOperacion(tipoOperacion);
	}

	/**
	 * Función que devuelve la fecha de la reserva asociada a la operación.
	 * 
	 * @return Fecha de la reserva asociada a la operación
	 */
	public LocalDate getFechaReservaOperacion() {
		return this.idOperacionHR.getReserva().getFecha();
	}

	/**
	 * Función que devuelve la fecha y hora en que se ha realizado la operación.
	 * 
	 * @return Fecha y hora en que se ha realizado la operación
	 */
	public Timestamp getFechaHoraOperacion() {
		return this.fechaHoraOperacion;
	}

	/**
	 * Función que devuelve la fecha en que se ha realizado la operación.
	 * 
	 * @return Fecha en que se ha realizado la operación
	 */
	public LocalDate getFechaOperacion() {
		return this.fechaHoraOperacion.toLocalDateTime().toLocalDate();
	}

	/**
	 * Función que establece la fecha y hora en que se ha realizado la operación.
	 * 
	 * @param fecha Fecha y hora en que se ha realizado la operación
	 */
	public void setFechaHoraOperacion(Timestamp fechaHora) {
		this.fechaHoraOperacion = fechaHora;
	}

	/**
	 * Función que devuelve el responsable de la operación que se ha realizado.
	 * 
	 * @return Responsable de la operación que se ha realizado
	 */
	public PropietarioAula getResponsableOperacion() {
		return this.responsableOperacion;
	}

	/**
	 * Función que establece el responsable de la operación que se ha realizado.
	 * 
	 * @param responsableOperacion Responsable de la operación que se ha realizado
	 */
	public void setResponsableOperacion(PropietarioAula responsableOperacion) {
		this.responsableOperacion = responsableOperacion;

	}
}
