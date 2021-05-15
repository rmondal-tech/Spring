package com.demo.spring.basic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.demo.spring.basic.sorting.loosecoupling.withdi.SortAlgorithmWithExOfLooseCouplingWithDi;
import com.demo.spring.basic.sorting.loosecoupling.withoutdi.BubbleSortServiceImpl;
import com.demo.spring.basic.sorting.loosecoupling.withoutdi.SortAlgorithmWithExOfLooseCoupling;
import com.demo.spring.basic.sorting.tightcoupling.SortAlgorithmWithExOfTightCoupling;

// What are the beans?
// What are the dependencies of a bean?
// Where to search for beans? => No need(component scan)

//Enable auto-configuration of the Spring Application Context, attempting to guess and configure beans that you are likely to need. Auto-configuration classes are usually applied based on your classpath and what beans you have defined. For example, if youhave tomcat-embedded.jar on your classpath you are likely to want a TomcatServletWebServerFactory 
//@SpringBootApplication- Indicates a configuration class that declares one or more @Bean methods and
//also triggers auto-configuration and component scanning. 
//This is a convenience annotation that is equivalent to declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
@SpringBootApplication
public class SpringBasicDiIoCComponentAutowiredPrimaryApplication {

	//	@Autowired
	//	SortAlgorithmWithExOfLooseCouplingWithDi sortAlgorithmWithExOfLooseCouplingWithDi;

	public static void main(String[] args) {

/*
applicationContext-Spring provides following two types of containers.
1. BeanFactory container 
2. ApplicationContext container.
Container will create the objects, wire them together,configure them, and manage their complete life cycle
 from creation till destruction. 
 */
		
		
ApplicationContext applicationContext = SpringApplication.run(SpringBasicDiIoCComponentAutowiredPrimaryApplication.class, args);

		
//for tight coupling example
		SortAlgorithmWithExOfTightCoupling sortAlgorithmWithExOfTightCoupling=
				new SortAlgorithmWithExOfTightCoupling();
		int[] sortednumbersByTightCouplingImpl = sortAlgorithmWithExOfTightCoupling.sort(new int[] {1,7,5,10,3});
		System.out.println("sortednumbersByTightCouplingImpl "+Arrays.toString(sortednumbersByTightCouplingImpl));

		
/*for loose coupling example.
Because service interface will use  which imlementation that is not decided the service 
class itself(SortAlgorithmWithExOfLooseCoupling) but managed from here outside who calls it
by passing new BubbleSortServiceImpl() this to service constructor */
		//basically the dependency is supplied by developer
		
				

		SortAlgorithmWithExOfLooseCoupling sortAlgorithmWithExOfLooseCoupling=
				new SortAlgorithmWithExOfLooseCoupling(new BubbleSortServiceImpl());
		int[] sortednumbersByLooseCouplingImpl = sortAlgorithmWithExOfLooseCoupling.sort(new int[] {1,7,5,10,3});
		System.out.println("sortednumbersByLooseCouplingImpl "+Arrays.toString(sortednumbersByLooseCouplingImpl));



// DI example.No Dependency is supplied by developer .Spring provides that


		System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()).contains("Bubble"));


		int[] sortednumbersByLooseCouplingImplWithDi = applicationContext.getBean(	SortAlgorithmWithExOfLooseCouplingWithDi.class).sort(new int[] {1,7,5,10,3});
		System.out.println("sortednumbersByLooseCouplingImplWithDi "+Arrays.toString(sortednumbersByLooseCouplingImplWithDi));



	}


}
