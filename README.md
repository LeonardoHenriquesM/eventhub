# EventHub API

Une api rest dev avec spring boot pour la gestion d'événements.

## architecture
- **On utilise 4 couches** : `Controller` `Service` `Repository` `Model`
- **Sécu des données avec le DTO** : Utilisation de `record` (`EventDTO`) pour pas exposer les entités JPA.
- **normes REST** : On versionne les endpoints (`/api/v1/events`) et on gère les codes HTTP via `ResponseEntity` (`200`, `201`, `404`).
- **performance & transactions** : `@Transactional(readOnly = true)` par défaut sur les lesctures comme findbyid(), surchargé avec `@Transactional` sans rien devant pour les écritures.

## Pour lancer le projet
1. Démarrer l'appli dans le fichier `EventhubApplication`.
2. Utiliser l'interface de swagger pour les tests : `http://localhost:8080/swagger-ui/index.html`