package com.lildutils.springboot.crud.mongo.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.lildutils.springboot.crud.mongo.document.LDuMongoCrudDocument;
import com.lildutils.springboot.crud.mongo.repository.LDuMongoCrudRepository;
import com.lildutils.springboot.crud.mongo.service.LDuMongoCrudService;
import com.lildutils.springboot.crud.service.dto.LDuCrudDTO;
import com.lildutils.springboot.crud.service.impl.LDuAbstractCrudServiceImpl;

public abstract class LDuMongoAbstractCrudServiceImpl<TDTO extends LDuCrudDTO<TID>, TMODEL extends LDuMongoCrudDocument<TID>, TID extends Serializable>
		extends LDuAbstractCrudServiceImpl<TDTO, TMODEL, TID> implements LDuMongoCrudService<TDTO>
{
	protected abstract LDuMongoCrudRepository<TMODEL, TID> getRepository();

	protected abstract TDTO convert( TMODEL model );

	protected abstract TMODEL convert( TDTO dto );

	protected boolean doCheckExists( TDTO dto )
	{
		return getRepository().findById( dto.getId() ).isPresent();
	}

	protected boolean doCheckUniqueness( TDTO dto )
	{
		return true;
	}

	@Override
	protected TDTO doCreate( TDTO dto )
	{
		return convert( getRepository().save( convert( dto ) ) );
	}

	@Override
	protected TDTO doRead( TDTO dto )
	{
		return convert( getRepository().findById( dto.getId() ).get() );
	}

	@Override
	protected TDTO doUpdate( TDTO dto )
	{
		TMODEL model = getRepository().findById( dto.getId() ).get();
		TMODEL update = convert( dto );
		BeanUtils.copyProperties( update, model, "id" );
		return convert( getRepository().save( model ) );
	}

	@Override
	protected TDTO doDelete( TDTO dto )
	{
		TMODEL model = getRepository().findById( dto.getId() ).get();
		getRepository().delete( model );
		return convert( model );
	}

	@Override
	protected Collection<TDTO> doList()
	{
		return getRepository().findAll().stream().map( this::convert ).collect( Collectors.toList() );
	}

	@Override
	protected long doCount()
	{
		return getRepository().count();
	}

}
