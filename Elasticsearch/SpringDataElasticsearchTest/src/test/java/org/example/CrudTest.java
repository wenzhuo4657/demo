package org.example;


import org.example.repository.IESUserRaffleOrderRepository;
import org.example.valobj.ESUserRaffleOrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
public class CrudTest {


    @Autowired
    private IESUserRaffleOrderRepository iESUserRaffleOrderRepository;


    @Test
    public  void testCrud()
    {
        Iterable<ESUserRaffleOrderVO> all = iESUserRaffleOrderRepository.findAll();
        System.out.println(all);
    }
}
