# TP5  Intégration Spring & Hibernate
🎯 **Objectifs du TP** 
Comprendre les bases de la gestion des dépendances avec Maven.
Configurer Spring pour gérer l’injection de dépendances et les transactions.
Intégrer Hibernate pour la gestion des entités persistantes.
Créer un DAO pour gérer les opérations CRUD.
Configurer une base de données MySQL pour l’interaction avec les entités.

🧱 Architecture logicielle

Le TP adopte une architecture en couches clairement séparées :
src/main/java/com/example
│
├─ entities        → Entités JPA (Product, Category)
├─ dao             → Interface DAO générique (IDao<T>)
├─ metier          → Implémentations Hibernate des DAO
├─ util            → Configuration Spring + Hibernate
└─ Main            → Exécution des opérations CRUD
Cette séparation garantit réutilisabilité, testabilité et maintenabilité du code.
<p align="center">
  <img src="https://github.com/YASSMINEOUQUELLI12/TP5/blob/main/CC.PNG" alt="Aperçu" width="600">
</p>

