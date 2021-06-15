package com.qian.config;

import com.qian.entity.Permission;
import com.qian.mapper.PermissionMapper;
import com.qian.service.impl.UserServiceImpl;
import com.qian.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 后期更改为redis查询
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserServiceImpl userService;

    // 拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().formLogin();
//        http.authorizeRequests().antMatchers("/add").hasAnyAuthority("add")
//                                .antMatchers("/update").hasAnyAuthority("update")
//                                .antMatchers("/delete").hasAnyAuthority("delete")
//                                .antMatchers("/login").permitAll()
////                                .antMatchers("/**").fullyAuthenticated().and().formLogin().and().csrf().disable();
//                                .antMatchers("/**").permitAll().and().csrf().disable();
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
        List<Permission> permissionList = permissionMapper.selectList(null);
        permissionList.forEach(e->{
            // 将数据库的要拦截授权的规则添加进security中
            authorizeRequests.antMatchers(e.getPermissionUrl()).hasAnyAuthority(e.getPermissionTag());
        });
        authorizeRequests.antMatchers("/login").permitAll();
//        authorizeRequests.antMatchers("/**").fullyAuthenticated().and().formLogin().and().csrf().disable();
        authorizeRequests.antMatchers("/**").permitAll().and().csrf().disable();
    }

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("mayikt_admin").password("mayikt_admin").authorities("add","update","delete");
//        auth.inMemoryAuthentication().withUser("mayikt_add").password("mayikt_add").authorities("add");
//        auth.inMemoryAuthentication().withUser("mayikt_update").password("mayikt_update").authorities("update");
//        auth.inMemoryAuthentication().withUser("mayikt_delete").password("mayikt_delete").authorities("delete");
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String) charSequence);
//                return (String) charSequence;
            }

            @Override
            public boolean matches(CharSequence rawPassword, String s) {
                String encode = MD5Util.encode((String) rawPassword);
//                boolean equals = rawPassword.equals(s);
                boolean equals = encode.equals(s);
                return equals;

//                return rawPassword.equals(s);
            }
        });



    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
