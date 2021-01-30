package com.akumo.site.resource.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter
@Setter
public class EmailDto {

    private String email;

    @Override
    public String toString() {
        return String.format("{\"email\":\"%s\"}\n", this.email);
    }

}