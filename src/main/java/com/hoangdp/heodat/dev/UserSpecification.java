package com.hoangdp.heodat.dev;

import java.util.Collection;

import org.springframework.data.jpa.domain.Specification;

import com.hoangdp.heodat.dev.User.UserType;

public final class UserSpecification {
    public static Specification<User> hasType(UserType type) {
        return (root, query, cb) -> cb.equal(root.get(User_.TYPE), type);
    }

    public static Specification<User> hasId(long userId) {
        return (root, query, cb) -> cb.equal(root.get(User_.ID), userId);
    }

    public static Specification<User> hasIdIn(Collection<Long> userIds) {
        return (root, query, cb) -> root.get(User_.ID).in(userIds);
    }
}
