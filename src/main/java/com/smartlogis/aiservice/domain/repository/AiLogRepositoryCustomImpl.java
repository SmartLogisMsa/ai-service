package com.smartlogis.aiservice.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartlogis.aiservice.domain.AiLog;
import com.smartlogis.aiservice.domain.QAiLog;
import com.smartlogis.aiservice.domain.dto.AiLogSearch;
import com.smartlogis.common.utils.QuerydslSortUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AiLogRepositoryCustomImpl implements AiLogRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public Page<AiLog> getAiLogs(AiLogSearch search, Pageable pageable) {
		QAiLog aiLog = QAiLog.aiLog;

		BooleanBuilder condition = new BooleanBuilder();
		if (search.type() != null) {
			condition.and(aiLog.type.eq(search.type()));
		}
		if (search.status() != null) {
			condition.and(aiLog.status.eq(search.status()));
		}
		if (search.model() != null && !search.model().isBlank()) {
			condition.and(aiLog.model.eq(search.model()));
		}

		OrderSpecifier<?>[] orders = QuerydslSortUtils.toOrderSpecifiers(AiLog.class, "createdAt", pageable.getSort());

		List<AiLog> contents = queryFactory
			.selectFrom(aiLog)
			.where(condition)
			.orderBy(orders)
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();

		Long total = Optional.ofNullable(
			queryFactory.select(aiLog.count()).from(aiLog).where(condition).fetchOne()
		).orElse(0L);


		return new PageImpl<>(contents, pageable, total);
	}
}
