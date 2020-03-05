package com.lildutils.springboot.crud.persistence.model;

public interface LDuCrudModel<TID>
{
	TID getId();

	void setId( TID id );

}
