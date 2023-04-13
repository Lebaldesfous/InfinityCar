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

sudo mysql -u root
```
### Créer la base de données & un utilisateur :

```
create database infinitycardb;

create user infinityadmin identified by 'admin';

grant all privileges on infinitycardb.* to infinityadmin;
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
