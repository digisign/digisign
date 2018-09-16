package com.example.digital.controller;


import com.example.digital.entity.User;
import com.example.digital.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

     @Autowired
	 private UserService userService;


	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	/* @Autowired
	    private UserService userService;*/ //Service which will do all data retrieval/manipulation work

	    

	  //-------------------Retrieve Single User--------------------------------------------------------
	    
	    @RequestMapping(value="/user",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<User>> getUsersById(@RequestParam(name="id" ,required=false) Long id) {
	    /*	System.out.println("Fetching User with id " + id);
	    	List<User> list = new ArrayList<User>();
	    	if(id!=null) {
	    		list =  userService.getUsersById(id);
	    	}else {
	    		list = userService.getAllUsers();
	    	}
	    	
	    	if (list.isEmpty()) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
	        }*/
	      //return new ResponseEntity<List<User>>(list, HttpStatus.OK);
			return null;
	      
	    } 
	    	
	  //-------------------Retrieve All Users--------------------------------------------------------
	    
	    /*@RequestMapping(value="/user/",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<User>> listAllUsers() {
	    	List<User> list = userService.getAllUsers();
	    	if(list.isEmpty()){
	              return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	    	return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	    } */
	    
	   

	    
	  //-------------------Create a User--------------------------------------------------------
	    @RequestMapping(value="/user",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		public User save(@RequestBody User user) {
			return userService.save(user);
		}
	    
	  //------------------- Update a User --------------------------------------------------------
	    
	    @RequestMapping(value="user/{id}",method = RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> updateUser(@RequestParam(name="id" ,required=false) Long id,@RequestBody User user) {
		
	    	//userService.updateUser(user);
	    	
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	    
	  //------------------- Delete a User --------------------------------------------------------
	    
	   
	    
	    @RequestMapping(value="/user",method = RequestMethod.DELETE)
	    public ResponseEntity<User> deleteUsers(long userid) {
	    	/*System.out.println("Fetching & Deleting User with id " + userid);
	    	
	    	 //User user = userService.findByID(userid);
	         if (user == null) {
	             System.out.println("Unable to delete. User with id " + userid + " not found");
	             return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	         }
	    	//userService.softdeleteUser(user);*/
	    	return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	    } 
	    
    
	 /*   @CrossOrigin
		@RequestMapping("/login")
		public Principal user(Principal principal) {
			logger.info("user logged "+principal);
			return principal;
		}*/
	    
    /*
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUserName(), userForm.getPassword());

        return "redirect:/welcome";
    }
    
    

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    
    */

	@RequestMapping(value="/user",method = RequestMethod.GET)
	public User getUser(@QueryParam(value="email") String email) {
		return userService.getUserByEmail(email);
	}

}
