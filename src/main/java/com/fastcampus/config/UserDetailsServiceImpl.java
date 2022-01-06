package com.fastcampus.config;

import com.fastcampus.domain.Member;
import com.fastcampus.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username).get();

        if (member == null) {
            throw new UsernameNotFoundException(username + "이 H2 DB에 없네요...");
        }

        return new User(member.getUsername(), "{noop}" + member.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_" + member.getRole().toString()));
    }
}
