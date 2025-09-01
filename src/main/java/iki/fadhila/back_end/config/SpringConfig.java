package iki.fadhila.back_end.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SpringConfig {

    private UserDetailsService userDetailsService;

   @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
       return configuration.getAuthenticationManager();
    }

   @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) -> {
              /*     requests.requestMatchers(HttpMethod.POST,"/auth/**").permitAll();
                   requests.requestMatchers(HttpMethod.POST,"/employees/**").hasRole("ADMIN");
                   requests.requestMatchers(HttpMethod.GET,"/employees/**").hasAnyRole("ADMIN","USER");
                   requests.requestMatchers(HttpMethod.PUT,"/employees/**").hasRole("ADMIN");
                   requests.requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN");
                    requests.requestMatchers(HttpMethod.POST,"/roles/**").hasRole("ADMIN");
                    requests.requestMatchers(HttpMethod.GET,"/roles/**").hasAnyRole("ADMIN","USER");
                    requests.requestMatchers(HttpMethod.PUT,"/roles/**").hasRole("ADMIN");
                    requests.requestMatchers(HttpMethod.DELETE,"/roles/**").hasRole("ADMIN");
                    requests.requestMatchers(HttpMethod.POST,"/salaries/**").hasRole("ADMIN");
                    requests.requestMatchers(HttpMethod.GET,"/salaries/**").hasAnyRole("ADMIN","USER");
                    requests.requestMatchers(HttpMethod.PUT,"/salaries/**").hasRole("ADMIN");
                    requests.requestMatchers(HttpMethod.DELETE,"/salaries/**").hasRole("ADMIN"); */
                    requests.requestMatchers("/auth/**").permitAll();
                    requests.anyRequest().authenticated();
        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }
/*
  @Bean
  public UserDetailsService userDetailsService(){

      UserDetails admin=User.builder().username("admin")
              .password(passwordEncoder().encode("1234"))
              .roles("ADMIN")
              .build();

      UserDetails user=User.withUsername("user")
              .password(passwordEncoder().encode("1234"))
              .roles("USER")
              .build();

      return new InMemoryUserDetailsManager(user,admin);
  }
  */

}
