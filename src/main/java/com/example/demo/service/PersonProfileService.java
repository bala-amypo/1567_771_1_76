List<PersonProfile> getAllProfiles();
PersonProfile getProfileById(Long id);
PersonProfile createProfile(PersonProfile p);
PersonProfile updateProfile(Long id, PersonProfile p);
void deleteProfile(Long id);
package com.example.demo.service;

import com.example.demo.model.PersonProfile;
import java.util.List;

public interface PersonProfileService {
    List<PersonProfile> getAllProfiles();
    PersonProfile getProfileById(Long id);
    PersonProfile createProfile(PersonProfile profile);
    PersonProfile updateProfile(Long id, PersonProfile profile);
    void deleteProfile(Long id);
}
