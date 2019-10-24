package ru.job4j.mail;

import ru.job4j.mail.model.User;

import java.util.*;

/**
 * Class MergeUsers
 *
 * @author Petr B.
 * @since 24.10.2019, 11:18
 */
public class MergeUsers {
    public List<User> merge(List<User> users) {
        List<User> result = users;
        Iterator<User> it = users.iterator();
        int needDel = 0;
        while (it.hasNext()) {
            User to = it.next();
            if (needDel == to.getId()) {
                it.remove();
            }
            for (User from : result) {
                if (to.getId() != from.getId()) {
                    Set<String> emaitTo = to.getEmail();
                    if (emaitTo.removeAll(from.getEmail())) {
                        emaitTo.addAll(from.getEmail());
                        needDel = from.getId();
                    }
                }
            }

        }
        return result;
    }
}
