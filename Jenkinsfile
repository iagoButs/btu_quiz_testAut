pipeline {
  agent any
  stages {
    stage('buld mvn_proj') {
      parallel {
        stage('buld mvn_proj') {
          steps {
            sh 'call mvn clean install'
          }
        }

        stage('mvn version') {
          steps {
            sh 'call mvn -v'
          }
        }

      }
    }

  }
}