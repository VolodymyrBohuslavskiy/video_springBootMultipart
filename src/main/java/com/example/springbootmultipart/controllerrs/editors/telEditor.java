package com.example.springbootmultipart.controllerrs.editors;

import com.example.springbootmultipart.Services.TelService;
import com.example.springbootmultipart.models.Tel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class telEditor extends PropertyEditorSupport {

    @Autowired
    TelService telService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Tel tel = new Tel();
        tel.setNumber(text);
        telService.save(tel);
        setValue(tel);// Передати створений обєкт Tel tel в Contact
        System.out.println(text + tel);
    }
}
