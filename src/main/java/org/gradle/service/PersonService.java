package org.gradle.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.gradle.dto.Person;
import org.gradle.mappers.PersonMapper;
import org.gradle.util.MybatisSessionFactory;

public class PersonService implements PersonMapper {
	private static final Logger logger = Logger.getLogger(PersonService.class);

	private static final PersonService instance = new PersonService();
	public static PersonService getInstance() {

		return instance;
	}

	private PersonService() {
	}
	
	@Override
	public List<Person> selectAll() {
		
		SqlSession sqlSession = MybatisSessionFactory.openSession();
		PersonMapper personDao = sqlSession.getMapper(PersonMapper.class);
		try {
			List<Person> returnList = personDao.selectAll();
			return returnList;
		} finally {
			sqlSession.close();
		}
	}

}
