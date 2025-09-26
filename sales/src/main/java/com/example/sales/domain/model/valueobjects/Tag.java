package com.example.sales.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Tag {
    private String tag;

    public Tag(){}
    public Tag(String tag){this.tag = tag;}

    public String getTag(){return this.tag;}

    public void setTag(String tag){this.tag = tag;}
    
}
