package com.example.digital.config;

//@Configuration
//@EnableWebSecurity
public class WebAppConfig  {
	
	/*@Autowired
	private UserDetailsService userDetailsService;*/
	
/*	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
		
	        return new  BCryptPasswordEncoder();
	    }*/
	 /*
	 @Bean
	 public IInstitutionService iInstitutionService() {
		return iInstitutionService();
		 
	 }*/
	 
	 /*   @Bean
		@Override
		 public AuthenticationManager authenticationManagerBean() throws Exception {
		      return super.authenticationManagerBean();
		}  */
		
	 
	 
/*	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .requestMatchers().antMatchers("/").and()
	                .authorizeRequests()
	                    .antMatchers("/api/file/**", "/user1/**","/app1/**","/**").permitAll()
	                    .anyRequest().authenticated();
	        
	                  *//*  .and()
	                .formLogin()
	                    .loginPage("/login")	
	                    .permitAll()
	                    .and()
	                .logout()
	                    .permitAll();*//*
	    }*/

	 /*   @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        //auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	        //auth.inMemoryAuthentication().withUser("john123").password("password").roles("USER");
	    }
	*/
	/*
	
	@Bean
	@Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
	      return super.authenticationManagerBean();
	}  
	
	@Bean
	public IContactAddressDao ContactAddressDao() {
		return ContactAddressDao();
	}

	
	
	 @Autowired
		@Qualifier("userDetailsService")
		private UserDetailsService userDetailsService;
		
		@Autowired
	    private DataSource dataSource;
		
		
		private final String USER_QUERY="select username,password,enable from user where username=?";
		private final String ROLES_QUERY="select * from user u inner join user_role ur on (u.userId=ur.User_Id)  inner join"
				+ "role r on (ur.role_Id=r.roleid where u.username=?)";
		
		@Autowired
		private AuthenticationManager authenticationManager;
		
		@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
		   @Override
		   public AuthenticationManager authenticationManagerBean() throws Exception {
		       return super.authenticationManagerBean();
		   }
		
		@Bean
		public UserDetailsService userDetailsService() {
		    return super.userDetailsService();
		}
		
		
	 
	 @Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth,PasswordEncoder passwordEncoder) throws Exception {
		 System.out.println("**configure global");
	 auth.userDetailsService(userDetailsService);
	 auth.jdbcAuthentication()
	 .usersByUsernameQuery(USER_QUERY)
	 .authoritiesByUsernameQuery(ROLES_QUERY)
	 .dataSource(dataSource)
	 .passwordEncoder(bCryptPasswordEncoder);
	 }
*/	 }
