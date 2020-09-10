package kea.mara.demo.repository;

import kea.mara.demo.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepository implements IMemberRepository {

    List<Member> members;

    public MemberRepository(){
        this.members = new ArrayList<>();
        this.members.add(new Member("mads@rasted.dk", "1234"));
        this.members.add(new Member("nick@larsen.dk", "1234"));

    }
    @Override
    public boolean create(Member m) {
        return false;
    }

    @Override
    public Member read(String email) {
        return null;
    }

    @Override
    public List<Member> readAll() {
        return this.members;
    }
}
