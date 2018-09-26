package com.example.springbootweb;

import com.example.springbootweb.model.Test;
import com.example.springbootweb.service.TestService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootWebApplication.class)
public class SpringBootWebApplicationTests {

    @Resource
    private TestService testService;

    @org.junit.Test
    public void testFindAll(){
        List<Test> list = testService.findAll();
        for (int i=0; i<list.size(); i++){
            System.out.println("id:"+list.get(i).getId()+",name:"+list.get(i).getName());
        }
        System.out.println("size:"+list.size());
    }

}
