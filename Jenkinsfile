pipeline {
  agent any
  stages {
    stage('buid_maven_project') {
      parallel {
        stage('buid_maven_project') {
          steps {
            sh 'mvn clean install -Dlicense.skip=true'
          }
        }

        stage('mvn-version') {
          steps {
            sh 'mvn -v'
          }
        }

      }
    }

  }
}