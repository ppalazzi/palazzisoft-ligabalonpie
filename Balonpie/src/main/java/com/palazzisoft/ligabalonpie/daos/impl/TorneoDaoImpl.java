package com.palazzisoft.ligabalonpie.daos.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.palazzisoft.balonpie.service.model.ParticipanteTorneo;
import com.palazzisoft.balonpie.service.model.Torneo;
import com.palazzisoft.balonpie.service.model.enumeration.EEstado;
import com.palazzisoft.ligabalonpie.daos.api.TorneoDao;
/**
 * 
 * @author ppalazzi
 *
 */
public class TorneoDaoImpl extends GenericDaoImpl<Torneo, Integer> implements TorneoDao {
	
	@Override
	protected Class<Torneo> getPersistenceClass() {
		return Torneo.class;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Torneo> obtenerTodosLosTorneos() {
		String sql = "FROM Torneo";
		return this.getHibernateTemplate().find(sql);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ParticipanteTorneo> obtenerParticipantesEquiposPorParticipanteId(Integer participanteId) {
		String sql = "FROM ParticipanteTorneo pe where  pe.participante.id = ?";		
		
		return this.getHibernateTemplate().find(sql, participanteId);	
	}
	
	@Override
	public Torneo obtenerTorneoPorDescripcion(String descripcion) {
		Torneo torneo = null;
		String sql = "FROM Torneo t where t.descripcion = ?";
		
		@SuppressWarnings("unchecked")
		List<Torneo> resultado = this.getHibernateTemplate().find(sql, descripcion);
		
		if (!resultado.isEmpty()) {
			torneo = resultado.get(PRIMER_ELEMENTO);
		}
		
		return torneo;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Torneo> obtenerTorneosDeParticipante(Integer participanteId) {
		String sql = "From Torneo t where t.participante.id = ?";
		return this.getHibernateTemplate().find(sql, participanteId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Torneo> obtenerTorneosValidosPorParticipante(
			Integer participanteId) {
		String sql = "From Torneo t where t.participante.id = ? and t.fechaInicio < ? and t.fechaFin > ? "
				+ "and t.estado = ?";
		Date currentDate = Calendar.getInstance().getTime();
		Object[] parameters = {participanteId, currentDate, currentDate, EEstado.ACTIVO.getEstado()};
		return this.getHibernateTemplate().find(sql, parameters);
	}
}
