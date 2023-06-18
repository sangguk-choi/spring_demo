def mainDir="Chapter02/2-jenkins-docker" // 메인 디렉토리
def ecrLoginHelper="docker-credential-ecr-login" // ECR에 push할 때 필요한 로그인을 미리 전역변수로 적어둠
def region="us-east-1" // 사용하는 리전
def ecrUrl="436115905187.dkr.ecr.us-east-1.amazonaws.com/test" // ECR url
def repository="test" // 프라이빗 fp파지토리
def deployHost="172.31.81.217" // 배포서버 - AWS EC2 프리이빗 IP

pipeline { // 파이프라인을 stage별로 나눠서 명시함, 흐름을 파악할 때 사용
    agent any

    stages {
        stage('Pull Codes from Github'){
            steps{
                checkout scm
            }
        }
        stage('Build Codes by Gradle') { // Gradle을 이용한 빌드과정
            steps {
                sh """
                chmod +x gradlew
                ./gradlew clean build
                """
            }
        }
    }
}