package br.com.sempreufg.model.dao.interfaces;

import java.util.List;

import br.com.sempreufg.model.utils.Email;

public interface IEmailDAO extends IDao<Email, Long> {
	public List<Email> consultaEmail(String email);
}
