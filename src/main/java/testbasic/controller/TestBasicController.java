/**
 * This is the Spring Boot POC using Spring boot, Spring Secure, and AWS 
 */
package testbasic.controller;

import java.util.List;
import java.util.concurrent.Executor;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import paymentdata.model.Transaction;
import paymentdata.model.TransactionResponse;
import paymentdata.vantiv.AuthorizationRequest;
import paymentdata.vantiv.AuthorizationReversalRequest;
import paymentdata.vantiv.TokenizationRequest;
import testbasic.model.User;
import testbasic.repository.TestBasicRepository;
import testbasic.service.TestBasicServiceImp;

/**
 * @author x3fm
 * the main controller for apis gateway
 * this controller handles all HTTP request from path /api/v1
 */
@RestController
@RequestMapping("/api/v1")
public class TestBasicController extends AbstractTestBasicController{
	
	@Autowired 
	private TestBasicServiceImp testService;
	
	@Autowired
	private TestBasicRepository repository;
	
	/**
	 * test Spring interceptor
	 */
	
	/**
	 * test connection
	 */
	@RequestMapping(value = "/greetings") 
	public String greetings() {
		return "Hello from TestBasic!";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET) 
	public List<User> getAllUser() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User inputUser) {
		if(inputUser != null) {
			System.out.println("UserID: " + inputUser.getId());
			System.out.println("userName: " + inputUser.getUserName());
			System.out.println("password: " + inputUser.getPassword());
		}
		//test interception
//		ServletContext testContext = context.getServletContext();
//		Executor executor = new Executor() {
//			
//			@Override
//			public void execute(Runnable command) {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		//ExecutorCompletionService<User>  isCompleted = new ExecutorCompletionService<>(executor, completionQueue;
		
		System.out.println("*********Create user*******");
		return repository.saveAndFlush(inputUser);
	}
	
	@RequestMapping(value = "/users/{id}", 
				method = RequestMethod.GET,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public User get(@PathVariable Long id) {
		System.out.println("***********get user by id:*************");
		User result = repository.findOne(id);
		return result;
	}
	
	@RequestMapping(value = "/users/{id}",
				method = RequestMethod.PUT,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public User update(@PathVariable Long id, @RequestBody User user2) {
		User needUpdateUser = repository.findOne(id);
		BeanUtils.copyProperties(user2, needUpdateUser);
		return repository.saveAndFlush(needUpdateUser);
	}	
	
	@RequestMapping(value = "/users/{id}",
					method = RequestMethod.DELETE,
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE
					)
	public User delete (@PathVariable Long id) {
		User existingUser = repository.findOne(id);
		repository.delete(existingUser);
		return existingUser;
	}
				
	
	/**
	 * get list of transactions
	 */
	@RequestMapping(value   = "/transactions",
					method  = RequestMethod.GET,
					consumes	= MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaction>> getListTransaction() {
		return ResponseEntity.ok().body(testService.getListOfTransaction());
	}
	
	/**
	 * create Authorization code
	 */
	@RequestMapping(value  = "/authorizations",
					method = RequestMethod.POST,
					consumes	= MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> authorization(@RequestBody AuthorizationRequest authRequest) {
		return testService.authorization(authRequest);
	}
	
	/**
	 * create High value token 
	 * test adding 
	 */
	@RequestMapping(value = "/tokenizations",
					method = RequestMethod.POST,
					consumes	= MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> tokenization(@RequestBody TokenizationRequest tokenRequest) {
		return testService.tokenization(tokenRequest);
	}
	
	/**
	 * create AuthorizationReversal request
	 */
	@RequestMapping(value = "/authorizationreversals",
					method = RequestMethod.POST,
					consumes	= MediaType.APPLICATION_JSON_VALUE,
					produces    = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TransactionResponse> authorizationReversal(@RequestBody AuthorizationReversalRequest reversalRequest) {
		return testService.authorizationReversal(reversalRequest);
	}
}
