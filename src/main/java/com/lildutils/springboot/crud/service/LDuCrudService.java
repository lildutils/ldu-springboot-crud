package com.lildutils.springboot.crud.service;

public interface LDuCrudService<TDTO>
{
	TDTO create( TDTO dto );

	TDTO read( TDTO dto );

	TDTO update( TDTO dto );

	TDTO delete( TDTO dto );

}
