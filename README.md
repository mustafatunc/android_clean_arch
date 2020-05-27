 Multimodule Clean Architecture with Sample
========
Android Clean architecture implementation with a sample use case


Libs
--------
Kotlin <br/>
Room - database <br/>
Retrofit - network <br/>
Kotlin Coroutines - use case <br/>
ViewModel + LiveData - presentation <br/>
Koin - Dependency injection <br/>



Architecture
-------------
Module dependencies <br/>
![architecture](https://github.com/mustafatunc/android_clean_arch/blob/master/arts/modules.jpg)


Domain
-------------
Domain is a kotlin-only module. It doesn't depend on any other module.<br/>
Defines the Use Cases, Repository interfaces, Exceptions and Entities

Repository
-------------
Repository module implements the Repository interfaces defined in Domain module.<br/>
Handles caching mechanism and where the data comes from

Network
-------------
Network module implements the RepositoryNetwork interfaces defined in Repository module.<br/>
Defines network api, communicates with backend

Database
-------------
Database module implements the RepositoryDatabase interfaces defined in Repository module.<br/>
Stores the data. I mean.. it's database

DI - Dependency Injection
-------------
di module knows every module that provides a koin module, except the app module<br/>
Provides all dependencies that are needed in other (gradle) modules

App
-------------
App is ui stuff as usual. ViewModel classes interact with Domain UseCases.<br/><br/>
