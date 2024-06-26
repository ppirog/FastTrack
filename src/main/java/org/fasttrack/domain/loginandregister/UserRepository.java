package org.fasttrack.domain.loginandregister;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Transactional
    @Modifying
    @Query("delete from User u where u.username = ?1")
    void deleteByUsername(String username);

    default void updateIsAdminByUsername(String username, boolean isAdmin) {
        Optional<User> optionalUser = findByUsername(username);
        optionalUser.ifPresent(
                user -> {
                    User a = User.builder()
                            .username(user.getUsername())
                            .password(user.getPassword())
                            .isAdmin(isAdmin)
                            .build();
                    delete(user);
                    save(a);
                });
    }
}