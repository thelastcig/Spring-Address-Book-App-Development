package com.address_book.address_book_app.repository;


import com.address_book.address_book_app.model.AddressBookEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookEntry, Long> {
}
