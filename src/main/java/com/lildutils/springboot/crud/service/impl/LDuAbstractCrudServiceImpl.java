package com.lildutils.springboot.crud.service.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.lildutils.springboot.crud.model.LDuCrudModel;
import com.lildutils.springboot.crud.service.LDuCrudService;
import com.lildutils.springboot.crud.service.dto.LDuCrudDTO;
import com.lildutils.springboot.crud.service.ex.LDuEntityAlreadyExistsException;
import com.lildutils.springboot.crud.service.ex.LDuEntityNotFoundException;

public abstract class LDuAbstractCrudServiceImpl<TDTO extends LDuCrudDTO<TID>, TMODEL extends LDuCrudModel<TID>, TID extends Serializable>
		implements LDuCrudService<TDTO>
{
	protected abstract CrudRepository<TMODEL, TID> getRepository();

	protected abstract boolean doCheckExists( TDTO dto );

	protected abstract boolean doCheckUniqueness( TDTO dto );

	protected abstract TDTO doCreate( TDTO dto );

	protected abstract TDTO doRead( TDTO dto );

	protected abstract TDTO doUpdate( TDTO dto );

	protected abstract TDTO doDelete( TDTO dto );

	protected abstract Collection<TDTO> doList();

	protected abstract long doCount();

	@Override
	public boolean checkExists( TDTO dto )
	{
		return doCheckExists( dto );
	}

	@Override
	public boolean checkUniqueness( TDTO dto )
	{
		return doCheckUniqueness( dto );
	}

	@Override
	public TDTO create( TDTO dto )
	{
		if( !checkUniqueness( dto ) )
		{
			throw new LDuEntityAlreadyExistsException();
		}
		return doCreate( dto );
	}

	@Override
	public TDTO read( TDTO dto )
	{
		if( !checkExists( dto ) )
		{
			throw new LDuEntityNotFoundException();
		}
		return doRead( dto );
	}

	@Override
	public TDTO update( TDTO dto )
	{
		if( !checkExists( dto ) )
		{
			throw new LDuEntityNotFoundException();
		}
		return doUpdate( dto );
	}

	@Override
	public TDTO delete( TDTO dto )
	{
		if( !checkExists( dto ) )
		{
			throw new LDuEntityNotFoundException();
		}
		return doDelete( dto );
	}

	@Override
	public Collection<TDTO> list()
	{
		return doList();
	}

	@Override
	public long count()
	{
		return doCount();
	}

}
