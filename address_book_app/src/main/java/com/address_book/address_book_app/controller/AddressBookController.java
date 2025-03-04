package com.address_book.address_book_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @GetMapping
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("Fetching all contacts");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok("Fetching contact with ID: " + id);
    }

    @PostMapping
    public ResponseEntity<String> addContact() {
        return ResponseEntity.ok("Adding new contact");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id) {
        return ResponseEntity.ok("Updating contact with ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        return ResponseEntity.ok("Deleting contact with ID: " + id);
    }
}

