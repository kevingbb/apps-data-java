package com.kevin.blair.entities;

import java.util.List;

public class PagedPeople {

    //Model Specific Properties
    public Long totalItems;
    public List<Person> people;
    public Integer totalPages;
    public Integer currentPage;

    //constructor
    public PagedPeople (){

    }

    public PagedPeople(Long totalItems, List<Person> people, Integer totalPages, Integer currentPage){
        this.totalItems = totalItems;
        this.people = people;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    //getters

    public Long getTotalItems(){
        return this.totalItems;
    }

    public List<Person> getPeople(){
        return this.people;
    }

    public Integer getTotalPages(){
        return this.totalPages;
    }

    public Integer getCurrentPage(){
        return this.currentPage;
    }

    //setters

    public void setTotalItems(Long totalItems){
        this.totalItems = totalItems;
    }

    public void setPeople(List<Person> people){
        this.people = people;
    }

    public void setTotalPages(Integer totalPages){
        this.totalPages = totalPages;
    }

    public void setCurrentPage(Integer currentPage){
        this.currentPage = currentPage;
    }

}
