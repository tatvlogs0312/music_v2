package com.example.music.configuration;

import com.example.music.service.custom.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomUserDetailsService userService;

  public SecurityConfig(CustomUserDetailsService userService) {
    this.userService = userService;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    auth.setUserDetailsService(userService);
    auth.setPasswordEncoder(passwordEncoder());
    return auth;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
//        .antMatchers(
//            "/css/**",
//            "/image/**",
//            "/js/**",
//            "/mp3/**",
//            "/albums/**",
//            "/api/v1/**",
//            "/artist/**",
//            "/error/**",
//            "/",
//            "/login/**",
//            "/music/**",
//            "/register/**",
//            "/reset/**",
//            "/search/**")
//        .permitAll()
//        .antMatchers("/*")
//        .permitAll()
        .antMatchers("/change/**")
        .authenticated()
        .anyRequest()
        .permitAll()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        //        .logoutSuccessUrl("/login?logout")
        .logoutSuccessUrl("/")
        .permitAll();
    http.csrf().disable();
  }
}
