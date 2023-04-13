# InfinityCar

## Installer Mariadb sous wsl

### Windows

- Télécharger wsl dans le microsoft store

- Activier la fonctionnalité windows "Sous System Windows pour Linux" ainsi que "plateforme de machine virtuelle"

- Utiliser la commande dans un terminal :

```
wsl --install ubuntu 
```

### installer mariadb

```
sudo apt update

sudo apt install mariadb-server mariadb-client
```

### Démarrer la base de données:

```
sudo service mariadb start

```
### Créer la base de données & un utilisateur :

```
sudo mysql -u root

MariaDB [(none)]>create database infinitycardb;
MariaDB [(none)]>create user infinityadmin identified by 'admin';
MariaDB [(none)]>grant all privileges on infinitycardb.* to infinityadmin;
```

## Installer Node 

### Linux 

```
sudo apt install node
```
### Windows 

```
winget install "OpenJS.NodeJS"
```
#### Dans le dossier frontapp :

```
npm install 
```

## Démarrer le projet

- Lancer la base de données > `sudo service mariadb start`
- Lancer l'API > éxécuter le fichier java *CarApplication.java*
- Lancer le front > Dans le folder frontapp : `npm run serve`
