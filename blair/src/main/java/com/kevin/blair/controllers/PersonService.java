package com.kevin.blair.controllers;

import java.util.ArrayList;

import com.kevin.blair.repositories.PersonRepository;
import com.kevin.blair.entities.Person;
import com.kevin.blair.entities.PagedPeople;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class PersonService 
{
    @Autowired
    PersonRepository repository;
     
    public PagedPeople getPeople(Integer page, Integer size, String sortBy)
    {
        // Need to deal with Page Offset in UI
        Integer pageOffset = page - 1;
        Pageable paging = PageRequest.of(pageOffset, size, Sort.by(sortBy));
        Page<Person> pagedResult = repository.findAll(paging);
        Long totalItems = repository.count();
        Integer totalPages = (int)Math.ceil((double)totalItems / (double)size);
         
        if(pagedResult.hasContent()) {
            return new PagedPeople(totalItems, pagedResult.getContent(), totalPages, page);
        } else {
            return new PagedPeople(totalItems, new ArrayList<Person>(), 0, 1);
        }
    }
}
