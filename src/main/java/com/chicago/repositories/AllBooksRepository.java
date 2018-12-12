package com.chicago.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chicago.models.Book;

@Repository
public interface AllBooksRepository extends CrudRepository<Book,Integer> {

	
}
