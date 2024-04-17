# CI/CD 문서

날짜: 2024년 4월 16일
상태: 진행 중

# 1. Backend

## 1.1. BackEnd Server Docker 이미지 생성

### 1.1.1. build.gradle 에 Jasypt 의존성 추가

<aside>
🚨 jasypt 3.0.5 보다 이전 버전에서는 빌드 커맨드가 잘 작동하지 않아 현재 최신 버전인 3.0.5 버전을 사용하였다.

</aside>

```powershell
implementation 'com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5'

tasks.named('test') {
	useJUnitPlatform()
	systemProperty 'jasypt.encryptor.password', findProperty("jasypt.encryptor.password")
}
```

### 1.1.2. Dockerfile에 jasypt 관련 내용 추가

```docker
FROM openjdk:17-alpine
COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "--jasypt.encryptor.password=itty"]
```

### 1.1.3. build 파일 생성

![Untitled](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/Untitled.png)

<aside>
🚨 설정파일인 application.yml의 민감정보들을 암호화하여 Github에 업로드하기 위해
Jasypt를 사용하였다.

이로 인해 암호화된 민감정보들을 다시 복호화하여 프로그램이 인식하도록 프로그램 외부에서 복호화 key를 전달해주어야 하는데,

그 key를 전달하는 방법으로 CLI 환경에서 빌드하는 명령에 key 값을 추가하는 방식을 택하였다.

gradle을 사용하여 빌드 시 `-P` 플래그를 추가한다.

</aside>

```powershell
./gradlew clean build -P jasypt.encryptor.password=itty
```

- `clean`: 기존에 만들어진 build를 지운 후, 새 build 파일을 생성

### 1.1.4. Docker Hub 로그인

```java
docker login
```

### 1.1.5. Docker에 Dockerfile (image) 생성하기

```java
docker build -t eodud3196/backend_server .
```

- Docker에 eodud3196/backend_server 라는 이름의 Dockerfile(image)를 생성
- 이때 [eodud3196]은 본인의 DockerHub 아이디로 작성
- 마지막에 .을 붙이는 이유: 현재 디렉토리에 존재하는 Dockerfile을 기준으로 image 파일을 생성한다는 의미

### 1.1.6. Docker에 image Push(이미지 배포)

```java
docker push eodud3196/backend_server
```

- 생성한 이미지 파일을 도커에 푸시

### 1.1.7. manifest 파일 생성

- deployment 파일 생성
    
    [itty-project-deployment.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/itty-project-deployment.yml)
    

- service 파일 생성
    
    [itty-project-service.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/itty-project-service.yml)
    

### 1.1.8. kubelet에 deployment 적용하여 Pod 생성(컨테이너 배포)

```powershell
kubectl apply -f itty-project-deployment.yml
```

### 1.1.9. Proxy에 service 적용

```powershell
kubectl apply -f itty-project-service.yml
```

---

# 2. Frontend

```visual-basic
npm install
```

- 필요한 모든 종속성을 설치하고, 프로젝트가 생산 환경에서 제대로 실행될 수 있도록 구성
- 개발 환경에서는 디버깅을 위한 도구가 필요하지만, 배포 시에는 최적화된 코드가 필요함. **`npm install`**은 필요한 모든 환경 설정 파일과 스크립트를 설치하며, 이는 배포 과정에서 코드를 최적화하고, 필요한 모든 구성 요소가 포함되도록 함
- 여러 플러그인과 확장 기능을 사용

```visual-basic
npm install axios
```

- HTTP 요청을 보낼 수 있는 간단하고 직관적인 API를 제공
- 비동기 코드를 보다 쉽게 작성하고 관리
- 모든 주요 브라우저에서 동작하며, 오래된 브라우저를 지원하기 위한 자동 변환 기능을 제공
- JSON 데이터를 자동으로 파싱하여 개발자가 서버로부터 받은 응답을 즉시 객체로 사용할 수 있게 함

```visual-basic
npm run dev
```

- 배포 받은 Vue 파일 실행 (Localhost:(포트번호) 로 지정)

---

# 3. Redis

<aside>
💡 Spring Security 로그인 토큰 관리를 위한 Redis 서버 Kubernetes 실행 과정

</aside>

### 3.1. manifest 파일 생성

- redis 디렉토리 생성
- Kubernetes 실행을 위한 yml 파일 작성
    
    [redis-configmap.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/redis-configmap.yml)
    
    - 애플리케이션 설정을 저장하는 데 사용되는 리소스
    
    [redis-dep.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/redis-dep.yml)
    
    [redis-svc.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/redis-svc.yml)
    
    ```yaml
      externalIPs:
      - 192.168.0.31
    ```
    
    - service 파일에 다음과 같이 IP를 설정함
    - Backend Server에서 192.168.0.31:6379를 이용하여 서로 통신 가능 하게 적용

### 3.2. Kubernetes Redis 실행

```bash
kubectl apply -f redis/
```

- redis 디렉토리 밖에서 위와 같은 명령어를 실행 하면 3개의 .yml 파일이 실행 됨

---

# 4. MariaDB

## 4.1 Backend 서버와 통신을 위한 MariaDB Docker 이미지 생성

### 4.1.1 Dockerfile 생성

[Dockerfile](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/Dockerfile.txt)

