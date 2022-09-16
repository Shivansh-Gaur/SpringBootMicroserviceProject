package com.master.service;








import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.master.dto.RegUser;


@Service
public class UpdateService {

	@Autowired
	RegisterService regs;
	
	public RegUser get(Integer id) {
	Optional<RegUser> result =regs.findById(id);
	return result.get();
	}
}
