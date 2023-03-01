package com.tga105.forum.Repository;

import com.tga105.forum.Enity.ReplyEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEnity,Integer> {


}
