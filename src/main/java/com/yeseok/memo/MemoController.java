package com.yeseok.memo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/memos")
public class MemoController {

   private final List<Memo> memos = new ArrayList<>();
   private long nextId = 1;

   @GetMapping
    public List<Memo> getMemos() {
       return memos;
   }

   @PostMapping
    public Memo createMemo(@RequestBody MemoRequest request) {

       Memo memo = new Memo(nextId++, request.content());
       memos.add(memo);
       return memo;

   }

   public record MemoRequest(String content){

   }



}
