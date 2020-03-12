package com.lildutils.springboot.crud.service;

import java.util.Collection;

public interface LDuCrudService<TDTO>
{
	boolean checkExists( TDTO dto );

	boolean checkUniqueness( TDTO dto );

	TDTO create( TDTO dto );

	TDTO read( TDTO dto );

	TDTO update( TDTO dto );

	TDTO delete( TDTO dto );

	Collection<TDTO> list();

	long count();

}
