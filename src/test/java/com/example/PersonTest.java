package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSet() {

        final Person elizabeth = Person.builder()
                .name("Elizabeth")
                .build();
        final Person philip = Person.builder()
                .name("Philip")
                .build();
        final Person charles = Person.builder()
                .name("Charles")
                .build();
        final Person anne = Person.builder()
                .name("Anne")
                .build();
        final Person andrew = Person.builder()
                .name("Andrew")
                .build();
        final Person edward = Person.builder()
                .name("edward")
                .build();
        final Set<Person> children = new HashSet<>(Arrays.asList(charles, anne, andrew, edward));
        elizabeth.setChildren(children);
        philip.setChildren(children);

        final Person savedElizabeth = personRepository.save(elizabeth);

        System.out.println(savedElizabeth);

        final Set<Person> savedChildren = savedElizabeth.getChildren();
        savedChildren.forEach(child ->
                assertThat(savedChildren.contains(child), is(true)));
    }
}