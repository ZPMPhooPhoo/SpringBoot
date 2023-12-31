package com.turingjavaee7.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.model.Store;
import com.turingjavaee7.demo.sevice.ArithmeticService;
import com.turingjavaee7.demo.sevice.PrototypeService;
import com.turingjavaee7.demo.sevice.impl.ExampleBean;
import com.turingjavaee7.demo.sevice.impl.HelloMessageGenerator;
import com.turingjavaee7.demo.sevice.impl.PrototypeBean;
import com.turingjavaee7.demo.sevice.impl.PrototypeDemo;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	/*Test1
	@Autowired
	ArithmeticService arithService;
	
	@GetMapping("/")
	String home()
	{
//		log.info("Get /");
		log.info("Get/" + arithService.add(1, 2));
		return "home";
	}
	*/
	

	/*Test2__Singleton
	@Autowired
	ExampleBean exampleBean;
	public HomeController() {
		log.info("Home Controller created");
	}
	*/
	
	
	/*Test3__ConstructorBasedInjection
	public HomeController(ExampleBean exampleBean) {
		log.info("Home Controller created");
	}
	*/
	
	
	/*Test4__SetterBasedInjection
	 private ArithmeticService arithmeticService;
	 public void setArithmeticService(ArithmeticService arithService)
	 {
		 log.info("Setter injected for Arithmetic Service");
		 this.arithmeticService = arithService;
	 }
	 @GetMapping("/")
		String home()
		{
		 log.info("Get/" + arithmeticService.add(1, 2));
			return "home";
		}
	*/
	
	
	/*Test5__DependencyResolutionProcess
	@Autowired
	@Qualifier("arithTwo")
	private ArithmeticService arithmeticService;
	
	@GetMapping("/")
	String home()
	{
		log.info("Get/" + arithmeticService.add(1, 2));
		return "home";
	}
	*/
	
	/*Test6__BeanScope
	int a;
	public HomeController(ExampleBean exampleBean) {
		log.info("Home Controller created");
	}
	@GetMapping("/")
	String home()
	{
		log.info("Home Controller /" + this.a);
		a++;
		try {
			Thread.sleep(1000); //
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "home";
	}
	*/
	
	/*Test7__PrototypeBean
	public HomeController(ExampleBean exampleBean) {
		log.info("Home Controller created");
	}
	@Autowired
	PrototypeService prototypeService;
	@GetMapping("/")
	String home()
	{
		new PrototypeDemo().getPrototype();
		log.info("Home Controller /" + this);
		return "home";
	}
	*/
	
	/*Test8__RequestScope
	@Resource(name = "requestScopedBean")
	HelloMessageGenerator requestScopedBean;
	
	public HomeController(ExampleBean exampleBean)
	{
		log.info("Home Controller created");
	}
	
	@GetMapping("/")
	String home()
	{
		new PrototypeDemo().getPrototype();
		log.info("Home Controller /" + this);
		return "home";
	}
	
	@GetMapping("/scopes/request")
	public String getRequestScopeMessage(final Model model) {
		log.info("HelloMessage Generator "+ this.requestScopedBean);
		model.addAttribute("previousMessage", requestScopedBean.getMessage());
		requestScopedBean.setMessage("Good Morning");
		model.addAttribute("currentMessage", requestScopedBean.getMessage());
		return "scopesExample";
	}
	*/
	
	/*Test9__ApplicationScope
	@GetMapping("/")
	String home()
	{
		try {
			log.info("Handleby thread "+ Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Home Controller /" + this);
		return "home";
	}
	
	@Resource(name="appScopedBean")
	HelloMessageGenerator appScopedBean;
	
	@GetMapping("/scopes/application")
	public String getApplicationScopeMessage(final Model model) {
		log.info("HelloMessage Generator "+ this.appScopedBean);
		model.addAttribute("previousMessage", appScopedBean.getMessage());
		appScopedBean.setMessage("Good Afternoon");
		model.addAttribute("currentMessage", appScopedBean.getMessage());
		return "appScopedBean";
	}
	*/
	
	/*
	@Value("${catalog.name}") String catalog;
	@Autowired
	Store<Integer> integerStore;
	@GetMapping("/catalog")
	String home()
	{
		log.info("Catalog "+catalog);
		return "home";
	}
	*/
	
	@GetMapping("/api")
	@ResponseBody ShoppingCart getShoppingCart()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart("Item One");
		cart.addToCart("Item Two");
		return cart;
	}
	
	@GetMapping("/search")
	public String search(@RequestParam String query)
	{
		log.info("Query "+query);
		return "scopesExample";
	}
	
	@GetMapping("/hello")
	String hello()
	{
		return "hello";
	}
	
	@GetMapping("/throw")
	String throwException() throws Exception
	{
		throw new Exception("Just throw");
	}
	
}
