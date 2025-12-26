package com.example.demo.service;

import com.example.demo.model.PersonProfile;
import java.util.List;

public interface PersonProfileService {
    PersonProfile createProfile(PersonProfile profile);
    PersonProfile updateProfile(Long id, PersonProfile profile);
    PersonProfile getProfileById(Long id);
    List<PersonProfile> getAllProfiles();
}
