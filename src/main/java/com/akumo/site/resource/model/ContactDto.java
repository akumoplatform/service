package com.akumo.site.resource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ContactDto {

    @JsonIgnore
    private String id;

    private String email;

    private String name;

    private String subject;

    private String message;

    @Override
    public String toString(){
        return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"email\":\"%s\",\"subject\":\"%s\",\"message\":\"%s\"}",
                this.id, this.name, this.email, this.subject, this.message);
    }

}
