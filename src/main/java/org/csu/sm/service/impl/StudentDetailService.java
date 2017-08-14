package org.csu.sm.service.impl;

import org.csu.sm.domain.Signon;
import org.csu.sm.persistence.SignonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GF on 2017/8/13.
 */
@Service("studentDetailService")
public class StudentDetailService implements UserDetailsService{
    @Autowired
    SignonDAO signonDAO;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Signon signon=signonDAO.getSignon(Long.valueOf(s));
       if(signon==null){
           System.out.print("signon not found");
           throw new UsernameNotFoundException("signon not found");
       }else{
            return new org.springframework.security.core.userdetails.User(Long.toString(signon.getStudentId()),signon.getPassword(),getAuthorities(signon));
       }
    }

    public List<GrantedAuthority> getAuthorities(Signon signon){
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        GrantedAuthority authority=new SimpleGrantedAuthority(signon.getAuthorities());
        authorities.add(authority);
        return authorities;
    }
}
