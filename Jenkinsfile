pipeline {
    agent any
    tools{
        maven 'MAVEN'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Hello World'
       checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'df90ef4e-c0f4-4225-b8dd-7e80de820e9c', url: 'https://github.com/mbora172/jdbcPresent.git']]])
                      sh "mvn -Dmaven.test.failure.ignore=true clean package"

            }
            }
    }
    post{
        always{
            junit(
                allowEmptyResults:true,
                testResults: 'test-reports/.xml')
            }
        }
    }
