package com.spring.core.session03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.spring.core.session03.bean.CarFactory;
import com.spring.core.session03.bean.Clazz;
import com.spring.core.session03.bean.DBConn;
import com.spring.core.session03.bean.Student;
import com.spring.core.session03.bean.Teacher;

@Configuration
@PropertySources({
    @PropertySource(value = "data.properties", ignoreResourceNotFound = true)
})
public class SpringConfig3 {
    
    // 引用外部資源
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    // 透過外部資源注入資料
    @Bean
    public Clazz clazz1(@Value("${clazz.name1}") String name, @Value("${clazz.credit1}") int credit) {
    	return new Clazz(1, name, credit);
    }
    
    @Bean
    public Clazz clazz2(@Value("${clazz.name2}") String name, @Value("${clazz.credit2}") int credit) {
        return new Clazz(2, name, credit);
    }
    
    @Bean
    public Clazz clazz3(@Value("${clazz.name3}") String name, @Value("${clazz.credit3}") int credit) {
        return new Clazz(3, name, credit);
    }
    
    // 學生 1 配置
    @Bean
    public Student student1(Clazz clazz1, Clazz clazz2, Clazz clazz3) {
        Set<Clazz> clazzs = new HashSet<>(Arrays.asList(clazz1, clazz2, clazz3));
        return new Student(1, "John", clazzs);
    }
    
    // 學生 2 配置
    @Bean
    public Student student2(Clazz clazz1, Clazz clazz3) {
        Set<Clazz> clazzs = new HashSet<>(Arrays.asList(clazz1, clazz3));
        return new Student(2, "Mary", clazzs);
    }
    
    // 講師 1 配置
    @Bean
    public Teacher teacher1(Student student1, Student student2, Clazz clazz1, Clazz clazz3) {
        Set<Student> students = new HashSet<>(Arrays.asList(student1, student2));
        List<Clazz> clazzs = Arrays.asList(clazz1, clazz3);
        Map<String, Integer> salary = new HashMap<>();
        salary.put("base", 50000);
        salary.put("addition", 20000);
        return new Teacher(1, "Bob", students, clazzs, salary);
    }
    
    // 講師 2 配置
    @Bean
    public Teacher teacher2(Student student1, Student student2, Clazz clazz1, Clazz clazz2, Clazz clazz3) {
        Set<Student> students = new HashSet<>(Arrays.asList(student1, student2));
        List<Clazz> clazzs = Arrays.asList(clazz1, clazz2, clazz3);
        Map<String, Integer> salary = new HashMap<>();
        salary.put("base", 65000);
        salary.put("addition", 25000);
        return new Teacher(2, "Jean", students, clazzs, salary);
    }

    // 簡化集合配置 set, list, map
    @Bean
    public Set<Student> students(Student student1, Student student2) {
        return new HashSet<>(Arrays.asList(student1, student2));
    }

    @Bean
    public List<Clazz> clazzs(Clazz clazz1, Clazz clazz2, Clazz clazz3) {
        return Arrays.asList(clazz1, clazz2, clazz3);
    }

    @Bean
    public Map<String, Integer> salary() {
        Map<String, Integer> salary = new HashMap<>();
        salary.put("base", 65000);
        salary.put("addition", 25000);
        return salary;
    }

    // init-method 與 destroy-method 配置
    @Bean(initMethod = "init", destroyMethod = "destory")
    public DBConn dbconn() {
        return new DBConn();
    }

    // CarFactory 工廠建立
    @Bean
    @Scope("prototype")
    public CarFactory carFactory() {
        return new CarFactory();
    }
    
}
