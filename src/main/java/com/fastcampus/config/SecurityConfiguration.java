package com.fastcampus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // SpringBootWebSercurityConfiguration, WebSecurityEnablerConfiguration
    // 두개를 비활성화 해야 스프링 부트가 제공하는 시큐리팅을 커스텀 가능
}
