# Vacation App (API)

![Version](https://img.shields.io/badge/version-1.0.0-blue)

## 📖 Description

Globalement (frontend et API), ce projet est une application de gestion de visualisation des repos. Il s'agit d'un outil permettant de saisir l'état initial de ses compteurs de repos puis de déclarer des périodes de repos pour consulter l'évolution de ses compteurs. Cet outil permet une meilleure visualisation de ses compteurs, mais il ne communique pas avec les outils officiels de chaque entreprise.

## Contexte

Ce projet s'inscrit à la suite de ma première année d'études où j'ai souhaité améliorer mes compétences en développement backend et applicatif. Dans ce but : je me suis formé au langage Java, à Spring Booot et à l'architecture de projets, et cette API correspond à la mise en pratique de ces connaissances. De ce fait, l'attention a été principalement apportée au backend du projet (ce dépôt) et le frontend est en cours de réalisation dans le but de pouvoir proposer une démonstration fonctionnelle prochainement.

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

Ce projet s'appuie sur une architecture multi-tiers (ou multi-niveaux) qui sépare les responsabilités de chaque composant.

Les couches principales sont les suivantes :
- ```controller``` : la couche de "Présentation", elle reçoit les requêtes et renvoie la réponse adaptée après avoir délégué les traitements aux autres couches.
- ```service``` : la couche "Métier", elle contient la logique et effectue les traitements métiers.
- ```repository``` : la couche "Persistance", elle interagit avec la base de données avec des modèles.
- ```model``` : contient la représentation des données (entités/modèles) des tables de la base de données. Ce sont ces modèles qui sont utilisés par la couche ```repository```.
- ```dto (Data Transfer Object)``` : contient des représentations simplifiées des modèles pour convenir à des besoins spécifiques. Ainsi la couche ```service``` n'a pas connaissance des objets de ```model```.
- ```mapper``` : contient des objets permettant de passer d'un modèle à un DTO et inversement.

L'avantage est que chaque couche n’appelle que la couche immédiatement en dessous d’elle et n’a pas connaissance des couches supérieures ce qui facilite l'écriture du code et les dépendances entre les fichiers.

Voici une représentation simplifiée de ce type d'architecture (multi-tiers) :

<img width="518" height="541" alt="diagramme_multi_tiers" src="https://github.com/user-attachments/assets/725a2c9a-1add-4ef3-a95c-731f0eb4b2a6" />

Pour ce projet, l'architecture est basée sur cette représentation plus détaillée :

<img width="998" height="541" alt="diagramme_multi_tiers_details" src="https://github.com/user-attachments/assets/510204e0-b40f-4554-b826-3e83d0c0a543" />

## Consulter le code

Le code de l'API de ce projet peut être consulté dans [ce même dépôt GitHub](https://github.com/AntoineNEBOUT/vacation_app_api)

## 🧑‍💻 Auteur
- **Antoine Nebout**
  - [Portfolio](https://www.antoinenebout.fr/)
  - [Profil Linkedin](https://www.linkedin.com/in/antoine-nebout/)
  - [Profil GitHub](https://github.com/AntoineNEBOUT)
