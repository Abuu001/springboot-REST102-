package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Springboot102ApplicationTests {

    Calculator underTest = new Calculator();

    @Test
    void itShouldAddNumbers(){
        //given
        int noOne = 20;
        int noTwo = 30;

        //when
       int result= underTest.add(noOne,noTwo);

       //then
        assertThat(result).isEqualTo(50);

    }

    class Calculator{
        int add(int a ,int b){
            return a +b;
        }
    }
}
