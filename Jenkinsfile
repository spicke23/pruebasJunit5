pipeline {
    agent any 

    stages {
        stage('Checkout') {
            steps {
                // Requerimiento 1: Obtiene el código de su proyecto desde GitHub.
                git 'https://github.com/MiguelAngelRamos/simple-java-maven-app.git'
            }
        }

        stage('Build') {
            steps {
                // Requerimiento 2: Genera los artefactos.
                script {
                    sh 'clean package'
                }
            }
        }

        stage('Archive Artifacts') {
            steps {
                // Requerimiento 3: Archiva los artefactos.
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Test') {
            steps {
                // Requerimiento 4: Ejecuta los tests de Maven.
                script {
                    sh 'test'
                }
            }
        }
    }
}
