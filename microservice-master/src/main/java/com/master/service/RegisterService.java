package com.master.service;







import org.springframework.data.repository.CrudRepository;

import com.master.dto.RegUser;



public interface RegisterService extends CrudRepository<RegUser,Integer>{

	public RegUser findByUsername(String username);

}
