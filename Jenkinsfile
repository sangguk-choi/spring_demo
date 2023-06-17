pipeline { // 파이프라인을 stage별로 나눠서 명시함, 흐름을 파악할 때 사용
    agent any

    stages {
        stage('Pull Codes from Github'){
            steps{
                checkout scm
            }
        }
    }
}