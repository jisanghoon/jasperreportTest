package org.gradle;

import java.util.List;

import org.gradle.dto.Person;
import org.gradle.service.PersonService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonTest {
	private static PersonService ps;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ps = PersonService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ps = null;
	}

	@Test
	public void test() {
		List<Person> list = ps.selectAll();
		Assert.assertNotNull(list);
		for (Person c : list) {
			System.out.println(c);
		}

	}
}
