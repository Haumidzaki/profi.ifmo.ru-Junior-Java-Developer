package specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TwoSpecification<T> extends AbstractSpecification<T> {
    private Specification<T> first;
    private Specification<T> second;

    public TwoSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    public Predicate toPredicate(Root<T> tRoot, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(
                first.toPredicate(tRoot, criteriaBuilder),
                second.toPredicate(tRoot, criteriaBuilder)
        );
    }

    @Override
    public Class<T> getType() {
        return first.getType();
    }
}
