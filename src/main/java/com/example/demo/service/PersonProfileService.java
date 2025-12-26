package com.example.demo.service;

import com.example.demo.model.PersonProfile;
import java.util.List;

public interface PersonProfileService {
    List<PersonProfile> getAllProfiles();
    PersonProfile createProfile(PersonProfile p);
    PersonProfile updateProfile(Long id, PersonProfile p);
    void deleteProfile(Long id);
}
