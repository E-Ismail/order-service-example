# Spring Data JPA Order Service

Database relationships: OneToOne, OneToMany and ManyToMany
Relationship Directions: Bi-directional, Uni-directional
Cascade Operations: Cascade persistence operations
    Ex: A delete of just OrderHeader would fail on foreign key constraints to OrderLin and OrderAproval
    Explicitly you'll need to perform deletes of the child records first
    Optionally, hibernate can be configured to delete OrderLines and OrderApproval before deleting the OrderHeader, use with caution**
    1- @OneToMany(mappedBy = "orderHeader", cascade= CascadeType.PERSIST) hibernate is going to save the entity for me. (Bidirectional)
    2- @ManyToOne Unidirectional
Foreign Key: @Foreignkey (JPA) this is only a meta-data
