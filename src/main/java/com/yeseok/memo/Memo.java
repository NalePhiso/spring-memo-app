package com.yeseok.memo;

public class Memo {

    private Long id;
    private String content;

    public Memo (long id, String content) {
        this.id = id;
        this.content = content;
    }


    public Long getId(){
        return id;
    }

    public String getContent(){
        return content;
    }


    public void setId(Long setId) {
        this.id = setId;
    }

    public void setContent(String setContent) {
        this.content = setContent;
    }


}
