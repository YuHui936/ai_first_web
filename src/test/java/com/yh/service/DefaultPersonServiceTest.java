package com.yh.service;

import com.yh.dao.PersonDao;
import com.yh.model.Country;
import com.yh.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultPersonServiceTest {
    @Mock
    private PersonDao personDao;

    @InjectMocks
    private DefaultPersonService personService;

    @Before
    public void setup() {
        // 创建模拟对象并注入到被测试对象中

        personService = new DefaultPersonService();
        personService.setPersonDao(personDao);
    }

    @Test
    public void testGetAllPersons() {
        // 模拟 personDao 的行为
        when(personDao.getAllPersons()).thenReturn(new Person[]{new Person(), new Person()});

        // 调用被测试方法
        Person[] persons = personService.getAllPersons();

        // 使用断言验证返回值是否符合预期
        assertNotNull(persons);
        assertEquals(2, persons.length);

        // 验证 personDao 的 getAllPersons 方法被调用
        verify(personDao, times(1)).getAllPersons();
    }

    @Test
    public void testGetPersonById() {
        // 模拟 personDao 的行为
        int personId = 1;
        when(personDao.getPersonById(personId)).thenReturn(new Person(personId, "John", "Doe", "Football", "Male", new Country("1", "USA"), true, null, "john@example.com", "123-456-7890"));

        // 调用被测试方法
        Person person = personService.getPersonById(personId);

        // 使用断言验证返回值是否符合预期
        assertNotNull(person);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("Football", person.getSport());

        // 验证 personDao 的 getPersonById 方法被调用
        verify(personDao, times(1)).getPersonById(personId);
    }

    @Test
    public void testUpdatePerson() {
        // 创建一个测试用的 Person 对象
        Person updatedPerson = new Person(1, "John", "Doe", "Football", "Male", new Country("1", "USA"), true, null, "john@example.com", "123-456-7890");

        // 调用被测试方法
        personService.updatePerson(updatedPerson);

        // 验证 personDao 的 updatePerson 方法被调用，并传入了正确的参数
        verify(personDao, times(1)).updatePerson(eq(updatedPerson));
    }

}