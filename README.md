```
minikube start
😄  minikube v1.29.0 on Darwin 12.6
✨  Using the docker driver based on existing profile
👍  Starting control plane node minikube in cluster minikube
🚜  Pulling base image ...
E0209 09:01:41.933466    6296 cache.go:188] Error downloading kic artifacts:  failed to download kic base image or any fallback image
🤷  docker "minikube" container is missing, will recreate.
🔥  Creating docker container (CPUs=2, Memory=4000MB) ...
🐳  Preparing Kubernetes v1.26.1 on Docker 20.10.23 ...
🔗  Configuring bridge CNI (Container Networking Interface) ...
🔎  Verifying Kubernetes components...
    ▪ Using image docker.io/kubernetesui/dashboard:v2.7.0
    ▪ Using image gcr.io/k8s-minikube/storage-provisioner:v5
    ▪ Using image docker.io/kubernetesui/metrics-scraper:v1.0.8
💡  Some dashboard features require the metrics-server addon. To enable all features please run:

	minikube addons enable metrics-server	


🌟  Enabled addons: storage-provisioner, default-storageclass, dashboard
🏄  Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default


eval $(minikube docker-env)

docker pull mongo:latest
latest: Pulling from library/mongo
10ac4908093d: Pull complete 
685504455d09: Pull complete 
ebd36404f329: Pull complete 
3abd9b25affb: Pull complete 
2d7fde532eae: Pull complete 
24fc70e4c7d7: Pull complete 
ffc2353072f7: Pull complete 
560de8e3a6c7: Pull complete 
0748cd1d792c: Pull complete 
Digest: sha256:134e3f2db743d46bdb7f3eb6bcfa4b8e3dde578c9ff8a10742ce29d706acf9b2
Status: Downloaded newer image for mongo:latest
docker.io/library/mongo:latest

docker run -d -p 27017:27017 mongo:latest
1cb836820b9e08243d84751066c6015313d7bbe1babbd966913fe6c16c72ac81

docker ps 
CONTAINER ID   IMAGE          COMMAND                  CREATED              STATUS              PORTS                      NAMES
1cb836820b9e   mongo:latest   "docker-entrypoint.s…"   About a minute ago   Up About a minute   0.0.0.0:27017->27017/tcp   admiring_tu

docker exec -it 1cb8 mongo

docker rm $(docker ps -a -q) -f
docker rmi $(docker images -a -q) -f

docker-compose build
docker-compose up

mongodb://test:test@123@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&ssl=false

https://manglekuo.medium.com/running-mongodb-on-docker-with-macos-b08324f5aab2

docker build -t spring-mongo-service:1.0 .
[+] Building 7.9s (7/7) FINISHED                                                
 => [internal] load build definition from Dockerfile                       0.0s
 => => transferring dockerfile: 254B                                       0.0s
 => [internal] load .dockerignore                                          0.0s
 => => transferring context: 2B                                            0.0s
 => [internal] load metadata for docker.io/adoptopenjdk/openjdk11:alpine-  1.1s
 => [1/2] FROM docker.io/adoptopenjdk/openjdk11:alpine-jre@sha256:81762ba  6.0s
 => => resolve docker.io/adoptopenjdk/openjdk11:alpine-jre@sha256:81762ba  0.0s
 => => sha256:e21722b88970d7841b6ffa6b1362efae45b6fe06208 5.51kB / 5.51kB  0.0s
 => => sha256:c79ac3d758234eef78b7eacbf6e3ae311fec8010d0d 6.49MB / 6.49MB  1.1s
 => => sha256:b048779d61d6d98815f9c0f957ff96bcd532380d5 43.79MB / 43.79MB  4.4s
 => => sha256:81762bad162db816bdc0ed0c2b288b724882b0a8e28fac7 433B / 433B  0.0s
 => => sha256:1be9223b96065d625adfdb4361ecb4dc4b328a95d6ea277 951B / 951B  0.0s
 => => extracting sha256:c79ac3d758234eef78b7eacbf6e3ae311fec8010d0d2d320  0.2s
 => => extracting sha256:b048779d61d6d98815f9c0f957ff96bcd532380d51bf7157  1.4s
 => [internal] load build context                                          0.6s
 => => transferring context: 45.44MB                                       0.6s
 => [2/2] ADD target/springboot-k8s-mongo.jar app.jar                      0.5s
 => exporting to image                                                     0.2s
 => => exporting layers                                                    0.2s
 => => writing image sha256:7e973b9d7c2033fcc3235cb38a1bd66465457e102a780  0.0s
 => => naming to docker.io/library/springboot-mongo-service:1.0            0.0s

Use 'docker scan' to run Snyk tests against images to find vulnerabilities and learn how to fix them


echo -n 'test' | base64
dGVzdA==

echo -n 'test@123' | base64
dGVzdEAxMjM=


PersistentVolume will be created by k8s admin and PVC is requested by the developer, it will be created immediately.

kubectl apply -f mongo-config.yml 
configmap/mongo-conf created

kubectl apply -f mongo-secret.yml 
secret/mongo-secret created

kubectl apply -f mongo-deployment.yml 
service/mongodb-service created
persistentvolumeclaim/mongo-pv-claim created
deployment.apps/mongo created

kubectl get pods                     
NAME                     READY   STATUS    RESTARTS   AGE
mongo-849c7745db-jj9ps   1/1     Running   0          41s

kubectl apply -f deployment.yml 
service/spring-mongo-service created
deployment.apps/spring-mongo-service created

kubectl get pods                          
NAME                                    READY   STATUS              RESTARTS   AGE
mongo-849c7745db-47qm8                  1/1     Running             0          5m33s
spring-mongo-service-6c9f688b8f-dqsfl   0/1     ContainerCreating   0          3s
spring-mongo-service-6c9f688b8f-kmfsf   0/1     ContainerCreating   0          3s

kubectl logs -f spring-mongo-service-844c79fd84-bknxs

kubectl exec -it mongo-849c7745db-jj9ps mongo -u test -p --authenticationDatabase admin

show dbs;

use admin;

show collections;

http://minikubeip:minikubenodeport/findAllProducts

POST /addProduct

{
  "id" : "1",
  "productId" : "1234",
  "description" : "sai",
  "price" : "1234"
}

db.product.find().pretty();


```

<img width="1033" alt="Screenshot 2023-02-09 at 1 17 19 AM" src="https://user-images.githubusercontent.com/43849911/217635729-17353b81-4914-4b44-b61d-81aebb648088.png">

<img width="1107" alt="Screenshot 2023-02-09 at 1 38 37 AM" src="https://user-images.githubusercontent.com/43849911/217639951-3151ef96-8833-4078-95a8-03bd1c41e08c.png">

<img width="1425" alt="Screenshot 2023-02-15 at 1 11 05 AM" src="https://user-images.githubusercontent.com/43849911/218840565-4c5431a4-6a08-44d0-a02e-4268807facf4.png">
