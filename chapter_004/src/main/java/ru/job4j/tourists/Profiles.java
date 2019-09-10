package ru.job4j.tourists;

import ru.job4j.tourists.model.Address;
import ru.job4j.tourists.model.Profile;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Profiles
 *
 * @author Petr B.
 * @since 09.09.2019, 14:09
 */
public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted((profile1, profile2) -> profile1.getCity().compareTo(profile2.getCity()))
                .distinct().collect(Collectors.toList());
    }
}
