package com.upn.PJ_TIENDA.security;

import javax.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/auth/**","/registro/**", "/index", "/css/**", "/js/**", "/img/**").permitAll()
                .anyRequest().authenticated()
          .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/index",true).failureUrl("/login?error=true")
                .loginProcessingUrl("/login-post").permitAll()
          .and()
//                .logout(logout -> logout
//            .logoutUrl("/cookies/cookielogout")
//            .addLogoutHandler((request, response, auth) -> {
//                for (Cookie cookie : request.getCookies()) {
//                    String cookieName = cookie.getName();
//                    Cookie cookieToDelete = new Cookie(cookieName, null);
//                    cookieToDelete.setMaxAge(0);
//                    response.addCookie(cookieToDelete);
//                }
//            })
//          );
                .logout()
                .logoutUrl("/logout").logoutSuccessUrl("/index");
               
        
                
    }

    
    
    
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(service).passwordEncoder(cripto);
//    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("admin"));
//        return encoder;
//    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests().antMatchers("/", "/index", "/css/**", "/js/**", "/img/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/").invalidateHttpSession(true).permitAll();
//
//  


}

