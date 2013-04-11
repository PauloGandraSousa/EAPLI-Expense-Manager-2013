EAPLI 
Despesas Pessoais

=======================

This application serves as "play ground" for the lab project of EAPLI.

Parts of the application were developed to show specific approaches or 
techniques; as such, the overall application is not consistent in terms of design.
for production ready code this would obvisously be a problem as we should strive for 
consistency. in this case, it is acceptable as the inconsistencies are meant to provide
samples of different valid approaches.


several discussions migth be raised:
1) which layers?
2) domain objects with persistence knowledge or not
3) passing domain objects to the UI or not 
4) performing calculations in memory or directly at the persistence layer
5) factoring out common behaviour, e.g., IncomeType & ExpenseType, Income & Expense
6) having the explicit concept of account or not
7) initial balance of the account


--------------------------------------------------------------------------
1) which layers
--------------------------------------------------------------------------

the application follows a traditional approach of separating the following layers:
	UI | use case controllers | domain/model | persistence
access to the busines logc is guarded by use case controllers
 
generaly speaking the persistence layer is organized around the concept of Repository
(a class acting as an in memory list) that "takes care" of the objects.
to accomodate more in memory and database repositories the persistence layer is actually 
composed of interfaces and a PersistenceRegistry which acts as a registry and as a factory
of the actual repository implementation (this can also be seen as a case of the Strategy pattern)


--------------------------------------------------------------------------
2) domain objects with persistence knowledge or not
--------------------------------------------------------------------------

two different approaches are possible:
- pure domain objects without any knowledge of the persistence
- domain objects that can save and load thenselves from persistence (thus, an Active Record)

in the first case, the controller is responsible for obtaining the domain objects 
from the repository, asking the domain objects to perform the business logic and then pass
them back to the repository. in this case, the domain objects can "easily" be tested as 
they do not depend on any other package

in the second case, the controller asks the domain object class to load a certain instance,
asks that object to perform the business operation and then asks the object to save itself
back to the database


--------------------------------------------------------------------------
3) passing domain objects to the UI or not 
--------------------------------------------------------------------------


--------------------------------------------------------------------------
4) performing calculations in memory or directly at the persistence layer
--------------------------------------------------------------------------




--------------------------------------------------------------------------
5) factoring out common behaviour, e.g., IncomeType & ExpenseType, Income & Expense
--------------------------------------------------------------------------


--------------------------------------------------------------------------
6) having the explcit concept of account or not
--------------------------------------------------------------------------



--------------------------------------------------------------------------
7) initial balance of the account
--------------------------------------------------------------------------


