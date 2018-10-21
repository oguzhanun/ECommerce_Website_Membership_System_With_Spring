package com.oguzhanun.al_solucan_gubresi.config;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private DataSource comboPooledDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
									 .withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
									 .withUser(users.username("adam").password("test123").roles("EMPLOYEE", "ADMIN"));
		*/
		
		auth.jdbcAuthentication().dataSource(comboPooledDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//add your custom encoding filter as the first filter in the chain
        http.addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class);
        
        /*The ordering of antMatchers is important. You should list the most specific url
        patterns first and then add the more general patterns later. If you don't follow this
        approach, then you will not have proper access restrictions.
        */
		http.authorizeRequests()
					//.anyRequest().authenticated()
					.antMatchers("/uyeGirisi").hasRole("USER")//anonymous()//permitAll()//.hasRole("EMPLOYEE")
					//.antMatchers("/leaders/**").hasRole("MANAGER")
					//.antMatchers("/systems/**").hasRole("ADMIN")
					.and().formLogin()
					.loginPage("/uyeGirisSayfasi")
					//.defaultSuccessUrl("/uyeGirisi").usernameParameter("username").passwordParameter("password")
					.loginProcessingUrl("/authenticateTheUser")
					.successForwardUrl("/uyeGirisi")
					.permitAll()
					.and().logout()
					//.logoutSuccessUrl("/uyeGirisSayfasi")
					.permitAll()
					.and().exceptionHandling().accessDeniedPage("/accessDenied-page")
					//.and().csrf().disable()
		            ;
	}

	/*In our security configuration file, DemoSecurityConfig.java, we create a JDBC
	User Details Manager bean. This is based on our security datasource. It provides
	access to the database for creating users. We'll also use
	JdbcUserDetailsManager to check if a user exists.
	The JdbcUserDetailsManager has all of the low-level JDBC code for accessing
	the security database. There is no need for us to create the JDBC code ...
	JdbcUserDetailsManager will handle it for us*/
	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(comboPooledDataSource);
		
		return jdbcUserDetailsManager;
	}
}
