package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository;

import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonPage;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public PersonCriteriaRepository(EntityManager entityManager){
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    //Pagination and Filtering
    public Page<Person> findAllWithFilters(PersonPage personPage, PersonSearchCriteria personSearchCriteria){

        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class); //We get all the rows of the table to compare with
        Predicate predicate = getPredicate(personSearchCriteria, personRoot);
        criteriaQuery.where(predicate);

        setOrder(personPage, criteriaQuery, personRoot); //To set the order criteria

        TypedQuery<Person> typedQuery = entityManager.createQuery(criteriaQuery); //Made the query, and then change the first and max results
        typedQuery.setFirstResult(personPage.getPageNumber() * personPage.getPageSize());
        typedQuery.setMaxResults(personPage.getPageSize());

        Pageable pageable = getPageable(personPage); //To configure the page

        long personCount = getPersonCount(predicate); //get total entries with the filters

        //List<PersonOutputDto> personOutputDtoList = typedQuery.getResultList().stream().map(PersonOutputDto::new).collect(Collectors.toList());

        return new PageImpl<>(typedQuery.getResultList(), pageable, personCount);
    }

    private Predicate getPredicate(PersonSearchCriteria personSearchCriteria, Root<Person> personRoot) {

        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(personSearchCriteria.getUsername())){
            predicates.add(criteriaBuilder.like(personRoot.get("username"), "%" + personSearchCriteria.getUsername() + "%"));
        }
        //Si no queremos que coincida por letras sería simplement sin los "%": personSearchCriteria.getUsername(), como segundo argumento del método like.
        if(Objects.nonNull(personSearchCriteria.getName())){
            predicates.add(criteriaBuilder.like(personRoot.get("name"), "%" + personSearchCriteria.getName() + "%"));
        }
        if(Objects.nonNull(personSearchCriteria.getSurname())){
            predicates.add(criteriaBuilder.like(personRoot.get("username"), "%" + personSearchCriteria.getSurname() + "%"));
        }
        if(Objects.nonNull(personSearchCriteria.getCreated_date())){

            if(personSearchCriteria.getDateCriteria() != null) {
                if (personSearchCriteria.getDateCriteria().equals("prev"))
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(personRoot.get("created_date"), personSearchCriteria.getCreated_date()));
            }
            else
                predicates.add(criteriaBuilder.lessThan(personRoot.get("created_date"), personSearchCriteria.getCreated_date()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0])); //merges all the predicates into one
    }

    private void setOrder(PersonPage personPage, CriteriaQuery<Person> criteriaQuery, Root<Person> personRoot) {
        criteriaQuery.orderBy(criteriaBuilder.asc(personRoot.get(personPage.getSortBy())));
    }

    private Pageable getPageable(PersonPage personPage) {
        Sort sort = Sort.by(personPage.getSortDirection(), personPage.getSortBy());
        return PageRequest.of(personPage.getPageNumber(), personPage.getPageSize(), sort);
    }

    private long getPersonCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Person> countRoot = countQuery.from(Person.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);

        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
