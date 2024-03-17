package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        //From List of Person
        List<Person> people = MockData.getPeople();

        // To List of PersonDTO
        List<PersonDTO> dtos = people.stream()
                .map(p -> new PersonDTO(p.getId(), p.getFirstName(), p.getAge()))
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();

        double averagePrice = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(averagePrice);
    }


    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        int sub = Arrays.stream(integers).reduce(9, (a, b) -> a - b); // operation starts with 9
        int sum = Arrays.stream(integers).reduce(0, (a, b) -> a + b); // operation starts with 0
        System.out.println(sub); // 9 - 1 - 2 - 3 - 4 - 99 - 100 - 121 - 1302 - 199   =    -1822
        System.out.println(sum); // 0 + 1 + 2 + 3 + 4 + 99 + 100 + 121 + 1302 + 199   =     1831
    }
}

