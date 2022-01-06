package com.fastcampus.service;

import com.fastcampus.domain.Member;
import com.fastcampus.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// 스프링 시큐리티를 이용해서 로그인 인증기능을 구현한 상태이기 때문에 MemberRepository, MemberService, MemberServiceImpl은 사용하지 않는 상태다.
@Service
public class MemberServiceImpl implements MemberService{

    // 스프링부트가 만들어준 BoardRepository 타입의 객체를 의존성 주입한다.
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member getMember(Member member) {
        // Repository를 이용하여 상세 정보를 조회한다.
        Optional<Member> optional = memberRepository.findById(member.getUsername());
        if(!optional.isEmpty()) {
            return optional.get();
        } else {
            return null;
        }
    }
}
