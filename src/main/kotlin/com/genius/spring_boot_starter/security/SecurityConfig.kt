package com.genius.spring_boot_starter.security

import jakarta.servlet.http.HttpFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

/**
 * 
 * Author: Thulasi rajan 
 * Github: (https://github.com/itsgeniuS)
 * Created on: 08/06/25
 *
 **/
 
@Configuration
class SecurityConfig {
	
	@Bean
	fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
		return httpSecurity
			.csrf { csrf -> csrf.disable() }
			.sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
//			.authorizeHttpRequests { auth ->
//				auth
//					.requestMatchers("/")
//					.permitAll()
//					.requestMatchers("/auth/**")
//					.permitAll()
//					.dispatcherTypeMatchers(
//						DispatcherType.ERROR,
//						DispatcherType.FORWARD
//					)
//					.permitAll()
//					.anyRequest()
//					.authenticated()
//			}
//			.exceptionHandling { configurer ->
//				configurer
//					.authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//			}
//			.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter::class.java)
			.build()
	}

}
