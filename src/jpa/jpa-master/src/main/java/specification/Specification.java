package specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Specification<T> {
    Predicate toPredicate(Root<T> tRoot, CriteriaBuilder criteriaBuilder);
    Class<T> getType();
}
