package com.example.demo.serializers;

import com.example.demo.entities.Account;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class AccountSerializer extends JsonSerializer<Account> {

    @Override
    public void serialize(Account account, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (account != null) {
            jsonGenerator.writeString(String.valueOf(account.getId()));
        } else {
            jsonGenerator.writeString("");
        }
    }
}
