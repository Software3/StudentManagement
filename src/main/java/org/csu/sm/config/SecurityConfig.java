package org.csu.sm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

/**
 * Created by lenovo on 2017/8/10.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/studentmanagement");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select student_id,password ,true from signon where student_id=?")
                .authoritiesByUsernameQuery("select student_id,authorities from signon where student_id=?");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/").access("hasRole('USER')")
                .antMatchers("/basicInfo").access("hasRole('USER')")
                .antMatchers("/parentsInfo").access("hasRole('USER')")
                .antMatchers("/awardSitu").access("hasRole('USER')")
                .antMatchers("/failexamSitu").access("hasRole('USER')")
                .antMatchers("/withdrawInst").access("hasRole('USER')")
                .antMatchers("/addAward").access("hasRole('USER')")
                .antMatchers("/teacherhome").access("hasRole('ADMIN')")
                .antMatchers("/teacherBasicInfo").access("hasRole('ADMIN')")
                .antMatchers("/verify").access("hasRole('ADMIN')")
                .antMatchers("/auditedLog").access("hasRole('ADMIN')")
                .antMatchers("/auditInformation").access("hasRole('ADMIN')")
                .antMatchers("/studentInformation").access("hasRole('ADMIN')")
                .antMatchers("/studentList").access("hasRole('ADMIN')")
                .antMatchers("/auditInformationModifiable").access("hasRole('ADMIN')")
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/signin")
                .and().csrf().disable();
    }
}
