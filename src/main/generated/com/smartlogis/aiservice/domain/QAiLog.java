package com.smartlogis.aiservice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAiLog is a Querydsl query type for AiLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAiLog extends EntityPathBase<AiLog> {

    private static final long serialVersionUID = -488582513L;

    public static final QAiLog aiLog = new QAiLog("aiLog");

    public final com.smartlogis.common.domain.QAbstractEntity _super = new com.smartlogis.common.domain.QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    //inherited
    public final StringPath deletedBy = _super.deletedBy;

    public final StringPath errorMessage = createString("errorMessage");

    public final StringPath fullPrompt = createString("fullPrompt");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> latency = createNumber("latency", Long.class);

    public final StringPath model = createString("model");

    public final StringPath prompt = createString("prompt");

    public final StringPath response = createString("response");

    public final EnumPath<AiStatus> status = createEnum("status", AiStatus.class);

    public final EnumPath<AiType> type = createEnum("type", AiType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath updatedBy = _super.updatedBy;

    public QAiLog(String variable) {
        super(AiLog.class, forVariable(variable));
    }

    public QAiLog(Path<? extends AiLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAiLog(PathMetadata metadata) {
        super(AiLog.class, metadata);
    }

}