- 해당 파일은 MariaDB 컨테이너 이미지를 사용하여 데이터베이스를 초기화하는 작업을 수행함.
- 초기화 작업은 빌더 스테이지에서 수행되며, 그 결과로 초기화된 데이터베이스 디렉토리가 생성됨
- 다음 초기화된 데이터베이스 디렉토리를 기본 MariaDB 이미지로 복사하여 최종 이미지를 생성

[setup.sql](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/setup.sql)

- 해당 파일은 itty Database DDL문으로 Docker 이미지 초기 세팅할 DB이다.

### 4.1.2 Docker에 Dockerfile (image) 생성하기

```bash
docker build -t {DB image name}
```

### 4.1.3 Docker에 image Push(이미지 배포)

```bash
docker push {DB image name}
```

### 4.2.1 manifest 파일 생성

- db 디렉토리 생성
- Kubernetes 실행을 위한 yml 파일 작성
    
    [itty-db-volume.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/itty-db-volume.yml)
    
    - 애플리케이션 설정을 저장하는 데 사용되는 리소스
    
    [itty-db-deployment.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/itty-db-deployment.yml)
    
    [itty-db-service.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/itty-db-service.yml)
    
    ```yaml
      externalIPs:
      - 192.168.0.30
    ```
    
    - service 파일에 다음과 같이 IP를 설정함
    - Backend Server에서 192.168.0.30:3306을 이용하여 서로 통신 가능 하게 적용

### 4.2.2 Kubernetes MariaDB실행

```bash
kubectl apply -f db/
```

- redis 디렉토리 밖에서 위와 같은 명령어를 실행 하면 3개의 .yml 파일이 실행 됨

---

# 5. Prometheus

<aside>
💡 Prometheus는 시스템 모니터링 및 경고 툴킷이며, 이를 사용하여 매트릭 수집 및 대시보드 구축이 가능하다. 실시간으로 시스템의 상태를 모니터링하고, 다양한 지표를 수집하여 시스템의 안정성과 성능을 보장 하기 위함이다.

</aside>

### 5.1. manifest 파일 생성

- Prometheus 디렉토리 생성
- Kubernetes 실행을 위한 yml 파일 작성
    
    [prometheus-configmap.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/prometheus-configmap.yml)
    
    - 현재 이 시스템에서는 Backend와 Jenkins Server 모니터링을 진행함.
    
    ```yaml
        scrape_configs:
          - job_name: prometheus
            metrics_path: '/actuator/prometheus'
            static_configs:
              - targets: ['10.1.1.67:8888']       
    
          - job_name: jenkins
            metrics_path: '/prometheus/'
            static_configs:
              - targets: ['083f-183-109-114-170.ngrok-free.app']
            scheme: https
    ```
    
    - Backend 서버를 k8s로 실행시킨 후 kubectl describe {backend pods 이름}을 통해 IP를 확인함.
    - 해당 IP를 prometheus.static_configs.targes 쪽에 port 8888로 수정함.
    - jenkins 서버 모니터링을 위해 imac위에서 동작하고 있는 jenkins를 ngrok을 통해 주소를 Backend서버 targets 수정한것 처럼 수정한다.
    
    [prometheus-service.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/prometheus-service.yml)
    
    [prometheus-deployment.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/prometheus-deployment.yml)
    
    - service 파일에 다음과 같이 IP를 설정함
    - Backend Server에서 192.168.0.31:6379를 이용하여 서로 통신 가능 하게 적용

### 5.2. Kubernetes Prometheus 실행

```bash
kubectl apply -f prometheus/
```

- redis 디렉토리 밖에서 위와 같은 명령어를 실행 하면 3개의 .yml 파일이 실행 됨

### 5.3. 실행 확인

- 브라우저 환경에서 localhost:30090을 실행함.
- targets에 들어가 jenkins, backend가 configmap에서 설정한 주소로 접근이 가능한지 확인함

---

# 6. Grafana

<aside>
💡 시계열 매트릭 데이터를 시각화 하는데 가장 최적화된 대시보드를 제공해주는 오픈소스 툴킷. Prometheus에서 전달한 데이터를 대시보드에 시각적으로 표현함으로써, 관리자는 실시간으로 서비스의 상태를 확인하고 이상 현상을 즉시 파악 가능 함.

</aside>

### 6.1. manifest 파일 생성

- grafana 디렉토리 생성
- Kubernetes 실행을 위한 yml 파일 작성
    
    [grafana-volume.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/grafana-volume.yml)
    
    - 애플리케이션 설정을 저장하는 데 사용되는 리소스
    
    [grafana-deployment.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/grafana-deployment.yml)
    
    [grafana-service.yml](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/grafana-service.yml)
    

### 6.2. Kubernetes Redis 실행

```bash
kubectl apply -f grafana/
```

- redis 디렉토리 밖에서 위와 같은 명령어를 실행 하면 3개의 .yml 파일이 실행 됨

### 6.3. Dashboards 생성

- localhost:30000으로 접속함.
- Prometheus에서 데이터를 전송받기 위해 data source → prometheus 클릭

![Untitled](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/Untitled%201.png)

- kubectl describe {prometheus pod 이름}을 통해 알아낸 ip주소를 작성한다.
    - http://{pod 주소}:9090
- Dashboards 새성 imports를 통해 모니터링 대시보드를 생성 가능 함.
    
    ![Untitled](CI%20CD%20%E1%84%86%E1%85%AE%E1%86%AB%E1%84%89%E1%85%A5%20fd47fc8fa9414ec28081d449e9d44c4a/Untitled%202.png)
    
    - 19004 → Spring Boot 3.x Statistics
    - 12646 → Jenkins
