package it.luigibennardis.rest.data;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UtentiServiceImplementation implements UtentiRepository{

	@Autowired
	private UtentiRepository usrRepository;
	
	
	public List<Utenti> findAll() {
		return usrRepository.findAll();
	}


	
	
	@Override
	public List<Utenti> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Utenti> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Utenti> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <S extends Utenti> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteInBatch(Iterable<Utenti> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Utenti getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Page<Utenti> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Utenti> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Utenti findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Utenti entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(Iterable<? extends Utenti> entities) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}
