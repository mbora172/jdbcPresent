

pipeline {
  agent any
  tools {
    maven 'Maven 3.8.6'
    jdk 'jd11'
  }
  triggers{
    cron 'H 2,16 * * *'
  }
  stages {
    stage('Run Tests') {
      steps {
        sh 'mvn clean'
        sh 'mvn test'
      }
    }
  }
  post{
    always{
      junit '**/surefire-reports/*.xml'
      cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: 'target/cucumber.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
    }
    success {
      script {
        buildStatus = "SUCCESS"
        slackColor = "good"
      }
    }
    cleanup {

    }
  }
}