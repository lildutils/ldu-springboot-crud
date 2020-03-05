package com.lildutils.springboot.crud.service.impl;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.lildutils.springboot.crud.persistence.model.LDuCrudModel;
import com.lildutils.springboot.crud.persistence.repository.LDuCrudRepository;
import com.lildutils.springboot.crud.service.LDuCrudService;
import com.lildutils.springboot.crud.service.dto.LDuCrudDTO;
import com.lildutils.springboot.crud.service.ex.LDuEntityAlreadyExistsException;
import com.lildutils.springboot.crud.service.ex.LDuEntityNotFoundException;

public abstract class LDuAbstractCrudServiceImpl<TDTO extends LDuCrudDTO<TID>, TMODEL extends LDuCrudModel<TID>, TID extends Serializable>
		implements LDuCrudService<TDTO>
{
	protected abstract LDuCrudRepository<TMODEL, TID> getRepository();

	protected abstract TDTO convert( TMODEL model );

	protected abstract TMODEL convert( TDTO dto );

	/**
	 * Checks if the entity has uniqueness constraint(s).
	 * 		
	 * @param {@link LDuCrudDTO} the entity DTO
	 * @return true, if the entity is unique in the database
	 */
	protected abstract boolean checkUniqueness( TDTO dto );

	/**
	 * Checks if the entity has exists constraint(s).
	 * 
	 * @param {@link LDuCrudDTO} the entity DTO
	 * @return true, if the entity is exists in the database
	 */
	protected boolean checkExists( TDTO dto )
	{
		return getRepository().findById( dto.getId() ).isPresent();
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

	protected TDTO doCreate( TDTO dto )
	{
		return convert( getRepository().save( convert( dto ) ) );
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

	protected TDTO doRead( TDTO dto )
	{
		return convert( getRepository().findById( dto.getId() ).get() );
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

	protected TDTO doUpdate( TDTO dto )
	{
		TMODEL model = getRepository().findById( dto.getId() ).get();
		TMODEL update = convert( dto );
		BeanUtils.copyProperties( update, model, "id" );
		return convert( getRepository().save( model ) );
	}

	@Override
	public TDTO delete( TDTO dto )
	{
		return doDelete( dto );
	}

	protected TDTO doDelete( TDTO dto )
	{
		if( !checkExists( dto ) )
		{
			throw new LDuEntityNotFoundException();
		}
		TMODEL model = getRepository().findById( dto.getId() ).get();
		getRepository().delete( model );
		return convert( model );
	}

}
