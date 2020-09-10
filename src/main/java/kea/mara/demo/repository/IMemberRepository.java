package kea.mara.demo.repository;

import kea.mara.demo.model.Member;

import java.util.List;

public interface IMemberRepository {

    boolean create(Member m);
    Member read(String email);
    List<Member> readAll();

}
