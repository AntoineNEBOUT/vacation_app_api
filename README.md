# Vacation App (API)

![Version](https://img.shields.io/badge/version-1.0.0-blue)

## 📖 Description

Ce projet est une application de gestion de visualisation des repos. Il s'agit d'un outil individuel et isolé des services de gestion des repos des entreprises. Il permet aux personnes ne pouvant pas consulter de manière simple leurs compteurs et leurs périodes de repos de le faire dans cet outil à condition de saisir, dans celui-ci, les actions réalisées sur le service de l'entreprise.

## Contexte

Ce projet s'inscrit à la suite de ma première année d'études où j'ai souhaité améliorer mes compétences en développement backend/applicatif. Dans ce but : j'ai suivi diverses formations au langage Java, à Spring Booot et à l'architecture de projets backends/applicatifs et ce projet en est l'application/la conclusion. De ce fait, l'attention a été principalement apportée au backend du projet.

## 🔧 Conception technique de l'API

### 📂 Structure du code
```
src/main/java/fr/antoinenebout/vacation_app_api/
├── configuration/
|   └── SecurityConfiguration.java
├── controller/
│   ├── AuthController.java
│   ├── CounterController.java
│   ├── StateController.java
│   ├── UserController.java
│   ├── VacationController.java
│   ├── VacationGroupController.java
│   └── VacationTypeController.java
├── dto/
│   ├── Counter/
│   |   ├── CounterCreateDTO.java
│   |   ├── CounterDetailDTO.java
│   |   ├── CounterSummaryDTO.java
│   |   └── CounterUpdateDTO.java
│   ├── User/
│   |   ├── UserCreateDTO.java
│   |   ├── UserDetailDTO.java
│   |   └── UserUpdateDTO.java
│   ├── Vacation/
│   |   ├── VacationCreateDTO.java
│   |   ├── VacationDetailDTO.java
│   |   ├── VacationSummaryDTO.java
│   |   └── VacationUpdateDTO.java
│   ├── VacationGroup/
│   |   ├── VacationGroupCreateDTO.java
│   |   ├── VacationGroupDetailDTO.java
│   |   ├── VacationGroupSummaryDTO.java
│   |   └── VacationGroupUpdateDTO.java
│   ├── VacationType/
│   |   ├── VacationTypeCreateDTO.java
│   |   ├── VacationTypeDetailDTO.java
│   ├── AuthenticationRequest.java
│   ├── AuthenticationResponse.java
│   └── StateDTO.java
├── mapper/
│   ├── CounterMapper.java
│   ├── StateMapper.java
│   ├── UserMapper.java
│   ├── VacationMapper.java
│   ├── VacationGroupMapper.java
│   └── VacationTypeMapper.java
├── model/
│   ├── Counter.java
│   ├── State.java
│   ├── User.java
│   ├── Vacation.java
│   ├── VacationGroup.java
│   └── VacationType.java
├── repository/
│   ├── CounterRepository.java
│   ├── StateRepository.java
│   ├── UserRepository.java
│   ├── VacationRepository.java
│   ├── VacationGroupRepository.java
│   └── VacationTypeRepository.java
├── security/
│   ├── JwtAuthenticationFilter.java
│   └── JwtUtil.java
├── service/
│   ├── CounterService.java
│   ├── StateService.java
│   ├── UserDetailsServiceImpl.java
│   ├── UserService.java
│   ├── VacationService.java
│   ├── VacationGroupService.java
│   └── VacationTypeService.java
├── util/
│   └── AuthUtil.java
└── VacationAppApiApplication.java
```

### Détail de l'architecture

Ce projet s'appuie sur une architecture multi-tiers (ou multi-niveaux) dont les couches principales sont les suivantes :
- ```controller``` : la couche de "Présentation", elle reçoit les requêtes et renvoie la réponse adaptée après avoir délégué les traitements aux autres couches.
- ```service``` : la couche "Métier", elle contient la logique et effectue les traitement métier.
- ```repository``` : la couche "Persistance", elle interragit avec la base de données avec des modèles.
- ```model``` : contient la représentation des données (entités/modèles) des tables de la base de données. Ce sont ces modèles qui sont utilisés par la couche ```repository```.
- ```dto``` : contient des représentations simplifiées des modèles pour convenir à des besoins spécifiques. Ainsi la couche ```service``` n'a pas connaissance des objets de ```model```
- ```mapper``` : contient des objets permettant de passer d'un modèle à un dto et inversement.

## Consulter le code

Vous pouvez consulter le code de l'API de ce projet dans ce même dépôt [GitHub](https://github.com/AntoineNEBOUT/vacation_app_api)

## 🧑‍💻 Auteur
- **Antoine Nebout**
  - [Portfolio](https://www.antoinenebout.fr/)
  - [Profil Linkedin](https://www.linkedin.com/in/antoine-nebout/)
  - [Profil GitHub](https://github.com/AntoineNEBOUT)
