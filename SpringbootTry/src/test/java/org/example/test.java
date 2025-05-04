package org.example;

import com.google.common.base.Throwables;
import org.example.config.MyFeature;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Scanner;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;




//@Component
//@SpringBootTest(classes = Main.class)
public class test {

//    @Autowired
//    private MyFeature myFeature;

//    @Test
//    public void testMyFeatureBean() {
//
//        if (myFeature == null) {
//            System.out.println("dsfafsa");
//        }
//        assertNotNull("MyFeature bean should not be null", myFeature);
//
//    }


    @Test
    public  void pr() throws IOException {
            try {
                    int i=1/0;
            }catch (Exception e){
//                Throwables.propagateIfPossible(e, IOException.class);
                Throwable rootCause = Throwables.getRootCause(e);
                if (rootCause instanceof  ArithmeticException){
                    System.out.println("ArithmeticException");
                }
            }
    }
        @Test
        public  void prs(){
                try {
                        int i=1/0;
                }catch (Exception e){
                        String ee=Throwables.getStackTraceAsString(e);
                        System.out.println(ee);
                }
        }


        @Test
        public  void psrs(){
            RandomGeneratorFactory<RandomGenerator> l128X256MixRandom = RandomGeneratorFactory.of("L128X256MixRandom");

            RandomGenerator randomGenerator = l128X256MixRandom.create(System.currentTimeMillis());
            for (int i=0;i<10;i++) System.out.println(randomGenerator.nextInt(10));

        }

}

