package com.fastcampus.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class I18nConfiguration implements WebMvcConfigurer {
    @Bean // 한글이 깨질 때
    public FilterRegistrationBean<CharacterEncodingFilter> encodingFilterBean() {
        FilterRegistrationBean<CharacterEncodingFilter> registerBean = new FilterRegistrationBean<>();
        CharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
        filter.setEncoding("EUC-KR");
        registerBean.setFilter(filter);
        registerBean.addUrlPatterns("/board/*");
        return registerBean;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message.messageSource");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() { return new SessionLocaleResolver(); }

    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChange = new LocaleChangeInterceptor();
        localeChange.setParamName("lang");
        return localeChange;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) { registry.addInterceptor(localeChangeInterceptor()); }
}
