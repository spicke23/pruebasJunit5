pipeline {
    agent any 

    tools { 
        // Utiliza la instalación de Maven que has configurado en Jenkins
        maven 'jenkinsmaven' 
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
    }
}
