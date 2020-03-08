package com.lildutils.springboot.crud.service.helper;

public interface LDuServiceHelper<TDTO, TMODEL>
{
	TDTO convertModel( TMODEL model );

	TMODEL convertDTO( TDTO dto );

}
