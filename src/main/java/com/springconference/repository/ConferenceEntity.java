package com.springconference.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "conferences")
public class ConferenceEntity {

    @Id
    public Integer id;
    public String name;
    public String place;

}
