package org.gradle.mappers;

import java.util.List;

import org.gradle.dto.Person;

public interface PersonMapper {
	List<Person> selectAll();
}
