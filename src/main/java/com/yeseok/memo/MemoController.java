package com.yeseok.memo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/memos")
@RestController
public class MemoController {

   private final List<Memo> memos = new ArrayList<>();
   private Long memoId = 0L;

   @GetMapping
   public List<Memo> getMemos () {
      return memos;
   }

   @PostMapping
   public Memo post(@RequestBody MemoRequest request) {
      Memo memo = new Memo(memoId++, request.content());
      memos.add(memo);
      return memo;
   }

   @PutMapping("/{id}")
   public Memo updateMemo (@PathVariable Long id, @RequestBody MemoRequest request) {

      for(Memo memo: memos) {
         if(memo.getId().equals(id) ) {
            memo.setContent(request.content());
            return memo;
         }
      }

      throw new RuntimeException("Memo not found: " + id);
   }

   @DeleteMapping("/{id}")
   public void deleteMemo (@PathVariable Long id) {

      boolean removed = memos.removeIf(memo -> memo.getId().equals(id));

      if(!removed) {
         throw new RuntimeException("Memo not found: " + id);
      }

   }


   public record MemoRequest (String content) {

   }

}
