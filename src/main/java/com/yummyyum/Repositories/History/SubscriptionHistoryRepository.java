package com.yummyyum.Repositories.History;

import com.yummyyum.Model.History.SubscriptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionHistoryRepository extends JpaRepository<SubscriptionHistory, Long> {

    @Query(value = "SELECT * FROM subscription_history as sh JOIN user as u on u.id = sh.user_id WHERE u.username = :username",
            nativeQuery = true)
    List<SubscriptionHistory> getSubscriptionHistoriesByUsername(String username);

}
