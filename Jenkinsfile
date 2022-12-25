pipeline {
  agent any
  stages {
    stage('buid_maven_project') {
      steps {
        sh 'mvn clean install -Dlicense.skip=true'
      }
    }

  }
}