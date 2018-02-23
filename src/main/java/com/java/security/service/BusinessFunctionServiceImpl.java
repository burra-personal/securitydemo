package com.java.security.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.security.dao.repository.UserRepository;
import com.java.security.model.User;
import com.java.security.model.Values;

import ma.glasnost.orika.MapperFacade;
@Service(value = "businessFunctionService")
public class BusinessFunctionServiceImpl implements BusinessFunctionService {

	@Autowired
    private UserRepository userRepository;
	
	@Resource(name = "restServiceModelDomainMapperFacade")
	private MapperFacade restServiceModelDomainMapperFacade;
	
	
	@Override
	public String addUser(User user) {
		(new Values()).setXY(5, 6);
        com.java.security.domain.User domain = restServiceModelDomainMapperFacade.map(user, com.java.security.domain.User.class);
		userRepository.saveAndFlush(domain);
        return "saved";
	}


	@Override
	public User findByUserId(Integer id) {
		com.java.security.domain.User domain = userRepository.findOne(id);
		User model = restServiceModelDomainMapperFacade.map(domain, User.class);
		return model;
	}

}
