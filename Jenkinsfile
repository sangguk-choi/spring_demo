node {
  stage('========== Clone repository ==========') {
    checkout scm
  }
  stage('========== Docker Install ==========') {
    sudo apt install docker
  }
  stage('========== Build image ==========') {
    app = docker.build("jenkins-docker-pipeline/my-image")
  }
}