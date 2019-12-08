package com.robert.fullstack.domain.ddd;

public @interface DDD {

    @interface Entity {}

    @interface ValueObjectId {}

    @interface ValueObject {}

    @interface AggregateRoot {}

    @interface DomainService {}

    @interface DomainEvent {}

    @interface InfrastructureService {}

    @interface InfrastructureServiceImpl {}

    @interface Repository {}

    @interface RepositoryImpl {}

    @interface ApplicationService {}
}
