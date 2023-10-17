build image
```
./gradlew clean build
```
create image and push to acr via docker
```
az acr login --name enablementacrnonprod
```
```
docker buildx build -t enablementacrnonprod.azurecr.io/tang-spring-image:2.6 --push .
```
apply yaml
```
kubectl apply -f ./tang/tang-spring.yaml
```