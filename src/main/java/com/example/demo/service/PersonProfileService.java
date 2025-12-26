package com.example.demo.service;

import com.example.demo.model.PersonProfile;
import java.util.List;

public interface PersonProfileService {

    // Get all profiles
    List<PersonProfile> getAllProfiles();

    // Get profile by ID
    PersonProfile getProfileById(Long id);

    // Create a new profile
    PersonProfile createProfile(PersonProfile profile);

    // Update an existing profile
    PersonProfile updateProfile(Long id, PersonProfile profile);

    // Delete a profile by ID
    void deleteProfile(Long id);
}
