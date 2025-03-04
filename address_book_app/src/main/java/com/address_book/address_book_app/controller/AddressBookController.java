package com.address_book.address_book_app.controller;

import com.address_book.address_book_app.dto.AddressBookDTO;
import com.address_book.address_book_app.service.AddressBookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getContactById(@PathVariable Long id) {
        return service.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddressBookDTO> addContact(@RequestBody AddressBookDTO contactDTO) {
        return ResponseEntity.ok(service.addContact(contactDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBookDTO> updateContact(@PathVariable Long id, @RequestBody AddressBookDTO contactDTO) {
        return service.updateContact(id, contactDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        return service.deleteContact(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
