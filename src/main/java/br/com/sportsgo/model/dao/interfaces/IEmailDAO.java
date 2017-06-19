package br.com.sportsgo.model.dao.interfaces;

import java.util.List;

import br.com.sportsgo.model.utils.Email;

public interface IEmailDAO extends IDao<Email, Long> {
	public List<Email> consultaEmail(String email);
}
