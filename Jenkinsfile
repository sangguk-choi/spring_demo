pipeline {
    agent any

    // triggers {
    //     pollSCM('*/3 * * * *')
    // }

    environment {
        imagename = "docker_image"
        registryCredential = 'docker hub credential ID'
        dockerImage = ''
    }

    stages {
        // git에서 repository clone
        stage('Prepare') {
          steps {
            echo 'Clonning Repository'
            git url: 'git repository 주소',
              branch: 'master',
              credentialsId: '생성한 github access token credentail id'
            }
            post {
             success { 
               echo 'Successfully Cloned Repository'
             }
           	 failure {
               error 'This pipeline stops here...'
             }
          }
        }

    //     // gradle build
    //     stage('Bulid Gradle') {
    //       agent any
    //       steps {
    //         echo 'Bulid Gradle'
    //         dir ('.'){
    //             sh """
    //             ./gradlew clean build --exclude-task test
    //             """
    //         }
    //       }
    //       post {
    //         failure {
    //           error 'This pipeline stops here...'
    //         }
    //       }
    //     }
        
    //     // docker build
    //     stage('Bulid Docker') {
    //       agent any
    //       steps {
    //         echo 'Bulid Docker'
    //         script {
    //             dockerImage = docker.build imagename
    //         }
    //       }
    //       post {
    //         failure {
    //           error 'This pipeline stops here...'
    //         }
    //       }
    //     }

    //     // docker push
    //     stage('Push Docker') {
    //       agent any
    //       steps {
    //         echo 'Push Docker'
    //         script {
    //             docker.withRegistry( '', registryCredential) {
    //                 dockerImage.push("docker tag name")  // ex) "1.0"
    //             }
    //         }
    //       }
    //       post {
    //         failure {
    //           error 'This pipeline stops here...'
    //         }
    //       }
    //     }
    // }
}