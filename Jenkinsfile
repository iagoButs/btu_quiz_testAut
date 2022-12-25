pipeline {
  agent any
  stages {
    stage('buid_maven_project') {
      parallel {
        stage('buid_maven_project') {
          steps {
            sh 'call mvn clean install'
          }
        }

        stage('mvn-version') {
          steps {
            sh 'call mvn -v'
          }
        }

      }
    }

  }
}