package gestionaulasinformatica.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import gestionaulasinformatica.backend.entity.PropietarioAula;
import gestionaulasinformatica.backend.repository.IPropietarioAulaRepository;

/**
 * Service para la entidad PropietarioAula.
 * 
 * @author Lisa
 *
 */
@Service
public class PropietarioAulaService {
	private static final Logger LOGGER = Logger.getLogger(PropietarioAula.class.getName());
	private IPropietarioAulaRepository propietarioAulaRepository;

	public PropietarioAulaService(IPropietarioAulaRepository propietarioAulaRepository) {
		this.propietarioAulaRepository = propietarioAulaRepository;
	}

	/**
	 * Función que devuelve una lista con todos los propietarios de aulas que hay en
	 * la BD.
	 * 
	 * @return Lista con todos los propietarios de aulas que hay en la BD
	 */
	public List<PropietarioAula> findAll() {
		return propietarioAulaRepository.findAll();
	}

	/**
	 * Función que devuelve una lista con todos los propietarios de aulas cuyo
	 * nombre contenga el filtro de texto, o todos los propietarios en caso de que
	 * el filtro sea null, que hay en la BD.
	 * 
	 * @param filtroTexto Filtro que se quiere aplicar
	 * 
	 * @return Lista con todos los propietarios de aulas cuyo nombre contenga el
	 *         filtro de texto, o todos los propietarios en caso de que el filtro
	 *         sea null, que hay en la BD.
	 */
	public List<PropietarioAula> findAll(String filtroTexto) {
		if (filtroTexto == null || filtroTexto.isEmpty()) {
			return propietarioAulaRepository.findAll();
		} else {
			return propietarioAulaRepository.search(filtroTexto);
		}
	}

	/**
	 * Función que devuelve una lista con todos los centros que hay en la BD.
	 * 
	 * @return Lista con todos los centros que hay en la BD
	 */
	public List<PropietarioAula> findAllCentros() {
		return propietarioAulaRepository.findAllCentros();
	}

	/**
	 * Función que devuelve el propietario que tiene el id pasado por parámetro.
	 * 
	 * @param id Id del propietario que se quiere obtener
	 * 
	 * @return Propietario que tiene el id pasado por parámetro
	 */
	public Optional<PropietarioAula> findById(String id) {
		return propietarioAulaRepository.findById(id);
	}

	/**
	 * Función que elimina el propietario de aula pasado por parámetro de la BD.
	 * 
	 * @param propietario Propietario de aula que se quiere eliminar
	 */
	public void delete(PropietarioAula propietario) {
		propietarioAulaRepository.delete(propietario);
	}

	/**
	 * Función que guarda el propietario de aula pasado por parámetro en la BD si no
	 * es null.
	 * 
	 * @param propietario Propietario de aula que se quier guardar
	 */
	public void save(PropietarioAula propietario) {
		if (propietario == null) {
			LOGGER.log(Level.SEVERE, "El propietario del aula que se quiere guardar es nulo.");
			return;
		}
		propietarioAulaRepository.saveAndFlush(propietario);
	}
}
