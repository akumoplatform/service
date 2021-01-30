package com.akumo.site.service;

import com.akumo.site.domain.ContactRepository;
import com.akumo.site.domain.entities.Contact;
import com.akumo.site.resource.model.ContactDto;
import com.akumo.site.resource.model.EmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public synchronized String saveOrUpdateEmail(EmailDto email) throws URISyntaxException, IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "email.txt");
        Files.write(Paths.get(file.getAbsolutePath()), email.toString().getBytes(), StandardOpenOption.APPEND);
        return "success";

    }

    public synchronized void saveOrUpdate(ContactDto contact) throws URISyntaxException, IOException {
        contactRepository.save(Contact.builder()
                .id(UUID.randomUUID().toString())
                .email(contact.getEmail())
                .message(contact.getMessage())
                .subject(contact.getSubject())
                .name(contact.getName())
                .build());

        File file = new File(System.getProperty("user.dir") + File.separator + "bd.txt");
        Files.write(Paths.get(file.getAbsolutePath()), contact.toString().getBytes(), StandardOpenOption.APPEND);

    }

    public Optional<Contact> getById(long id) {
        return contactRepository.findById(id);

    }

    public List<ContactDto> getAll() {
        return contactRepository.findAll().stream().map(this::mapper).collect(Collectors.toList());

    }

    private ContactDto mapper(Contact contact) {
        return ContactDto.of(contact.getId(), contact.getEmail(), contact.getName(), contact.getSubject(), contact.getMessage());

    }

    public List<EmailDto> getEmails() throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "email.txt");
        String[] content = Files.readString(Paths.get(file.getAbsolutePath())).split("\n");
        return Arrays.stream(content).map(EmailDto::of).collect(Collectors.toList());

    }

}
