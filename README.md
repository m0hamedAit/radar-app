

### Etablir une architecture technique du projet
![](img/architecture.png)
### Etablir un diagramme de classe global du projet
![](img/class_diagram.png)
### Développer le micro-service Radar
#### Structure 
```bash
├───radar-command
│   │    ├───aggregates
│   │    └───controllers
│   │    RadarCommandApplication
├───radar-query
│   │   ├───controllers
│   │   ├───entities
│   │   ├───queries
│   │   ├───repositories
│   │   └───services
│   │   RadarQueryApplication
```

### Développer le micro-service Immatriculation
### Développer le micro-service Infractions
### Mettre en place les services techniques de l’architecture micro-service (Gateway, Eureka Discovery service)
### Développer votre application Frontend avec Angular ou React
### Sécuriser votre système avec un système de d’authentification OAuth2 comme Keycloak
### Ecrire un script docker-compose.yml pour le déploiement de ce système distribué dans des conteneurs docker.