package miu.edu.cs545assignment.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import miu.edu.cs545assignment.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryDao {

    private final EntityManager em;

    public List<User> findUsersWithPostsContainingTitleKeyword(String titleQuery) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        List<Predicate> predicates = new ArrayList<>();

        Root<User> user = cq.from(User.class);
        predicates.add(cb.like(cb.lower(user.get("posts").get("title")), "%" + titleQuery.toLowerCase() + "%"));
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}
