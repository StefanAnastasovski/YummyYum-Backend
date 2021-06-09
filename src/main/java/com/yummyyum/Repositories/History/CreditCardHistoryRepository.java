package com.yummyyum.Repositories.History;

import com.yummyyum.Model.History.CreditCardHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CreditCardHistoryRepository extends JpaRepository<CreditCardHistory, Long> {

    @Query(value = "SELECT * FROM credit_card_history as cch JOIN user as u on u.id = cch.user_id WHERE u.username = :username",
            nativeQuery = true)
    List<CreditCardHistory> getCreditCardHistoriesByUsername(String username);

}
