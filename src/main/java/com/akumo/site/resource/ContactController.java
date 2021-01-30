package com.akumo.site.resource;

import com.akumo.site.resource.model.ContactDto;
import com.akumo.site.resource.model.EmailDto;
import com.akumo.site.service.ContactService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/contact", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String saveContact(@RequestBody ContactDto contact) throws IOException, URISyntaxException {
        log.info(String.format("saving: %s", contact.toString()));
        contactService.saveOrUpdate(contact);
        return contact.getId();

    }


    @GetMapping("/contact/{id}")
    private ContactDto getById(@PathVariable(name = "id") long id) {
        var opt = contactService.getById(id);
        if (opt.isEmpty()) {
            return new ContactDto();

        } else {
            var contact = opt.get();
            return ContactDto.of(contact.getId(), contact.getEmail(), contact.getName(), contact.getSubject(), contact.getMessage());

        }

    }

    @GetMapping("/contact")
    private List<ContactDto> getContacts() {
        return contactService.getAll();

    }

    @PostMapping(value = "/email", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String saveEmail(@RequestBody EmailDto email) throws IOException, URISyntaxException {
        log.info(String.format("saving email: %s", email.toString()));
        return contactService.saveOrUpdateEmail(email);

    }

    @GetMapping("/email")
    private List<EmailDto> getEmails() throws IOException {
        return contactService.getEmails();

    }


}


