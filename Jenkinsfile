node {
  stage('========== Clone repository ==========') {
    checkout scm
  }
  stage('========== Build image ==========') {
    app = docker.build("sangguk-choi/spring_demo") # 저장소
  }
  stage('========== Push image ==========') {
    docker.withRegistry('https://registry.hub.docker.com', 'sangguk') { # Jenkins Credential 정보
      app.push("${env.BUILD_NUMBER}") # 빌드 번호
      app.push("latest") # 태그 정보
    }
  }
}