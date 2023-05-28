pipeline {
    agent any 

    tools { 
        maven 'mavenjenkins' 
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/MiguelAngelRamos/simple-java-maven-app.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('SonarQube analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonar', variable: 'sonarLogin')]) {
                    script {
                        sh 'mvn sonar:sonar -Dsonar.projectKey=my_project -Dsonar.host.url=http://localhost:9000 -Dsonar.login=${sonarLogin}'
                    }
                }
            }
        }
    }
}
