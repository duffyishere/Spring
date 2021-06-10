package org.duffy.mapper;

import org.duffy.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {

	public MemberVO read(String userid);
}
