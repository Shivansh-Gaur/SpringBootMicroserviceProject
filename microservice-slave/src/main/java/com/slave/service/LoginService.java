package com.slave.service;







import org.springframework.data.repository.CrudRepository;


import com.slave.dto.RegUser;







public interface LoginService extends CrudRepository<RegUser,Integer>{

	public RegUser findByUsername(String username);
	
	
}
