package com.example.demo.Security;

import com.example.demo.Auth.ApplicationUserService;
import com.example.demo.Jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.example.demo.User.UserPermission;
import com.example.demo.User.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder, ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

              /*  .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()*/
                .csrf().disable()//disable it when u r not actually using a browser frontend .eg postman
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(UserRole.PATIENT.name())
           /*     .antMatchers(HttpMethod.DELETE,"management/api/**").hasAuthority(UserPermission.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST,"management/api/**").hasAuthority(UserPermission.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"management/api/**").hasAuthority(UserPermission.COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"management/api/**").hasAnyRole(UserRole.ADMIN.name(),UserRole.ADMIN_TRAINEE.name())*/
                .anyRequest()
                .authenticated();
              /*  .and()
                .formLogin()
                    .loginPage("/login").permitAll() // to customize the login page our own
                    .defaultSuccessUrl("/courses",true) //when user has loged in redirect to courses page
                    .passwordParameter("password") //shld be same as the name of id of tht input field
                    .usernameParameter("username")  //shld be same as the name of id of tht input field
                .and()
                .rememberMe()  //feature to remember me ->the session is set to expire (default to 2 weeks)
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds((21))) //to  adjust ur session expiry days
                    .key("somethingverysecured") //hash
                    .rememberMeParameter("remember-me")  //shld be same as the name of id of tht input field
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID","remember-me")
                    .logoutSuccessUrl("/login");
              //  .httpBasic();  //used for the basic authentication .tht is the popup tht has username n pass*/
    }

 /*   @Bean
    @Override
    protected UserDetailsService userDetailsService() {
       UserDetails Naomi = User.builder()
                .username("Naomi")
                .password(passwordEncoder.encode("password"))
             //   .roles(UserRole.PATIENT.name()) //ROLE_PATIENT
                .authorities(UserRole.PATIENT.getGrantedAuthorities())
                .build();

        UserDetails linda = User.builder()
               .username("linda")
               .password(passwordEncoder.encode("password123"))
            //   .roles("ADMIN") //ROLE_ADMIN
                .authorities(UserRole.ADMIN.getGrantedAuthorities())
               .build();

        UserDetails tom = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password123"))
             //   .roles(UserRole.ADMIN_TRAINEE.name()) //ROLE_ADMINTRAINEE
                .authorities(UserRole.ADMIN_TRAINEE.getGrantedAuthorities())
                .build();

       return new InMemoryUserDetailsManager(Naomi,linda,tom);
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);

        return provider;
    }
}
