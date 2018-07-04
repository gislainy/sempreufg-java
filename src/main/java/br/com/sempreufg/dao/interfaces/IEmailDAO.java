package br.com.sempreufg.dao.interfaces;

import java.util.List;

import br.com.sempreufg.model.utils.Email;

public interface IEmailDAO extends IDao<Email, Long> {
	public List<Email> consultaEmail(String email);
}
