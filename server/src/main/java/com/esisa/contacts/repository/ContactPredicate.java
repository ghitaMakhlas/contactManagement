package com.esisa.contacts.repository;

import com.esisa.contacts.domain.QContact;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
public class ContactPredicate {
	
	public static Predicate findBySearchCriteria(
			String firstName,
			String lastName,
			String email,
			String graduationYear,
			String companyPosition
			) {
		QContact qContact = QContact.contact;
		BooleanBuilder builderSearchCriteria = new BooleanBuilder();
		if(!"".equals(firstName) && null != firstName) builderSearchCriteria.and(qContact.firstName.contains(firstName));
		if(!"".equals(lastName) && null != lastName) 
			builderSearchCriteria.and(qContact.lastName.contains(lastName));
		if(!"".equals(email) && null != email) builderSearchCriteria.and(qContact.email.contains(email));
		if(!"".equals(graduationYear) && null != graduationYear) builderSearchCriteria.and(qContact.graduationYear.contains(graduationYear));
		if(!"".equals(companyPosition) && null != companyPosition) builderSearchCriteria.and(qContact.companyPosition.contains(companyPosition));
	
		BooleanExpression searchContact = qContact.in(JPAExpressions
				.select(qContact)
				.from(qContact)
	            .where(builderSearchCriteria)
	            );
		BooleanBuilder builderContact = new BooleanBuilder();
		builderContact.and(searchContact);
        return builderContact;
	}

}
